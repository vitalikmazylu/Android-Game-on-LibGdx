package com.mygdx.game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.Launch;
import com.mygdx.game.Pages.Storage;

public class Storagebutton extends Actor {
    Sprite sprite=new Sprite(new Texture(Gdx.files.internal("boxes.png")));
    final Launch game;

    public Storagebutton(final Launch game){
        this.game=game;
        sprite.setBounds(sprite.getX(), sprite.getY(), Gdx.graphics.getHeight()*9/100f, Gdx.graphics.getHeight()*9/100f);
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setTouchable(Touchable.enabled);

        addListener(new InputListener() {



            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

               game.setScreen(new Storage(game));

                return true;
            }
        });
    }
    @Override
    protected void positionChanged(){
        sprite.setPosition(getX(),getY());
        super.positionChanged();

    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);

    }
    @Override
    public void act(float delta){
        super.act(delta);
    }

}
