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

    private int positionX = 90;
    private int positionY = 30;

    private int velocityX = 1;
    private int velocityY = 1;


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
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, positionX, positionY);
        batch.end();

        positionX = positionX + velocityX;

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
