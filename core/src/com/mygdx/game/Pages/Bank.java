package com.mygdx.game.Pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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


public class Bank  implements Screen{


    final Launch game;
    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;
    Texture img;
    Texture coin;
    Texture visitors;
    TextureAtlas bankbuttoms;
    Skin skin;
    BitmapFont bankfont;
    TextButton.TextButtonStyle bankstyle;
    TextButton.TextButtonStyle noaddstyle;
    TextButton coinbut1;
    TextButton coinbut2;
    TextButton coinbut3;
    TextButton visitbut1;
    TextButton visitbut2;
    TextButton noaddbut;
    /*Gdx.graphics.getWidth()*17/100f, Gdx.graphics.getHeight()*15/100f*/
    float tablex=Gdx.graphics.getWidth()*17/100f;
    float tabley=Gdx.graphics.getHeight()*15/100f;

    float coinbut1x=tablex+Gdx.graphics.getWidth()*7/100f;
    float coinbut1y=tabley+Gdx.graphics.getHeight()*50/100f;

    float coinbut2x=tablex+Gdx.graphics.getWidth()*33/100f;
    float coinbut2y=tabley+Gdx.graphics.getHeight()*50/100f;

    float coinbut3x=tablex+Gdx.graphics.getWidth()*7/100f;
    float coinbut3y=tabley+Gdx.graphics.getHeight()*28/100f;

    float visitbut1x=tablex+Gdx.graphics.getWidth()*33/100f;
    float visitbut1y=tabley+Gdx.graphics.getHeight()*28/100f;

    float visitbut2x=tablex+Gdx.graphics.getWidth()*7/100f;
    float visitbut2y=tabley+Gdx.graphics.getHeight()*6/100f;

    float noaddx=tablex+Gdx.graphics.getWidth()*33/100f;
    float noaddy=tabley+Gdx.graphics.getHeight()*6/100f;

    ControlBar tb;
    public Bank(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void show() {
        tb=new ControlBar();
        tb.createbar();
        betch=new SpriteBatch();
        img = new Texture("magazin_big_table.png");
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        tb.getbuttons(game, stage);

        coin=new Texture("dollar.png");
        visitors=new Texture("visitors.png");

        bankfont=new BitmapFont(Gdx.files.internal("Fonts/Bankfont.fnt"));
        bankfont.setColor(Color.WHITE);
        bankfont.getData().setScale(2f, 2f);

        skin=new Skin();

        bankbuttoms=new TextureAtlas(Gdx.files.internal("Bank/bank.pack"));
        skin.addRegions(bankbuttoms);

        bankstyle=new TextButton.TextButtonStyle();
        bankstyle.font=bankfont;
        bankstyle.fontColor=Color.WHITE;
        bankstyle.up= skin.getDrawable("bankbuttom");


        noaddstyle=new TextButton.TextButtonStyle();
        noaddstyle.font=bankfont;
        noaddstyle.fontColor=Color.WHITE;
        noaddstyle.up= skin.getDrawable("Addsbuttom");

        coinbut1=new TextButton("10000", bankstyle);
        coinbut1.setPosition(coinbut1x, coinbut1y);
        coinbut1.setSize(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*15/100f);

        coinbut2=new TextButton("100000", bankstyle);
        coinbut2.setPosition(coinbut2x, coinbut2y);
        coinbut2.setSize(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*15/100f);

        coinbut3=new TextButton("1000000", bankstyle);
        coinbut3.setPosition(coinbut3x, coinbut3y);
        coinbut3.setSize(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*15/100f);

        visitbut1=new TextButton("1000", bankstyle);
        visitbut1.setPosition(visitbut1x, visitbut1y);
        visitbut1.setSize(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*15/100f);

        visitbut2=new TextButton("10000", bankstyle);
        visitbut2.setPosition(visitbut2x, visitbut2y);
        visitbut2.setSize(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*15/100f);

        noaddbut=new TextButton("No Adds", noaddstyle);
        noaddbut.setPosition(noaddx, noaddy);
        noaddbut.setSize(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*15/100f);

        stage.addActor(coinbut1);
        stage.addActor(coinbut2);
        stage.addActor(coinbut3);
        stage.addActor(visitbut1);
        stage.addActor(visitbut2);
        stage.addActor(noaddbut);


    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1, 0f, 0f, 0.8f);
        tb.getBar();
        tb.setPicture();
        camera.update();
        betch.setProjectionMatrix(camera.combined);
        betch.begin();
        betch.draw(img, tablex, tabley,Gdx.graphics.getWidth()*60/100f,Gdx.graphics.getHeight()*72/100f);
        betch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        betch.begin();
        betch.draw(coin, coinbut1x+Gdx.graphics.getWidth()*2/100f, coinbut1y+Gdx.graphics.getHeight()*8.5f/100f,Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f);
        bankfont.draw(betch, "0.99$", coinbut1x+Gdx.graphics.getWidth()*7.5f/100f, coinbut1y-Gdx.graphics.getHeight()*2f/100f);

        betch.draw(coin, coinbut2x+Gdx.graphics.getWidth()*2/100f, coinbut2y+Gdx.graphics.getHeight()*8.5f/100f,Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f);
        bankfont.draw(betch, "4.99$", coinbut2x+Gdx.graphics.getWidth()*7.5f/100f, coinbut2y-Gdx.graphics.getHeight()*2f/100f);

        betch.draw(coin, coinbut3x+Gdx.graphics.getWidth()*2/100f, coinbut3y+Gdx.graphics.getHeight()*8.5f/100f,Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f);
        bankfont.draw(betch, "0.99$", coinbut3x+Gdx.graphics.getWidth()*7.5f/100f, coinbut3y-Gdx.graphics.getHeight()*2f/100f);

        betch.draw(visitors, visitbut1x+Gdx.graphics.getWidth()*2/100f, visitbut1y+Gdx.graphics.getHeight()*8.5f/100f,Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f);
        bankfont.draw(betch, "0.99$", visitbut1x+Gdx.graphics.getWidth()*7.5f/100f, visitbut1y-Gdx.graphics.getHeight()*2f/100f);

        betch.draw(visitors, visitbut2x+Gdx.graphics.getWidth()*2/100f, visitbut2y+Gdx.graphics.getHeight()*8.5f/100f,Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f);
        bankfont.draw(betch, "2.99$", visitbut2x+Gdx.graphics.getWidth()*7.5f/100f, visitbut2y-Gdx.graphics.getHeight()*2f/100f);

        bankfont.draw(betch, "0.99$", noaddx+Gdx.graphics.getWidth()*7.5f/100f, noaddy-Gdx.graphics.getHeight()*2f/100f);

        betch.end();
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
