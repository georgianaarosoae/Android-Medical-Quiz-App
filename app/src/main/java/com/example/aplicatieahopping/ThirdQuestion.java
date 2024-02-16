package com.example.aplicatieahopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdQuestion extends AppCompatActivity {
    private Button btnNext;
    private CheckBox correctAnswear;
    public static final String THIRD_KEY="THIRD_KEY";
    Intent prevIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_question);
        initComponents();
    }

    private void initComponents() {
        btnNext=findViewById(R.id.idBtnNext3);
        btnNext.setOnClickListener(nextQuesEvent());
        correctAnswear=findViewById(R.id.cbQuest1);
        prevIntent=getIntent();
    }

    private View.OnClickListener nextQuesEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz quiz=(Quiz)prevIntent.getSerializableExtra(SecondQuestion.SECOND_QUES2_KEY);
                if(correctAnswear.isChecked()) {
                    quiz.noAnswears++;
                }
                Intent intent=new Intent(getApplicationContext(), FourthQuestion.class);
                intent.putExtra(THIRD_KEY,quiz);
                startActivity(intent);
                finish();
            }
        };
    }
}
