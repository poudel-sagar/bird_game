//asasasa//
package com.example.last.bird_game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.last.bird_game.GameView.screenRatioX;
import static com.example.last.bird_game.GameView.screenRatioY;

public class Bullet {
    int x,y,width,height;
    Bitmap bullet;
    Bullet (Resources res)
    {
        bullet = BitmapFactory.decodeResource(res,R.drawable.bullet);
        width=bullet.getWidth();
        height=bullet.getWidth();

        width/=4;
        height/=4;
        width*=(int) screenRatioX;
        height*=(int) screenRatioY;
        bullet=Bitmap.createScaledBitmap(bullet,width,height,false);
    }
    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y +height);
    }

}
