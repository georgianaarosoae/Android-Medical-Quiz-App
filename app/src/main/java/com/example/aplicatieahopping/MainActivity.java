package com.example.aplicatieahopping;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnNext;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;
    public static final String MAIN_KEY="MAIN_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        btnNext=findViewById(R.id.idBtnStart);
        btnNext.setOnClickListener(startQuizEvent());
    }

    private View.OnClickListener startQuizEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz quiz=new Quiz();
                Intent intent=new Intent(getApplicationContext(), FirstQuestion.class);
                intent.putExtra("MAIN_KEY",quiz);
                startActivity(intent);
            }
        };
    }

}