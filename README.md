# Dagger Experiments

## Notes

- `Constructor Innjection` should be preferred whenever possible.
- `Field Injection / Member Injection` should be preferred when we don't have access to the Constructors.
    - Downside of Field Injection is that **fields / members**  cannot be private.
- `Method Injection` should be preferred when we want to do some configuration **after we create an Object**.

> Field and Method Injection is automatic **ONLY WHEN** Constructor Injection is in place.  

> Field and Method Injection happens on an Object which doesn't have Constructor Injection,
> when **we call the corresponding `inject` method on the `Component`**.
>> In this scenario, we pass our instance to the `Component` and ask it to **inject the fields & method** for us.
- Order of Injection:
    1. Constructor Injection.
    2. Field Injection.
    3. Method Injection.
 
- `Provider Methods` should be preferred when we are injecting `third-party` classes
    - Provider Methods **CAN ONLY BE** defined in `Module`, and the corresponding `Module` should be mapped to `Component`.
    > Provide Methods can be "static" if they don't depend on the state/members of a Module.

- `Binds Method` should be preferred when we want to bind an **implementation** to an **interface** dependency.

- `Injecting Values @ Runtime` to our Dependencies
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
        
- Binding `more than 1 instance` for a particular `type`
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
