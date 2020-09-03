package com.example.abc3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Pantalla_Game_Over extends AppCompatActivity {

    String nombre_jugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__game__over);

        TextView tv_score = findViewById(R.id.idtv_score);

        nombre_jugador = getIntent().getStringExtra("jugador");
        String score = getIntent().getStringExtra("score");
        String txt_score= nombre_jugador + " "+ score;

        tv_score.setText(txt_score);
    }

    public void Volver(View view){
        Intent intent = new Intent (this, Nivel1.class);
        intent.putExtra("jugador", nombre_jugador);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onResume() {
        super.onResume();

        View decorView = getWindow().getDecorView();
        int uiOptions =
                0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        }

        decorView.setSystemUiVisibility(uiOptions);
    }
}
