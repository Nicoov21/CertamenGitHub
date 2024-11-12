package com.example.certamengithub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText peso,altura,imc;
    Spinner cbx;
    ArrayList<String> sexos = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sexos.add("Seleccione una opcion:");
        sexos.add("Femenino");
        sexos.add("Masculinos");
        peso = findViewById(R.id.txtpeso);
        altura = findViewById(R.id.txtestatura);
        imc = findViewById(R.id.txtimc);

        cbx = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sexos);
        cbx.setAdapter(adapter);
    }
    public void formula(View view){
        String seleccion = (String) cbx.getSelectedItem();
        int indice = sexos.indexOf(seleccion);
        String pesito = peso.getText().toString();
        String altito = altura.getText().toString();
        if(indice == 0 || pesito.isEmpty() || altito.isEmpty()){
            Toast.makeText(this, "No deben quedar campos vacíos", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Hay datos", Toast.LENGTH_SHORT).show();
            Double PesoNuevo = Double.parseDouble(pesito);
            Double AlturaNueva = Double.parseDouble(altito)/100;
            Double IMCNuevo = PesoNuevo/(AlturaNueva * AlturaNueva);
            String imceo = String.valueOf(IMCNuevo);
            String nuevoimc = imceo.substring(0,5);
            imc.setText(nuevoimc);
        }
    }
    public void BajoPeso(){

    }
}