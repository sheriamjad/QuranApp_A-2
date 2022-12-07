package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class searchActivity extends AppCompatActivity {

    private TextView textview;
    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

         textview1= findViewById(R.id.idSurahNumber);
         String surahNumber = getIntent().getStringExtra("keynnumber");

         textview1.setText(surahNumber);

         Button btn = findViewById(R.id.idbtnsearch);
         btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textview1= findViewById(R.id.idSurahNumber);
                //String surahnum = (String)textview.getText();
                int surahnum = Integer.parseInt(textview1.getText().toString());
                textview = findViewById(R.id.idAyaNumber);
                //int ayaNumber = Integer.parseInt(String.valueOf(textview.getText()));


                if(surahnum<1 || surahnum>114 )
                {
                    Toast.makeText(searchActivity.this, "Please Enter A correct Surah Number",Toast.LENGTH_LONG).show();
                }
                else {
                    if(textview.getText().toString()!="") {
                        QuranArabicText quran = new QuranArabicText();
                        int ayaNumber = Integer.parseInt(textview.getText().toString());

                        if(ayaNumber <= quran.surahAyatCount[surahnum-1])
                        {
                            //textview = findViewById(R.id.idAyatTextView);
                            //textview.setText(quran.QuranArabicText[(surahnum-1)*surahnum+ayaNumber]);
                            textview.setText(quran.QuranArabicText[quran.SSP[surahnum-1]+ayaNumber-1]);
                        }
                    }
                    else{
                        Toast.makeText(searchActivity.this, "Please Enter ayat number",Toast.LENGTH_LONG).show();
                    }

                }



            }
        });




    }

}