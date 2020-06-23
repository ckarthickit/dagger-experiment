package kartdroid.dagger.experiment.ex5.di;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ex5.engine.Engine;
import kartdroid.dagger.experiment.ex5.external.engine.DieselEngine;

@Module
public class DieselEngineModule {

    private final int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    Engine providesEngine() {
        return new DieselEngine(horsePower);
    }
}
