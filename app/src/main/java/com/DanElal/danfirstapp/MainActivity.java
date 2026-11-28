package com.DanElal.danfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
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
    Button submitButton;
    EditText TextFreeNum;
    Button btnPlayAgain;
    int secretNumber;
    int attempts = 0;



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
        TextFreeNum = findViewById(R.id.TextFreeNum);
        submitButton = findViewById(R.id.submitButton);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSendMessage.setOnClickListener(this);
        btnFollow.setOnClickListener(this);
        swDan.setOnCheckedChangeListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        submitButton.setOnClickListener(this);
        btnPlayAgain.setOnClickListener(this);

        secretNumber = (int)(Math.random() * 100) + 1;





    }

    @Override
    public void onClick(View view) {
        int ViewId = view.getId();
        if (ViewId == R.id.btnSendMessage) {
            Toast.makeText(this, R.string.opening_chat, Toast.LENGTH_SHORT).show();
        } else if (ViewId == R.id.btnFollow) {
            Toast.makeText(this, R.string.started_following, Toast.LENGTH_SHORT).show();
            btnFollow.setText(R.string.following);
            Log.d("JJJ", "lll");
        }
        else if (ViewId == R.id.submitButton) {
            attempts++;
            String guessText = TextFreeNum.getText().toString();
            int guess = Integer.parseInt(guessText);

            if (guess > secretNumber) {
                Toast.makeText(this, "המספר גדול מדי, נסה מספר קטן יותר", Toast.LENGTH_SHORT).show();
            } else if (guess < secretNumber) {
                Toast.makeText(this, "המספר קטן מדי, נסה מספר גדול יותר", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "כל הכבוד! גילית את המספר הנכון ב-" + attempts + " צעדים!", Toast.LENGTH_LONG).show();
                btnPlayAgain.setVisibility(View.VISIBLE);
            }
        }
        else if (ViewId == R.id.btnPlayAgain) {
            attempts=0;
            secretNumber = (int)(Math.random() * 100) + 1;
            TextFreeNum.setText("");
            btnPlayAgain.setVisibility(View.INVISIBLE);
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


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }








}