package com.mygdx.game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.mygdx.game.Launch;
import com.mygdx.game.Pages.Bank;

public class Bankbutton extends Actor {
    Sprite sprite=new Sprite(new Texture(Gdx.files.internal("plusbuttom.png")));
    Launch game;


    public Bankbutton(final Launch game){
        this.game=game;
        sprite.setBounds(sprite.getX(), sprite.getY(), Gdx.graphics.getHeight()*5/100f, Gdx.graphics.getHeight()*5/100f);
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setTouchable(Touchable.enabled);

        addListener(new InputListener() {

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.UP) {
                    MoveByAction mba = new MoveByAction();
                    mba.setAmount(500f, 0f);
                    mba.setDuration(1f);
                    Bankbutton.this.addAction(mba);
                    System.out.println("Key works");
                  //  game.setScreen(new MainGame(game));

                }
                return true;
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("mouse work");
                //this.setScreen(new MainGame(this));
                game.setScreen(new Bank(game));
                //game.dispose();
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
