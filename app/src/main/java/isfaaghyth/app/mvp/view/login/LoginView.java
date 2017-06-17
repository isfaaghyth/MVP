package isfaaghyth.app.mvp.view.login;

import isfaaghyth.app.mvp.model.LoginModel;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public interface LoginView {
    void openMain();

    //callback
    void onSuccess(LoginModel result);
    void onError(String message);
}
