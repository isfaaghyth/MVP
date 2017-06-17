package isfaaghyth.app.mvp.presenter.main;

import android.util.Log;

import isfaaghyth.app.mvp.base.BasePresenter;
import isfaaghyth.app.mvp.model.EmployeeModel;
import isfaaghyth.app.mvp.network.RequestCallback;
import isfaaghyth.app.mvp.view.main.MainView;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        super.attachView(view);
    }

    public void loadEmployees() {
        onSubscribe(service.getEmployee(), new RequestCallback<EmployeeModel>() {
            @Override public void onSuccess(EmployeeModel model) {
                Log.d(model.getData().get(0).getName(), "");
                view.onSuccess(model);
            }

            @Override public void onFailure(String message) {
                view.onError(message);
            }

            @Override public void onFinish() {

            }
        });
    }
}
