package com.elvilla.computadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdaptadorComputadores.onComputadoresClickListener{
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Computadores> computador;
    private AdaptadorComputadores adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String bd = "Computadores";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstOpciones);


        computador = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorComputadores(computador,this);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(bd).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                computador.clear();
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Computadores p = snapshot.getValue(Computadores.class);
                        Computadores.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setComputadores(computador);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void crearPersonas(View v){
        i = new Intent(Principal.this,CrearComputadores.class);
        startActivity(i);


        //Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
        //      .setAction("Action", null).show();
    }


    @Override
    public void onPersonaClick(Computadores p) {
        Intent i = new Intent(Principal.this,DetalleComputadores.class);
        Bundle b = new Bundle();
        b.putInt("marca",p.getMarca());
        b.putInt("ram",p.getRam());
        b.putInt("color",p.getColor());
        b.putInt("tipo",p.getTipo());
        b.putInt("so",p.getSo());
        b.putInt("foto",p.getFoto());

        i.putExtra("datos",b);
        startActivity(i);

    }
}