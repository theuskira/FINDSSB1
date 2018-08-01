package br.com.icoddevelopers.findssp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SupermercadoAdapter extends ArrayAdapter<PrevSupermercado>{

    private final Context context;
    private final ArrayList<PrevSupermercado> elementos;

    public SupermercadoAdapter(Context context, ArrayList<PrevSupermercado> elementos){
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView prevSupermercado = (TextView) rowView.findViewById(R.id.prevSupermercado);

        prevSupermercado.setText(elementos.get(position).getSupermercado());

        return rowView;
    }
}
