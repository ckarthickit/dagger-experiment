package kartdroid.dagger.experiment.ex4.di;

import dagger.Component;
import kartdroid.dagger.experiment.ex4.App;
import kartdroid.dagger.experiment.ex4.Car;

@Component(modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(App app);
}
