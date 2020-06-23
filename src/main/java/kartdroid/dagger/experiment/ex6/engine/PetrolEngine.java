package kartdroid.dagger.experiment.ex6.engine;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {

    private final int horsePower;
    private final int engineCapacity;

    @Inject
    public PetrolEngine(@Named("horsePower") int horsePower,@Named("engineCapacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        System.out.println(
                "Petrol Engine Started. " +
                        "\nHorsePower: " + horsePower +
                        "\nEngine Capacity: " + engineCapacity);
    }
}
