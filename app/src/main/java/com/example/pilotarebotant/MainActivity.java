package com.example.pilotarebotant;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pilota> pilotes = new ArrayList<>();
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = findViewById(R.id.layoutPilota);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pilota);
        bitmap = Bitmap.createScaledBitmap(bitmap, 200,200, false);
        int posicioX = 0;
        for (int i = 0; i < 8; i++){
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageBitmap(bitmap);
            Pilota pilota = new Pilota(posicioX,0, 8 * (i + 1), 8 * (i + 1), imageView);
            pilotes.add(pilota);
            relativeLayout.addView(imageView);
            posicioX += 10;
        }
        int nav_bar_height = 0;
        Resources resources = getApplicationContext().getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            nav_bar_height = resources.getDimensionPixelSize(resourceId);
        }
        DisplayMetrics displayMetrics = this.getBaseContext().getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels - nav_bar_height;
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                final int pilotesSize = pilotes.size();
                for (int i = 0; i < pilotesSize; i++) {
                    Pilota pilota = pilotes.get(i);
                    ImageView imageView = pilotes.get(i).getiV();
                    //posicioX
                    if (width > pilota.getPosicioX() && pilota.getPosicioX() >= 0) {
                        if (pilota.getPosicioX() >= width) {
                            pilota.setVelocitatX(pilota.getVelocitatX() * -1);
                            pilota.setPosicioX(pilota.getPosicioX() + pilota.getVelocitatX());
                        } else {
                            imageView.setX(pilota.getPosicioX() + pilota.getVelocitatX());
                            pilota.setPosicioX(pilota.getPosicioX() + pilota.getVelocitatX());
                        }
                    } else if (width <= pilota.getPosicioX()) {
                        pilota.setVelocitatX(pilota.getVelocitatX() * -1);
                        pilota.setPosicioX(pilota.getPosicioX() + pilota.getVelocitatX());
                    } else if (pilota.getPosicioX() < 0) {
                        pilota.setVelocitatX(pilota.getVelocitatX() * -1);
                        pilota.setPosicioX(pilota.getPosicioX() + pilota.getVelocitatX());
                    }
                    //posicioY
                    if (height > pilota.getPosicioY() && pilota.getPosicioY() >= 0) {
                        imageView.setY(pilota.getPosicioY() + pilota.getVelocitatY());
                        pilota.setPosicioY(pilota.getPosicioY() + pilota.getVelocitatY());
                    } else if (height <= pilota.getPosicioY()) {
                        pilota.setVelocitatY(pilota.getVelocitatY() * -1);
                        pilota.setPosicioY(pilota.getPosicioY() + pilota.getVelocitatY());
                    } else if (pilota.getPosicioY() < 0) {
                        pilota.setVelocitatY(pilota.getVelocitatY() * -1);
                        pilota.setPosicioY(pilota.getPosicioY() + pilota.getVelocitatY());
                    }
                }
            }
        };
        timer.schedule(timerTask, 0, 80);
    }
}