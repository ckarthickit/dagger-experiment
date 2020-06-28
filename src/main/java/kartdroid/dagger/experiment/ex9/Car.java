package kartdroid.dagger.experiment.ex9;

import kartdroid.dagger.experiment.ex9.di.PerTripScope;
import kartdroid.dagger.experiment.ex9.engine.Engine;
import kartdroid.dagger.experiment.ex9.external.Driver;
import kartdroid.dagger.experiment.ex9.external.wheel.Wheels;

import javax.inject.Inject;

@PerTripScope
public class Car {

    private final Driver driver;
    private final Engine engine;
    private final Wheels wheels;
    @Inject
    NamePlate namePlate;

    @Inject
    public Car(Driver driver, Engine engine, Wheels wheels) {
        this.driver = driver;
        this.engine = engine;
        this.wheels = wheels;
    }

    @Inject
    void methodInjectRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive() {
        engine.start();
        System.out.println(driver + " drives " + this);
    }
}
