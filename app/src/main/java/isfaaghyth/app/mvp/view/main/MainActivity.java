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

    private ArrayList<EmployeeModel.Data> datas = new ArrayList<>();
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
        adapter = new RecyclerAdapter<EmployeeModel.Data, EmployeeHolder>(R.layout.layout_employee_item, EmployeeHolder.class, EmployeeModel.Data.class, datas) {
            @Override protected void bind(EmployeeHolder holder, EmployeeModel.Data model, int position) {
                holder.setContent(model.getName(), model.getId()+"");
            }
        };
        lstEmployee.setAdapter(adapter);
    }

    @Override public void onSuccess(EmployeeModel model) {
        datas = model.getData();
        adapter.notifyDataSetChanged();
    }

    @Override public void onError(String message) {
        showAlertMessage(message);
    }
}
