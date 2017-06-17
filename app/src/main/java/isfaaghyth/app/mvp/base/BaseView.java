package isfaaghyth.app.mvp.base;

/**
 * Created by isfaaghyth on 6/18/17.
 */

public interface BaseView<M> {
    void onSuccess(M model);
    void onError(String message);
}
