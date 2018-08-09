package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.ProdutosSupermercado;
import br.com.icoddevelopers.findssp.R;

public class EcoActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    BancoDado db = new BancoDado(this);
    ProdutosSupermercado produtosSupermercado = new ProdutosSupermercado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco);

        this.mViewHolder.btPesquisaProduto = (Button) findViewById(R.id.btPesquisarProdutoEco);
        this.mViewHolder.produtoPesquisa = (EditText) findViewById(R.id.produtoPesquisaEco);
        this.mViewHolder.nomeSupermercado = (TextView) findViewById(R.id.nomeSupermercadoEco);
        this.mViewHolder.nomeProduto = (TextView) findViewById(R.id.nomeProdutoEco);
        this.mViewHolder.produtoCorredor = (TextView) findViewById(R.id.produtoCorredorEco);
        this.mViewHolder.produtoPrateleira = (TextView) findViewById(R.id.produtoPrateleiraEco);
        this.mViewHolder.precoProduto = (TextView) findViewById(R.id.produtoPrecoEco);

        Intent intent = getIntent();
        final String supermercado = intent.getStringExtra("Supermercado");
        final String cnpj = intent.getStringExtra("CNPJ");
        mViewHolder.nomeSupermercado.setText(supermercado);

        mViewHolder.btPesquisaProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.list_ProductsEco(Integer.parseInt(cnpj), mViewHolder.produtoPesquisa.getText().toString(), mViewHolder.nomeProduto, mViewHolder.produtoCorredor, mViewHolder.produtoPrateleira, mViewHolder.precoProduto);
                    db.close();
                } catch (Exception e) {
                    Toast.makeText(EcoActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private static class ViewHolder {
        TextView nomeSupermercado;
        TextView produtoCorredor;
        TextView produtoPrateleira;
        TextView nomeProduto;
        TextView precoProduto;
        EditText produtoPesquisa;
        String nome;
        Button btPesquisaProduto;

    }
}