package kartdroid.dagger.experiment.network;

import javax.annotation.Nullable;

@FunctionalInterface
public interface Callback<V, E> {
    void onComplete(@Nullable V value, @Nullable E error);
}
