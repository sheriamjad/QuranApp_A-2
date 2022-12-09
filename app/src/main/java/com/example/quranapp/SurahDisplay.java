package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SurahDisplay extends AppCompatActivity {
    private TextView txtdisplay;
    private int currentAyaIndex;
//private String ind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_display);


        txtdisplay=findViewById(R.id.textSurahDisplay);

        String aya = getIntent().getStringExtra("keynumber");
        txtdisplay.setText(aya);

        //int currentAyaIndex = Integer.parseInt(index);
        String a=getIntent().getStringExtra("keyindex");

        QuranArabicText quran = new QuranArabicText();
        Button btn= findViewById(R.id.btnback);
        currentAyaIndex = Integer.valueOf(a);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAyaIndex--;
                if(currentAyaIndex>=0)
                {
                    txtdisplay.setText(quran.QuranArabicText[currentAyaIndex]);

                }
            }
        });

        Button btnf = findViewById(R.id.btnForward);
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAyaIndex++;
                if(currentAyaIndex<114)
                {
                    txtdisplay.setText(quran.QuranArabicText[currentAyaIndex]);

                }
            }
        });




//        String ayat = getIntent().getStringExtra("keynumber");
//
//
//        txtdisplay=findViewById(R.id.txtSurahDisplay);
//        txtdisplay.setText(ayat);

    }
}