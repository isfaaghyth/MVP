package isfaaghyth.app.mvp.presenter.login;

import isfaaghyth.app.mvp.base.BasePresenter;
import isfaaghyth.app.mvp.view.login.LoginView;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super.attachView(view);
    }

}
