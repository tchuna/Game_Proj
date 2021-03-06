package com.islandboys.game.model;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.islandboys.game.MGame;


/**
 *  Class Controller
 *
 */
public class Controller {

    Viewport viewport;
    Stage stage;
    boolean upPressed, downPressed, leftPressed, rightPressed,spacePressed;
    public boolean press;
    OrthographicCamera cam;


    /**
     *  Controller Constructor
     *
     */
    public Controller(){
        cam = new OrthographicCamera();
        viewport = new FitViewport(GameInfo.C_WIDTH,GameInfo.C_HEIGHT, cam);
        stage = new Stage(viewport, MGame.batch);

        stage.addListener(new InputListener(){

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch(keycode){
                    case Input.Keys.UP:
                        upPressed = true;
                        break;
                    case Input.Keys.DOWN:
                        downPressed = true;
                        break;
                    case Input.Keys.LEFT:
                        leftPressed = true;
                        break;
                    case Input.Keys.RIGHT:
                        rightPressed = true;
                        break;
                }
                return true;
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                switch(keycode){
                    case Input.Keys.UP:
                        upPressed = false;
                        break;
                    case Input.Keys.DOWN:
                        downPressed = false;
                        break;
                    case Input.Keys.LEFT:
                        leftPressed = false;
                        break;
                    case Input.Keys.RIGHT:
                        rightPressed = false;
                        break;
                }
                return true;
            }
        });

        Gdx.input.setInputProcessor(stage);

        Image atcimag = new Image(new Texture("mira.png"));
        atcimag.setSize(40, 40);

       atcimag.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                press=true;
            }
        });

       press=false;

        Image upImg = new Image(new Texture("up.png"));
        upImg.setSize(50, 50);
        upImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        });

        Image downImg = new Image(new Texture("down.png"));
        downImg.setSize(50, 50);
        downImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
            }
        });

        Image rightImg = new Image(new Texture("rigth.png"));
        rightImg.setSize(50, 50);
        rightImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
            }
        });

        Image leftImg = new Image(new Texture("left.png"));
        leftImg.setSize(50, 50);
        leftImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
            }
        });


        leftImg.setBounds(0,60,leftImg.getWidth(),leftImg.getHeight());
        rightImg.setBounds(90,60,rightImg.getWidth(),rightImg.getHeight());

        upImg.setBounds(445,60,upImg.getWidth(),upImg.getHeight());

        atcimag.setBounds(450,120,atcimag.getWidth(),atcimag.getHeight());

        stage.addActor(atcimag);
        stage.addActor(leftImg);
        stage.addActor(rightImg);
        stage.addActor(upImg);

    }

    /**
     *  draw the controller in the game
     *
     */
    public void draw(){
        stage.draw();
    }

    /**
     *  Get upPressed variable
     *  @return upPressed
     */
    public boolean isUpPressed() {
        return upPressed;
    }

    /**
     *  Get leftPressed variable
     *  @return leftPressed
     */
    public boolean isLeftPressed() {
        return leftPressed;
    }

    /**
     *  Get rightPressed variable
     *  @return rightPressed
     */
    public boolean isRightPressed() {
        return rightPressed;
    }


    /**
     *  resize Controller images
     */
    public void resize(int width, int height){
        viewport.update(width, height);
    }

}
