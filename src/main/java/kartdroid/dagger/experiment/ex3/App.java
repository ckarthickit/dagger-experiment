package kartdroid.dagger.experiment.ex3;

import kartdroid.dagger.experiment.ex3.di.CarComponent;
import kartdroid.dagger.experiment.ex3.di.DaggerCarComponent;

import javax.inject.Inject;

public class App implements Runnable {

    @Inject
    Car car;

    public static void main(String[] args) {
        new App().run();
    }


    @Override
    public void run() {
        CarComponent carComponent = DaggerCarComponent.create();
        carComponent.inject(this);
        car.drive();
    }
}
