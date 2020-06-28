# Dagger Experiments

## `Bindings` happen at development-time.

- Each `@Component` has its own **bindings & Scope**.

- 4 most common bindings
  1. `@Inject` Constructor which is the most preferred binding
  2. `@Binds` abstract method that maps a Concrete-Type to an Abstract-Type (that classed depend upon)
  3. `@Provides` is generally used for mapping Concrete-Types that are third-party (or) external to Abstract-Types  
  4. `@BindsInstance` is generally used on a Component/SubComponent Builder method to bind a concrete type with the 
     Component/Sub-component instance.
       - This is most commonly used to bind primitive types (like **int, float, etc.,**) to component instance.
       - If more than one value of the same primitive type needs to be bound, then we would need a Qualifier annotation.

- `Provider Methods` should be preferred when we are injecting `third-party` classes
    - Provider Methods **CAN ONLY BE** defined in `Module`, and the corresponding `Module` should be mapped to `Component`.
    > Provide Methods can be "static" if they don't depend on the state/members of a Module.

- `Binds Method` should be preferred when we want to bind an **implementation** to an **interface** dependency.

   ```java
     @Module
     public abstract class AModule{
       @Binds
       abstract Interface bindImpl(InterfaceImpl impl);
       
       @Provides
       Interface provideImpl(InterfaceImpl impl) {
        return impl;
       }
     }
   ```
   > `bindImpl` and `provideImpl` in the above example does the **exact same thing**.  
   > `@Binds` is preferred  in this case as we don't do anything extra with the Bound type.

- `@Inject` constructors (that doesn't have any other injected params) can generally be accessible by any component.  
  - It is the Scope that restricts it's Binding to a "particular component".    
    > Component scoped with "scope1" may not reference bindings with different scopes "scope2".
    > **This is the very reason, we shouldn't be using the same scope on multiple components**.  

  - If "another Component" has to use this dependency, then
     - it has to add the "particular component" as it's `dependency` and  **expose a provision method** in the "particular component".
     - or declare itself as `@Subcomponent`  
    > See Below for more details on **Multiple Components + Multiple Scopes , Component Dependencies. (ex8)**
---

## `Injection` happens at runtime

- `Constructor Injection` should be preferred whenever possible.
- `Field Injection / Member Injection` should be preferred when we don't have access to the Constructors.
    - Downside of Field Injection is that **fields / members**  cannot be private.
- `Method Injection` should be preferred when we want to do some configuration **after we create an Object**.

> Field and Method Injection is automatic **ONLY WHEN** Constructor Injection is in place.  

> Field and Method Injection happens on an Object which doesn't have Constructor Injection,
> when **we call the corresponding `inject` method on the `Component`** with the `Object-Type as parameter`.
>> In this scenario, we pass our instance to the `Component` and ask it to **inject the fields & method** for us.

- Order of Injection:
    1. Constructor Injection.
    2. Field Injection.
    3. Method Injection.
    
---

## `Injecting Values @ Runtime` to our Dependencies

1. We can pass runtime values to dependencies via the `Module`s that they are **Provided** in.   
      - Pass the runtime value to **`Module` constructor** and store it as a member of the Module
      - Use the member variable in `@Provides` methods, while instantiating the dependency.
      > Please note that a **`Module` with custom constructor** must be passed explicitly to corresponding `Components` builder method
        while instantiating the component.
    
2. Bind a `component` instance with a configuration value.
      - Marking a **method** on `@Component.Builder` (or) `@Component.Factory` as `@BindsInstance` and pass the **configuration object**.
          ```java
              @Component.Builder
              interface Builder {
                  @BindsInstance
                  Builder horsePower(int horsePower); //horsePower is the configuration object here.
                  CarComponent build();
              }
          ```
      - Now each instance of the `Component` will be **bound to the passed configuration value**, and the same would be used on dependency injection.
        
## Binding `more than 1 instance` for a particular `type` **(Add Qualifier)** (ex6)

- Using `@Named` annotation on the configuration parameter. (which is a `@Qualifier` annotations)
    ```java
      @Component.Builder
        interface Builder {
          @BindsInstance
          Builder horsePower(@Named("horsePower") int horsePower);
          @BindsInstance
          Builder engineCapacity(@Named("engineCapacity") int engineCapacity);
          CarComponent build();    
        }
    ```
 
## Scoping a dependency instance creation per Component **(Using Scope annotations)** (ex7)

- Use `@Singleton` to instantiate a `type` **only once** (per component).  
- Scope a `@Component` and it's corresponding `@Inject constructor enabled concrete type` (or) `@Binds abstract method` (or) `@Provides method`,
  with any Scoped annotation (here @Singleton) to instruct `how many instances of the "type"` can exist per component.
    
## Multiple Components + Multiple Scopes , Component Dependencies. (ex8)

- Each `component` can have **its own Scope**, and the **bindings can be scoped under the same**.

- A `Component` can mention "another component" as **dependency**
> meaning we will pass in the "another component" (typically using a @Component.Builder method) while creating the `Component`. 

  - corresponding builder gets **auto-created** when we don't have an explicit `@Component.Builder`.
  - If we have an explicit `@Component.Builder` we have to declare the builder method ourselves, else will result in an error.
    >Error: @Component.Builder is missing setters for required modules or components.

> **NOTE: Please note that the dependencies of "another-component" CAN ONLY BE ACCESSED by "the-component" via PROVISION METHODS declared in
> "another-component" in this dependency approach.  
> Else we would get Error: "the-component" may not reference bindings with different scopes.**

## Connecting 2 components together

There are multiple ways in which we can connect 2 components together.

1. `@Component Comp2` can mention `@Component Comp1` as it's **dependency**.  
    And `Comp1` has to expose **provision methods** for each dependency that it exposes to other components such as `Comp2`. 

    ```java
    @Component(dependencies = {Comp1.class}, modules = {Comp2Module1.class, Comp2Module2.class})
    public interface Comp2 {
    }
    ```

2. `@Subcomponent Comp2` can be made **sub-component**. 
   
   1.  `Method1 (See ex9)`
        - And corresponding **provision method** needs to be exposed in `@Component Comp1` to create a connection. 
        > Any Module inside sub-component `Comp2` which needs runtime values, must be passed as parameter to the 
        > **provision method** declared in `Comp1`. 
        
        > Comp2 implementation will become **private inner class** of Comp1 implementation. 
        > So any dependencies / runtime params that Comp2 need must be passed via Comp1's corresponding provision method.

        ```java
        interface Comp1 {
           Comp2 newComp2(Comp2Module2 module2Dep);
        }
        ```

   2. `Method1 (See ex10)`:
      - Explicitly declare `@Subcomponent.Builder` for `Comp2`.
      - Add **provision method** for the SubComponentBuilder in `@Component Comp1`.
      
      ```java
        @Component
        public interface Comp1 {
            Comp2.Builder comp2Builder();
        }
      ```
      
   3. `Method3` (TODO)
     - Make `@Subcomponent Comp2` as Sub-Component of a Module `@Module Comp2.InstallModule`.
     - Add `Comp2InstallModule` as a module of `@Component Comp1`.
      
     ```java
     @Component(modules = {Comp1Module1.class, Comp2.InstallModule.class})
     interface Comp1 {
     }
     
     @Subcomponent(modules={Comp2Module1.class})
     interface Comp2 {
       
        @Module(subcomponents = {Comp2.class})
        interface  InstallModule{
        }
     }
     ```

## `@Component/Subcomponent.Builder` vs `@Component/Subcomponent.Factory` 

|  Component Builder    |   Component Factory   |
|     ---               |       ---             |
| Has a series of builder methods for `Module with no default constructir` and `dependency Component/Subcomponent`. | Has a single method that accepts all the dependency as parameter. |
| If the configuration is wrong, we get exception at run-tie | Since here the dependencies are part of parameter list, we get compile time error if there is a mismatch in runtime-parameters. | 

## References:

- [Dagger2 Beginner Tutorial - Android][dagger2_beginner_tutorial_android]

---

[dagger2_beginner_tutorial_android]: https://www.youtube.com/playlist?list=PLrnPJCHvNZuA2ioi4soDZKz8euUQnJW65