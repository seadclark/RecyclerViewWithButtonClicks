package id.or.tauhid.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DoaPagi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_pagi);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<ModelDoa> rowListItem =  getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DoaPagi.this);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        AdapterDoa rcAdapter = new AdapterDoa(rowListItem);
        mRecyclerView.setAdapter(rcAdapter);

    }

    private List<ModelDoa> getData() {

        String[] data = getResources().getStringArray(R.array.doapagi);
        String[] baca = getResources().getStringArray(R.array.bacapagi);

        List<ModelDoa> list = new ArrayList<ModelDoa>();

        for (int i = 0; i < data.length; i++) {
                list.add(new ModelDoa(data[i], baca[i], ModelDoa.DOA_PAGI));
        }

        return list;
    }

    // Agar back button pada halaman induk settings berfungsi
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}