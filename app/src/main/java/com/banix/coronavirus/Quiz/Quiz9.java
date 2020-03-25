package com.banix.coronavirus.Quiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.banix.coronavirus.MainActivity;
import com.banix.coronavirus.R;



public class Quiz9 extends AppCompatActivity {
Button ButtonNext,returnneg,returnpost;
ArrayAdapter<CharSequence>adapter;
Dialog myDialog;
CheckBox idYes,idNo;
TextView resultat,resultatNegative;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz9);
        initContent();
        myDialog = new Dialog(this);
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckBoxSelect().equals(true)&&VerifBox().equals(true)) {

                    if(ResultatCovid19()<4) {
                        ShowPopupNegative();
                        resultatNegative.setText(String.valueOf((ResultatCovid19()*100)/9));

                    }else
                    {
                        ShowPopupPostive();
                        resultat.setText(String.valueOf((ResultatCovid19()*100/9)));
                    }


                }
            }
        });

    }
    public void GoToMain(){

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ShowPopupPostive() {
        myDialog.setContentView(R.layout.activity_resultat_postive);
        resultat=myDialog.findViewById(R.id.resultat);
        returnpost=myDialog.findViewById(R.id.idreturnposs);
        returnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToMain();

            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNegative() {
        myDialog.setContentView(R.layout.activity_resultat_negative);
        resultatNegative=myDialog.findViewById(R.id.resultatneg);
        returnneg=myDialog.findViewById(R.id.idreturn);
        returnneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToMain();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public int ValueTouxandDyspané(){
        Bundle bundle=getIntent().getExtras();
        String quiz4=bundle.getString("ValueChecked4");
        String quiz7=bundle.getString("ValueChecked7");
        int dysp=0;
        if(quiz4.equals("1")&&quiz7.equals("1")||quiz4.equals("1")||quiz7.equals("1"))
        {
            dysp=2;
        }else{
            dysp=0;
        }
        return dysp ;
    }

    public int ValueCardiaqueandInsoline(){
        Bundle bundle=getIntent().getExtras();
        String quiz8=bundle.getString("ValueChecked8");
        int inso=0;
        if(quiz8.equals("1")&&ValueSlected9()==1||quiz8.equals("1")||ValueSlected9()==1)
        {
            inso=1;
        }else{
            inso=0;
        }
        return inso ;
    }

    public Boolean CheckBoxSelect(){

        if(!idYes.isChecked()&&!idNo.isChecked()) {
            Toast.makeText(Quiz9.this, "ٌقم بإختيار نعم أم لا", Toast.LENGTH_LONG).show();
            return false;
        }else {
            return true;
        }

    }

    public int ValueSlected9(){
        int s=0;
        if(idYes.isChecked())
        {
            s=1;
        }else{
            s=0;
        }
        return s;
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
            Toast.makeText(Quiz9.this, "يمكنك فقط تحديد مربع اختيار واحدا", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public int ResultatCovid19(){
       Bundle bundle=getIntent().getExtras();
       String quiz1=bundle.getString("ValueChecked1");
       String quiz2=bundle.getString("ValueChecked2");
       System.out.println("aywah  "+quiz1);
       String quiz5=bundle.getString("ValueChecked5");
       String quiz6=bundle.getString("ValueChecked6");
       int infected=0;
       int expanstion=0 ,fievre=0,malgorge=0,diar=0;

        if(quiz1.equals("1"))
        {  expanstion=2;
        }

        if(quiz2.equals("1"))
        {  fievre=2;
        }
        if(quiz5.equals("1"))
        {  malgorge=1;
        }
        if(quiz6.equals("1"))
        {  diar=1;
        }


       infected=expanstion+diar+fievre+malgorge+ValueTouxandDyspané()+ValueCardiaqueandInsoline();
       System.out.println("aywah  "+infected);

       return infected;

    }

    private void initContent() {

        ButtonNext=findViewById(R.id.idNext);
        idYes=findViewById(R.id.idYes1);
        idNo=findViewById(R.id.idNo1);

    }
}
