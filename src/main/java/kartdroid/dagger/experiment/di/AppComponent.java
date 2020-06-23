package kartdroid.dagger.experiment.di;

import dagger.Component;
import kartdroid.dagger.experiment.App;
import kartdroid.dagger.experiment.di.module.LoggingModule;
import kartdroid.dagger.experiment.di.module.NetworkingModule;
import kartdroid.dagger.experiment.di.scopes.PerApp;

@PerApp
@Component(modules = {LoggingModule.class, NetworkingModule.class}, dependencies = {DataProvider.class})
public interface AppComponent {
    App provideApp();
}
