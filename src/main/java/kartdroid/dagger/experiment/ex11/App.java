package kartdroid.dagger.experiment.ex11;

import kartdroid.dagger.experiment.ex11.di.AppComponent;
import kartdroid.dagger.experiment.ex11.di.CarComponent;
import kartdroid.dagger.experiment.ex11.di.DaggerAppComponent;

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
        CarComponent carComponent1 = appComponent.carComponentFactory().create(100, 1200);
        carComponent1.inject(this);
        car.drive();
        dupeCar.drive();

        System.out.println("=======car-component-2=========");
        CarComponent carComponent2 = appComponent.carComponentFactory().create(120, 1800);
        carComponent2.inject(this);
        car.drive();
        dupeCar.drive();

        System.out.println("======================");
    }
}
