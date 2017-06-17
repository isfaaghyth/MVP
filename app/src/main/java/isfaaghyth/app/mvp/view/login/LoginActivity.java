package isfaaghyth.app.mvp.view.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import isfaaghyth.app.mvp.R;
import isfaaghyth.app.mvp.base.BaseActivity;
import isfaaghyth.app.mvp.presenter.login.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.edt_email) EditText edtEmail;
    @BindView(R.id.edt_password) EditText edtPassword;

    @Override protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_login);
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick() {
    }

}
