package br.com.icoddevelopers.findssp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.views.MainActivity;

public class ProdutosActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    BancoDado db = new BancoDado(this);
    ProdutosSupermercado produtosSupermercado = new ProdutosSupermercado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        this.mViewHolder.btPesquisaProduto = (Button) findViewById(R.id.btPesquisarProduto);
        this.mViewHolder.produtoPesquisa = (EditText) findViewById(R.id.produtoPesquisa);
        this.mViewHolder.nomeSupermercado = (TextView) findViewById(R.id.nomeSupermercado);
        this.mViewHolder.nomeProduto = (TextView) findViewById(R.id.nomeProduto);
        this.mViewHolder.produtoCorredor = (TextView) findViewById(R.id.produtoCorredor);
        this.mViewHolder.produtoPrateleira = (TextView) findViewById(R.id.produtoPrateleira);


        Intent intent = getIntent();
        final String supermercado = intent.getStringExtra("Supermercado");

        try {
            db.list_Supermercado(supermercado, mViewHolder.nomeSupermercado);
            db.close();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        mViewHolder.btPesquisaProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.list_Products(supermercado, mViewHolder.produtoPesquisa.getText().toString(), mViewHolder.nomeProduto, mViewHolder.produtoCorredor, mViewHolder.produtoPrateleira);
                    db.close();
                }catch (Exception e){
                    Toast.makeText(ProdutosActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private static class ViewHolder{
        TextView nomeSupermercado;
        TextView produtoCorredor;
        TextView produtoPrateleira;
        TextView nomeProduto;
        EditText produtoPesquisa;
        String nome;
        Button btPesquisaProduto;

    }
}
