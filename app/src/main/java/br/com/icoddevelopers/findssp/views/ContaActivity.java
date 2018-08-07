package br.com.icoddevelopers.findssp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.BancoDado;
import br.com.icoddevelopers.findssp.Constants;
import br.com.icoddevelopers.findssp.R;
import br.com.icoddevelopers.findssp.Status;

public class ContaActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private BancoDado db = new BancoDado(this);
    private Status status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        status = new Status(this);

        this.mViewHolder.contaEmpresa = (TextView) findViewById(R.id.contaEmpresa);
        this.mViewHolder.contaCNPJ = (TextView) findViewById(R.id.contaCPNJ);
        this.mViewHolder.contaEmail = (TextView) findViewById(R.id.contaEmail);
        this.mViewHolder.contaRua = (TextView) findViewById(R.id.contaRua);
        this.mViewHolder.contaNumero = (TextView) findViewById(R.id.contaNumero);
        this.mViewHolder.contaBairro = (TextView) findViewById(R.id.contaBairro);
        this.mViewHolder.contaCidade = (TextView) findViewById(R.id.contaCidade);

        try{
            db.conta(Integer.parseInt(status.getStorageStrin(Constants.CNPJ_EMPRESA)), mViewHolder.contaEmpresa, mViewHolder.contaCNPJ, mViewHolder.contaEmail, mViewHolder.contaRua, mViewHolder.contaNumero, mViewHolder.contaBairro, mViewHolder.contaCidade);
            db.close();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private static class ViewHolder{
        TextView contaEmpresa;
        TextView contaCNPJ;
        TextView contaEmail;
        TextView contaRua;
        TextView contaNumero;
        TextView contaBairro;
        TextView contaCidade;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflar = getMenuInflater();
        inflar.inflate(R.menu.sair, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.menuDeslogar){
            status.storageString(Constants.CNPJ_EMPRESA, "");
            status.storageString(Constants.LOGADO_EMPRESA, Constants.FALSO);
            status.storageString(Constants.EMAIL_EMPRESA_LOGADA, "");
            status.storageString(Constants.NOME_EMPRESA_LOGADA, "");

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
