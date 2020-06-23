package kartdroid.dagger.experiment.ex2;

import javax.inject.Inject;

public class Remote {
    @Inject
    public Remote() {

    }

    public void setListener(Car car) {
        if (car != null) {
            System.out.println("car is listening...");
        }
    }
}
