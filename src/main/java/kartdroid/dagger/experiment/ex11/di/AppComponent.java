package kartdroid.dagger.experiment.ex11.di;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DriverModule.class})
public interface AppComponent {
    CarComponent.Factory carComponentFactory();
}
