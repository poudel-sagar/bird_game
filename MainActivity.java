package com.example.last.bird_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GameActivity.class));

            }
        });
        TextView highScoreTxt=findViewById(R.id.highScoreTxt);
        SharedPreferences grefs=getSharedPreferences("",MODE_PRIVATE);
        highScoreTxt.setText(text"Highscore:"+prefs.getInt("highscore",0));

        isMute=prefs.getBoolean("isMute",false);
        final ImageView volumeCtrl=findViewById(R.id.volumeCtrl);
        if(isMute)
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMute=!isMute;
                if(isMute)
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute",isMute);
                editor.apply();
            }
        });


    }
}
