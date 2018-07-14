package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btlogin = (Button) findViewById(R.id.btLogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if(login.equals("icoddevelopers") && senha.equals("icodicod")){
                    alert("Login Realizado com Sucesso!");
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                    finish();
                }else{
                    alert("Usuario ou Senha Invalido.");
                }

            }
        });
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}
