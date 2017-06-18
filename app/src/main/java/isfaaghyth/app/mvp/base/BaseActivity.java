package isfaaghyth.app.mvp.base;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract P initPresenter();
    protected abstract void initialize();

    protected void binding(int layoutId) {
        setContentView(layoutId);
        ButterKnife.bind(this);
        presenter = initPresenter();
        initialize();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.dettachView();
    }

    protected void showAlertMessage(String message) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(message);
        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {}
        });
        alert.show();
    }
}
