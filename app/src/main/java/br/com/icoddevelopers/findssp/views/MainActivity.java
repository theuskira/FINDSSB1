package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.icoddevelopers.findssp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void enviarSupermercado(View view){
        EditText nomeSupermercado = (EditText) findViewById(R.id.supermercado);

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
}
