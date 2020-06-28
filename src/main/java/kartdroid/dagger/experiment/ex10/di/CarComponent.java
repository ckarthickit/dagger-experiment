package kartdroid.dagger.experiment.ex10.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kartdroid.dagger.experiment.ex10.App;
import kartdroid.dagger.experiment.ex10.Car;

import javax.inject.Named;

@PerTripScope
@Subcomponent(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(App app);

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder horsePower(@Named("horsePower") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engineCapacity") int engineCapacity);

        CarComponent build();
    }
}
