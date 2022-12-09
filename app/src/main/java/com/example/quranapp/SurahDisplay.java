package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SurahDisplay extends AppCompatActivity {
    private TextView txtdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_display);


        txtdisplay=findViewById(R.id.textSurahDisplay);
        String aya = getIntent().getStringExtra("keynumber");
        String index = getIntent().getStringExtra("keyindex");
        //int currentAyaIndex = Integer.parseInt(index);
        txtdisplay.setText(aya);

        QuranArabicText quran=new QuranArabicText();
        Button btn= findViewById(R.id.btnback);
        btn.setOnClickListener(new View.OnClickListener() {
            int currentAyaIndex = Integer.parseInt(index);
            @Override
            public void onClick(View view) {
                currentAyaIndex--;
                if(currentAyaIndex!=0)
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