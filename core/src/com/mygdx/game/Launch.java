package com.mygdx.game;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.Pages.DataBase.AddMusic;
import com.mygdx.game.Pages.DataBase.Example;
import com.mygdx.game.Pages.Play;

import jdk.internal.jimage.ImageReaderFactory;

public class Launch extends Game {
    public ImageReaderFactory assets;

    FileHandle file;

    // Texture img;
    ControlBar tb;
    Stage stage;
    public Music music;
    public Music sings;
public SpriteBatch batch;
public boolean play;
Skin skin;


    @Override
    public void create() {
        file = Gdx.files.local("Music.json");


        System.out.println("Launch create");
batch=new SpriteBatch();
        tb=new ControlBar();

skin=new Skin();
        music = Gdx.audio.newMusic(Gdx.files.internal("music/windows.mp3"));

        playmusic();

        this.setScreen(new Play(this,true));
    }


    public void playmusic(){

            music.setVolume(1.0f);
            music.setLooping(false);
            music.play();

    }

    @Override
    public void render() {
        super.render();
        if (file.exists()) {
            String scores = file.readString();
            AddMusic muz = json.fromJson(AddMusic.class, scores);
            play= muz.playmusic;
        }else {
            play=true;
        }

      //  System.out.println("Play "+play);
if (play==false){
    music.setVolume(0f);
}else {
    music.setVolume(1.0f);
}

    }



    @Override
    public void dispose() {

        super.dispose();
        batch.dispose();


      //  stage.dispose();

    }



}
