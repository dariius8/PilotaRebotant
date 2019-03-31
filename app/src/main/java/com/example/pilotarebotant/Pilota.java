package com.example.pilotarebotant;

import android.widget.ImageView;

public class Pilota {
    private int posicioX;
    private int posicioY;
    private int velocitatX;
    private int velocitatY;
    private ImageView iV;

    public Pilota(int posicioX, int posicioY, int velocitatX, int velocitatY, ImageView iV) {
        this.posicioX = posicioX;
        this.posicioY = posicioY;
        this.velocitatX = velocitatX;
        this.velocitatY = velocitatY;
        this.iV = iV;
    }

    public int getPosicioX() {
        return posicioX;
    }

    public void setPosicioX(int posicioX) {
        this.posicioX = posicioX;
    }

    public int getPosicioY() {
        return posicioY;
    }

    public void setPosicioY(int posicioY) {
        this.posicioY = posicioY;
    }

    public int getVelocitatX() {
        return velocitatX;
    }

    public void setVelocitatX(int velocitatX) {
        this.velocitatX = velocitatX;
    }

    public int getVelocitatY() {
        return velocitatY;
    }

    public void setVelocitatY(int velocitatY) {
        this.velocitatY = velocitatY;
    }

    public ImageView getiV() {
        return iV;
    }

    public void setiV(ImageView iV) {
        this.iV = iV;
    }
}