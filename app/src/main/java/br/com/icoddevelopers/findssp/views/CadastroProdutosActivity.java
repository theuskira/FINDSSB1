package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.icoddevelopers.findssp.BancoController;
import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.Constants;
import br.com.icoddevelopers.findssp.ProdutosSupermercado;
import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.Status;

public class CadastroProdutosActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewHolder = new ViewHolder();
    private BancoDado db = new BancoDado(this);
    private Status status;
    private int supermercado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produtos);

        mViewHolder.nomeProduto = (EditText) findViewById(R.id.cadastroNomeProduto);
        mViewHolder.corredorProduto = (EditText) findViewById(R.id.cadastroCorredorProduto);
        mViewHolder.prateleiraProduto = (EditText) findViewById(R.id.cadastroPrateleiraProduto);
        mViewHolder.precoProduto = (EditText) findViewById(R.id.cadastroPrecoProduto);
        mViewHolder.nomeSupermercado = (TextView) findViewById(R.id.cadastroProdutoNomeSupermercado);
        mViewHolder.cnpjSupermercado = (TextView) findViewById(R.id.cadastroProdutoCNPJSupermercado);
        mViewHolder.checkEco = (CheckBox) findViewById(R.id.checkEco);


        status = new Status(this);


        try {
            db.verificar_empresa(status.getStorageStrin(Constants.EMAIL_EMPRESA_LOGADA), mViewHolder.nomeSupermercado);
            db.close();
        }catch (Exception e){
            Toast.makeText(CadastroProdutosActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
        try {
            db.verificar_cnpj(status.getStorageStrin(Constants.EMAIL_EMPRESA_LOGADA), mViewHolder.cnpjSupermercado);
            supermercado =  Integer.parseInt(mViewHolder.cnpjSupermercado.getText().toString());
            db.close();
        }catch (Exception e){
            Toast.makeText(CadastroProdutosActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onClick(View view) {

    }

    private static class ViewHolder{
        EditText nomeProduto;
        EditText corredorProduto;
        EditText prateleiraProduto;
        EditText precoProduto;
        TextView nomeSupermercado;
        TextView cnpjSupermercado;
        CheckBox checkEco;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflar = getMenuInflater();
        inflar.inflate(R.menu.menucadastro, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.usuarioSalvar){

            String produto = mViewHolder.nomeProduto.getText().toString();
            String corredor = mViewHolder.corredorProduto.getText().toString();
            String prateleira = mViewHolder.prateleiraProduto.getText().toString();

            float preco = 0f;
            if(mViewHolder.precoProduto.getText().toString().equals("")){
                preco = 0f;
            }else{
                preco = Float.parseFloat(mViewHolder.precoProduto.getText().toString());
            }

            if(produto.equals("") || corredor.equals("") || prateleira.equals("")){
                Toast.makeText(CadastroProdutosActivity.this, "Campos Obrigatorios Faltando!", Toast.LENGTH_LONG).show();
            }else{

                if(mViewHolder.checkEco.isChecked()){
                    try {

                        BancoController crud = new BancoController(getBaseContext());
                        mViewHolder.corredorProduto.setText(null);
                        String resultado;

                        resultado = crud.insereDadoEco(supermercado, produto, corredor, prateleira, preco);

                        Toast.makeText(CadastroProdutosActivity.this, resultado, Toast.LENGTH_LONG).show();

                        mViewHolder.nomeProduto.setText(null);
                        mViewHolder.corredorProduto.setText(null);
                        mViewHolder.prateleiraProduto.setText(null);
                        mViewHolder.precoProduto.setText(null);

                        Toast.makeText(CadastroProdutosActivity.this, "Produto Ecológico Adicionado!", Toast.LENGTH_LONG).show();

                    }catch (Exception e){
                        Toast.makeText(CadastroProdutosActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }

                }else{
                    try {

                        BancoController crud = new BancoController(getBaseContext());
                        mViewHolder.corredorProduto.setText(null);
                        String resultado;

                        resultado = crud.insereDado(supermercado, produto, corredor, prateleira, preco);

                        Toast.makeText(CadastroProdutosActivity.this, resultado, Toast.LENGTH_LONG).show();


                        mViewHolder.nomeProduto.setText(null);
                        mViewHolder.corredorProduto.setText(null);
                        mViewHolder.prateleiraProduto.setText(null);
                        mViewHolder.precoProduto.setText(null);

                        Toast.makeText(CadastroProdutosActivity.this, "Produto Inserido!", Toast.LENGTH_LONG).show();

                    }catch (Exception e){
                        Toast.makeText(CadastroProdutosActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }




}
