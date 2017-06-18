package isfaaghyth.app.mvp.view.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import isfaaghyth.app.mvp.adapter.EmployeeAdapter;
import isfaaghyth.app.mvp.R;
import isfaaghyth.app.mvp.base.BaseActivity;
import isfaaghyth.app.mvp.model.EmployeeModel;
import isfaaghyth.app.mvp.presenter.main.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.lst_employee) RecyclerView lstEmployee;

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_main);
    }

    @Override protected void initialize() {
        lstEmployee.setLayoutManager(new LinearLayoutManager(this));
        presenter.loadEmployees();
    }

    @Override public void onSuccess(EmployeeModel model) {
        lstEmployee.setAdapter(new EmployeeAdapter(model.getData()));
    }

    @Override public void onError(String message) {
        showAlertMessage(message);
    }
}
