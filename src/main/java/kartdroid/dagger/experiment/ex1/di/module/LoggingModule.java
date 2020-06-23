package kartdroid.dagger.experiment.ex1.di.module;

import dagger.Binds;
import dagger.Module;
import kartdroid.dagger.experiment.ex1.logging.DummyLogger;
import kartdroid.dagger.experiment.ex1.logging.Logger;

@Module
public abstract class LoggingModule {
    @Binds
    abstract Logger bindDummyLogger(DummyLogger dummyLogger);
}
