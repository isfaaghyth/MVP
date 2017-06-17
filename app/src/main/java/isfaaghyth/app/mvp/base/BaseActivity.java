package isfaaghyth.app.mvp.base;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract P initPresenter();

    protected void binding(int layoutId) {
        setContentView(layoutId);
        ButterKnife.bind(this);
        presenter = initPresenter();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.dettachView();
    }
}
