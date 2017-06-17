package isfaaghyth.app.mvp.presenter.main;

import isfaaghyth.app.mvp.base.BasePresenter;
import isfaaghyth.app.mvp.view.main.MainView;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        super.attachView(view);
    }


}
