package kartdroid.dagger.experiment.ex8.external.engine;

import kartdroid.dagger.experiment.ex8.engine.Engine;

public class DieselEngine implements Engine {

    private final int horsePower;
    private final int engineCapacity;

    public DieselEngine(int horsePower, int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        System.out.println(
                "Diesel Engine Started. " +
                        "\nHorsePower: " + horsePower +
                        "\nEngine Capacity: " + engineCapacity);
    }
}
