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