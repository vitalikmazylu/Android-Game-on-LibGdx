package com.mygdx.game.Pages;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
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
import com.mygdx.game.Pages.DataBase.Example;
import com.mygdx.game.Pages.DataBase.Improves;
import com.mygdx.game.Pages.DataBase.Market;

public class Marketing implements Screen {

    int price=0;
    int addsview;
    byte market=1;
    boolean infotime=false;
    int timeend;
    /*Gdx.graphics.getWidth()*35/100f, Gdx.graphics.getHeight()*31/100f*/
    float tablex=Gdx.graphics.getWidth()*39/100f;
    float tabley=Gdx.graphics.getHeight()*32/100f;

    String radioname;
    String smmname;
    String banername;
    String magazinesname;
    String tvname;
    String times;
    String aceptname;
    String markinfo;

    final Launch game;
    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;


   private Skin skin;
    ControlBar tb;

    ImageTextButton radio;
    TextButton smm;
    TextButton billboard;
    TextButton magazines;
    TextButton tv;

BitmapFont bfont;
TextureAtlas batlas;
ImageTextButton.ImageTextButtonStyle bstyle;
    ImageTextButton.ImageTextButtonStyle smmstyle;
    ImageTextButton.ImageTextButtonStyle banerstyle;
    ImageTextButton.ImageTextButtonStyle magazstyle;
    ImageTextButton.ImageTextButtonStyle tvstyle;

BitmapFont pmfont;
TextureAtlas pmatlas;
TextButton.TextButtonStyle pmstyle;

TextButton plus;
TextButton minus;

BitmapFont cfont;

Texture coin;
Texture table;

    BitmapFont btfont;
    TextureAtlas btatlas;
    TextButton.TextButtonStyle btstyle;

    TextButton accept;
    TextButton multtime;

    Improves mfile;
    Market ex;

    BitmapFont infoaceept;
    public Marketing(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
    @Override
    public void show() {
skin=new Skin();
ex=new Market();
        tb=new ControlBar();
        tb.createbar();
        switch (tb.language){
            case "English":
                radioname="Radio";
                smmname="SMM";
                banername="Billboard";
               magazinesname="Magazines";
               tvname="Tv";
                aceptname="Accept";
                markinfo="The Promotion will available after";
                times="days";
                break;
            case "France":
               radioname="Radio";
                smmname="SMM";
                banername="Panneau d'affichage";
                magazinesname="Magazines";
                tvname="Tv";
                aceptname="Accepter";
                markinfo="La promotion sera disponible pour";
                times="jours";
                break;
            case "Russian":
                radioname="Радио";
                smmname="СММ";
                banername="Рекламный щит";
                magazinesname="Журналы";
                tvname="Телевизор";
                aceptname="Принять";
                markinfo="Акция будет доступна для";
                times="дни";
                break;
            case "Spanish":
                radioname="Radio";
                smmname="SMM";
                banername="Cartelera";
                magazinesname="Revistas";
                tvname="Televisor";
                aceptname="Aceptar";
                markinfo="La Promoción estará disponible para";
                times="dias";
                break;

            case "Germany":
                radioname="Radio";
                smmname="SMM";
                banername="Werbetafel";
                magazinesname="Zeitschriften";
                tvname="Fernseher";
                aceptname="Akzeptieren";
                markinfo="Die Promotion ist verfügbar für";
                times = "Tage";
                break;
            case "Poland":
                radioname="Radio";
                smmname="SMM";
                banername="Billboard";
                magazinesname="Czasopisma";
                tvname="Tv";
                aceptname="Akceptuj";
                markinfo="Promocja będzie dostępna dla";
                times="dni";
                break;
            case "Ucraine":
                radioname="Радіо";
                smmname="SMM";
                banername="Білборд";
                magazinesname="Журнали";
                tvname="Телевізор";
                aceptname="Прийняти";
                markinfo="Акція буде доступна";
                times="дні";
                break;
            case "Italy":
                radioname="Radio";
                smmname="SMM";
                banername="Tabellone per le affissioni";
                magazinesname="Riviste";
                tvname="Tv";
                aceptname="Accetta";
                markinfo="La promozione sarà disponibile per";
                times="giorni";
                break;
        }
        betch=new SpriteBatch();
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
      tb.getbuttons(game,stage);

bfont=new BitmapFont(Gdx.files.internal("Fonts/marketfont.fnt"));
        bfont.getData().setScale(2, 2);
batlas=new TextureAtlas(Gdx.files.internal("marketingui/market.pack"));
skin.addRegions(batlas);
bstyle=new ImageTextButton.ImageTextButtonStyle();
bstyle.font=bfont;
bstyle.fontColor= Color.WHITE;
bstyle.up= skin.getDrawable("radiobuttons");
bstyle.checked= skin.getDrawable("radiobuttonsdown");
bstyle.unpressedOffsetY=-70;
bstyle.checkedOffsetY=-70;
bstyle.pressedOffsetY=-70;

        smmstyle=new ImageTextButton.ImageTextButtonStyle();
        smmstyle.font=bfont;
        smmstyle.fontColor= Color.WHITE;
        smmstyle.up= skin.getDrawable("smmbuttoms");
        smmstyle.checked= skin.getDrawable("smmbuttomsdown");
        smmstyle.unpressedOffsetY=-70;
        smmstyle.checkedOffsetY=-70;
        smmstyle.pressedOffsetY=-70;

        banerstyle=new ImageTextButton.ImageTextButtonStyle();
        banerstyle.font=bfont;
        banerstyle.fontColor= Color.WHITE;
        banerstyle.up= skin.getDrawable("borderbuttom");
        banerstyle.checked=skin.getDrawable("borderbuttomdown");
        banerstyle.unpressedOffsetY=-70;
        banerstyle.checkedOffsetY=-70;
        banerstyle.pressedOffsetY=-70;

        magazstyle=new ImageTextButton.ImageTextButtonStyle();
        magazstyle.font=bfont;
        magazstyle.fontColor= Color.WHITE;
        magazstyle.up= skin.getDrawable("magazinebuttom");
        magazstyle.checked=skin.getDrawable("magazinebuttomdown");
        magazstyle.unpressedOffsetY=-70;
        magazstyle.checkedOffsetY=-70;
        magazstyle.pressedOffsetY=-70;

        tvstyle=new ImageTextButton.ImageTextButtonStyle();
        tvstyle.font=bfont;
        tvstyle.fontColor= Color.WHITE;
        tvstyle.up= skin.getDrawable("tvbuttom");
        tvstyle.checked=skin.getDrawable("tvbuttomdown");
        tvstyle.unpressedOffsetY=-70;
        tvstyle.checkedOffsetY=-70;
        tvstyle.pressedOffsetY=-70;

cfont=new BitmapFont(Gdx.files.internal("Fonts/marketaccess.fnt"));
cfont.setColor(Color.WHITE);
cfont.getData().setScale(1.5f, 1.5f);

radio=new ImageTextButton(radioname,bstyle);
radio.setPosition(Gdx.graphics.getWidth()*20/100f, Gdx.graphics.getHeight()*45/100f);
radio.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);

      FileHandle file = Gdx.files.local("Improve.json");
        String itemparams = file.readString();
        mfile=json.fromJson(Improves.class, itemparams);

radio.addListener(new ClickListener() {
    @Override
    public void clicked(InputEvent event, float x, float y) {
        if(radio.isChecked()){
            price+=500*mfile.radiolevel;
            addsview+=400*mfile.radiolevel;

        }else{
            price-=500*mfile.radiolevel;
            addsview-=400*mfile.radiolevel;
        }

    }});

smm=new TextButton(smmname, smmstyle);
        smm.setPosition(Gdx.graphics.getWidth()*32/100f, Gdx.graphics.getHeight()*45/100f);
        smm.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);

        smm.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(smm.isChecked()){
                    price+=800*mfile.smmlevel;
                    addsview+=700*mfile.smmlevel;
                }else{
                    price-=800*mfile.smmlevel;
                    addsview-=700*mfile.smmlevel;
                }

            }});

        billboard=new TextButton(banername, banerstyle);
        billboard.setPosition(Gdx.graphics.getWidth()*44/100f, Gdx.graphics.getHeight()*45/100f);
        billboard.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);

        billboard.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(billboard.isChecked()){
                    price+=1500*mfile.banerlevel;
                    addsview+=1000*mfile.banerlevel;

                }else{
                    price-=1500*mfile.banerlevel;
                    addsview-=1000*mfile.banerlevel;

                }

            }});

        magazines=new TextButton(magazinesname, magazstyle);
        magazines.setPosition(Gdx.graphics.getWidth()*56/100f, Gdx.graphics.getHeight()*45/100f);
        magazines.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);

        magazines.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(magazines.isChecked()){
                    price+=500*mfile.magazineslevel;
                    addsview+=300*mfile.magazineslevel;

                }else{
                    price-=500*mfile.magazineslevel;
                    addsview-=300*mfile.magazineslevel;

                }

            }});

        tv=new TextButton(tvname, tvstyle);
        tv.setPosition(Gdx.graphics.getWidth()*68/100f, Gdx.graphics.getHeight()*45/100f);
        tv.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);

        tv.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(tv.isChecked()){
                    price+=3000*mfile.tvlevel;
                    addsview+=5000*mfile.tvlevel;

                }else{
                    price-=3000*mfile.tvlevel;
                    addsview-=5000*mfile.tvlevel;

                }

            }});

        //stage.setKeyboardFocus(bad);
stage.addActor(radio);
stage.addActor(smm);
stage.addActor(billboard);
stage.addActor(magazines);
stage.addActor(tv);

coin=new Texture("dollar.png");
table=new Texture("marketingui/markettable.png");

pmfont=new BitmapFont(Gdx.files.internal("Fonts/marketfont.fnt"));
pmfont.setColor(Color.BLACK);
pmfont.getData().setScale(3, 3);
pmatlas=new TextureAtlas(Gdx.files.internal("magazinui/plusminus.pack"));
skin.addRegions(pmatlas);
pmstyle=new TextButton.TextButtonStyle();
        pmstyle.font=pmfont;
        pmstyle.fontColor= Color.BLACK;
        pmstyle.up= skin.getDrawable("minuspluslight");
        pmstyle.down=skin.getDrawable("minusplusdark");

        plus=new TextButton("+", pmstyle);
        plus.setPosition(tablex+Gdx.graphics.getWidth()*12/100f, tabley+Gdx.graphics.getHeight()*2/100f);
plus.setSize(Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f );
        plus.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
              if(market<127) {
                  market++;
              }
            }});


minus=new TextButton("-", pmstyle);
minus.setPosition(tablex+Gdx.graphics.getWidth()*1/100f, tabley+Gdx.graphics.getHeight()*2/100f);
        minus.setSize(Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f );

        minus.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
              if (market<=1){

              }else{
                  market--;
              }

            }});

stage.addActor(plus);
stage.addActor(minus);

       btfont=new BitmapFont(Gdx.files.internal("Fonts/marketaccess.fnt"));
        btfont.setColor(Color.BLACK);
        btfont.getData().setScale(1, 1);
        btatlas=new TextureAtlas(Gdx.files.internal("Ui/newbuttom.pack"));
        skin.addRegions(btatlas);
        btstyle=new TextButton.TextButtonStyle();
        btstyle.font=btfont;
        btstyle.fontColor= Color.WHITE;
        btstyle.up= skin.getDrawable("greenbutton");

        multtime=new TextButton("X2", btstyle);
        multtime.setPosition(Gdx.graphics.getWidth()*68/100f, Gdx.graphics.getHeight()*32/100f);
        multtime.setSize(Gdx.graphics.getWidth()*10/100f,Gdx.graphics.getWidth()*4/100f );



        accept=new TextButton(aceptname, btstyle);
        accept.setPosition(Gdx.graphics.getWidth()*56/100f, Gdx.graphics.getHeight()*32/100f);
        accept.setSize(Gdx.graphics.getWidth()*10/100f,Gdx.graphics.getWidth()*4/100f );

        accept.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if(radio.isChecked()|| smm.isChecked()||billboard.isChecked()||magazines.isChecked()|| tv.isChecked() ) {
                    if (tb.value >= price * market){
                        tb.value -= price * market;
                    timeend += tb.time + market;
                    // market=1;
                    // price=0;

                    System.out.println("Radio" + radio.isChecked());
                    radio.setChecked(false);
                    smm.setChecked(false);
                    billboard.setChecked(false);
                    magazines.setChecked(false);
                    tv.setChecked(false);
                    infotime = true;
                    stage.addActor(multtime);
                    FileHandle file = Gdx.files.local("marketing.json");
                    ex.viewes =addsview * market;
                    ex.time =timeend;

                    String text = json.toJson(ex);
                    file.writeString(text, false);
                    tb.watches += addsview * market;
                }
                }
            }});

        multtime.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                timeend=market*2+tb.time;
                FileHandle file = Gdx.files.local("marketing.json");
                ex.viewes = addsview * market;
                ex.time = timeend;

                String text = json.toJson(ex);
                file.writeString(text, false);
                multtime.remove();
            }});

        stage.addActor(accept);

        infoaceept=new BitmapFont();
        infoaceept.setColor(Color.GOLD);
        infoaceept.getData().setScale(4, 4);

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(255f/255f, 45f/255f, 16f/255f, 1f);
        tb.getBar();
        tb.setPicture();
        camera.update();
        betch.setProjectionMatrix(camera.combined);
        betch.begin();
        betch.draw(table, tablex, tabley,Gdx.graphics.getWidth()*15/100f,Gdx.graphics.getWidth()*4/100f);
       pmfont.draw(betch, market+times, tablex+Gdx.graphics.getWidth()*4.5f/100f, tabley+Gdx.graphics.getHeight()*6/100f);
        betch.draw(coin, Gdx.graphics.getWidth()*26/100f, Gdx.graphics.getHeight()*33/100f,Gdx.graphics.getWidth()*2/100f,Gdx.graphics.getWidth()*2/100f);
        cfont.draw(betch, ""+price*market, Gdx.graphics.getWidth()*29/100f, Gdx.graphics.getHeight()*37/100f);
if(infotime) {
    infoaceept.draw(betch, markinfo + timeend, Gdx.graphics.getWidth() * 20 / 100f, Gdx.graphics.getHeight() * 25 / 100f);
if (tb.time>timeend) {
    infotime = false;
timeend=0;
    multtime.remove();
}
}
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        betch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        FileHandle file = Gdx.files.local("scores.json");
        Example ex=new Example();

        ex.watches= tb.watches;
        ex.price= tb.value;
        String text = json.toJson(ex);

        file.writeString(text, false);
       // System.out.println("Text"+text);
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        tb.bardispose();
        stage.dispose();
        betch.dispose();
        skin.dispose();
        bfont.dispose();
        batlas.dispose();
        pmfont.dispose();
        pmatlas.dispose();
        cfont.dispose();
        btfont.dispose();
        btatlas.dispose();
       coin.dispose();
        table.dispose();

    }

    @Override
    public void dispose() {
        System.out.println("Disposed");
        tb.bardispose();
        stage.dispose();
        betch.dispose();
        skin.dispose();
        bfont.dispose();
        batlas.dispose();
        pmfont.dispose();
        pmatlas.dispose();
        cfont.dispose();
        btfont.dispose();
        btatlas.dispose();
        coin.dispose();
        table.dispose();
    }
}
