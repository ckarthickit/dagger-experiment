package kartdroid.dagger.experiment.ex8.di;

import dagger.Component;
import kartdroid.dagger.experiment.ex8.Driver;

import javax.inject.Singleton;

@Singleton
@Component
public interface AppComponent {
    // "this component dependencies have to be exposed,
    // otherwise components which add  "this" component to their dependencies,
    // cannot access them
    Driver getDriver();
}
