package kartdroid.dagger.experiment.ex7.di;

import dagger.BindsInstance;
import dagger.Component;
import kartdroid.dagger.experiment.ex7.App;
import kartdroid.dagger.experiment.ex7.Car;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Component(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder horsePower(@Named("horsePower") int horsePower);
        @BindsInstance
        Builder engineCapacity(@Named("engineCapacity") int engineCapacity);
        CarComponent build();
    }
}
