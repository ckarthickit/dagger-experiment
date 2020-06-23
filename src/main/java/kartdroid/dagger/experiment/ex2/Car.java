package kartdroid.dagger.experiment.ex2;

import javax.inject.Inject;

public class Car {
    private final Engine engine;
    private final Wheels wheels;

    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        System.out.println("driving...");
    }
}
