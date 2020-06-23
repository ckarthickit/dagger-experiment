package kartdroid.dagger.experiment.ex1.network;

public interface NetworkClient {
    void get(String url, Callback<byte[], String> callback);
}
