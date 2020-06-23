package kartdroid.dagger.experiment.ex4.engine;

import javax.inject.Inject;

public class PetrolEngine implements Engine {

    @Inject
    public PetrolEngine(){

    }

    @Override
    public void start() {
        System.out.println("Petrol Engine Started.");
    }
}
