package kartdroid.dagger.experiment.ex10;

import kartdroid.dagger.experiment.ex10.di.AppComponent;
import kartdroid.dagger.experiment.ex10.di.CarComponent;
import kartdroid.dagger.experiment.ex10.di.DaggerAppComponent;
import kartdroid.dagger.experiment.ex10.di.DieselEngineModule;

import javax.inject.Inject;

public class App implements Runnable {

    @Inject
    protected Car car;

    @Inject
    protected Car dupeCar;

    public static void main(String[] args) {
        new App().run();
    }


    @Override
    public void run() {
        System.out.println("======================");

        System.out.println("=======app-component=========");
        AppComponent appComponent = DaggerAppComponent.create();

        System.out.println("=======car-component-1=========");
        CarComponent carComponent1 = appComponent.carComponentBuilder()
                .horsePower(100)
                .engineCapacity(1200)
                .build();
        carComponent1.inject(this);
        car.drive();
        dupeCar.drive();

        System.out.println("=======car-component-2=========");
        CarComponent carComponent2 = appComponent.carComponentBuilder()
                .horsePower(120)
                .engineCapacity(1800)
                .build();
        carComponent2.inject(this);
        car.drive();
        dupeCar.drive();

        System.out.println("======================");
    }
}
