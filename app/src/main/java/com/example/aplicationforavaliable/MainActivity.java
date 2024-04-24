package com.example.aplicationforavaliable;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner tamanhoCamisaData, tipoParticipanteData;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos spinners
        tamanhoCamisaData = findViewById(R.id.tamanho_camisa);
        tipoParticipanteData = findViewById(R.id.tipo_participante);

        // Inicialização da barra de progresso
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);

        // Configuração do spinner de tamanho da camisa
        List<String> tamanhoCamisa = new ArrayList<>();
        tamanhoCamisa.add("P");
        tamanhoCamisa.add("M");
        tamanhoCamisa.add("G");
        tamanhoCamisa.add("GG");
        ArrayAdapter<String> tamanhoCamisaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanhoCamisa);
        tamanhoCamisaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tamanhoCamisaData.setAdapter(tamanhoCamisaAdapter);

        // Configuração do spinner de tipo de participante
        List<String> tipoParticipante = new ArrayList<>();
        tipoParticipante.add("Estudante de nível técnico");
        tipoParticipante.add("Estudante universitário");
        tipoParticipante.add("Docente");
        tipoParticipante.add("Profissional de T.I");
        tipoParticipante.add("Outro");
        ArrayAdapter<String> tipoParticipanteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipoParticipante);
        tipoParticipanteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoParticipanteData.setAdapter(tipoParticipanteAdapter);

        // Atualização do progresso da barra conforme os spinners são selecionados
        tamanhoCamisaData.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateProgressBar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tipoParticipanteData.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateProgressBar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void updateProgressBar() {
        int progress = 0;
        if (tamanhoCamisaData.getSelectedItemPosition() > 0) {
            progress += 50;
        }
        if (tipoParticipanteData.getSelectedItemPosition() > 0) {
            progress += 50;
        }
        progressBar.setProgress(progress);
    }
}

