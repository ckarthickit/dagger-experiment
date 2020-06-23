package kartdroid.dagger.experiment.ex4.di;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ex4.engine.Engine;
import kartdroid.dagger.experiment.ex4.external.engine.DieselEngine;

@Module
public class DieselEngineModule {

    @Provides
    static Engine providesEngine() {
        return new DieselEngine();
    }
}
