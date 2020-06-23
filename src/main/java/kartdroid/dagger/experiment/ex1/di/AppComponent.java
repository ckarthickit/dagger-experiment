package kartdroid.dagger.experiment.ex1.di;

import dagger.Component;
import kartdroid.dagger.experiment.ex1.App;
import kartdroid.dagger.experiment.ex1.ProvidedDependency;
import kartdroid.dagger.experiment.ex1.di.module.LoggingModule;
import kartdroid.dagger.experiment.ex1.di.module.NetworkingModule;
import kartdroid.dagger.experiment.ex1.di.module.ManuallyInjectedProviderModule;
import kartdroid.dagger.experiment.ex1.di.scopes.PerApp;

@PerApp
@Component(modules = {LoggingModule.class, NetworkingModule.class, ManuallyInjectedProviderModule.class}, dependencies = {DataProvider.class})
public interface AppComponent {
    App provideApp();

    void inject(ProvidedDependency providedDependency);
}
