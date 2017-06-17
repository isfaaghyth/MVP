package isfaaghyth.app.mvp.presenter.login;

import isfaaghyth.app.mvp.base.BasePresenter;
import isfaaghyth.app.mvp.model.LoginModel;
import isfaaghyth.app.mvp.network.RequestCallback;
import isfaaghyth.app.mvp.util.SessionManager;
import isfaaghyth.app.mvp.view.login.LoginView;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super.attachView(view);
    }

    public void isLogin() {
        if (SessionManager.checkExist("is_login")) {
            if (SessionManager.grabBoolean("is_login")) {
                view.openMain();
            }
        }
    }

    public void onRequestLogin(String email, String password) {
        onSubscribe(service.login(email, password), new RequestCallback<LoginModel>() {
            @Override public void onSuccess(LoginModel model) {
                view.onSuccess(model);
            }

            @Override public void onFailure(String message) {
                view.onError(message);
            }

            @Override public void onFinish() {}
        });
    }
}
