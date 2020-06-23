package kartdroid.dagger.experiment.ex2;

import dagger.Component;

@Component
public interface CarComponent {
    Car getCar();
    void inject(App app);
}
