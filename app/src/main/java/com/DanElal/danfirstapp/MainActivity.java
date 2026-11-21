package com.DanElal.danfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener{


    TextView tvUserName;
    Button btnSendMessage;
    Button btnFollow;
    Switch swDan;



    ImageView imgFlag;
    ImageView imgMap;
    SeekBar seekBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        swDan=findViewById(R.id.swDan);
        tvUserName = findViewById(R.id.tvUserName);
        btnSendMessage = findViewById(R.id.btnSendMessage);
        btnFollow = findViewById(R.id.btnFollow);
        imgFlag = findViewById(R.id.imgFlag);
        imgMap = findViewById(R.id.imgMap);
        seekBar = findViewById(R.id.seekBar);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSendMessage.setOnClickListener(this);
        btnFollow.setOnClickListener(this);
        swDan.setOnCheckedChangeListener(this);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        int ViewId = view.getId();
        if (ViewId == R.id.btnSendMessage) {
            Toast.makeText(this, R.string.opening_chat, Toast.LENGTH_SHORT).show();
        } else if (ViewId == R.id.btnFollow) {
            Toast.makeText(this, R.string.started_following, Toast.LENGTH_SHORT).show();
            btnFollow.setText(R.string.following);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            btnFollow.setVisibility(View.VISIBLE);
            btnSendMessage.setVisibility(View.VISIBLE);
        } else {
            btnFollow.setVisibility(View.INVISIBLE);
            btnSendMessage.setVisibility(View.INVISIBLE);
        }
    }





    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float alpha = progress / 100f;

        imgMap.setAlpha(alpha);
        imgFlag.setAlpha(1 - alpha);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }








}