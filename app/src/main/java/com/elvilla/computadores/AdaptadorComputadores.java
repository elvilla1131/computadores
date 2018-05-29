package com.elvilla.computadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdaptadorComputadores extends RecyclerView.Adapter<AdaptadorComputadores.PersonaViewHolder> {
    private ArrayList<Computadores> computador;
    private onComputadoresClickListener clickListener;


    public AdaptadorComputadores(ArrayList<Computadores> computador, Principal ClickListener){
        this.computador=computador;
        this.clickListener = ClickListener;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_computadores,parent,false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        final Computadores c = computador.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.marca.setText(c.getMarca());
        holder.ram.setText(c.getRam());
        holder.apellido.setText(p.getApellido());


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onPersonaClick(p);
            }
        });


    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView cedula;
        private TextView nombre;
        private TextView apellido;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            cedula = v.findViewById(R.id.lblCedula);
            nombre = v.findViewById(R.id.lblNombre);
            apellido = v.findViewById(R.id.lblApellido);
        }

    }
    public interface onPersonaClickListener {
        void onPersonaClick(Persona p);
    }
}
