package kartdroid.dagger.experiment.ex9.di;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DriverModule.class})
public interface AppComponent {
    CarComponent provideNewCarSubComponent(DieselEngineModule dieselEngineModule);
}
