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
import br.com.icoddevelopers.findssp.Constants;
import br.com.icoddevelopers.findssp.ProdutosSupermercado;
import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.Status;

public class ProdutosActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private BancoDado db = new BancoDado(this);
    private ProdutosSupermercado produtosSupermercado = new ProdutosSupermercado();
    private Status status;
    private String cnpj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        status = new Status(this);

        this.mViewHolder.btPesquisaProduto = (Button) findViewById(R.id.btPesquisarProduto);
        this.mViewHolder.produtoPesquisa = (EditText) findViewById(R.id.produtoPesquisa);
        this.mViewHolder.nomeSupermercado = (TextView) findViewById(R.id.nomeSupermercado);
        this.mViewHolder.nomeProduto = (TextView) findViewById(R.id.nomeProduto);
        this.mViewHolder.produtoCorredor = (TextView) findViewById(R.id.produtoCorredor);
        this.mViewHolder.produtoPrateleira = (TextView) findViewById(R.id.produtoPrateleira);
        this.mViewHolder.precoProduto = (TextView) findViewById(R.id.produtoPreco);


        Intent intent = getIntent();
        final String supermercado = intent.getStringExtra("Supermercado");
        final String cnpj = intent.getStringExtra("CNPJ");
        mViewHolder.nomeSupermercado.setText(supermercado);


        mViewHolder.btPesquisaProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.list_Products(Integer.parseInt(cnpj) ,mViewHolder.produtoPesquisa.getText().toString(), mViewHolder.nomeProduto, mViewHolder.produtoCorredor, mViewHolder.produtoPrateleira, mViewHolder.precoProduto);
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
        TextView precoProduto;
        EditText produtoPesquisa;
        String nome;
        Button btPesquisaProduto;

    }
}
