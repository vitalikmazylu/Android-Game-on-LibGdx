package com.mygdx.game.Pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ControlBar;
import com.mygdx.game.HomeGame;
import com.mygdx.game.Launch;
import com.mygdx.game.Pages.DataBase.Example;
import com.mygdx.game.Pages.DataBase.Improves;
import com.mygdx.game.Pages.DataBase.Language;

public class Play implements Screen {
    int a=0;
    boolean language=false;
    boolean animation=true;

    Launch game;
    Launch launch;
    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;
    Texture blackfon;
    Texture img;
    Texture wt;
    Texture logotable;
    ControlBar tb;

    Skin skin;
    BitmapFont mfont;
    BitmapFont animfont;
    BitmapFont playfont;
    BitmapFont logofont;

    TextureAtlas matlas;
    TextureAtlas latlas;
    TextureAtlas playatlas;

    TextButton.TextButtonStyle mstyle;
    TextButton.TextButtonStyle exitstyle;

    ImageTextButton.ImageTextButtonStyle lstyle;
    ImageTextButton.ImageTextButtonStyle frstyle;
    ImageTextButton.ImageTextButtonStyle rustyle;
    ImageTextButton.ImageTextButtonStyle spstyle;

    ImageTextButton.ImageTextButtonStyle gestyle;
    ImageTextButton.ImageTextButtonStyle plstyle;
    ImageTextButton.ImageTextButtonStyle uastyle;
    ImageTextButton.ImageTextButtonStyle cnstyle;

    ImageButton.ImageButtonStyle constyle;

    ImageButton gamecontinue;
    TextButton newgame;
    TextButton setting;
    TextButton exit;

    ImageTextButton english;
    ImageTextButton france;
    ImageTextButton russian;
    ImageTextButton spanish;
    ImageTextButton germany;
    ImageTextButton poland;
    ImageTextButton ucraine;
    ImageTextButton italy;

    Json json;
    Example ex;
    Improves impr;
    Language lg;
    AudioMusic audio;

    Sound sound;
//Music music;
    boolean lfile=true;

    public Play(final Launch game, boolean a){
        this.game=game;
        this.animation=a;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
    public Play(){

    }
    @Override
    public void show() {
        launch=new Launch();
        FileHandle file = Gdx.files.local("scores.json");
        FileHandle lfile = Gdx.files.local("language.json");
        //file.delete();
        if(lfile.exists()){
            language=false;
        }else{
            language=true;
        }

        //launch.playmusic();
        /*music = Gdx.audio.newMusic(Gdx.files.internal("music/windows.mp3"));

        music.setVolume(1.0f);
        music.setLooping(false);
        music.play();

        music.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                String namemusic[]={"music/windows.mp3","music/stefania.mp3"};
                music= Gdx.audio.newMusic(Gdx.files.internal("music/windows.mp3"));
                music.setLooping(false);
                music.play();
            }
        });*/


        tb=new ControlBar();
        impr=new Improves();
        audio=new AudioMusic();

      //  audio.createmusic();

        betch=new SpriteBatch();

        img = new Texture("PlayMenu/background.png");
        logotable= new Texture("PlayMenu/logotable.png");

        blackfon=new Texture("PlayMenu/darksilver.png");
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        skin=new Skin();
        wt=new Texture(Gdx.files.internal("PlayMenu/WhiteTable.png"));

        Texture texture = new Texture(Gdx.files.internal("Fonts/animationfont.png"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        animfont=new BitmapFont(Gdx.files.internal("Fonts/animationfont.fnt"), new TextureRegion(texture), false);
        animfont.getData().setScale(2.3f, 2.3f);

        animfont.setColor(Color.WHITE);

logofont=new BitmapFont(Gdx.files.internal("Fonts/logofont.fnt"));
logofont.getData().setScale(1.5f, 1.5f);
logofont.setColor(Color.WHITE);

        mfont=new BitmapFont(Gdx.files.internal("Fonts/playfont.fnt"));
        mfont.setColor(Color.BLACK);
        mfont.getData().setScale(2f, 2f);

        playfont=new BitmapFont(Gdx.files.internal("Fonts/playfont21.fnt"));
        playfont.setColor(Color.WHITE);
        playfont.getData().setScale(1.5f, 1.5f);

        matlas=new TextureAtlas(Gdx.files.internal("magazinui/buttom.pack"));
        playatlas=new TextureAtlas(Gdx.files.internal("PlayMenu/playui.pack"));
        skin.addRegions(matlas);
skin.addRegions(playatlas);



        mstyle=new TextButton.TextButtonStyle();
        mstyle.font=playfont;
        mstyle.fontColor=Color.WHITE;
        mstyle.up= skin.getDrawable("newgamebutton");

        exitstyle=new TextButton.TextButtonStyle();
        exitstyle.font=playfont;
        exitstyle.fontColor= Color.WHITE;
        exitstyle.up= skin.getDrawable("exitbutton");

        latlas=new TextureAtlas(Gdx.files.internal("Language/langbuttom.pack"));
        skin.addRegions(latlas);

        lstyle=new ImageTextButton.ImageTextButtonStyle();
        lstyle.up= skin.getDrawable("langtable");
        lstyle.font=mfont;
        lstyle.fontColor=Color.BLACK;
        lstyle.imageUp=skin.getDrawable("England");
        lstyle.imageUp.setLeftWidth(150f);
        lstyle.imageUp.setMinWidth(150f);
        lstyle.imageUp.setMinHeight(80f);

        frstyle=new ImageTextButton.ImageTextButtonStyle();
        frstyle.up= skin.getDrawable("langtable");
        frstyle.font=mfont;
        frstyle.fontColor=Color.BLACK;
        frstyle.imageUp=skin.getDrawable("France");
        frstyle.imageUp.setLeftWidth(150f);
        frstyle.imageUp.setMinWidth(150f);
        frstyle.imageUp.setMinHeight(80f);

       rustyle=new ImageTextButton.ImageTextButtonStyle();
        rustyle.up=skin.getDrawable("langtable");
        rustyle.font=mfont;
        rustyle.fontColor=Color.BLACK;
        rustyle.imageUp=skin.getDrawable("Russia");
        rustyle.imageUp.setLeftWidth(150f);
        rustyle.imageUp.setMinWidth(150f);
        rustyle.imageUp.setMinHeight(80f);

        spstyle=new ImageTextButton.ImageTextButtonStyle();
        spstyle.up=skin.getDrawable("langtable");
        spstyle.font=mfont;
        spstyle.fontColor=Color.BLACK;
        spstyle.imageUp=skin.getDrawable("Spain");
        spstyle.imageUp.setLeftWidth(150f);
        spstyle.imageUp.setMinWidth(150f);
        spstyle.imageUp.setMinHeight(80f);

        gestyle=new ImageTextButton.ImageTextButtonStyle();
        gestyle.up=skin.getDrawable("langtable");
        gestyle.font=mfont;
        gestyle.fontColor=Color.BLACK;
        gestyle.imageUp=skin.getDrawable("Germany");
        gestyle.imageUp.setLeftWidth(150f);
        gestyle.imageUp.setMinWidth(150f);
        gestyle.imageUp.setMinHeight(80f);

        plstyle=new ImageTextButton.ImageTextButtonStyle();
        plstyle.up=skin.getDrawable("langtable");
        plstyle.font=mfont;
        plstyle.fontColor=Color.BLACK;
        plstyle.imageUp=skin.getDrawable("Poland");
        plstyle.imageUp.setLeftWidth(150f);
        plstyle.imageUp.setMinWidth(150f);
        plstyle.imageUp.setMinHeight(80f);

        uastyle=new ImageTextButton.ImageTextButtonStyle();
        uastyle.up=skin.getDrawable("langtable");
        uastyle.font=mfont;
        uastyle.fontColor=Color.BLACK;
        uastyle.imageUp=skin.getDrawable("Ucraina");
        uastyle.imageUp.setLeftWidth(150f);
        uastyle.imageUp.setMinWidth(150f);
        uastyle.imageUp.setMinHeight(80f);

        cnstyle=new ImageTextButton.ImageTextButtonStyle();
        cnstyle.up=skin.getDrawable("langtable");
        cnstyle.font=mfont;
        cnstyle.fontColor=Color.BLACK;
        cnstyle.imageUp=skin.getDrawable("China");
        cnstyle.imageUp.setLeftWidth(150f);
        cnstyle.imageUp.setMinWidth(150f);
        cnstyle.imageUp.setMinHeight(80f);

        constyle=new ImageButton.ImageButtonStyle();
        constyle.up= skin.getDrawable("roundbuttom");
        constyle.imageUp= skin.getDrawable("playchar");
        constyle.imageUp.setMinHeight(Gdx.graphics.getWidth()*4/100f);
        constyle.imageUp.setMinWidth(Gdx.graphics.getWidth()*3/100f);
        constyle.imageUp.setRightWidth(50);

        gamecontinue=new ImageButton(constyle);
        gamecontinue.setZIndex(100);
        gamecontinue.setPosition(Gdx.graphics.getWidth()*44/100f, Gdx.graphics.getHeight()*40/100f);
        gamecontinue.setSize(Gdx.graphics.getWidth()*7/100f, Gdx.graphics.getWidth()*7/100f);

        newgame=new TextButton("New game", mstyle);
        newgame.setZIndex(100);
        newgame.setPosition(Gdx.graphics.getWidth()*43/100f, Gdx.graphics.getHeight()*30/100f);
        newgame.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getHeight()*6/100f);
/*
        setting=new TextButton("Setting", mstyle);
        setting.setZIndex(100);
        setting.setPosition(Gdx.graphics.getWidth()*40/100f, Gdx.graphics.getHeight()*50/100f);
        setting.setSize(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*7/100f);*/

        exit=new TextButton("Exit", exitstyle);
        exit.setZIndex(100);
        exit.setPosition(Gdx.graphics.getWidth()*43/100f, Gdx.graphics.getHeight()*20/100f);
        exit.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getHeight()*6/100f);

        /* Create Language buttom*/
        english=new ImageTextButton("English",lstyle);
        english.setPosition(Gdx.graphics.getWidth()*15/100f, Gdx.graphics.getHeight()*75/100f);
        english.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        france=new ImageTextButton("Français", frstyle);
        france.setPosition(Gdx.graphics.getWidth()*15/100f, Gdx.graphics.getHeight()*55/100f);
        france.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        russian=new ImageTextButton("Руский", rustyle);
        russian.setPosition(Gdx.graphics.getWidth()*15/100f, Gdx.graphics.getHeight()*35/100f);
        russian.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        spanish=new ImageTextButton("Español", spstyle);
        spanish.setPosition(Gdx.graphics.getWidth()*15/100f, Gdx.graphics.getHeight()*15/100f);
        spanish.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        germany=new ImageTextButton("Deutsch", gestyle);
        germany.setPosition(Gdx.graphics.getWidth()*50/100f, Gdx.graphics.getHeight()*75/100f);
        germany.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        poland=new ImageTextButton("Polski", plstyle);
        poland.setPosition(Gdx.graphics.getWidth()*50/100f, Gdx.graphics.getHeight()*55/100f);
        poland.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        ucraine=new ImageTextButton("Українский", uastyle);
        ucraine.setPosition(Gdx.graphics.getWidth()*50/100f, Gdx.graphics.getHeight()*35/100f);
        ucraine.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        italy=new ImageTextButton("Italy", cnstyle);
        italy.setPosition(Gdx.graphics.getWidth()*50/100f, Gdx.graphics.getHeight()*15/100f);
        italy.setSize(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*13/100f);

        if (language==true) {

            stage.addActor(english);
            stage.addActor(russian);
            stage.addActor(france);
            stage.addActor(spanish);
            stage.addActor(germany);
            stage.addActor(poland);
            stage.addActor(ucraine);
            stage.addActor(italy);
        }else{
            if(file.exists()) {
                stage.addActor(gamecontinue);
            }
            stage.addActor(newgame);
          //  stage.addActor(setting);
            stage.addActor(exit);
        }

       /* stage.addActor(gamecontinue);
        stage.addActor(newgame);
        stage.addActor(setting);
        stage.addActor(exit);*/


        //stage.setKeyboardFocus(bad);


        json=new Json();

        ex=new Example();
        lg=new Language();

        sound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.mp3"));

        //json.setOutputType(JsonWriter.OutputType.json);
        //json.setElementType(Example.class, "numbers");


        /*ex.price=10;
        ex.time=15;
        ex.watches=100;
        String text = json.toJson(ex);


        file.writeString(text, false);*/

       //String text = json.toJson(ex);
        /*FileHandle file = Gdx.files.local("scores.txt");
        file.writeString("text", false);*/

        gamecontinue.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
               FileHandle file = Gdx.files.local("scores.json");


                sound.play(1.0f);

               if(file.exists()==true){
                    String scores = file.readString();
                    System.out.println(scores);
                    Example exampl=json.fromJson(Example.class, scores);
                    System.out.println("Examples"+exampl.price);
                }else {
                    System.out.println("file is not exist");

                }

                game.setScreen(new HomeGame(game));
                System.out.println(Gdx.files.getLocalStoragePath());


            }
        });

        newgame.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                FileHandle file = Gdx.files.local("scores.json");
                ex.price=3000;
                ex.time=0;
                ex.watches=100;

                ex.salepercent=5;
                String text = json.toJson(ex);
                file.writeString(text, false);
                /*Crete improve database*/
                FileHandle improvefile = Gdx.files.local("Improve.json");
                impr.smartfonlevel=1;
                impr.accesoirelevel=1;
                impr.pclevel=1;
                impr.appliencelevel=1;
                impr.autolevel=1;

                impr.sellskilllevel=1;
                impr.sellskillcoeficient=4;
                impr.storagelevel=1;
                impr.storecapacity=200;
                impr.obiavlenialevel=1;
                impr.webstorelevel=1;
                impr.sellpointlevel=0;

                impr.radiolevel=1;
                impr.smmlevel=1;
                impr.banerlevel=1;
                impr.magazineslevel=1;
                impr.tvlevel=1;
                String imprtext= json.toJson(impr);
                improvefile.writeString(imprtext, false);
                System.out.println("New game created");

                String jsonname[]={"smartfonitem_1_1.json","smartfonitem_1_2.json","smartfonitem_1_3.json","smartfonitem_1_4.json","smartfonitem_1_4.json","smartfonitem_1_5.json","smartfonitem_2_1.json","smartfonitem_2_2.json","smartfonitem_2_3.json","smartfonitem_2_4.json","smartfonitem_2_5.json","smartfonitem_3_1.json","smartfonitem_3_2.json","smartfonitem_3_3.json","smartfonitem_3_4.json","smartfonitem_3_5.json","smartfonitem_4_1.json","smartfonitem_4_2.json","smartfonitem_4_3.json","smartfonitem_4_4.json","smartfonitem_4_5.json"};
for(int i=0;i< jsonname.length;i++){
    FileHandle itemfile = Gdx.files.local(jsonname[i]);
    if(itemfile.exists()){
        itemfile.delete();
    }

}


                if(file.exists()) {
                    game.setScreen(new HomeGame(game));
                }
            }
        });

      /*  setting.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                FileHandle file = Gdx.files.local("scores.json");
               file.delete();
               System.out.println("Deleted");
                game.dispose();
hide();
            }
        });*/

        exit.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {

                sound.play(1.0f);
              FileHandle lfile = Gdx.files.local("language.json");
               lfile.delete();
               /* FileHandle file = Gdx.files.local("scores.json");
                file.delete();*/

            }
        });
        english.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
               getlanguage("English");
            }
        });
        france.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                getlanguage("France");
            }
        });
        russian.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                getlanguage("Russian");
            }
        });
        spanish.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                getlanguage("Spanish");
            }
        });
        germany.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                getlanguage("Germany");
            }
        });
        poland.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                getlanguage("Poland");
            }
        });
        ucraine.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                getlanguage("Ucraine");
            }
        });
        italy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(1.0f);
                getlanguage("Italy");
            }
        });
    }
    public void getlanguage(String l){
        FileHandle lfile = Gdx.files.local("language.json");
        lg.lang=l;
        String ltext = json.toJson(lg);
        lfile.writeString(ltext, false);
if(lfile.exists()) {
    stage.addActor(gamecontinue);
}
        stage.addActor(newgame);
        //stage.addActor(setting);
        stage.addActor(exit);

        english.remove();
        france.remove();
        russian.remove();
        spanish.remove();
        germany.remove();
        poland.remove();
        ucraine.remove();
       italy.remove();
        language=false;

    }


    public void getbackground(){
        betch.setProjectionMatrix(camera.combined);
        betch.begin();


        betch.draw(img, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
if(language==false) {
    betch.draw(logotable, Gdx.graphics.getWidth() * 5 / 100f, Gdx.graphics.getHeight() * 80 / 100f, Gdx.graphics.getWidth() * 30 / 100f, Gdx.graphics.getHeight() * 15 / 100f);
    betch.draw(wt, Gdx.graphics.getWidth() * 39 / 100f, Gdx.graphics.getHeight() * 15 / 100f, Gdx.graphics.getWidth() * 18 / 100f, Gdx.graphics.getHeight() * 45 / 100f);
    logofont.draw(betch, "Tycoon Webstore", Gdx.graphics.getWidth() * 7 / 100f, Gdx.graphics.getHeight() * 90 / 100f);
}
        betch.end();
    }
    public void getlogo(){
        betch.setProjectionMatrix(camera.combined);
        betch.begin();

        animfont.draw(betch, "VM GAMES", Gdx.graphics.getWidth()*35/100f, Gdx.graphics.getHeight()*55/100f);

        betch.end();
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(24/100f, 24/100f, 26/100f, 1.0f);
        //tb.getBar();
        //tb.setPicture();
        camera.update();


        //System.out.println("AUdio  -" +audio);


        if (animation) {


            if (a >= 200) {
                //ScreenUtils.clear(0/100f, 0/100f, 0/100f, 1.0f);
               // betch.draw(blackfon, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                animation=false;
             /*   if(language){
                    ScreenUtils.clear(0/100f, 0/100f, 0/100f, 1.0f);
                }else {

getbackground();
                }*/

            }else{
                ScreenUtils.clear(0/100f, 0/100f, 0/100f, 1.0f);
                //animfont.draw(betch, "VM GAMES", Gdx.graphics.getWidth()*35/100f, Gdx.graphics.getHeight()*55/100f);
                getlogo();

            }
            a++;
        }else{
            ScreenUtils.clear(24/100f, 24/100f, 26/100f, 0f);
getbackground();

            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();

        }



        //System.out.println(json.prettyPrint(ex));
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
