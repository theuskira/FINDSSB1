package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.Main2Activity;
import br.com.icoddevelopers.findssp.PrevSupermercado;
import br.com.icoddevelopers.findssp.ProdutosActivity;
import br.com.icoddevelopers.findssp.ProdutosSupermercado;
import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.SupermercadoAdapter;
import br.com.icoddevelopers.findssp.SupermercadosActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewHolder = new ViewHolder();
    private BancoDado db = new BancoDado(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.pesquisaSupermercado = (EditText) findViewById(R.id.pesquisa_supermercado);
        this.mViewHolder.perquisar = (Button) findViewById(R.id.btBusca);

        this.mViewHolder.perquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("Supermercado", mViewHolder.pesquisaSupermercado.getText().toString());
                    startActivity(intent);
            }
        });



    }


    private ArrayList<PrevSupermercado> adicionarSupermercados(){
        ArrayList<PrevSupermercado> supermercados = new ArrayList<PrevSupermercado>();
        PrevSupermercado e = new PrevSupermercado("");

        return supermercados;
    }

    private static class ViewHolder{
        EditText pesquisaSupermercado;
        ListView listViewSupermercados;
        Button perquisar;
    }



    /*public void enviarSupermercado(View view){
        EditText nomeSupermercado = (EditText) findViewById(R.id.pesquisa_supermercado);

        Intent intent = new Intent(this, ProdutosActivity.class);

        Bundle params = new Bundle();
        params.putString("Supermercado", nomeSupermercado.getText().toString());

        intent.putExtras(params);

        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflar = getMenuInflater();
        inflar.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.botaoCadastrarProduto){
            Intent intentUsuario = new Intent(this, CadastroProdutosActivity.class);
            startActivity(intentUsuario);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
    }

}
