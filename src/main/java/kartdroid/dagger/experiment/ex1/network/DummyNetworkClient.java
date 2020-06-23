package kartdroid.dagger.experiment.ex1.network;


import javax.inject.Inject;

public class DummyNetworkClient implements NetworkClient {

    @Inject
    DummyNetworkClient() {

    }

    @Override
    public void get(String url, Callback<byte[], String> callback) {
        double random = Math.random() * 10;
        byte[] dummyValue = (random < 5) ? "Dummy Value".getBytes() : null;
        String dummyError = (dummyValue == null) ? "Error Occurred" : null;
        callback.onComplete(dummyValue, dummyError);
    }
}
