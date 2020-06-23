package kartdroid.dagger.experiment.network;

public interface NetworkClient {
    void get(String url, Callback<byte[], String> callback);
}
