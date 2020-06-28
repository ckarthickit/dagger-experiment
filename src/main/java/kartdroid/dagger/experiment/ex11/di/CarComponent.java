package kartdroid.dagger.experiment.ex11.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kartdroid.dagger.experiment.ex11.App;
import kartdroid.dagger.experiment.ex11.Car;

import javax.inject.Named;

@PerTripScope
@Subcomponent(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(App app);

    @Subcomponent.Factory
    interface Factory {
        CarComponent create(@BindsInstance @Named("horsePower") int horsePower, @BindsInstance @Named("engineCapacity") int engineCapacity);
    }
}
