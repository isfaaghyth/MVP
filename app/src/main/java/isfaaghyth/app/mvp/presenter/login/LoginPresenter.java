package isfaaghyth.app.mvp.presenter.login;

import isfaaghyth.app.mvp.base.BasePresenter;
import isfaaghyth.app.mvp.util.SessionManager;
import isfaaghyth.app.mvp.view.login.LoginView;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super.attachView(view);
    }

    public boolean isLogin() {
        if (SessionManager.checkExist("is_login")) return false;
        if (SessionManager.grabBoolean("is_login")) {
            return true;
        } else {
            return false;
        }
    }

    public void onRequestLogin(String email, String password) {
        
    }
}
