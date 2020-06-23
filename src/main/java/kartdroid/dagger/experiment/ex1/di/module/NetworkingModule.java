package kartdroid.dagger.experiment.ex1.di.module;

import dagger.Binds;
import dagger.Module;
import kartdroid.dagger.experiment.ex1.network.DummyNetworkClient;
import kartdroid.dagger.experiment.ex1.network.NetworkClient;

@Module
public abstract class NetworkingModule {
    @Binds
    abstract NetworkClient bindsDummy(DummyNetworkClient dummyNetworkClient);
}
