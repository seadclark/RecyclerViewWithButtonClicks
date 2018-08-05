package id.or.tauhid.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static id.or.tauhid.myapplication.ModelDoa.DOA_BANGUNT;
import static id.or.tauhid.myapplication.ModelDoa.DOA_MASJID;
import static id.or.tauhid.myapplication.ModelDoa.DOA_MAU_TIDUR;
import static id.or.tauhid.myapplication.ModelDoa.DOA_PAGI;
import static id.or.tauhid.myapplication.ModelDoa.DOA_SORE;

public class AdapterDoa extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<ModelDoa> mList;

    public AdapterDoa(List<ModelDoa> list) {

        this.mList = list;
    }

    public ModelDoa getItem(int position) {
        if (position > -1   && position < getItemCount()) {
            return this.mList.get(position);
        } else {
            return null;
        }
    }

    public ModelDoa getItem7(int position) {
        if (position ==2  && position < getItemCount()) {
            return this.mList.get(position);
        } else {
            return null;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {

            case DOA_PAGI:
                View vieu = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_doa, parent, false);
                PagiViewHolder rcv = new PagiViewHolder(vieu, this);
                return rcv;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ModelDoa object = mList.get(position);

        if (object != null) {

            switch (object.getType()) {

                case DOA_PAGI:
                    ((PagiViewHolder) holder).mTitle.setText(object.getName());
                    ((PagiViewHolder) holder).tombolbaca.setText(object.ambilName());
                    break;
            }
        }
    }

    public void deleteItem(int position) {
        mList.remove(position); // hapus list
        notifyItemRemoved(position);
        // notifyItemRangeChanged( position, mList.size());
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            ModelDoa object = mList.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }


}