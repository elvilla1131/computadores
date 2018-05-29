package com.elvilla.computadores;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearComputadores extends AppCompatActivity {
    private Spinner cmbMarca;
    private Spinner cmbRam;
    private Spinner cmbColor;
    private Spinner cmbTipo;
    private Spinner cmbSo;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computadores);


        cmbMarca = findViewById(R.id.cmbMarca);
        cmbRam = findViewById(R.id.cmbRam);
        cmbColor = findViewById(R.id.cmbColor);
        cmbTipo = findViewById(R.id.cmbTipo);
        cmbSo = findViewById(R.id.cmbSo);
        opc = this.getResources().getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbSexo.setAdapter(adapter);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

    }

    public void  guardar (View v){
        String ced,nomb,apelli,id;
        int sexo,foto;

        foto = Datos.fotoAleatoria(fotos);
        ced = txtCedula.getText().toString();
        nomb = txtNombre.getText().toString();
        apelli = txtApellido.getText().toString();
        sexo = cmbSexo.getSelectedItemPosition();
        id = Datos.getId();

        Persona p = new Persona (id,foto,ced,nomb,apelli,sexo);
        p.guardar();

        Snackbar.make(v, getResources().getString(R.string.Mensaje_guardado_exitoso), Snackbar.LENGTH_LONG).setAction("Action", null).show();



    }

    public void limpiar (View v){
        limpiar();
    }


    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cmbSexo.setSelection(0);
        txtCedula.requestFocus();


    }

    public void onBackPressed(){
        finish();
        Intent i = new  Intent(CrearPersonas.this,Principal.class);
        startActivity(i);
    }


}
