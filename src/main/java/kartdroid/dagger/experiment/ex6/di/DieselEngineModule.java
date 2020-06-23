package kartdroid.dagger.experiment.ex6.di;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ex6.engine.Engine;
import kartdroid.dagger.experiment.ex6.external.engine.DieselEngine;

import javax.inject.Named;

@Module
public abstract class DieselEngineModule {

    @Provides
    static Engine providesEngine(@Named("horsePower") int horsePower,@Named("engineCapacity") int engineCapacity) {
        return new DieselEngine(horsePower, engineCapacity);
    }
}
