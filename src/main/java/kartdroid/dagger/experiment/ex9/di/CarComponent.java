package kartdroid.dagger.experiment.ex9.di;

import dagger.Subcomponent;
import kartdroid.dagger.experiment.ex9.App;
import kartdroid.dagger.experiment.ex9.Car;

@PerTripScope
@Subcomponent(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(App app);

    /*@Component.Builder
    interface Builder {
        @BindsInstance
        Builder horsePower(@Named("horsePower") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engineCapacity") int engineCapacity);

        Builder appComponent(AppComponent appComponent);

        CarComponent build();
    }*/
}
