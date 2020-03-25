package com.banix.coronavirus.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.banix.coronavirus.R;


public class Quiz6 extends AppCompatActivity {
Button ButtonNext;
    CheckBox idYes,idNo;

ArrayAdapter<CharSequence>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);
        initContent();
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckBoxSelect().equals(true)&&VerifBox().equals(true)) {
                    GoToQuiz7();
                }
            }
        });
    }
    public void GoToQuiz7(){
        Bundle bundle=getIntent().getExtras();
        String quiz1=bundle.getString("ValueChecked1");
        String quiz2=bundle.getString("ValueChecked2");
        String quiz4=bundle.getString("ValueChecked4");
        String quiz5=bundle.getString("ValueChecked5");

        Intent intent=new Intent(this, Quiz7.class);
        intent.putExtra("ValueChecked1",quiz1);
        intent.putExtra("ValueChecked2",quiz2);
        intent.putExtra("ValueChecked4",quiz4);
        intent.putExtra("ValueChecked5",quiz5);
        intent.putExtra("ValueChecked6",Integer.toString(ValueSlected()));
        startActivity(intent);
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
    public Boolean CheckBoxSelect(){

        if(!idYes.isChecked()&&!idNo.isChecked()) {
            Toast.makeText(Quiz6.this, "ٌقم بإختيار نعم أم لا", Toast.LENGTH_LONG).show();
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
            Toast.makeText(Quiz6.this, "يمكنك فقط تحديد مربع اختيار واحدا", Toast.LENGTH_LONG).show();
            return false;
        }
    }
    private void initContent() {

        ButtonNext=findViewById(R.id.idNext);
        idYes=findViewById(R.id.idYes1);
        idNo=findViewById(R.id.idNo1);

    }
}
