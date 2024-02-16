package com.example.aplicatieahopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondQuestion extends AppCompatActivity {

    private Button btnNext;

    public static final String SECOND_QUES2_KEY="SECOND_QUES2_KEY";

    private CheckBox correctAnswear;
    private Intent prevIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_question);
        initComponents();
    }

    private void initComponents() {
        btnNext=findViewById(R.id.idBtnNext2);
        btnNext.setOnClickListener(nextQuesEvent());
        correctAnswear=findViewById(R.id.cbQues3);
        prevIntent=getIntent();
    }

    private View.OnClickListener nextQuesEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz quiz=(Quiz)prevIntent.getSerializableExtra(FirstQuestion.FIRST_Q_KEY);
                if(correctAnswear.isChecked()) {
                    quiz.noAnswears++;
                }

                Intent intent=new Intent(getApplicationContext(), ThirdQuestion.class);
                intent.putExtra(SECOND_QUES2_KEY,quiz);
                startActivity(intent);
                finish();
            }
        };
    }
}
