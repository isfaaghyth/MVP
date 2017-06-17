package isfaaghyth.app.mvp.base;

import android.util.Log;

import isfaaghyth.app.mvp.network.NetworkClient;
import isfaaghyth.app.mvp.network.NetworkServices;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by isfaaghyth on 6/18/17.
 */

public class BasePresenter<V> {
    public V view;
    protected NetworkServices service;
    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;

    public void attachView(V view) {
        this.view = view;
        service = NetworkClient.request().create(NetworkServices.class);
    }

    public void dettachView() {
        this.view = null;
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
            Log.e("BasePresenter", "dettachView");
        }
    }

    protected void onSubscribe(Observable observable, Subscriber subscriber) {
        this.subscriber = subscriber;

        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    protected void stop() {
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }
}
