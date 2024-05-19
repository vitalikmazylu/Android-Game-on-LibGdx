package com.mygdx.game.Pages;

import static java.lang.Thread.sleep;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.ControlBar;
import com.mygdx.game.HomeGame;
import com.mygdx.game.Launch;

public class Badlogic extends Actor/* implements Screens */{
    Sprite sprite=new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
Launch game;
HomeGame home;
    ControlBar cn=new ControlBar();


    public Badlogic(final Launch game){
this.game=game;
        //this.bought=bought;
       setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
       setTouchable(Touchable.enabled);

        addListener(new InputListener() {



            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

               // game.setScreen(new MainGame(game));
                System.out.println("mouse touched");
              //  Magazine mg=new Magazine(game);
               // mg.bought=true;

                cn.value();
              // home.hide();

                return true;
            }
        });

    }
    @Override
    protected void positionChanged(){
sprite.setPosition(getX(),getY());
        cn.value();
super.positionChanged();

    }

    @Override
    public void draw(Batch batch, float parentAlpha){
sprite.draw(batch);
        cn.value();

    }
    @Override
    public void act(float delta){
        super.act(delta);
    }


}
