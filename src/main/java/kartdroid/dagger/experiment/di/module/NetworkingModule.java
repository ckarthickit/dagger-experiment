package kartdroid.dagger.experiment.di.module;

import dagger.Binds;
import dagger.Module;
import kartdroid.dagger.experiment.network.DummyNetworkClient;
import kartdroid.dagger.experiment.network.NetworkClient;

@Module
public abstract class NetworkingModule {
    @Binds
    abstract NetworkClient bindsDummy(DummyNetworkClient dummyNetworkClient);
}
