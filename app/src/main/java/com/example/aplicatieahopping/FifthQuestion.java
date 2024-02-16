package com.example.aplicatieahopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FifthQuestion extends AppCompatActivity {

    private Button btnNext;
    private ActivityResultLauncher<Intent> launcher;

    public final static String FIFTH_KEY="FIFTH_KEY";


//    private CheckBox correctAnswear1;
//    private CheckBox correctAnswear2;
//    private CheckBox correctAnswear3;
//    private CheckBox correctAnswear4;
//    private CheckBox correctAnswear5;
      private CheckBox correctAnswear;
      Intent prevIntent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_question);
        initComponents();
    }

    private void initComponents() {

        btnNext=findViewById(R.id.idBtnNext5);
        btnNext.setOnClickListener(nextQuesEvent());
        correctAnswear=findViewById(R.id.cbQuestion1);
        prevIntent=getIntent();

    }

    private View.OnClickListener nextQuesEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz quiz=(Quiz)prevIntent.getSerializableExtra(FourthQuestion.FOURTH_KEY);
                if(correctAnswear.isChecked()) {
                    quiz.noAnswears++;
                }
                Intent intent=new Intent(getApplicationContext(), FinalResult.class);
                intent.putExtra(FIFTH_KEY,quiz);
                startActivity(intent);
                finish();

            }
        };
    }

}
