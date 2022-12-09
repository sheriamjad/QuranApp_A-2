package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class searchActivity extends AppCompatActivity {

    private EditText textview;
    private EditText textview1;

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


                textview1 = (EditText) findViewById(R.id.idSurahNumber);
                //String surahnum = (String)textview.getText();
                String surahNumStr = textview1.getText().toString();
                if (TextUtils.isEmpty(surahNumStr)) {
                    Toast.makeText(searchActivity.this, "Please Enter a valid Surah Number", Toast.LENGTH_LONG).show();
                }
                else{
                        int surahnum = Integer.parseInt(textview1.getText().toString());
                        textview = (EditText) findViewById(R.id.idAyaNumber);
                        if (surahnum < 1 || surahnum > 114)
                        {
                            Toast.makeText(searchActivity.this, "Please Enter A correct Surah Number", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            if(TextUtils.isEmpty(textview.getText().toString()))
                            {
                                Toast.makeText(searchActivity.this, "Please Enter ayat number", Toast.LENGTH_LONG).show();
                            }
                            else
                            { QuranArabicText quran = new QuranArabicText();
                                int ayaNumber = Integer.parseInt(textview.getText().toString());

                                if (ayaNumber <= quran.surahAyatCount[surahnum - 1]) {
                                    TextView textviewDisplay = findViewById(R.id.idAyatTextView);
                                    //textview.setText(quran.QuranArabicText[(surahnum-1)*surahnum+ayaNumber]);
                                    //textviewDisplay.setText(quran.QuranArabicText[quran.SSP[surahnum - 1] + ayaNumber - 1]);
                                    Intent intent = new Intent(searchActivity.this,SurahDisplay.class);

                                    intent.putExtra("keynumber",quran.QuranArabicText[quran.SSP[surahnum - 1] + ayaNumber - 1] );
                                    intent.putExtra("keyindex",(quran.SSP[surahnum - 1] + ayaNumber - 1));
                                    startActivity(intent);

                                }
                            }

                        }
                    }
                }

        });
    }
}