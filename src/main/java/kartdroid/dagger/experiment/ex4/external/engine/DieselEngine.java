package kartdroid.dagger.experiment.ex4.external.engine;

import kartdroid.dagger.experiment.ex4.engine.Engine;

public class DieselEngine implements Engine {

    public DieselEngine() {

    }

    @Override
    public void start() {
        System.out.println("Diesel Engine Started.");
    }
}
