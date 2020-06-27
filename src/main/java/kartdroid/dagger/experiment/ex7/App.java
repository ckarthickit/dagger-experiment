package kartdroid.dagger.experiment.ex7;

import kartdroid.dagger.experiment.ex7.di.CarComponent;
import kartdroid.dagger.experiment.ex7.di.DaggerCarComponent;

import javax.inject.Inject;

public class App implements Runnable {

    public static void main(String[] args) {
        new App().run();
    }


    @Override
    public void run() {
        System.out.println("======================");
        CarComponent carComponent1 = DaggerCarComponent.builder()
                .horsePower(100)
                .engineCapacity(1500)
                .build();
        carComponent1.inject(this);
        carComponent1.getCar().drive();

        System.out.println("======================");
        CarComponent carComponent2 = DaggerCarComponent.builder()
                .horsePower(200)
                .engineCapacity(1800)
                .build();
        carComponent2.inject(this);
        carComponent2.getCar().drive();
        System.out.println("======================");
    }
}
