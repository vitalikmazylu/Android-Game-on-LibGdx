package com.mygdx.game.Pages;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
import com.mygdx.game.Pages.DataBase.Improves;
import com.mygdx.game.Pages.accessoriesmodules.Accessor;
import com.mygdx.game.Pages.accessoriesmodules.Apllecient;
import com.mygdx.game.Pages.accessoriesmodules.AutoTovar;
import com.mygdx.game.Pages.accessoriesmodules.Notebooks;
import com.mygdx.game.Pages.smartphonehelper.Smartphone;

import java.io.UnsupportedEncodingException;

public class Magazine implements Screen {

    String smartphonesting;
    String accesoirestring;
    String pcstring;
    String appliencestring;
    String autostring;

    boolean bought=false;
    boolean smartphone=true;
    boolean accesoire=false;
    boolean notebook=false;
    boolean hometovar=false;
    boolean autotovar=false;

short timer=60;

public byte smartfonlevel;
    public byte accesoirelevel;
    public byte pclevel;
    public byte appliancelevel;
    public byte autolevel;
public int storecapacity;
//Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*21/100f
float bigtablex=Gdx.graphics.getWidth()*30/100f;
float bigtabley=Gdx.graphics.getHeight()*21/100f;
//Gdx.graphics.getWidth()*5/100f, Gdx.graphics.getHeight()*21/100f
float smalltablex=Gdx.graphics.getWidth()*5/100f;
float smalltabley=Gdx.graphics.getHeight()*21/100f;


    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;


    Texture smalltable;
    Texture bigtable;


    ControlBar tb;
    /*Bitmap*/
    BitmapFont textdeliver;
    /*Text button*/
    Skin skin;
    TextButton phones;
    TextButton Accessories;
    TextButton Appliances;
    TextButton PC;
    TextButton cargoods;
    BitmapFont font;
    TextureAtlas buttonAtlas;

    TextButton.TextButtonStyle textButtonStyle;

    FileHandle file;

    public Smartphone sm;
    public Accessor ac;
    Notebooks pc;
    Apllecient apl;
    AutoTovar auto;

    final Launch game;

    Sound sound;

    public Magazine(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        /*Кнопки*/
        betch=new SpriteBatch();

    }


   // @android.annotation.TargetApi(android.os.Build.VERSION_CODES.KITKAT)
    @Override
    public void show() {

        sound=Gdx.audio.newSound(Gdx.files.internal("sounds/click.mp3"));
        file = Gdx.files.local("Improve.json");
        String scores = file.readString();
        System.out.println(scores);
        Improves impr=json.fromJson(Improves.class, scores);
smartfonlevel=impr.smartfonlevel;
accesoirelevel=impr.accesoirelevel;
pclevel=impr.pclevel;
appliancelevel=impr.appliencelevel;
autolevel=impr.autolevel;
storecapacity=impr.storecapacity;

        tb=new ControlBar();

        tb.createbar();

        /*Bitmap*/
        textdeliver=new BitmapFont();
/*Texture*/


smalltable=new Texture("magazin_small_table.png");
bigtable=new Texture("magazin_big_table.png");

/*For indentific language*/
        switch (tb.language){
            case "English":
                 smartphonesting="Smartfons";
                accesoirestring="Accesoire";
                 pcstring="PC & Notebooks";
                appliencestring="Appliances";
                 autostring="Auto accesoire";
                break;
            case "France":
                 smartphonesting="Smartphones";
                accesoirestring="Accessoires";
                 pcstring="PC et portables";
                appliencestring="appareils électroménagers";
                autostring="accessoires de voiture";
                break;
            case "Russian":
                 smartphonesting="Смартфоны";
                 accesoirestring="Аксесуары";
                 pcstring="Пк и Ноутбуки";
                 appliencestring="Бытовая техника";
                autostring="Авто аксесуары";
                break;
            case "Spanish":
                smartphonesting="teléfonos inteligentes";
                accesoirestring="Accesorios";
                pcstring="PC y portátiles";
                appliencestring="Accesorios";
                autostring="Accesorios de coche";
                break;
        }


        /*TextButton*/
        //skin=new Skin(Gdx.files.internal("ui/uiskin.atlas"));
         //skin.addRegions("Ui/uiskin.atlas");
        //Arial=new BitmapFont();


/*Stages*/
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        sm=new Smartphone(betch,stage,tb,smartfonlevel,storecapacity,bigtablex,bigtabley);
        ac=new Accessor(betch,stage,tb,accesoirelevel,storecapacity,bigtablex,bigtabley);
        pc=new Notebooks(betch,stage,tb,pclevel,storecapacity,bigtablex,bigtabley);
        apl=new Apllecient(betch,stage,tb,appliancelevel,storecapacity,bigtablex,bigtabley);
        auto=new AutoTovar(betch,stage,tb,autolevel,storecapacity,bigtablex,bigtabley);

        tb.getbuttons(game,stage);

//stage.addActor(badlogic);
        /*TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font =Arial;
        //textButtonStyle.getData().setScale(fontsize, fontsize);
        textButtonStyle.fontColor = Color.WHITE;
        TextButton txt=new TextButton("Custom Btn ", textButtonStyle);
        txt.setPosition(200, 20);
        txt.setColor(Color.BLACK);
        txt.setScale(500f, 200f);
        stage.addActor(txt);*/
       /* TextButton button2 = new TextButton("Text Button",skin,"default");
        button2.setSize(300,200);
        button2.setPosition(200,100);
        button2.setTransform(true);
        button2.scaleBy(0.5f);
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Pressed Text Button");
                return true;
            }
        });
        stage.addActor(button2);*/
        skin=new Skin();
/*
        pfont=new BitmapFont();
        pageatlas=new TextureAtlas(Gdx.files.internal("magazinui/buttom.pack"));
        skin.addRegions(pageatlas);
        pagestyle=new TextButton.TextButtonStyle();
        pagestyle.font=pfont;
        pagestyle.up=skin.getDrawable("pagebutton");
        pagestyle.down=skin.getDrawable("pabebuttonclick");
        pfont.getData().setScale(2.5f,2.5f);

        page1=new TextButton("1", pagestyle);
        page1.setPosition(Gdx.graphics.getWidth()*70/100f, Gdx.graphics.getHeight()*25/100f);
        page1.setSize(Gdx.graphics.getWidth()*3/100f, Gdx.graphics.getWidth()*3/100f);
*/


      //  stage.addActor(page1);
        font=new BitmapFont(Gdx.files.internal("Fonts/kategoria.fnt"));



        buttonAtlas = new TextureAtlas(Gdx.files.internal("Store/textbutton.pack"));
        skin.addRegions(buttonAtlas);
        textButtonStyle=new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("yellowbutton");
        textButtonStyle.down= skin.getDrawable("greenbutton");
        font.getData().setScale(2f, 2f);
        textButtonStyle.fontColor=Color.BLACK;

       // textButtonStyle.down = skin.getDrawable("down-button");
       // textButtonStyle.checked = skin.getDrawable("checked-button");
       // Charset utf8 = Charset.forName("UTF-8");

//Gdx.graphics.getWidth()*5/100f, Gdx.graphics.getHeight()*21/100f
        phones=new TextButton(smartphonesting, textButtonStyle);
        phones.setPosition(smalltablex+Gdx.graphics.getWidth()*2/100f, smalltabley+Gdx.graphics.getHeight()*40/100f);
        phones.setSize(Gdx.graphics.getWidth()*15/100f,Gdx.graphics.getHeight()*6/100f);

        Accessories=new TextButton(accesoirestring, textButtonStyle);
        Accessories.setPosition(smalltablex+Gdx.graphics.getWidth()*2/100f, smalltabley+Gdx.graphics.getHeight()*32/100f);
        Accessories.setSize(Gdx.graphics.getWidth()*15/100f,Gdx.graphics.getHeight()*6/100f);

        PC=new TextButton(pcstring, textButtonStyle);
        PC.setPosition(smalltablex+Gdx.graphics.getWidth()*2/100f, smalltabley+Gdx.graphics.getHeight()*24/100f);
PC.setSize(Gdx.graphics.getWidth()*15/100f,Gdx.graphics.getHeight()*6/100f);

        Appliances=new TextButton(appliencestring, textButtonStyle);
        Appliances.setPosition(smalltablex+Gdx.graphics.getWidth()*2/100f, smalltabley+Gdx.graphics.getHeight()*16/100f);
        Appliances.setSize(Gdx.graphics.getWidth()*15/100f,Gdx.graphics.getHeight()*6/100f);

        cargoods=new TextButton(autostring, textButtonStyle);
        cargoods.setPosition(smalltablex+Gdx.graphics.getWidth()*2/100f, smalltabley+Gdx.graphics.getHeight()*8/100f);
        cargoods.setSize(Gdx.graphics.getWidth()*15/100f,Gdx.graphics.getHeight()*6/100f);

stage.addActor(phones);
stage.addActor(Accessories);
stage.addActor(PC);
stage.addActor(Appliances);
stage.addActor(cargoods);

       if(smartphone) {
           sm.setitem();
           sm.getlistener();
       }
        phones.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                accesoire=false;
                smartphone=true;
                notebook=false;
                hometovar=false;
                autotovar=false;

                sm.setitem();
                sm.getlistener();

            };
        });

        Accessories.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                accesoire=true;
                smartphone=false;
                notebook=false;
                hometovar=false;
                autotovar=false;
                ac.setitem();
                ac.getlistener();
            };
        });


        PC.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                accesoire=false;
                smartphone=false;
                notebook=true;
                hometovar=false;
                autotovar=false;
pc.setitem();
pc.getlistener();
            }});

        Appliances.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                accesoire=false;
                smartphone=false;
                notebook=false;
                hometovar=true;
                autotovar=false;
apl.setitem();
apl.getlistener();
            }});

        cargoods.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                accesoire=false;
                smartphone=false;
                notebook=false;
                hometovar=false;
                autotovar=true;
auto.setitem();
auto.getlistener();
            }});

    }


    @Override
    public void render(float delta) {
       // timer-=1;
       // if(smartphone) sm.getlistener();
        ScreenUtils.clear(255f/255f, 45f/255f, 16f/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*Bitmap*/
        textdeliver.setColor(Color.WHITE);
        textdeliver.getData().setScale(4, 4);

        /*Control Bar*/
        tb.getBar();
        tb.setPicture();
        /*Batch*/
        camera.update();
        betch.setProjectionMatrix(camera.combined);



        betch.begin();

      /*Big table,Small table*/
        betch.draw(smalltable, smalltablex,smalltabley,Gdx.graphics.getWidth()*20/100f,Gdx.graphics.getHeight()*51/100f);
       betch.draw(bigtable, bigtablex, bigtabley,Gdx.graphics.getWidth()*51/100f,Gdx.graphics.getHeight()*51/100f);

       if(smartphone) {
           sm.getitem();
       }
if (accesoire) {
    ac.getitem();
}
if (notebook){
    pc.getitem();
}
if(hometovar){
    apl.getitem();
}
if (autotovar){
    auto.getitem();
}
        betch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

       // if(smartphone) sm.disposeitem();
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
        tb.bardispose();
        stage.dispose();
        betch.dispose();


        smalltable.dispose();
        textdeliver.dispose();
       if(smartphone) sm.disposeitem();
       if (accesoire) ac.disposeitem();
System.out.println("Magazin hide Storage capacity"+storecapacity);

    }

    @Override
    public void dispose() {
        tb.bardispose();
        stage.dispose();
        betch.dispose();

        smalltable.dispose();
        textdeliver.dispose();
        sm.disposeitem();

    }
}
