package kartdroid.dagger.experiment.di.module;

import dagger.Binds;
import dagger.Module;
import kartdroid.dagger.experiment.logging.DummyLogger;
import kartdroid.dagger.experiment.logging.Logger;

@Module
public abstract class LoggingModule {
    @Binds
    abstract Logger bindDummyLogger(DummyLogger dummyLogger);
}
