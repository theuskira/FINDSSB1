package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.cadasto.CadastroActivity;
import br.com.icoddevelopers.findssp.cadasto.CadastroEmpresaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarSupermercado(View view){
        EditText nomeSupermercado = (EditText) findViewById(R.id.pesquisa_supermercado);

        Intent intent = new Intent(this, ProdutosActivity.class);

        Bundle params = new Bundle();
        params.putString("Supermercado", nomeSupermercado.getText().toString());

        intent.putExtras(params);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflar = getMenuInflater();
        inflar.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.botaoContaMenu){
            Intent intentUsuario = new Intent(this, CadastroActivity.class);
            startActivity(intentUsuario);
        }else if(id == R.id.botaoContaEmpresaMenu){
            Intent intentEmpresa = new Intent(this, CadastroEmpresaActivity.class);
            startActivity(intentEmpresa);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
    }
}
