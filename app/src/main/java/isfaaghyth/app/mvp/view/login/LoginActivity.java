package isfaaghyth.app.mvp.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import isfaaghyth.app.mvp.R;
import isfaaghyth.app.mvp.base.BaseActivity;
import isfaaghyth.app.mvp.model.LoginModel;
import isfaaghyth.app.mvp.presenter.login.LoginPresenter;
import isfaaghyth.app.mvp.view.main.MainActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.edt_email) EditText edtEmail;
    @BindView(R.id.edt_password) EditText edtPassword;

    @Override protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_login);
        presenter.isLogin();
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick() {
        String email = edtEmail.getText().toString();
        String pass = edtPassword.getText().toString();
        presenter.onRequestLogin(email, pass);
    }

    @Override public void onSuccess(LoginModel result) {
        if (result.isStatus()) {
            openMain();
        } else {
            showAlertMessage(result.getMessage());
        }
    }

    @Override public void onError(String message) {
        showAlertMessage(message);
    }

    @Override public void openMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
