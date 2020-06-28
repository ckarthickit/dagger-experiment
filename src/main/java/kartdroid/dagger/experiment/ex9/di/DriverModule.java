package kartdroid.dagger.experiment.ex9.di;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ex9.external.Driver;

import javax.inject.Singleton;

@Module
public abstract class DriverModule {

    @Singleton
    @Provides
    static Driver providesDriver() {
        return new Driver();
    }
}
