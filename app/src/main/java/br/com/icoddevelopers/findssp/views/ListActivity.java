package br.com.icoddevelopers.findssp.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.Constants;
import br.com.icoddevelopers.findssp.ProdutosSupermercado;
import br.com.icoddevelopers.findssp.R;

/**
 * Created by jacks on 10/08/2018.
 */

public class ListActivity extends AppCompatActivity{

    ListView lista;
    TextView supermercado;
    TextView preco;
    TextView produtoName;
    Button pesquisar;
    Button btnCarrinho;
    Button btnAdd;
    EditText campoPesquisa;
    ProdutosSupermercado produtoAtual = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        supermercado = findViewById(R.id.nomeSupermercadoList);
        lista = findViewById(R.id.listarProdutos);
        produtoName = findViewById(R.id.produtoList);
        preco = findViewById(R.id.produtoPrecoList);
        pesquisar = findViewById(R.id.btPesquisarProdutoList);
        campoPesquisa = findViewById(R.id.produtoPesquisaList);
        btnCarrinho = findViewById(R.id.btnCarrinho);
        btnAdd = findViewById(R.id.btAddProdutoList);

        supermercado.setText(getIntent().getStringExtra("Supermercado"));
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(campoPesquisa.getText().toString() == ""){
                    popularLista(false, campoPesquisa.getText().toString());
                }else{
                    popularLista(true, campoPesquisa.getText().toString());
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    produtoAtual = (ProdutosSupermercado) parent.getItemAtPosition(position);
                    DecimalFormat formato = new DecimalFormat("R$ ##.##");
                    preco.setText(formato.format(Double.parseDouble(produtoAtual.getPreco())));
                } catch(Exception e){
                    Toast.makeText(ListActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                produtoName.setText(produtoAtual.getProduto());
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(produtoAtual != null){
                    if(Constants.usados.contains(produtoAtual)){
                        int i = Constants.carrinho.indexOf(produtoAtual);
                        Constants.carrinho.get(i).incrementar();
                    }else{
                        Constants.carrinho.add(produtoAtual);
                        Constants.usados.add(produtoAtual);
                    }
                    Toast.makeText(ListActivity.this, "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ListActivity.this, "Nenhum produto foi selecionado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, ListFullActivity.class);
                intent.putExtra("Supermercado", getIntent().getStringExtra("Supermercado"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        popularLista(false, "");
    }

    public void popularLista(boolean filtrado, String produto){
        BancoDado bd = new BancoDado(this);
        ArrayList<ProdutosSupermercado> allProducts = new ArrayList();
        if(filtrado){
            allProducts = bd.listProducts(Integer.parseInt(getIntent().getStringExtra("CNPJ")), produto);
        }else {
            allProducts = bd.listAllProducts(Integer.parseInt(getIntent().getStringExtra("CNPJ")));
        }
        ArrayAdapter<ProdutosSupermercado> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allProducts);
        lista.setAdapter(adapter);
    }
}
