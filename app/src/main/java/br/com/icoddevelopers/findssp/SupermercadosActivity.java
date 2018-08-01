package br.com.icoddevelopers.findssp;

import  android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.views.CadastroProdutosActivity;

public class SupermercadosActivity extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermercados);
    /*
        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();
        try{

            String[] nomeCampos = new String[]{BancoDado.getColunaSupermercado(), BancoDado.getColunaProduto()};
            int[] idViews = new int[]{R.id.idLivro, R.id.nomeLivro};

            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                    R.layout.activity_supermercados, cursor, nomeCampos, idViews, 0);
            lista = (ListView) findViewById(R.id.listView);
            lista.setAdapter(adaptador);

            Toast.makeText(SupermercadosActivity.this, "Sucesso", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(SupermercadosActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }*/


    }
}
