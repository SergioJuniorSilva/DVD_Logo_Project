package com.sergio.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    private int positionX = 0;
    private int positionY = 0;

    private int velocityX = 1;
    private int velocityY = 1;

    private float red = 0.25f;
    private float green = 0.50f;
    private float blue = 0.75f;

    private boolean redrup = true;
    private boolean greenup = true;
    private boolean blueup = true;


    //private int velocity = 1;

    //private boolean isgoingup = true;
    //private boolean isgoingright = true;

    private int upperboundary = 480 - 44;
    private int sideboundary = 640 - 94;


    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("DVD.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(red, green, blue, 1f);
        batch.begin();
        batch.draw(image, positionX, positionY);
        batch.end();

        positionX = positionX + velocityX;

        //red = red + 0.001f;

        if(redrup){
            red = red + 0.001f;
        }
        else{
            red = red - 0.001f;
        }
        if(red >= 1){
            redrup = false;
        }
        if(red <= 0 ){
            redrup = true;
        }


        if(greenup){
            green = green + 0.001f;
        }
        else{
            green = green - 0.001f;
        }
        if(green >= 1){
            greenup = false;
        }
        if(green <= 0 ){
            greenup = true;
        }

        if(blueup){
            blue = blue + 0.001f;
        }
        else{
            blue = blue - 0.001f;
        }
        if(blue >= 1){
            blueup = false;
        }
        if(blue <= 0 ){
            blueup = true;
        }

        /*if(red <= 0){
            red = red + 0.01f;
        }

        if(red >= 100f){
            red = red - 0.01f;
        }

        /*if (isgoingright){
            positionX = positionX + velocityX;
        }
        else{
            positionX = positionX - velocityX;
        }*/

        //colisoes
        if (positionX >= sideboundary ){
            velocityX = -1;
        }
        if (positionX <= 0){
            velocityX = 1;
        }


        positionY = positionY + velocityY;

        /*if (isgoingup) {
            positionY = positionY + velocityY;
        }
        else {
            positionY = positionY - velocityY;
        }*/


        //colisoes
        if (positionY >= upperboundary){
            velocityY = -1;
        }
        if (positionY <= 0){
            velocityY = 1;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
