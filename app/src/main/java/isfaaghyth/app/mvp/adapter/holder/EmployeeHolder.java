package isfaaghyth.app.mvp.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import isfaaghyth.app.mvp.R;

/**
 * Created by isfaaghyth on 6/18/17.
 */

public class EmployeeHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title) private TextView txtTitle;
    @BindView(R.id.txt_desc) private TextView txtDesc;

    public EmployeeHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setContent(String title, String desc) {
        txtTitle.setText(title);
        txtDesc.setText(desc);
    }
}
