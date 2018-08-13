package com.example.hawer.progresocresco;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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
    private Button sumarButton, irmainButton;
    private TextView labelProgresso;
    private ConstraintLayout layoutProgresoRetos, layoutRetosFinalizados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_card_view);

        layoutProgresoRetos = findViewById(R.id.contendor_layout_contenido);
        layoutRetosFinalizados = findViewById(R.id.contendor_layout_retos_finzalizados);

        progressBar = findViewById(R.id.progressbar_retos);
        sumarButton = findViewById(R.id.botonSumar);
        irmainButton = findViewById(R.id.irmain);
        labelProgresso = findViewById(R.id.label_cantidad_progreso);
        sumarButton.setOnClickListener(onButtonClick);
        irmainButton.setOnClickListener(onButtonClick);

        labelProgresso.setText(String.valueOf(cantidadProgreso) + "%");
    }

    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.botonSumar:
                    if (cantidadProgreso < 100) {
                        cantidadProgreso = cantidadProgreso + 10;
                        progressBar.setProgress(cantidadProgreso);
                        labelProgresso.setText(String.valueOf(cantidadProgreso) + "%");
                    }

                    if (cantidadProgreso == 100) {
                        layoutProgresoRetos.setVisibility(View.GONE);
                        layoutRetosFinalizados.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Felicidades", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.irmain:
                    startActivity(new Intent(MainActivity.this, Main.class));
                    break;
            }


        }
    };
}
