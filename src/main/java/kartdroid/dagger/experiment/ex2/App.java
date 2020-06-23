package kartdroid.dagger.experiment.ex2;

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
