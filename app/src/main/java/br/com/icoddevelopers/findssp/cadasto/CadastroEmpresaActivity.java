package br.com.icoddevelopers.findssp.cadasto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.icoddevelopers.findssp.R;

public class CadastroEmpresaActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_empresa);

        this.mViewHolder.campoCNPJEmpresa = (EditText) findViewById(R.id.campoCNPJEmpresa);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN.NNN.NNN/NNNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(this.mViewHolder.campoCNPJEmpresa, smf);
        this.mViewHolder.campoCNPJEmpresa.addTextChangedListener(mtw);
    }

    private static class ViewHolder{
        EditText campoCNPJEmpresa;
    }
}
