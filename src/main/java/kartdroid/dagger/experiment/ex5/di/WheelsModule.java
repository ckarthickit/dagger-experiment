package kartdroid.dagger.experiment.ex5.di;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ex5.external.wheel.Rims;
import kartdroid.dagger.experiment.ex5.external.wheel.Tires;
import kartdroid.dagger.experiment.ex5.external.wheel.Wheels;

@Module
public class WheelsModule {

    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    Tires provideInflatedTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
