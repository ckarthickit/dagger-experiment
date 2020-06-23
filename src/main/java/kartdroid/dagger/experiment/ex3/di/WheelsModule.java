package kartdroid.dagger.experiment.ex3.di;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ex3.external.Rims;
import kartdroid.dagger.experiment.ex3.external.Tires;
import kartdroid.dagger.experiment.ex3.external.Wheels;

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
