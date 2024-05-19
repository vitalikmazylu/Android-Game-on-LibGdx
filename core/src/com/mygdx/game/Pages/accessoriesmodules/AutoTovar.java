package com.mygdx.game.Pages.accessoriesmodules;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.ControlBar;
import com.mygdx.game.Pages.DataBase.Improves;
import com.mygdx.game.Pages.DataBase.Items;
import com.mygdx.game.Pages.Magazine;

import java.util.ArrayList;

public class AutoTovar {

    byte smartfonlevel;
    int storecapacity;
    boolean error=false;
    String errormessage;
    float timer=50f;

    String buy;
    String dropstring;
    String optstring;
    String factorystring;

    FileHandle fileb;

    byte sellkategory;
    byte pagec=1;
    byte conprice=1;//Condition price OPT-2 Drop-1 from Factory-3
    int price1;
    int price2;
    int price3;
    int price4;

    int priceitem1;
    int priceitem2;
    int priceitem3;
    int priceitem4;

    int dropprice1;
    int dropprice2;
    int dropprice3;
    int dropprice4;

    int optprice1;
    int optprice2;
    int optprice3;
    int optprice4;

    int factoryprice1;
    int factoryprice2;
    int factoryprice3;
    int factoryprice4;

    short minps;
    short pieces1=1;
    short pieces2=1;
    short pieces3=1;
    short pieces4=1;

    String photo1;
    String photo2;
    String photo3;
    String photo4;

    short timedeliver;
    String timename;
    byte timeitem=10;
    float timechanger;

    float bigtablex,bigtabley;
    float ytable;
    float xtable1;
    float xtable2;
    float xtable3;
    float xtable4;

    float widthtable= Gdx.graphics.getWidth()*11/100f;
    float heighttable=Gdx.graphics.getHeight()*35/100f;

    ControlBar tb;
    String image;
    Texture redtable;
    Texture countbar;
    Texture coin;

    //Sprite sprite;
    SpriteBatch betch;
    Texture item1;
    Texture item2;
    Texture item3;
    Texture item4;
    Stage stage;
    Skin skin;
    BitmapFont font;
    BitmapFont textdeliver;
    BitmapFont counteritem;
    TextureAtlas atlas;

    TextButton.TextButtonStyle textButtonStyle;
    TextButton button1;
    TextButton button2;
    TextButton button3;
    TextButton button4;
    TextButton skip;
    /*For button subscribe*/
    TextureAtlas subscratlas;

    TextButton.TextButtonStyle substyle;
    BitmapFont sfont;
    TextButton pay;
    /*For Plus Minus buttom */
    TextureAtlas patlas;
    TextButton.TextButtonStyle pstyle;
    BitmapFont pfont;
    TextButton plus1;
    TextButton plus2;
    TextButton plus3;
    TextButton plus4;
    TextButton minus1;
    TextButton minus2;
    TextButton minus3;
    TextButton minus4;

    /*Page*/
    BitmapFont pagefont;
    TextureAtlas pageatlas;
    TextButton.TextButtonStyle pagestyle;

    TextButton page1;
    TextButton page2;
    TextButton page3;
    TextButton page4;
    TextButton page5;
    /* For Opt Drop */
    BitmapFont prfont;
    TextButton.TextButtonStyle prstyle;
    TextureAtlas pratlas;
    TextButton drop;
    TextButton opt;
    TextButton factory;

    ArrayList<Items> list;
    Items itm;
    Magazine mgz;
    Improves impr;

    Sound click;
    Sound clickbuy;

    BitmapFont errorfont;

    public AutoTovar(SpriteBatch betch,Stage stage,ControlBar tb,byte level,int capacity,float tablex,float tabley){
        this.betch=betch;
        this.stage=stage;
        this.tb=tb;
        this.smartfonlevel=level;
        this.storecapacity=capacity;

        this.bigtablex=tablex;
        this.bigtabley=tabley;
        /*For price*/



    }

    //Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*21/100f




    public void setitem(){
        ytable=bigtabley+Gdx.graphics.getHeight()*13/100f;

        xtable1=bigtablex+Gdx.graphics.getWidth()*2/100f;
        xtable2=xtable1+Gdx.graphics.getWidth()*12/100f;
        xtable3=xtable2+Gdx.graphics.getWidth()*12/100f;
        xtable4=xtable3+Gdx.graphics.getWidth()*12/100f;


        impr=new Improves();
        // price1=priceitem1;
        list=new ArrayList<Items>();

        textdeliver=new BitmapFont();
        counteritem=new BitmapFont();
        redtable=new Texture("Store/redtable.png");
        countbar=new Texture("magazinui/countbuttom.png");
        /*For sound*/
        click=Gdx.audio.newSound(Gdx.files.internal("sounds/click.mp3"));
        clickbuy=Gdx.audio.newSound(Gdx.files.internal("sounds/clickbuy.mp3"));


        /*For language*/
        dropstring="-0%";
        optstring="-25%";
        factorystring="-50%";
        switch (tb.language){
            case "English":
                buy="Buy";

                break;
            case "France":
                buy="Acheter";

                break;
            case "Russian":
                buy="Купить";

                break;
            case "Spanish":
                buy="Comprar";
                break;

            case "Germany":
                buy="Kaufen"
                ;break;
            case "Poland":
                buy="Kup";break;
            case "Ucraine":
                buy="Купити";
                break;
            case "Italy":
                buy="acquistare";
                break;
        }

        skin=new Skin();

        coin=new Texture("money.png");

        prfont=new BitmapFont(Gdx.files.internal("Fonts/kategoria.fnt"));

        pratlas=new TextureAtlas(Gdx.files.internal("Store/textbutton.pack"));
        skin.addRegions(pratlas);
        prstyle=new TextButton.TextButtonStyle();
        prstyle.font=prfont;
        prstyle.up= skin.getDrawable("yellowbutton");
        prstyle.checked=skin.getDrawable("greenbutton");
        prfont.getData().setScale(2, 2);
        prstyle.fontColor= Color.WHITE;

        drop=new TextButton(dropstring, prstyle);
        drop.setPosition(Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*76/100f);
        drop.setSize(Gdx.graphics.getWidth()*12/100f,Gdx.graphics.getHeight()*6/100f);

        opt=new TextButton(optstring, prstyle);
        opt.setPosition(Gdx.graphics.getWidth()*45/100f, Gdx.graphics.getHeight()*76/100f);
        opt.setSize(Gdx.graphics.getWidth()*12/100f,Gdx.graphics.getHeight()*6/100f);

        factory=new TextButton(factorystring, prstyle);
        factory.setPosition(Gdx.graphics.getWidth()*60/100f, Gdx.graphics.getHeight()*76/100f);
        factory.setSize(Gdx.graphics.getWidth()*12/100f,Gdx.graphics.getHeight()*6/100f);


        errorfont=new BitmapFont(Gdx.files.internal("Fonts/errorfont.fnt"));
        errorfont.setColor(Color.RED);
//errorfont.getData().setScale(2f, 2f);


        font=new BitmapFont(Gdx.files.internal("Fonts/buyfont.fnt"));

        atlas = new TextureAtlas(Gdx.files.internal("Ui/newbuttom.pack"));
        skin.addRegions(atlas);
        textButtonStyle=new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("greenbutton");
        font.getData().setScale(3, 3);

        button1=new TextButton(buy, textButtonStyle);
        button1.setPosition(xtable1+Gdx.graphics.getWidth()*1.6f/100f, ytable+Gdx.graphics.getHeight()*1f/100f);
        button1.setSize(Gdx.graphics.getWidth()*8/100f,Gdx.graphics.getHeight()*4/100f);

        button2=new TextButton(buy, textButtonStyle);
        button2.setPosition(xtable2+Gdx.graphics.getWidth()*1.6f/100f, ytable+Gdx.graphics.getHeight()*1f/100f);
        button2.setSize(Gdx.graphics.getWidth()*8/100f,Gdx.graphics.getHeight()*4/100f);

        button3=new TextButton(buy, textButtonStyle);
        button3.setPosition(xtable3+Gdx.graphics.getWidth()*1.6f/100f, ytable+Gdx.graphics.getHeight()*1f/100f);
        button3.setSize(Gdx.graphics.getWidth()*8/100f,Gdx.graphics.getHeight()*4/100f);

        button4=new TextButton(buy, textButtonStyle);
        button4.setPosition(xtable4+Gdx.graphics.getWidth()*1.6f/100f, ytable+Gdx.graphics.getHeight()*1f/100f);
        button4.setSize(Gdx.graphics.getWidth()*8/100f,Gdx.graphics.getHeight()*4/100f);

        /*For Pay button*/
        sfont=new BitmapFont();
        subscratlas=new TextureAtlas(Gdx.files.internal("magazinui/paybutton.pack"));
        skin.addRegions(subscratlas);
        substyle=new TextButton.TextButtonStyle();
        substyle.font=sfont;
        substyle.fontColor=Color.WHITE;
        substyle.up=skin.getDrawable("paybutton");
        sfont.getData().setScale(3,3);

        pay=new TextButton("right now", substyle);
        pay.setPosition(Gdx.graphics.getWidth()*65/100f, Gdx.graphics.getHeight()*19/100f);
        pay.setSize(Gdx.graphics.getWidth()*9/100f,Gdx.graphics.getHeight()*5/100f);
        /* Plus Minus buttom */
        pfont=new BitmapFont();
        patlas=new TextureAtlas(Gdx.files.internal("magazinui/plusminus.pack"));
        skin.addRegions(patlas);
        pstyle=new TextButton.TextButtonStyle();
        pstyle.font=pfont;
        pstyle.fontColor=Color.BLACK;
        pstyle.up=skin.getDrawable("minuspluslight");
        pstyle.down=skin.getDrawable("minusplusdark");
        pfont.getData().setScale(2,2);
        /*minus 1 col*/
        minus1=new TextButton("-", pstyle);
        minus1.setPosition(xtable1+Gdx.graphics.getWidth()*7f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        minus1.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);
        /* minus 2 cols */
        minus2=new TextButton("-", pstyle);
        minus2.setPosition(xtable2+Gdx.graphics.getWidth()*7f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        minus2.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);
        /*minus 3 cols*/
        minus3=new TextButton("-", pstyle);
        minus3.setPosition(xtable3+Gdx.graphics.getWidth()*7f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        minus3.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);
        /*minus 4 cols*/
        minus4=new TextButton("-", pstyle);
        minus4.setPosition(xtable4+Gdx.graphics.getWidth()*7f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        minus4.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);
        /*Plus 1 cols*/
        plus1=new TextButton("+", pstyle);
        plus1.setPosition(xtable1+Gdx.graphics.getWidth()*2f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        plus1.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);
        /*Plus 2 cols*/
        plus2=new TextButton("+", pstyle);
        plus2.setPosition(xtable2+Gdx.graphics.getWidth()*2f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        plus2.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);
        /*Plus 3 cols*/
        plus3=new TextButton("+", pstyle);
        plus3.setPosition(xtable3+Gdx.graphics.getWidth()*2f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        plus3.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);
        /*Plus 4 cols*/
        plus4=new TextButton("+", pstyle);
        plus4.setPosition(xtable4+Gdx.graphics.getWidth()*2f/100f, ytable+Gdx.graphics.getHeight()*11.5f/100f);
        plus4.setSize(Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getWidth()*2/100f);

        /*Pages*/
        pagefont=new BitmapFont(Gdx.files.internal("Fonts/kategoria.fnt"));
        pageatlas=new TextureAtlas(Gdx.files.internal("Store/textbutton.pack"));
        skin.addRegions(pageatlas);
        pagestyle=new TextButton.TextButtonStyle();
        pagestyle.font=pagefont;
        pagestyle.up=skin.getDrawable("yellowbutton");
        pagestyle.checked=skin.getDrawable("greenbutton");
        pagefont.getData().setScale(2.5f,2.5f);
//Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*21/100f
        page1=new TextButton("1", pagestyle);
        page1.setPosition(bigtablex+Gdx.graphics.getWidth()*30/100f, bigtabley+Gdx.graphics.getHeight()*4/100f);
        page1.setSize(Gdx.graphics.getWidth()*3/100f, Gdx.graphics.getWidth()*3/100f);



        page2=new TextButton("2", pagestyle);
        page2.setPosition(bigtablex+Gdx.graphics.getWidth()*34/100f, bigtabley+Gdx.graphics.getHeight()*4/100f);
        page2.setSize(Gdx.graphics.getWidth()*3/100f, Gdx.graphics.getWidth()*3/100f);



        page3=new TextButton("3", pagestyle);
        page3.setPosition(bigtablex+Gdx.graphics.getWidth()*38/100f, bigtabley+Gdx.graphics.getHeight()*4/100f);
        page3.setSize(Gdx.graphics.getWidth()*3/100f, Gdx.graphics.getWidth()*3/100f);



        page4=new TextButton("4", pagestyle);
        page4.setPosition(bigtablex+Gdx.graphics.getWidth()*42/100f, bigtabley+Gdx.graphics.getHeight()*4/100f);
        page4.setSize(Gdx.graphics.getWidth()*3/100f, Gdx.graphics.getWidth()*3/100f);



        page5=new TextButton("5", pagestyle);
        page5.setPosition(bigtablex+Gdx.graphics.getWidth()*46/100f, bigtabley+Gdx.graphics.getHeight()*4/100f);
        page5.setSize(Gdx.graphics.getWidth()*3/100f, Gdx.graphics.getWidth()*3/100f);


        stage.addActor(page1);
        stage.addActor(page2);
        stage.addActor(page3);
        stage.addActor(page4);
        stage.addActor(page5);

        stage.addActor(minus1);
        stage.addActor(minus2);
        stage.addActor(minus3);
        stage.addActor(minus4);
        stage.addActor(plus1);
        stage.addActor(plus2);
        stage.addActor(plus3);
        stage.addActor(plus4);
//stage.addActor(pay);
        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(drop);
        stage.addActor(opt);
        stage.addActor(factory);
        /*Plus listeners*/
        getpage(pagec);

    }

    public void getlistener(){
        itm=new Items();

        drop.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                click.play();
                conprice=1;
                minps=1;
                pieces1=minps;
                pieces2=minps;
                pieces3=minps;
                pieces4=minps;

                opt.setChecked(false);
                factory.setChecked(false);
            }});

        opt.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play();
                conprice=2;
                minps=5;
                timeitem=30;
                pieces1=minps;
                pieces2=minps;
                pieces3=minps;
                pieces4=minps;
                drop.setChecked(false);
                factory.setChecked(false);
            }});

        factory.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play();
                conprice=3;
                minps=100;
                timeitem=50;
                pieces1=minps;
                pieces2=minps;
                pieces3=minps;
                pieces4=minps;
                drop.setChecked(false);
                opt.setChecked(false);
            }});

        plus1.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play();
                pieces1++;
                price1=priceitem1*pieces1;

            }});
        plus2.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play();
                pieces2++;
                price2=priceitem2*pieces2;


            }});
        plus3.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play();
                pieces3++;
                price3=priceitem3*pieces3;

            }});
        plus4.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play();
                pieces4++;
                price4=priceitem4*pieces4;

            }});

        /*Minus listeners*/
        minus1.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(pieces1>minps) {
                    click.play();
                    pieces1--;
                    price1=priceitem1*pieces1;
                }
            }});

        minus2.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(pieces2>minps) {
                    click.play();
                    pieces2--;
                    price2=priceitem2*pieces2;
                }
            }});
        minus3.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(pieces3>minps) {
                    click.play();
                    pieces3--;
                    price3=priceitem3*pieces3;
                }
            }});
        minus4.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(pieces4>minps) {
                    click.play();
                    pieces4--;
                    price4=priceitem4*pieces4;
                }
            }});
        /*Skip and subscribe listeners*/

        /*Buttom buy listeners*/
        button1.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                byte b=1;
                getbuttom(b);
            }});

        button2.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                byte b=2;
                getbuttom(b);
            }
        });

        button3.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                byte b=3;
                getbuttom(b);
            }
        });

        button4.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                byte b=4;
                getbuttom(b);
            }
        });
        page1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                pagec=1;

                page2.setChecked(false);
                page3.setChecked(false);
                page4.setChecked(false);
                page5.setChecked(false);
                if(pagec<=smartfonlevel){

                    getpage(pagec);
                }else{
                    error=true;
                    getpageerror();
                }
            }});
        page2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pagec=2;
                page1.setChecked(false);

                page3.setChecked(false);
                page4.setChecked(false);
                page5.setChecked(false);
                if(pagec<=smartfonlevel){
                    getpage(pagec);
                }else{
                    error=true;
                    getpageerror();
                }
            }});
        page3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pagec=3;
                page1.setChecked(false);
                page2.setChecked(false);

                page4.setChecked(false);
                page5.setChecked(false);
                if(pagec<=smartfonlevel){
                    getpage(pagec);
                }else{
                    error=true;
                    getpageerror();
                }
            }});
        page4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pagec=4;
                page1.setChecked(false);
                page2.setChecked(false);
                page3.setChecked(false);

                page5.setChecked(false);
                if(pagec<=smartfonlevel){
                    getpage(pagec);
                }else{
                    error=true;
                    getpageerror();
                }
            }});
        page5.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pagec=5;
                page1.setChecked(false);
                page2.setChecked(false);
                page3.setChecked(false);
                page4.setChecked(false);

                if(pagec<=smartfonlevel){
                    getpage(pagec);
                }else{
                    error=true;
                    getpageerror();
                }
            }});
    }

    public void getpage(byte a){
        click.play();
        switch (a) {
            case 1:/*1 Page*/
                photo1 = "smartphoneitems/Nokia 150.jpg";
                priceitem1 = 300;
                dropprice1 = 300;
                optprice1 = priceitem1 * 75 / 100;
                factoryprice1 = priceitem1 * 50 / 100;


                photo2 = "smartphoneitems/One Plus 9.jpg";
                priceitem2 = 525;
                dropprice2 = 525;
                optprice2 = priceitem2 * 75 / 100;
                factoryprice2 = priceitem2 * 50 / 100;

                photo3 = "smartphoneitems/POco m4 pro.jpg";
                priceitem3 = 238;
                dropprice3 = 238;
                optprice3 = priceitem3 * 75 / 100;
                factoryprice3 = priceitem3 * 50 / 100;

                photo4 = "smartphoneitems/Nokia G10.jpg";
                priceitem4 = 100;
                dropprice4 = 100;
                optprice4 = priceitem4 * 75 / 100;
                factoryprice4 = priceitem4 * 50 / 100;


                break;

            case 2:/*2 Page*/
                photo1 = "smartphoneitems/Samsung Galaxy a53.jpg";
                priceitem1 = 425;
                dropprice1 = 425;
                optprice1 = priceitem1 * 75 / 100;
                factoryprice1 = priceitem1 * 50 / 100;


                photo2 = "smartphoneitems/Google Pixel 6.jpg";
                priceitem2 = 875;
                dropprice2 = 875;
                optprice2 = priceitem2 * 75 / 100;
                factoryprice2 = priceitem2 * 50 / 100;

                photo3 = "smartphoneitems/Xiaomi poco x4pro.jpg";
                priceitem3 = 350;
                dropprice3 = 350;
                optprice3 = priceitem3 * 75 / 100;
                factoryprice3 = priceitem3 * 50 / 100;

                photo4 = "smartphoneitems/Sigma mobile X-Style.jpg";
                priceitem4 = 15;
                dropprice4 = 15;
                optprice4 = priceitem4 * 75 / 100;
                factoryprice4 = priceitem4 * 50 / 100;


                break;

            case 3:/*3 Page*/
                photo1 = "smartphoneitems/Poco C40.jpg";
                priceitem1 = 130;
                dropprice1 = 130;
                optprice1 = priceitem1 * 75 / 100;
                factoryprice1 = priceitem1 * 50 / 100;


                photo2 = "smartphoneitems/Samsung galaxy fold 4.jpg";
                priceitem2 = 1700;
                dropprice2 = 1700;
                optprice2 = priceitem2 * 75 / 100;
                factoryprice2 = priceitem2 * 50 / 100;

                photo3 = "smartphoneitems/Huawei P50 pro.jpg";
                priceitem3 = 1000;
                dropprice3 = 1000;
                optprice3 = priceitem3 * 75 / 100;
                factoryprice3 = priceitem3 * 50 / 100;

                photo4 = "smartphoneitems/Iphone 12.jpg";
                priceitem4 = 875;
                dropprice4 = 875;
                optprice4 = priceitem4 * 75 / 100;
                factoryprice4 = priceitem4 * 50 / 100;

                break;

            case 4:/*4 page*/
                photo1 = "smartphoneitems/Samsung galaxy flip4.jpg";
                priceitem1 = 1000;
                dropprice1 = 1000;
                optprice1 = priceitem1 * 75 / 100;
                factoryprice1 = priceitem1 * 50 / 100;


                photo2 = "smartphoneitems/Iphone 14 pro.jpg";
                priceitem2 = 1400;
                dropprice2 = 1400;
                optprice2 = priceitem2 * 75 / 100;
                factoryprice2 = priceitem2 * 50 / 100;

                photo3 = "smartphoneitems/Xiaomi redmi 10a.jpg";
                priceitem3 = 110;
                dropprice3 = 110;
                optprice3 = priceitem3 * 75 / 100;
                factoryprice3 = priceitem3 * 50 / 100;

                photo4 = "smartphoneitems/One plus 8t.jpg";
                priceitem4 = 210;
                dropprice4 = 210;
                optprice4 = priceitem4 * 75 / 100;
                factoryprice4 = priceitem4 * 50 / 100;


                break;

            case 5:/*5 Page*/
                photo1 = "smartphoneitems/Xiaomi redmi note11 pro.jpg";
                priceitem1 = 438;
                dropprice1=438;
                optprice1 = priceitem1 * 75 / 100;
                factoryprice1 = priceitem1 * 50 / 100;


                photo2 = "smartphoneitems/Samsung galaxy s22.jpg";
                priceitem2 = 720;
                dropprice2 = 720;
                optprice2 = priceitem2 * 75 / 100;
                factoryprice2 = priceitem2 * 50 / 100;

                photo3 = "smartphoneitems/Asus Rog phone 5s.jpg";
                priceitem3 = 700;
                dropprice3 = 700;
                optprice3 = priceitem3 * 75 / 100;
                factoryprice3 = priceitem3 * 50 / 100;

                photo4 = "smartphoneitems/google pixel 7.jpg";
                priceitem4 = 1400;
                dropprice4 = 1400;
                optprice4 = priceitem4 * 75 / 100;
                factoryprice4 = priceitem4 * 50 / 100;

                page1.setChecked(false);
                page2.setChecked(false);
                page3.setChecked(false);
                page4.setChecked(false);

                break;
        }
        item1=new Texture(photo1);
        item2=new Texture(photo2);
        item3=new Texture(photo3);
        item4=new Texture(photo4);
    }
    public void errorbutton(){
        error=true;
        switch (tb.language){
            case "English":
                errormessage="Not enough funds";
                break;
            case "France":
                errormessage="Pas assez de fonds";
                break;
            case "Russian":
                errormessage="Не хватает средств";
                break;
            case "Spanish":
                errormessage="No hay suficientes fondos";
                break;

            case "Germany":
                errormessage="nicht genug Geld";
                ;break;
            case "Poland":
                errormessage="Brak wystarczających środków";
                break;
            case "Ucraine":
                errormessage="Бракує коштів";
                break;
            case "Italy":
                errormessage="fondi insufficienti";
                break;
        }
    }

    public void getbuttom(byte b){
        if(storecapacity>=pieces1) {

            //bought = true;

            /*When player press on opt and from factory and then press "Buy" he needs to show addversiment */

            if(conprice==2||conprice==3){
                System.out.println("Reklama");
            }
            switch (b){
                case 1:
                    fileb = Gdx.files.local("smartfonitem_1_" + pagec + ".json");
                    System.out.println("Price 1"+price1);
                    if(tb.value>=price1 && storecapacity>=pieces1) {
                        clickbuy.play(1.0f);
                        timedeliver += timeitem * pieces1;
                        tb.value -= price1;
                        storecapacity -= pieces1;
                        itm.value = dropprice1;
                        itm.pieces = pieces1;
                        itm.imgname = photo1;
                        itm.timedeliever = timedeliver;
                    }else {
                        errorbutton();
                    }
                    break;
                case 2:
                    System.out.println("Price 2"+price2);
                    if(tb.value>=price2 && storecapacity>=pieces2) {
                        clickbuy.play(1.0f);
                        fileb = Gdx.files.local("smartfonitem_2_" + pagec + ".json");
                        timedeliver += timeitem * pieces2;
                        tb.value -= price2;
                        storecapacity -= pieces2;
                        itm.value = dropprice2;
                        itm.pieces = pieces2;
                        itm.imgname = photo2;
                        itm.timedeliever = timedeliver;
                    }else{
                        errorbutton();
                    }
                    break;
                case 3:
                    System.out.println("Price 3 "+price3);
                    if(tb.value>=price3 && storecapacity>=pieces3) {
                        clickbuy.play(1.0f);
                        fileb = Gdx.files.local("smartfonitem_3_" + pagec + ".json");
                        timedeliver += timeitem * pieces3;
                        tb.value -= price3;
                        storecapacity -= pieces3;
                        itm.value = dropprice3;
                        itm.pieces = pieces3;
                        itm.imgname = photo3;
                        itm.timedeliever = timedeliver;
                    }else{
                        errorbutton();
                    }
                    break;
                case 4:
                    System.out.println("Price 4"+price4);
                    if(tb.value>=price4 && storecapacity>=pieces4) {
                        clickbuy.play(1.0f);
                        fileb = Gdx.files.local("smartfonitem_4_" + pagec + ".json");
                        timedeliver += timeitem * pieces4;
                        tb.value -= price4;
                        storecapacity -= pieces4;
                        itm.value = dropprice4;
                        itm.pieces = pieces4;
                        itm.imgname = photo4;
                        itm.timedeliever = timedeliver;
                    }else {
                        errorbutton();
                    }
                    break;
                // default: fileb = Gdx.files.local("smartfonitem_4_" + pagec + ".json");
            }



            if (fileb.exists()) {
                System.out.println("File exist");
                String itemparams = fileb.readString();
                Items smartparams = json.fromJson(Items.class, itemparams);
                if (smartparams.pieces == 0) {
                    String text = json.toJson(itm);
                    fileb.writeString(text, false);
                } else {
                    itm.pieces += smartparams.pieces;
                    String text = json.toJson(itm);
                    fileb.writeString(text, false);
                }

            } else {
                System.out.println("File not exist");
                String text = json.toJson(itm);
                fileb.writeString(text, false);
            }






        }else{
            System.out.println("Improve your storage");

        } }

    private void getpageerror(){
        switch (tb.language){
            case "English":
                errormessage="Improve your smartfone level";
                break;
            case "France":
                errormessage="Improv your smartfone level";
                break;
            case "Russian":
                errormessage="Improve your smartfoe level";
                break;
            case "Spanish":
                errormessage="Improve yor smartfone level";
                break;
        }
    }


    public void getitem() {
        textdeliver.setColor(Color.WHITE);
        textdeliver.getData().setScale(3, 3);

        counteritem.setColor(Color.BLACK);
        counteritem.getData().setScale(Gdx.graphics.getWidth() * 1 / 1000f, Gdx.graphics.getWidth() * 1 / 1000f);


        switch (conprice) {
            case 1:
                price1 = priceitem1 * pieces1;
                price2 = priceitem2 * pieces2;
                price3 = priceitem3 * pieces3;
                price4 = priceitem4 * pieces4;
                break;
            case 2:
                price1 = optprice1 * pieces1;
                price2 = optprice2 * pieces2;
                price3 = optprice3 * pieces3;
                price4 = optprice4 * pieces4;
                break;
            case 3:
                price1 = factoryprice1 * pieces1;
                price2 = factoryprice2 * pieces2;
                price3 = factoryprice3 * pieces3;
                price4 = factoryprice4 * pieces4;
                break;
        }






        /*First table*/
        betch.draw(redtable, xtable1, ytable, widthtable, heighttable);
        /*Bar*/
        betch.draw(countbar, xtable1 + Gdx.graphics.getWidth() * 1.5f / 100f, ytable + Gdx.graphics.getHeight() * 11 / 100f, Gdx.graphics.getWidth() * 8 / 100f, Gdx.graphics.getHeight() * 5 / 100f);
        /*Imagine*/
        betch.draw(item1, xtable1 + Gdx.graphics.getWidth() * 2.0f / 100f, ytable + Gdx.graphics.getHeight() * 18 / 100f, Gdx.graphics.getWidth() * 7 / 100f, Gdx.graphics.getHeight() * 15 / 100f);
        /*Coin image*/
        betch.draw(coin, xtable1 + Gdx.graphics.getWidth() * 2f / 100f, ytable + Gdx.graphics.getHeight() * 6f / 100f, Gdx.graphics.getWidth() * 2 / 100f, Gdx.graphics.getWidth() * 2 / 100f);
        /*Counter*/
        counteritem.draw(betch, pieces1 + "", xtable1 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 14.5f / 100f);
        /*Price*/
        textdeliver.draw(betch, price1 + "", xtable1 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 10f / 100f);



        /*Second table*/
        betch.draw(redtable, xtable2, ytable, widthtable, heighttable);
        /*Bar*/
        betch.draw(countbar, xtable2 + Gdx.graphics.getWidth() * 1.5f / 100f, ytable + Gdx.graphics.getHeight() * 11 / 100f, Gdx.graphics.getWidth() * 8 / 100f, Gdx.graphics.getHeight() * 5 / 100f);
        /*Image*/
        betch.draw(item2, xtable2 + Gdx.graphics.getWidth() * 2.0f / 100f, ytable + Gdx.graphics.getHeight() * 18 / 100f, Gdx.graphics.getWidth() * 7 / 100f, Gdx.graphics.getHeight() * 15 / 100f);
        /*Coin image*/
        betch.draw(coin, xtable2 + Gdx.graphics.getWidth() * 2f / 100f, ytable + Gdx.graphics.getHeight() * 6f / 100f, Gdx.graphics.getWidth() * 2 / 100f, Gdx.graphics.getWidth() * 2 / 100f);
        /*Counter*/
        counteritem.draw(betch, pieces2 + "", xtable2 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 14.5f / 100f);
        /*Price*/
        textdeliver.draw(betch, price2 + "", xtable2 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 10f / 100f);



        /*Third table*/
        betch.draw(redtable, xtable3, ytable, widthtable, heighttable);
        /*Bar*/
        betch.draw(countbar, xtable3 + Gdx.graphics.getWidth() * 1.5f / 100f, ytable + Gdx.graphics.getHeight() * 11 / 100f, Gdx.graphics.getWidth() * 8 / 100f, Gdx.graphics.getHeight() * 5 / 100f);
        /*Image*/
        betch.draw(item3, xtable3 + Gdx.graphics.getWidth() * 2.0f / 100f, ytable + Gdx.graphics.getHeight() * 18 / 100f, Gdx.graphics.getWidth() * 7 / 100f, Gdx.graphics.getHeight() * 15 / 100f);
        /*Coin image*/
        betch.draw(coin, xtable3 + Gdx.graphics.getWidth() * 2f / 100f, ytable + Gdx.graphics.getHeight() * 6f / 100f, Gdx.graphics.getWidth() * 2 / 100f, Gdx.graphics.getWidth() * 2 / 100f);
        /*Counter*/
        counteritem.draw(betch, pieces3 + "", xtable3 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 14.5f / 100f);
        /*Price*/
        textdeliver.draw(betch, price3 + "", xtable3 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 10f / 100f);

        /*Four table*/
        betch.draw(redtable, xtable4, ytable, widthtable, heighttable);
        /*Bar*/
        betch.draw(countbar, xtable4 + Gdx.graphics.getWidth() * 1.5f / 100f, ytable + Gdx.graphics.getHeight() * 11 / 100f, Gdx.graphics.getWidth() * 8 / 100f, Gdx.graphics.getHeight() * 5 / 100f);
        /*Image*/
        betch.draw(item4, xtable4 + Gdx.graphics.getWidth() * 2.0f / 100f, ytable + Gdx.graphics.getHeight() * 18 / 100f, Gdx.graphics.getWidth() * 7/ 100f, Gdx.graphics.getHeight() * 15 / 100f);
        /*Coin image*/
        betch.draw(coin, xtable4 + Gdx.graphics.getWidth() * 2f / 100f, ytable + Gdx.graphics.getHeight() * 6f / 100f, Gdx.graphics.getWidth() * 2 / 100f, Gdx.graphics.getWidth() * 2 / 100f);
        /*Counter*/
        counteritem.draw(betch, pieces4 + "", xtable4 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 14.5f / 100f);
        /*Price*/
        textdeliver.draw(betch, price4 + "", xtable4 + Gdx.graphics.getWidth() * 5f / 100f, ytable + Gdx.graphics.getHeight() * 10f / 100f);




        if(error) {
            errorfont.draw(betch, errormessage, bigtablex + Gdx.graphics.getWidth() * 5 / 100f, bigtabley + Gdx.graphics.getHeight() * 7 / 100f);
            Timer timer = new Timer();
            Timer.Task task = timer.scheduleTask(new Timer.Task() {
                @Override
                public void run () {
                    error=false;
                }
            }, 3);
        }


    }

    public void disposeitem(){
        FileHandle improvefile = Gdx.files.local("Improve.json");

        String scores = improvefile.readString();
        System.out.println(scores);
        Improves imp = json.fromJson(Improves.class, scores);

        impr.smartfonlevel = imp.smartfonlevel;
        impr.accesoirelevel = imp.accesoirelevel;
        impr.pclevel = imp.pclevel;
        impr.appliencelevel = imp.appliencelevel;
        impr.autolevel = imp.autolevel;

        impr.sellskilllevel = imp.sellskilllevel;
        impr.sellskillcoeficient = imp.sellskillcoeficient;
        impr.storagelevel = imp.storagelevel;
        impr.storecapacity = storecapacity;
        impr.obiavlenialevel = imp.obiavlenialevel;
        impr.webstorelevel = imp.webstorelevel;
        impr.sellpointlevel = imp.sellpointlevel;


        impr.radiolevel = imp.radiolevel;
        impr.smmlevel = imp.smmlevel;
        impr.banerlevel = imp.banerlevel;
        impr.magazineslevel = imp.magazineslevel;
        impr.tvlevel = imp.tvlevel;
        String imprtext= json.toJson(impr);
        improvefile.writeString(imprtext, false);


        redtable.dispose();
        countbar.dispose();
        coin.dispose();

        item1.dispose();
        item2.dispose();
        item3.dispose();
        item4.dispose();


        skin.dispose();
        font.dispose();

        textdeliver.dispose();
        counteritem.dispose();
        atlas.dispose();
        subscratlas.dispose();
        sfont.dispose();

    /* betch .dispose();
     item1 .dispose();
     item2 .dispose();
     item3 .dispose();
     item4 .dispose();
     stage .dispose();
     skin .dispose();
     font .dispose();
     textdeliver .dispose();
     counteritem .dispose();
     sfont .dispose();

     patlas .dispose();
     pagefont .dispose();
     pageatlas .dispose();
     prfont .dispose();
     pratlas .dispose();*/

    }


}
