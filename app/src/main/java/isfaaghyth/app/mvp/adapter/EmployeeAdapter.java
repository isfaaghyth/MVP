package isfaaghyth.app.mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import isfaaghyth.app.mvp.R;
import isfaaghyth.app.mvp.adapter.holder.EmployeeHolder;
import isfaaghyth.app.mvp.model.EmployeeModel;

/**
 * Created by isfaaghyth on 6/18/17.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

    private ArrayList<EmployeeModel.Data> datas;

    public EmployeeAdapter(ArrayList<EmployeeModel.Data> datas) {
        this.datas = datas;
    }

    @Override public EmployeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EmployeeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_employee_item, parent, false));
    }

    @Override public void onBindViewHolder(EmployeeHolder holder, int position) {
        holder.setContent(datas.get(position).getName(), String.valueOf(datas.get(position).getId()));
    }

    @Override public int getItemCount() {
        return datas.size();
    }

}
