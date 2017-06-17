package isfaaghyth.app.mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by isfaaghyth on 6/18/17.
 */

public abstract class RecyclerAdapter<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    abstract protected void bind(VH holder, M model, int position);

    protected int layoutId;
    Class<VH> viewHolderClass;
    Class<M> modelClass;
    ArrayList<M> datas;

    public RecyclerAdapter(int layoutId, Class<VH> viewHolderClass, Class<M> modelClass, ArrayList<M> datas) {
        this.layoutId = layoutId;
        this.viewHolderClass = viewHolderClass;
        this.modelClass = modelClass;
        this.datas = datas;
    }

    @Override public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        try {
            Constructor<VH> constructor = viewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    @Override public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        M model = getItem(position);
        bind(holder, model, position);
    }

    private M getItem(int position) {
        return datas.get(position);
    }
}
