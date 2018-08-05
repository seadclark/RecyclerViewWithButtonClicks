package id.or.tauhid.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class PagiViewHolder extends RecyclerView.ViewHolder {
    public TextView mTitle;
    public Button tombolbaca;
    public Button teksbaca;
    public Button tombolshare;
    private RelativeLayout rl2;
    private int klik10 = 10;
    private int klik7 = 7;
    private AdapterDoa myAdapter;
    public List<ModelDoa> mList;

    public PagiViewHolder(View itemView, AdapterDoa myAdapter) {
        super(itemView);
        this.myAdapter = myAdapter;

        itemView.setOnClickListener(mainViewClickListener);
        mTitle = (TextView) itemView.findViewById(R.id.titleTextView);
        tombolbaca = (Button) itemView.findViewById(R.id.buttonbaca);
        tombolshare = (Button) itemView.findViewById(R.id.buttonshare);
        tombolbaca.setOnClickListener(bacaClickListener);
        tombolshare.setOnClickListener(shareClickListener);
        rl2 = (RelativeLayout) itemView.findViewById(R.id.relmasjid);
    }

    private View.OnClickListener bacaClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            teksbaca = (Button) v.findViewById(R.id.buttonbaca);
            ModelDoa modelDoa = myAdapter.getItem(getAdapterPosition());
            ModelDoa modelDoa7 = myAdapter.getItem7(getAdapterPosition());

            if (modelDoa != null) {
                modelDoa.setRead10(modelDoa.getRead10() - 1);
                teksbaca.setText("Read " + modelDoa.getRead10() + "x");

                if (modelDoa.getRead10() <= 0) {
                    myAdapter.deleteItem(getAdapterPosition());
                }

            } else
            if (modelDoa7 != null) {
                modelDoa7.setRead7(modelDoa7.getRead7() - 1);
                teksbaca.setText("Read " + modelDoa7.getRead7() + "x");

                if (modelDoa7.getRead7() <= 0) {
                    myAdapter.deleteItem(getAdapterPosition());
                }
            }

        } // onclick
    };

    private View.OnClickListener shareClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // Do button click handling here
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, mTitle.getText().toString() + "\n \n download aplikasinya di: http://www.tauhid.or.id" );
                sendIntent.setType("text/plain");
                Intent.createChooser(sendIntent,"Share via");
                v.getContext().startActivity(sendIntent);
        }
    };

    private View.OnClickListener mainViewClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // Do button click handling here
        }
    };


}

