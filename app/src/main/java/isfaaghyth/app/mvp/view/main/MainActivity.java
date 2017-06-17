package isfaaghyth.app.mvp.view.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import isfaaghyth.app.mvp.R;
import isfaaghyth.app.mvp.adapter.RecyclerAdapter;
import isfaaghyth.app.mvp.adapter.holder.EmployeeHolder;
import isfaaghyth.app.mvp.base.BaseActivity;
import isfaaghyth.app.mvp.model.EmployeeModel;
import isfaaghyth.app.mvp.presenter.main.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.lst_employee) RecyclerView lstEmployee;

    private ArrayList<EmployeeModel> datas = new ArrayList<>();
    private RecyclerAdapter adapter;

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_main);
        initialize();
    }

    @Override protected void initialize() {
        presenter.loadEmployees();
        lstEmployee.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter<EmployeeModel, EmployeeHolder>(R.layout.layout_employee_item, EmployeeHolder.class, EmployeeModel.class, datas) {
            @Override protected void bind(EmployeeHolder holder, EmployeeModel model, int position) {
                for (int i = 0; i < model.getData().size(); i++) {
                    holder.setContent(model.getData().get(i).getName(), model.getData().get(i).getId()+"");
                }
            }
        };
        lstEmployee.setAdapter(adapter);
    }

    @Override public void onSuccess(EmployeeModel model) {

    }

    @Override public void onError(String message) {

    }
}
