package com.example.aplicatieahopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FinalResult extends AppCompatActivity {
    private Button btnNext;
    private TextView tvFinal;

    private CheckBox correctAnswear1;
    private CheckBox correctAnswear2;
    private CheckBox correctAnswear3;
    private CheckBox correctAnswear4;
    private CheckBox correctAnswear5;
    Intent prevIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_result);
        initComponents();
    }

    private void initComponents() {
        btnNext=findViewById(R.id.idBtnRetry);
        btnNext.setOnClickListener(nextQuesEvent());
        tvFinal=findViewById(R.id.idTVFinal);
        prevIntent=getIntent();
        Quiz quiz=(Quiz) prevIntent.getSerializableExtra(FifthQuestion.FIFTH_KEY);
        String finalText=getString(R.string.final_result, quiz.noAnswears);
        tvFinal.setText(finalText);

    }

    private View.OnClickListener nextQuesEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }




}
