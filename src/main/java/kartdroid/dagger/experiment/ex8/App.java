package kartdroid.dagger.experiment.ex8;

import kartdroid.dagger.experiment.ex8.di.AppComponent;
import kartdroid.dagger.experiment.ex8.di.CarComponent;
import kartdroid.dagger.experiment.ex8.di.DaggerAppComponent;
import kartdroid.dagger.experiment.ex8.di.DaggerCarComponent;

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
        System.out.println("driver is: " + appComponent.getDriver());


        System.out.println("=======car-component-1=========");
        CarComponent carComponent1 = DaggerCarComponent.builder()
                .horsePower(100)
                .engineCapacity(1400)
                .appComponent(appComponent)
                .build();
        carComponent1.inject(this);
        car.drive();
        dupeCar.drive();


        System.out.println("=======car-component-2=========");
        CarComponent carComponent2 = DaggerCarComponent.builder()
                .horsePower(120)
                .engineCapacity(1800)
                .appComponent(appComponent)
                .build();
        carComponent2.inject(this);
        car.drive();
        dupeCar.drive();

        
        System.out.println("======================");
    }
}
