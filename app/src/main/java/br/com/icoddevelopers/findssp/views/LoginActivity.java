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
import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.Status;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewholder = new ViewHolder();
    private BancoDado db = new BancoDado(this);
    private Status status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mViewholder.login = (EditText) findViewById(R.id.contaLoginUsuario);
        this.mViewholder.senha = (EditText) findViewById(R.id.loginSenha);
        this.mViewholder.entrar = (Button) findViewById(R.id.loginEntrar);
        this.mViewholder.cadastrar = (Button) findViewById(R.id.loginCadastrar);
        this.mViewholder.v3 = (TextView) findViewById(R.id.v3);
        this.mViewholder.v4 = (TextView) findViewById(R.id.v4);

        status  = new Status(this);
        status.storageString(Constants.LOGADO_EMPRESA, Constants.FALSO);
        status.storageString(Constants.EMAIL_EMPRESA_LOGADA, "");
        status.storageString(Constants.NOME_EMPRESA_LOGADA, "");

        mViewholder.entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mViewholder.login.getText().toString().equals("") || mViewholder.senha.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Campo Imcompleto", Toast.LENGTH_LONG).show();
                }else{
                    try {
                        db.verificar_empresa(mViewholder.login.getText().toString(), mViewholder.v3);
                        db.verificar_cnpj(mViewholder.login.getText().toString(), mViewholder.v4);
                        db.close();
                        if(db.verificar_login(mViewholder.login.getText().toString(), mViewholder.senha.getText().toString())){
                            Toast.makeText(LoginActivity.this, "Bem Vindo " + mViewholder.v3.getText().toString(), Toast.LENGTH_LONG).show();

                            // SharedPreferences
                            status.storageString(Constants.NOME_EMPRESA_LOGADA, mViewholder.v3.getText().toString());
                            status.storageString(Constants.LOGADO_EMPRESA, Constants.VERDADE);
                            status.storageString(Constants.EMAIL_EMPRESA_LOGADA, mViewholder.login.getText().toString());
                            status.storageString(Constants.CNPJ_EMPRESA, mViewholder.v4.getText().toString());

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LoginActivity.this, "Usuario ou Senha Invalidos", Toast.LENGTH_LONG).show();
                            status.storageString(Constants.CNPJ_EMPRESA, "");
                            status.storageString(Constants.LOGADO_EMPRESA, Constants.FALSO);
                            status.storageString(Constants.EMAIL_EMPRESA_LOGADA, "");
                            status.storageString(Constants.NOME_EMPRESA_LOGADA, "");
                        }
                    }catch (Exception e){
                        Toast.makeText(LoginActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        mViewholder.cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroEmpresaActivity.class);
                startActivity(intent);
            }
        });

    }

    private static class ViewHolder{
        EditText login;
        EditText senha;
        Button entrar;
        Button cadastrar;
        TextView v3;
        TextView v4;
    }

    @Override
    public void onClick(View view) {

    }
}
