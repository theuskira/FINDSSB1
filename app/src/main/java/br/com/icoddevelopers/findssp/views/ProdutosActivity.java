package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.icoddevelopers.findssp.R;

public class ProdutosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();

            if(params != null){
                String nome = params.getString("Supermercado");

                TextView supermercado = (TextView) findViewById(R.id.nomeSupermercado);
                supermercado.setText(nome);
            }
        }




    }
}
