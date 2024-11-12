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
    EditText peso,altura,imc,area;

    Spinner cbx;
    ArrayList<String> sexos = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sexos.add("Seleccione una opcion:");
        sexos.add("Femenino");
        sexos.add("Masculino");
        peso = findViewById(R.id.txtpeso);
        altura = findViewById(R.id.txtestatura);
        imc = findViewById(R.id.txtimc);
        area = findViewById(R.id.txtmensaje);

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
            Double PesoNuevo = Double.parseDouble(pesito);
            Double AlturaNueva = Double.parseDouble(altito)/100;
            Double IMCNuevo = PesoNuevo/(AlturaNueva * AlturaNueva);
            String imceo = String.valueOf(IMCNuevo);
            String nuevoimc = imceo.substring(0,5);
            imc.setText(nuevoimc);
            if(IMCNuevo >= 25){
                guaton();
            }else if (IMCNuevo < 18.5){
                flaco();
            }else{
                fixa();
            }
        }
    }
    public void guaton(){
        String mensaje = "Como reducir el IMC: \n" +
                "1) Haga 30 minutos de ejercicio aeróbico 5 veces por semana. \n" +
                "2) Logre un equilibrio entre el consumo de calorias y la actividad fisica. \n" +
                "3) limite las grasas saturadas a no mas del 7% de las calorias totales. \n" +
                "4) Tenga una alimentacion baja en colesterol con carnes magras, frutas, verduras y cereales integrales.";
        area.setText(mensaje);
    }
    public void flaco(){
        String mensaje = "Como aumentar el IMC: \n" +
                "1) Come alimentos con mas frecuencia. Empieza poco a poco a hacer 5 a 6 comidas mas pequeñ0as durante el dia. \n" +
                "2) Elige alimentos con muchos nutrientes. \n" +
                "3) Agrega aderezos. \n" +
                "4) Prueba licuados y batidos de frutas. \n" +
                "5) controla que bebes y cuando. \n" +
                "6) Haz ejercicio.";
        area.setText(mensaje);
    }
    public void fixa(){
        String mensaje = "Felicitaciones ud mantiene una excelente alimentacion.";
        area.setText(mensaje);
    }
    //https://github.com/Nicoov21/CertamenGitHub.git
    //Link github publico :O
}