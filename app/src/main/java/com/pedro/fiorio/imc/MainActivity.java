package com.pedro.fiorio.imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pedro.fiorio.imc.Report;

public class MainActivity extends AppCompatActivity {

    String name;
    int age;
    double weight;
    double height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        String sAge, sWeight, sHeight;

        this.name = ((EditText) findViewById(R.id.name)).getText().toString();
        sAge = ((EditText) findViewById(R.id.age)).getText().toString();
        sWeight = ((EditText) findViewById(R.id.weight)).getText().toString();
        sHeight = ((EditText) findViewById(R.id.height)).getText().toString();

        if (this.name.isEmpty() || sAge.isEmpty() || sWeight.isEmpty() || sHeight.isEmpty()) return;

        this.age = Integer.parseInt(sAge);
        this.weight =  Double.parseDouble(sWeight);
        this.height = Double.parseDouble(sHeight);

        if (this.height <= 0 || this.weight <= 0) return;

        Intent it = new Intent(getBaseContext(),Report.class);
        Bundle params = new Bundle();
        params.putString("name", this.name);
        params.putInt("age", this.age);
        params.putDouble("weight", this.weight);
        params.putDouble("height", this.height);
        it.putExtras(params);
        startActivity(it);

    }
}