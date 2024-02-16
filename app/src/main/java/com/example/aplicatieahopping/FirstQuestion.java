package com.example.aplicatieahopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstQuestion extends AppCompatActivity {
    private Button btnNext;

    private CheckBox rightAnswear;
    private Intent prevIntent;

    public static final String FIRST_Q_KEY="FIRST_Q_KEY";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_question);
        initComponents();
    }

    private void initComponents() {
        btnNext=findViewById(R.id.idBtnNext1);
        btnNext.setOnClickListener(nextQuesEvent());
        rightAnswear=findViewById(R.id.cbQ4);
        prevIntent=getIntent();
    }

    private View.OnClickListener nextQuesEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz quiz=(Quiz)prevIntent.getSerializableExtra(MainActivity.MAIN_KEY);
                if(rightAnswear.isChecked()) {
                    quiz.noAnswears++;
                }
                Intent intent=new Intent(getApplicationContext(), SecondQuestion.class);
                intent.putExtra(FIRST_Q_KEY, quiz);
                startActivity(intent);
                finish();
            }
        };
    }
}
