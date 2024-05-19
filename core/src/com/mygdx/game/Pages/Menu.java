package com.mygdx.game.Pages;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ControlBar;
import com.mygdx.game.HomeGame;
import com.mygdx.game.Launch;
import com.mygdx.game.Pages.DataBase.AddMusic;
import com.mygdx.game.Pages.DataBase.Language;

public class Menu implements Screen {
    /*Gdx.graphics.getWidth()*32/100f, Gdx.graphics.getHeight()*15/100f*/
    float tablex=Gdx.graphics.getWidth()*32/100f;
    float tabley=Gdx.graphics.getHeight()*15/100f;
    String lang[]={"English","France","Spanish","Germany","Poland","Russian","Ucraine","Italy"};
    int i=0;
    boolean musicplay;
    String rezume;
    String languages;
    String musicname;
    String mainmenu;

     Launch game;
     Launch launch;
    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;
    Texture img;
    ControlBar tb;

Language lg;

    Music musicb;

    Skin skin;
    BitmapFont lfont;
    BitmapFont mfont;
    TextureAtlas matlas;
    TextButton.TextButtonStyle mstyle;
    TextButton.TextButtonStyle rezumestyle;
    ImageButton.ImageButtonStyle langstyle;
    ImageButton.ImageButtonStyle musicstyle;

    ImageButton music;
   ImageButton language;
    TextButton reset;
    TextButton exit;

Sound sound;
AddMusic addmus;
    FileHandle file;

    public Menu(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
    @Override
    public void show() {
        file = Gdx.files.local("Music.json");
        if (file.exists()) {
            String scores = file.readString();
            AddMusic muz = json.fromJson(AddMusic.class, scores);
            musicplay= muz.playmusic;
        }else {
            musicplay=true;
        }

        tb=new ControlBar();
        lg=new Language();
        addmus=new AddMusic();
       // audio=new AudioMusic();
//launch=new Launch();
//pl.music.stop();
        tb.createbar();

        for(int j=0;j<lang.length;j++){
            if (lang[j]== tb.language){
                i=j;

            }
        }

        musicb = Gdx.audio.newMusic(Gdx.files.internal("music/windows.mp3"));


        System.out.println("Language "+tb.language);
        switch (tb.language){
            case "English":
                rezume="Resume";
                languages="Language :";
                musicname="Music :";
                mainmenu="Main Menu";
                break;
            case "France":
                rezume="Reprendre";
                languages="Langue :";
                musicname="Musique :";
                mainmenu="Menu principal";
                break;
            case "Russian":
                rezume="Возобновить";
                languages = "Язык:";
                musicname="Музыка:";
                mainmenu="Главное меню";
                break;
            case "Spanish":
                rezume="Reanudar";
                languages="Idioma:";
                musicname="Música:";
                mainmenu="Menú principal";
                break;

            case "Germany":
                rezume="Lebenslauf";
                languages = "Sprache:";
                musicname="Musik :";
                mainmenu="Hauptmenü";
                break;
            case "Poland":
                rezume="Wznów";
                languages="Język :";
                musicname="Muzyka :";
                mainmenu="Menu główne ";
                break;
            case "Ucraine":
                rezume="Назад";
                languages="Мова:";
                musicname="Музика:";
                mainmenu="Головне меню ";
                break;
            case "Italy":
                rezume="Riprendi";
                languages="Lingua :";
                musicname="Musica :";
                mainmenu="Menu principale";
                break;
        }



launch=new Launch();
        betch=new SpriteBatch();
        img = new Texture("menuui/blacktable.png");
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        //tb.getbuttons(game, stage);


        sound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.mp3"));
        skin=new Skin();
lfont=new BitmapFont();
        mfont=new BitmapFont(Gdx.files.internal("Fonts/placefont.fnt"));

        mfont.setColor(Color.BLACK);
        mfont.getData().setScale(2.1f, 2.1f);

        lfont=new BitmapFont(Gdx.files.internal("Fonts/paramfont.fnt"));
        lfont.setColor(Color.WHITE);
        lfont.getData().setScale(2, 2);

        matlas=new TextureAtlas(Gdx.files.internal("menuui/menu.pack"));
        skin.addRegions(matlas);
        mstyle=new TextButton.TextButtonStyle();
        mstyle.font=mfont;
        mstyle.fontColor= Color.WHITE;
        mstyle.up= skin.getDrawable("mainmenu");

        rezumestyle=new TextButton.TextButtonStyle();
        rezumestyle.font=mfont;
        rezumestyle.fontColor=Color.WHITE;
        rezumestyle.up= skin.getDrawable("rezumebutton");
        rezumestyle.unpressedOffsetY=10;


        langstyle=new ImageButton.ImageButtonStyle();
        langstyle.up= skin.getDrawable(lang[i]);

        musicstyle=new ImageButton.ImageButtonStyle();
        musicstyle.up= skin.getDrawable("checkmusictable");
        musicstyle.imageUp=skin.getDrawable("checkmusic");
        musicstyle.imageUp.setMinHeight(60f);
        musicstyle.imageUp.setMinWidth(60f);
        musicstyle.checkedOffsetX=40;
        musicstyle.pressedOffsetX=-40;
        musicstyle.unpressedOffsetX=-40;

        music=new ImageButton( musicstyle);
        music.setChecked(musicplay);//if player wants to stop music he press in this buttom
        music.setPosition(tablex+Gdx.graphics.getWidth()*22/100f, tabley+Gdx.graphics.getHeight()*27/100f);
        music.setSize(Gdx.graphics.getWidth()*8/100f, Gdx.graphics.getHeight()*7/100f);

        language=new ImageButton(langstyle);
        language.setPosition(tablex+Gdx.graphics.getWidth()*22/100f, tabley+Gdx.graphics.getHeight()*40/100f);
        language.setSize(Gdx.graphics.getWidth()*8/100f, Gdx.graphics.getHeight()*7/100f);

        reset=new TextButton(rezume, rezumestyle);
        reset.setPosition(tablex+Gdx.graphics.getWidth()*2/100f, tabley+Gdx.graphics.getHeight()*55/100f);
        reset.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*15/100f);

        exit=new TextButton(mainmenu, mstyle);

        exit.setPosition(tablex+Gdx.graphics.getWidth()*2/100f, tabley+Gdx.graphics.getHeight()*5/100f);
        exit.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*15/100f);
        //stage.setKeyboardFocus(bad);
stage.addActor(music);
stage.addActor(language);
stage.addActor(reset);
stage.addActor(exit);

music.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
        sound.play(1.0f);
        FileHandle file = Gdx.files.local("Music.json");

        if (music.isChecked()) {
            addmus.playmusic = true;
        } else {
            addmus.playmusic = false;
        }

        String text = json.toJson(addmus);
        file.writeString(text, false);
    }
});

       language.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                //String lang[]={"England","France","Spain","Germany","Poland","Russia","Ucraine","Italy"};
                if(i==7){
                    i=0;
                }else{
                    i++;
                }
               langstyle.up= skin.getDrawable(lang[i]);

                FileHandle lfile = Gdx.files.local("language.json");
                lg.lang=lang[i];
                String ltext = json.toJson(lg);
                lfile.writeString(ltext, false);

               System.out.println("Language "+tb.language);
                switch (lang[i]){
                    case "English":
                        rezume="Resume";
                        languages="Language :";
                        musicname="Music :";
                        mainmenu="Main Menu";
                        break;
                    case "France":
                        rezume="Reprendre";
                        languages="Langue :";
                        musicname="Musique :";
                        mainmenu="Menu principal";
                        break;
                    case "Russian":
                        rezume="Возобновить";
                        languages = "Язык:";
                        musicname="Музыка:";
                        mainmenu="Главное меню";
                        break;
                    case "Spanish":
                        rezume="Reanudar";
                        languages="Idioma:";
                        musicname="Música:";
                        mainmenu="Menú principal";
                        break;

                    case "Germany":
                        rezume="Lebenslauf";
                        languages = "Sprache:";
                        musicname="Musik :";
                        mainmenu="Hauptmenü";
                        break;
                    case "Poland":
                        rezume="Wznów";
                        languages="Język :";
                        musicname="Muzyka :";
                        mainmenu="Menu główne ";
                        break;
                    case "Ucraine":
                        rezume="Назад";
                        languages="Мова:";
                        musicname="Музика:";
                        mainmenu="Головне меню ";
                        break;
                    case "Italy":
                        rezume="Riprendi";
                        languages="Lingua :";
                        musicname="Musica :";
                        mainmenu="Menu principale";
                        break;
                }
reset.setText(rezume);
                exit.setText(mainmenu);
            }
        });

exit.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
        sound.play(1.0f);
        game.setScreen(new Play(game,false
        ));
    }
});
        reset.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                game.setScreen(new HomeGame(game));
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(16f/255f, 183f/255f, 255f/255f, 1f);
      //  tb.getBar();
      //  tb.setPicture();
        camera.update();
        betch.setProjectionMatrix(camera.combined);
        betch.begin();
        betch.draw(img, tablex, tabley, Gdx.graphics.getWidth()*35/100f, Gdx.graphics.getHeight()*75/100f);
        lfont.draw(betch, languages, tablex+Gdx.graphics.getWidth()*5/100f, tabley+Gdx.graphics.getHeight()*45/100f);
        lfont.draw(betch, musicname, tablex+Gdx.graphics.getWidth()*5/100f, tabley+Gdx.graphics.getHeight()*32/100f);
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
        betch.dispose();
        stage.dispose();
        img.dispose();
        skin.dispose();
        lfont.dispose();
        mfont.dispose();
        matlas.dispose();
    }

    @Override
    public void dispose() {
        betch.dispose();
        stage.dispose();
        img.dispose();
        skin.dispose();
        lfont.dispose();
        mfont.dispose();
        matlas.dispose();
    }
}
