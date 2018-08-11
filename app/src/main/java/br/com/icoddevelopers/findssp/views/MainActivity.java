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

import java.util.ArrayList;

import br.com.icoddevelopers.findssp.BancoController;
import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.Constants;
import br.com.icoddevelopers.findssp.PrevSupermercado;
import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.Status;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewHolder = new ViewHolder();
    private BancoDado db = new BancoDado(this);
    private Status status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.status  = new Status(this);

        this.mViewHolder.pesquisaSupermercado = (EditText) findViewById(R.id.pesquisa_supermercado);
        this.mViewHolder.perquisar = (Button) findViewById(R.id.btBusca);

        this.mViewHolder.perquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(mViewHolder.pesquisaSupermercado.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Campo Vazio!", Toast.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("Supermercado", mViewHolder.pesquisaSupermercado.getText().toString());
                        startActivity(intent);
                    }
            }
        });


        BancoController crud = new BancoController(getBaseContext());

        crud.insereEmpresa("teste", "teste@gmail.com", "1", 1, "1", "1", 1, "1");
        crud.insereDado(1, "Arroz", "10", "10", 10);
        crud.insereDado(1, "Feijão", "11", "11", 11);
        crud.insereDado(1, "Batata", "12", "12", 12);
        crud.insereDado(1, "O que falta?", "13", "13", 13);
        crud.insereDado(1, "test", "14", "14", 15.7f);
        crud.insereDadoEco(1, "Arroz", "10", "10", 14);

    }


    private ArrayList<PrevSupermercado> adicionarSupermercados(){
        ArrayList<PrevSupermercado> supermercados = new ArrayList<PrevSupermercado>();
        PrevSupermercado e = new PrevSupermercado("");

        return supermercados;
    }

    private static class ViewHolder{
        EditText pesquisaSupermercado;
        Button perquisar;
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
        String logado = status.getStorageStrin(Constants.LOGADO_EMPRESA);

        if(id == R.id.botaoCadastrarProduto){
            if(logado.equals(Constants.VERDADE)){
                Intent intent = new Intent(this, CadastroProdutosActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(MainActivity.this, "Empresa Nao Conectada!", Toast.LENGTH_LONG).show();
            }
        }else if(id == R.id.botaoConta){
            if(logado.equals("")){
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Usuario Nao Conectado!", Toast.LENGTH_LONG).show();
            }else if(logado.equals(Constants.VERDADE)){
                Intent intent = new Intent(this, ContaActivity.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Usuario Nao Conectado!", Toast.LENGTH_LONG).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
    }

}
