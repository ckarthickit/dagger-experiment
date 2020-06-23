package kartdroid.dagger.experiment.ex5.external.engine;

import kartdroid.dagger.experiment.ex5.engine.Engine;

public class DieselEngine implements Engine {

    private final int horsePower;

    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        System.out.println("Diesel Engine Started. horsePowe: " + horsePower);
    }
}
