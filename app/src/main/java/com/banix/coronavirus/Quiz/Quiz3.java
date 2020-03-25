package com.banix.coronavirus.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.banix.coronavirus.R;


public class Quiz3 extends AppCompatActivity {
Button ButtonNext;
Spinner Combo;

ArrayAdapter<CharSequence>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        initContent();
        AddTemperateur();

        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToQuiz4();
            }
        });
    }

    public void GoToQuiz4(){
        Bundle bundle=getIntent().getExtras();
        String quiz1=bundle.getString("ValueChecked1");
        String quiz2=bundle.getString("ValueChecked2");

        Intent intent=new Intent(this, Quiz4.class);
        intent.putExtra("ValueChecked1",quiz1);
        intent.putExtra("ValueChecked2",quiz2);
        startActivity(intent);
    }

    public  void AddTemperateur(){
        adapter = ArrayAdapter.createFromResource(this,R.array.temperateur,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Combo.setAdapter(adapter);
        Combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initContent() {

        ButtonNext=findViewById(R.id.idNext);
        Combo=findViewById(R.id.idCombo);


    }

}
