package br.com.icoddevelopers.findssp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListSupermercadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_supermercados);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.supermercadoList);
        //List<>
    }
}
