package br.com.icoddevelopers.findssp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.views.MainActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    BancoDado db;

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.mViewHolder.txtSupermercado = (TextView) findViewById(R.id.txtSupermercado);
        this.mViewHolder.btnPesquisar = (Button) findViewById(R.id.btnPesquisar);
        this.mViewHolder.btnList = (Button) findViewById(R.id.btnList);
        this.mViewHolder.btnEco = (Button) findViewById(R.id.btnEco);

        db = new BancoDado(this);

        Intent intent = getIntent();
        final String supermercado = intent.getStringExtra("Supermercado");

        try {
            db.list_Supermercado(supermercado, mViewHolder.txtSupermercado);
            db.close();
        }catch (Exception e){
            Toast.makeText(Main2Activity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        this.mViewHolder.btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ProdutosActivity.class);
                intent.putExtra("Supermercado", supermercado);
                startActivity(intent);
            }
        });

        this.mViewHolder.btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ListActivity.class);
                intent.putExtra("Supermercado", supermercado);
                startActivity(intent);
            }
        });

        this.mViewHolder.btnEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "Função Ainda Não Terminada!", Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public void onClick(View view) {

    }


    private static class ViewHolder{
        TextView txtSupermercado;
        Button btnPesquisar;
        Button btnList;
        Button btnEco;
    }
}
