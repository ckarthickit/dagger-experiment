package kartdroid.dagger.experiment.di.module;

import dagger.Module;
import dagger.Provides;
import kartdroid.dagger.experiment.ProvidedDependency;

/**
 * A Module which Provides something that is injected at runtime manually.
 * </p>
 * <b>Please note that this Module is not abstract</b>.
 */
@Module
public class ManuallyInjectedProviderModule {

    private final ProvidedDependency providedDependency;

    public ManuallyInjectedProviderModule(ProvidedDependency providedDependency) {
        this.providedDependency = providedDependency;
    }

    @Provides
    ProvidedDependency providesRuntimeDependency() {
        return this.providedDependency;
    }
}
