package com.example.hawer.progresocresco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int cantidadProgreso = 0;
    private ProgressBar progressBar;
    private Button sumarButton;
    private TextView labelProgresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar_retos);
        sumarButton = findViewById(R.id.botonSumar);
        labelProgresso = findViewById(R.id.label_progreso);
        sumarButton.setOnClickListener( onButtonClick );

        labelProgresso.setText( String.valueOf(cantidadProgreso) );
    }

    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            cantidadProgreso = cantidadProgreso + 10;
            if(cantidadProgreso <=100){
                progressBar.setProgress(cantidadProgreso);
            }

            if(cantidadProgreso == 100){
                Toast.makeText(MainActivity.this, "Felicidades", Toast.LENGTH_SHORT).show();
            }
            labelProgresso.setText( String.valueOf(cantidadProgreso) );
        }
    };
}
