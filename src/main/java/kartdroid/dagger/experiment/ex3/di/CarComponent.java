package kartdroid.dagger.experiment.ex3.di;

import dagger.Component;
import dagger.Provides;
import kartdroid.dagger.experiment.ex3.App;
import kartdroid.dagger.experiment.ex3.Car;

@Component(modules = WheelsModule.class)
public interface CarComponent {
    Car getCar();

    void inject(App app);
}
