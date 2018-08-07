package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.BancoController;
import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.R;

public class CadastroEmpresaActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    BancoDado db = new BancoDado(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_empresa);

        this.mViewHolder.nomeEmpresa = (EditText) findViewById(R.id.campoCadastroEmpresaNome);
        this.mViewHolder.emailEmpresa = (EditText) findViewById(R.id.campoCadastroEmpresaEmail);
        this.mViewHolder.ruaEmpresa = (EditText) findViewById(R.id.campoCadastroEmpresaRua);
        this.mViewHolder.numEmpresa = (EditText) findViewById(R.id.campoCadastroEmpresaNum);
        this.mViewHolder.bairroEmpresa = (EditText) findViewById(R.id.campoCadastroEmpresaBairro);
        this.mViewHolder.cidadeEmpresa = (EditText) findViewById(R.id.campoCadastroEmpresaCidade);
        this.mViewHolder.cnpjEmpresa = (EditText) findViewById(R.id.campoCadastroEmpresaCNPJ);
        this.mViewHolder.senhaEmpresa = (EditText) findViewById(R.id.cadastroEmpresaSenha);

    }

    private static class ViewHolder{
        EditText nomeEmpresa;
        EditText emailEmpresa;
        EditText ruaEmpresa;
        EditText numEmpresa;
        EditText bairroEmpresa;
        EditText cidadeEmpresa;
        EditText cnpjEmpresa;
        EditText senhaEmpresa;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflar = getMenuInflater();
        inflar.inflate(R.menu.menucadastro, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.usuarioSalvar) {
            String supermercado = mViewHolder.nomeEmpresa.getText().toString();
            String email = mViewHolder.emailEmpresa.getText().toString();
            String rua = mViewHolder.ruaEmpresa.getText().toString();
            String num = mViewHolder.numEmpresa.getText().toString();
            String bairro = mViewHolder.bairroEmpresa.getText().toString();
            String cidade = mViewHolder.cidadeEmpresa.getText().toString();
            String cnpj = mViewHolder.cnpjEmpresa.getText().toString();
            String senha = mViewHolder.senhaEmpresa.getText().toString();

            if(supermercado.equals("") || email.equals("") || rua.equals("") || num.equals("") || bairro.equals("") || cnpj.equals("")){
                Toast.makeText(CadastroEmpresaActivity.this, "Campos Obrigatorios Faltando!", Toast.LENGTH_LONG).show();
            }else{
                try {

                    BancoController crud = new BancoController(getBaseContext());

                    crud.insereEmpresa(supermercado, email, rua, Integer.parseInt(num), bairro, cidade, Integer.parseInt(cnpj), senha);

                    mViewHolder.nomeEmpresa.setText(null);
                    mViewHolder.emailEmpresa.setText(null);
                    mViewHolder.ruaEmpresa.setText(null);
                    mViewHolder.numEmpresa.setText(null);
                    mViewHolder.bairroEmpresa.setText(null);
                    mViewHolder.cidadeEmpresa.setText(null);
                    mViewHolder.cnpjEmpresa.setText(null);
                    mViewHolder.senhaEmpresa.setText(null);

                    Toast.makeText(this, "Empresa Cadastrada!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
