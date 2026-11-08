package com.DanElal.danfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnIsrael;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
            btnIsrael=findViewById(R.id.btnIsrael);
            btnIsrael.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int ViewId = view.getId();
        if (ViewId==R.id.btnIsrael)
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();
    }
}