package kartdroid.dagger.experiment.ex6;

import kartdroid.dagger.experiment.ex6.di.CarComponent;
import kartdroid.dagger.experiment.ex6.di.DaggerCarComponent;

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
                .horsePower(100)
                .engineCapacity(1500)
                .build();
        carComponent.inject(this);
        car.drive();
    }
}
