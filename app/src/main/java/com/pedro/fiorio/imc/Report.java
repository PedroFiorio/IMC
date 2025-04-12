package com.pedro.fiorio.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent it = getIntent();
        Bundle params = it.getExtras();

        double imc = params.getDouble("weight") / (params.getDouble("height") * params.getDouble("height"));

        EditText nameDisplay = (EditText) findViewById(R.id.nameDisplay);
        nameDisplay.setText(params.getString("name"));

        EditText ageDisplay = (EditText) findViewById(R.id.ageDisplay);
        ageDisplay.setText(params.getInt("age") + " anos");

        EditText weightDisplay = (EditText) findViewById(R.id.weightDisplay);
        weightDisplay.setText("" + params.getDouble("weight") + " kg");

        EditText heightDisplay = (EditText) findViewById(R.id.heightDisplay);
        heightDisplay.setText("" + params.getDouble("height") + " m");

        EditText imcDisplay = (EditText) findViewById(R.id.imcDisplay);
        imcDisplay.setText("" + String.format("%.1f", imc) + " kg/m\u00B2");

        EditText classificationDisplay = (EditText) findViewById(R.id.classificationDisplay);

        if (imc < 18.5)
            classificationDisplay.setText("Abaixo do Peso");
        else if (imc <= 24.9)
            classificationDisplay.setText("Saudável");
        else if (imc <= 29.9)
            classificationDisplay.setText("Sobrepeso");
        else if (imc <= 34.9)
            classificationDisplay.setText("Obesidade Grau I");
        else if (imc <= 39.9)
            classificationDisplay.setText("Obesidade Grau II (severa)");
        else
            classificationDisplay.setText("Obesidade Grau III (mórbida)");

    }

    public void onClick(View view) {
        Intent it = new Intent(getBaseContext(),MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(it);
    }

}