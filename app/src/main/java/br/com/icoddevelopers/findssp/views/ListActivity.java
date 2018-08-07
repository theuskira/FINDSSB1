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
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.R;

public class ListActivity extends AppCompatActivity implements View.OnClickListener{
    BancoDado db = new BancoDado(this);
    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.mViewHolder.nomeSupermercado = (TextView) findViewById(R.id.nomeSupermercadoList);
        this.mViewHolder.produtoList = (TextView) findViewById(R.id.produtoList);
        this.mViewHolder.produtoCorredor = (TextView) findViewById(R.id.produtoCorredorList);
        this.mViewHolder.produtoPrateleira = (TextView) findViewById(R.id.produtoPrateleiraList);
        this.mViewHolder.precoProduto = (TextView) findViewById(R.id.produtoPrecoList);
        this.mViewHolder.produtoPesquisa = (EditText) findViewById(R.id.produtoPesquisaList);
        this.mViewHolder.addProdutoList = (Button) findViewById(R.id.btAddProdutoList);
        this.mViewHolder.btPesquisarProduto = (Button) findViewById(R.id.btPesquisarProdutoList);


        Intent intent = getIntent();
        final String supermercado = intent.getStringExtra("Supermercado");
        Toast.makeText(this, supermercado, Toast.LENGTH_LONG).show();

        try {
            db.list_Supermercado(supermercado, mViewHolder.nomeSupermercado);
            db.close();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        mViewHolder.btPesquisarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.list_All_Products(mViewHolder.produtoPesquisa.getText().toString(), mViewHolder.produtoList, mViewHolder.produtoCorredor, mViewHolder.produtoPrateleira, mViewHolder.precoProduto);
                    db.close();
                }catch (Exception e){
                    Toast.makeText(ListActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        mViewHolder.addProdutoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ListActivity.this, "Funçao Não Implementada!", Toast.LENGTH_LONG).show();
            }
        });


    }

    private class ViewHolder{
        TextView nomeSupermercado;
        TextView produtoList;
        TextView produtoCorredor;
        TextView produtoPrateleira;
        TextView precoProduto;
        EditText produtoPesquisa;
        Button addProdutoList;
        Button btPesquisarProduto;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflar = getMenuInflater();
        inflar.inflate(R.menu.salvarlista, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.concluirLista){
            Toast.makeText(ListActivity.this, "Funçao Não Implementada!", Toast.LENGTH_LONG).show();
            //Intent intentUsuario = new Intent(this, ListFullActivity.class);
            //startActivity(intentUsuario);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
