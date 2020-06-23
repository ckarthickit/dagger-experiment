package kartdroid.dagger.experiment.ex5.di;

import dagger.Component;
import kartdroid.dagger.experiment.ex5.App;
import kartdroid.dagger.experiment.ex5.Car;

@Component(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(App app);
}
