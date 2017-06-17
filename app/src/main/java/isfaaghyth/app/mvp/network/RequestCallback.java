package isfaaghyth.app.mvp.network;

import android.util.Log;

import retrofit2.HttpException;
import rx.Subscriber;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public abstract class RequestCallback<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);
    public abstract void onFailure(String message);
    public abstract void onFinish();

    @Override public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            String message = httpException.getMessage();
            onFailure(message);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override public void onNext(M model) {
        onSuccess(model);
    }

    @Override public void onCompleted() {
        onFinish();
    }

}
