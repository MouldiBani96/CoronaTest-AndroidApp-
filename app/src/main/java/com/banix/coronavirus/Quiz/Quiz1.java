package com.banix.coronavirus.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.banix.coronavirus.R;


public class Quiz1 extends AppCompatActivity {
CheckBox idYes,idNo;
Button ButtonNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        initContent();
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckBoxSelect().equals(true)&&VerifBox().equals(true))
                {

                 GoToQuiz2();
                }
            }
        });

    }

    public void GoToQuiz2(){
        Intent intent=new Intent(this, Quiz2.class);
        intent.putExtra("ValueChecked1",Integer.toString(ValueSlected()));
        startActivity(intent);
    }

    public Boolean CheckBoxSelect(){

        if(!idYes.isChecked()&&!idNo.isChecked()) {
            Toast.makeText(Quiz1.this, "ٌقم بإختيار نعم أم لا", Toast.LENGTH_LONG).show();
           return false;
        }else {
            return true;
        }

    }

    public Boolean VerifBox(){
        int NombreDeCheck=0;
        if (idYes.isChecked()) {
            NombreDeCheck=NombreDeCheck+1;
        }if (idNo.isChecked()) {
            NombreDeCheck=NombreDeCheck+1;
        }
        if (NombreDeCheck == 1) {
            return true;

        } else {
            Toast.makeText(Quiz1.this, "يمكنك فقط تحديد مربع اختيار واحدا", Toast.LENGTH_LONG).show();
            return false;
        }
    }
    public int ValueSlected(){
       int s=0;
       if(idYes.isChecked())
       {
           s=1;
       }else{
           s=0;
       }
       return s;
    }
    private void initContent() {
        idYes=findViewById(R.id.idYes1);
        idNo=findViewById(R.id.idNo1);
        ButtonNext=findViewById(R.id.idNext);


    }
}
