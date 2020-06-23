package kartdroid.dagger.experiment.ex3;

import kartdroid.dagger.experiment.ex3.external.Wheels;

import javax.inject.Inject;

public class Car {

    private final Engine engine;
    private final Wheels wheels;
    @Inject
    NamePlate namePlate;

    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    @Inject
    void methodInjectRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive() {
        System.out.println("driving...");
    }
}
