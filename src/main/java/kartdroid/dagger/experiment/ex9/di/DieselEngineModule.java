package kartdroid.dagger.experiment.ex9.di;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ex9.engine.Engine;
import kartdroid.dagger.experiment.ex9.external.engine.DieselEngine;

import javax.inject.Named;

@Module
public class DieselEngineModule {

//    @Named("horsePower")
//    @Provides
//    static int providesHorsePower() {
//        return 100;
//    }
//
//    @Named("engineCapacity")
//    @Provides
//    static int providesEngineCapacity() {
//        return 1400;
//    }

    private final int horsePower;
    private final int engineCapacity;
    public DieselEngineModule(int horsePower, int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Provides
    /*static*/ Engine providesEngine(/*@Named("horsePower") int horsePower, @Named("engineCapacity") int engineCapacity*/) {
        return new DieselEngine(horsePower, engineCapacity);
    }
}
