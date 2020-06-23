package kartdroid.dagger.experiment;

import kartdroid.dagger.experiment.logging.Logger;

import javax.inject.Inject;

public class ProvidedDependency {
    @Inject
    public Logger logger;
}
