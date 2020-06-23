package kartdroid.dagger.experiment.ex5;

import kartdroid.dagger.experiment.ex5.di.CarComponent;
import kartdroid.dagger.experiment.ex5.di.DaggerCarComponent;
import kartdroid.dagger.experiment.ex5.di.DieselEngineModule;

import javax.inject.Inject;

public class App implements Runnable {

    @Inject
    Car car;

    public static void main(String[] args) {
        new App().run();
    }


    @Override
    public void run() {
        CarComponent carComponent = DaggerCarComponent.builder()
                .dieselEngineModule(new DieselEngineModule(100))
                .build();
        carComponent.inject(this);
        car.drive();
    }
}
