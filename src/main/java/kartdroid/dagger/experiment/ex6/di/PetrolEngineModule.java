package kartdroid.dagger.experiment.ex6.di;

import dagger.Binds;
import dagger.Module;
import kartdroid.dagger.experiment.ex6.engine.Engine;
import kartdroid.dagger.experiment.ex6.engine.PetrolEngine;

@Module
public abstract class PetrolEngineModule {


    /**
     * static @Provides can also be used to bind a concrete implementation to an interface.
     *
     * @param petrolEngine
     * @return {@link Engine}
     */
//    @Provides
//    static Engine providePetrolEngine(PetrolEngine petrolEngine) {
//        return petrolEngine;
//    }
    @Binds
    abstract Engine bindsEngine(PetrolEngine petrolEngine);
}
