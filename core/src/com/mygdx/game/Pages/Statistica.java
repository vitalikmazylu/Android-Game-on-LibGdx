package com.mygdx.game.Pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Buttons.Bankbutton;
import com.mygdx.game.Buttons.Homebutton;
import com.mygdx.game.Buttons.Magazinebutton;
import com.mygdx.game.Buttons.Marketingbutton;
import com.mygdx.game.Buttons.Orderbutton;
import com.mygdx.game.Buttons.Pausebutton;
import com.mygdx.game.Buttons.Progresbutton;
import com.mygdx.game.Buttons.Statisticbutton;
import com.mygdx.game.Buttons.Storagebutton;
import com.mygdx.game.ControlBar;
import com.mygdx.game.Launch;

public class Statistica implements Screen {
    final Launch game;
    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;
    Texture img;
    ControlBar tb;
    public Statistica(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
    @Override
    public void show() {

        tb=new ControlBar();
        betch=new SpriteBatch();
        img = new Texture("statistic.png");
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        /*Home*/
        Homebutton homeb=new Homebutton(game);
        homeb.setPosition(Gdx.graphics.getWidth()*8/100f, Gdx.graphics.getHeight()*3/100f);
        /*Magazine*/
        Magazinebutton magaz=new Magazinebutton(game);
        magaz.setPosition(Gdx.graphics.getWidth()*18/100f, Gdx.graphics.getHeight()*3/100f);
        /*Storage*/
        Storagebutton storagebutton=new Storagebutton(game);
        storagebutton.setPosition(Gdx.graphics.getWidth()*28/100f, Gdx.graphics.getHeight()*3/100f);
        /*Bank*/
        Bankbutton bank=new Bankbutton(game);
        bank.setPosition(Gdx.graphics.getWidth()*38/100f, Gdx.graphics.getHeight()*3/100f);
        /*Progres*/
        Progresbutton progres=new Progresbutton(game);
        progres.setPosition(Gdx.graphics.getWidth()*48/100f, Gdx.graphics.getHeight()*3/100f);
        /*Orders*/
        Orderbutton order=new Orderbutton(game);
        order.setPosition(Gdx.graphics.getWidth()*58/100f, Gdx.graphics.getHeight()*3/100f);
        /*Statistica*/
        Statisticbutton statistica=new Statisticbutton(game);
        statistica.setPosition(Gdx.graphics.getWidth()*68/100f, Gdx.graphics.getHeight()*3/100f);
        /*Marketing*/
        Marketingbutton marketing=new Marketingbutton(game);
        marketing.setPosition(Gdx.graphics.getWidth()*78/100f, Gdx.graphics.getHeight()*3/100f);
        /*Pause*/
        Pausebutton pause=new Pausebutton(game);
        pause.setPosition(Gdx.graphics.getWidth()*88/100f, Gdx.graphics.getHeight()*3/100f);

        stage.addActor(homeb);
        stage.addActor(magaz);
        stage.addActor(storagebutton);
        stage.addActor(bank);
        stage.addActor(progres);
        stage.addActor(order);
        stage.addActor(statistica);
        stage.addActor(marketing);
        stage.addActor(pause);

        //stage.setKeyboardFocus(bad);

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1, 0f, 0f, 0.8f);
        tb.getBar();
        tb.setPicture();
        camera.update();
        betch.setProjectionMatrix(camera.combined);
        betch.begin();
        betch.draw(img, 100, 200, 200, 200);
        betch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.dispose();
        betch.dispose();
        img.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        betch.dispose();
        img.dispose();
    }
}
