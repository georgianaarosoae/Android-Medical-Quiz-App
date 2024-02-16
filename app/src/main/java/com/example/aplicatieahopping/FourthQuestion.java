package com.example.aplicatieahopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FourthQuestion extends AppCompatActivity {
    private Button btnNext;

    public static final String FOURTH_KEY="FOURTH_KEY";

    private CheckBox correctAnswear;
    Intent prevIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_question);
        initComponents();
    }

    private void initComponents() {
        btnNext=findViewById(R.id.idBtnNext4);
        btnNext.setOnClickListener(nextQuesEvent());
        correctAnswear=findViewById(R.id.cbQuestt2);
        prevIntent=getIntent();
    }

    private View.OnClickListener nextQuesEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz quiz=(Quiz)prevIntent.getSerializableExtra(ThirdQuestion.THIRD_KEY);
                if(correctAnswear.isChecked()) {
                    quiz.noAnswears++;
                }
                Intent intent=new Intent(getApplicationContext(), FifthQuestion.class);
                intent.putExtra("FOURTH_KEY",quiz);
                startActivity(intent);
                finish();
            }
        };
    }
}
