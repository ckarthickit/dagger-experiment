package kartdroid.dagger.experiment.ex9;

import kartdroid.dagger.experiment.ex8.di.DaggerCarComponent;
import kartdroid.dagger.experiment.ex9.di.AppComponent;
import kartdroid.dagger.experiment.ex9.di.CarComponent;
import kartdroid.dagger.experiment.ex9.di.DaggerAppComponent;
import kartdroid.dagger.experiment.ex9.di.DieselEngineModule;
import kartdroid.dagger.experiment.ex9.external.Driver;

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
//
        System.out.println("=======app-component=========");
        AppComponent appComponent = DaggerAppComponent.create();
//
//
        System.out.println("=======car-component-1=========");
        CarComponent carComponent1 = appComponent.provideNewCarSubComponent(new DieselEngineModule(102,1800));
        carComponent1.inject(this);
        car.drive();
        dupeCar.drive();

        System.out.println("=======car-component-2=========");
        CarComponent carComponent2 = appComponent.provideNewCarSubComponent(new DieselEngineModule(104,1200));
        carComponent2.inject(this);
        car.drive();
        dupeCar.drive();
        System.out.println("======================");
    }
}
