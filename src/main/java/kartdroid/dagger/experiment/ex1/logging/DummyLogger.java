package kartdroid.dagger.experiment.ex1.logging;

import kartdroid.dagger.experiment.ex1.di.scopes.PerApp;

import javax.inject.Inject;

@PerApp
public class DummyLogger implements Logger {

    @Inject
    DummyLogger(){

    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
