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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
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
import com.mygdx.game.Pages.DataBase.Items;


public class Progress implements Screen {

    float smartfonx= Gdx.graphics.getWidth()*20/100f;
    float smartfony= Gdx.graphics.getHeight()*65/100f;

    float accesoirex=smartfonx+Gdx.graphics.getWidth()*11/100f;
    float accesoirey=Gdx.graphics.getHeight()*65/100f;

    float pcx=accesoirex+Gdx.graphics.getWidth()*11/100f;
    float pcy=Gdx.graphics.getHeight()*65/100f;

    float appliencex=pcx+Gdx.graphics.getWidth()*11/100f;
    float appliencey=Gdx.graphics.getHeight()*65/100f;

    float autoproductx=appliencex+Gdx.graphics.getWidth()*11/100f;
    float autoproducty=Gdx.graphics.getHeight()*65/100f;

    float skillx=smartfonx;
    float skilly=Gdx.graphics.getHeight()*42/100f;

    float storagex=smartfonx+Gdx.graphics.getWidth()*11/100f;
    float storagey=Gdx.graphics.getHeight()*42/100f;

    float obx=storagex+Gdx.graphics.getWidth()*11/100f;
    float oby=Gdx.graphics.getHeight()*42/100f;
    /*Webstore*/
    float webstorex=obx+Gdx.graphics.getWidth()*11/100f;
    float webstorey=Gdx.graphics.getHeight()*42/100f;
/*Sell Point*/
float spointx=webstorex+Gdx.graphics.getWidth()*11/100f;
float spointy=Gdx.graphics.getHeight()*42/100f;
/*Radio*/
float radiox=smartfonx;
float radioy=Gdx.graphics.getHeight()*19/100f;
/*Social Media*/
float smx=radiox+Gdx.graphics.getWidth()*11/100f;
float smy=Gdx.graphics.getHeight()*19/100f;
/*Baner*/
    float banerx=smx+Gdx.graphics.getWidth()*11/100f;
    float banery=Gdx.graphics.getHeight()*19/100f;
    /*Newspaper*/
    float newspx=banerx+Gdx.graphics.getWidth()*11/100f;
    float newpy=Gdx.graphics.getHeight()*19/100f;
    /*Tv*/
    float tvx=newspx+Gdx.graphics.getWidth()*11/100f;
    float tvy=Gdx.graphics.getHeight()*19/100f;

    byte smartfonelevel=1;
    byte accesoirelev=1;
    byte pclevel=1;
    byte appliencelevel=1;
    byte autoproductlevel=1;

    byte sellesskillevel=1;
    byte sellskillcoeficient;
    byte storagelevel=1;
    byte obiavlenialevel=1;
    byte webstorelevel=1;
    byte salepointlevel=1;

    byte radiolevel=1;
    byte socialmedialevel=1;
    byte baennerlevel=1;
    byte newspaperlevel=1;
    byte tvlevel=1;

    int storecapacity=200;


   private int smartfonfrice=5000;
private int accesoireprice=5000;
private int pcprice=5000;
private int applienceprice=5000;
private int autoproductprice=5000;

int storageprice=15000;
int sellskilprice=500;
int obiavleniaprice=500;
int webstoreprice=5000;
int sellpointprice=50000;

int newspaperprice=2000;
int radioprice=3000;
int socialmediaprice=5000;
int banerprice=7000;
int tvprice=15000;

String _4items;
String sellstr;
String storagestr;
String obstr;
String webstorestr;
String sellpointstr;

    String radiostr;
    String smstr;
    String banerstr;
    String magazinesstr;
    String tvstr;
    String level;
/*For buutom name*/
    String smartfonname;
    String accesoirename;
    String pcname;
    String applicientename;
    String autoname;

    String sellskillstr;
    String storagename;
    String obname;
    String webstorename;
    String sellpointname;

    String radioname;
    String smname;
    String banername;
    String magazinesname;
    String tvname;



    final Launch game;
    Skin skin;
    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;



    ControlBar tb;
Texture coin;
    Texture window;
    Texture table;
    Texture leveltable;

    BitmapFont ifont;
    BitmapFont afont;
    BitmapFont levelfont;
    BitmapFont achievefont;

    TextureAtlas iatlas;
    TextureAtlas aatlas;

    TextButton.TextButtonStyle istyle;
  TextButton.TextButtonStyle astyle;



TextButton smartfon;
TextButton accesoire;
TextButton PC;
TextButton Applience;
TextButton autoproduct;
TextButton skillsell;
TextButton storage;
TextButton obiavleniabutton;
TextButton webstorebutton;
TextButton Salespoint;
TextButton radiobuttom;
TextButton socialmediabutton;
TextButton Bannerbutton;
TextButton Newspapersbutton;
TextButton TVbutton;

Improves impr;
    FileHandle file;
    Improves imprfile;
    public Progress(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
    @Override
    public void show() {

        tb=new ControlBar();
        tb.createbar();

        switch (tb.language){
            case "English":
                _4items="+4 items";
                sellstr="Sales Success";
                storagestr="+700 storage \ncapacity";
                obstr="+100 visitors";
                webstorestr="+500 visitors";
                sellpointstr="+10000 visitors";

                radiostr="";
                smstr="";
                banerstr="";
                magazinesstr="";
                tvstr="";
                level="Level";
                /*For buutom name*/
               smartfonname="Smartfon";
                accesoirename="Accesoire";
                pcname="PC & Notenook";
                applicientename="Appliences";
               autoname="Auto Product";

                sellskillstr="Sell Skill";
                storagename="Storage";
                obname="Ads";
                webstorename="Webstore";
               sellpointname="Point of sale";

                radioname="Radio";
                smname="Social Media";
                 banername="Baner";
                magazinesname="Magazines";
                tvname="TV";
                break;
            case "France":
                _4items="+4 éléments";
                sellstr="Succès des ventes";
                storagestr="+700 capacité \nde stockage";
                obstr="+100 visiteurs";
                webstorestr="+500visiteurs";
                sellpointstr="+10000 visiteurs";

                radiostr="";
                smstr="";
                banerstr="";
                magazinesstr="";
                tvstr="";
                level="Niveau";
                /*Pour le nom du bouton*/
                smartfonname="Smartfon";
                accesoirename="Accesoire";
                pcname="PC & Notenook";
                applicientename="Appareils";
                autoname="Produit automatique";

                sellskillstr="Vendre des compétences";
                storagename="Stockage";
                obname="Annonces";
                webstorename="Boutique en ligne";
                sellpointname="Point de vente";

               radioname="Radio";
                smname="Réseaux sociaux";
                banername="Bannière";
                magazinesname="Magazines";
                tvname="TV";
                break;
            case "Russian":
                _4items="+4 товара";
                sellstr="Успех в продаж";
                storagestr="+700 емкость \nхранилища";
                obstr="+100 посетителей";
                webstorestr="+500 посетителей";
                sellpointstr="+10000 посетителей";

                radiostr="";
                smstr= "";
                banerstr="";
                magazinesstr="";
                tvstr = "";
                level="Уровень";
                /*Для буутного имени*/
                smartfonname="Смартфон";
                accesoirename="Аксессуар";
                pcname="ПК и ноутбук";
                applicientename="Устройства";
                autoname="Авто продукт";

                sellskillstr="Навык в Продаж";
                storagename = "Хранилище";
                obname="Объявления";
                webstorename="Веб-магазин";
                sellpointname="Точка продажу";

                radioname="Радио";
                smname="Социальные сети";
                banername="Банер";
                magazinesname="Журналы";
                tvname="ТВ";
                break;
            case "Spanish":
                _4items="+4 elementos";
                sellstr="Éxito de ventas";
                storagestr="+700 capacidad \nde almacenamiento";
                obstr="+100 visitantes";
                webstorestr="+500 visitantes";
                sellpointstr="+10000 visitantes";

                radiostr="";
                smstr="";
                banerstr="";
                magazinesstr="";
                tvstr="";
                level="Nivel";
                /*Para el nombre del cliente*/
                smartfonname="Smartfon";
                accesoirename="Accesorio";
                pcname="PC y Notenook";
                applicientename="Electrodomésticos";
                autoname="Producto automático";

                sellskillstr="Habilidad de venta";
                storagename="Almacenamiento";
                obname="Anuncios";
                webstorename="Tienda web";
                sellpointname="Punto de venta";

                radioname="Radio";
                smname="Redes Sociales";
                banername="Banner";
                magazinesname="Revistas";
                tvname="TV";
                break;

            case "Germany":
                _4items="+4 Artikel";
                sellstr="Verkaufserfolg";
                storagestr="+700 Speicherkapazität";
                obstr="+100 Besucher";
                webstorestr="+500 Besucher";
                sellpointstr="+10000 Besucher";

                radiostr="";
                smstr="";
                banerstr="";
                magazinesstr="";
                tvstr="";
                level="Level";
                /*Für Buutom-Name*/
                smartfonname="Smartfon";
                accesoirename="Zubehör";
                pcname="PC & Notenook";
                applicientename="Appliences";
                autoname="Autoprodukt";

                sellskillstr="Skill verkaufen";
                storagename="Speicher";
                obname="Anzeigen";
                webstorename="Webstore";
                sellpointname="Kasse";

                radioname="Radio";
                smname="Soziale Medien";
                banername="Baner";
                magazinesname="Zeitschriften";
                tvname="TV";
                break;
            case "Poland":
                _4items="+4 przedmioty";
                sellstr="Sukces sprzedaży";
                storagestr="+700 pojemności\n pamięci";
                obstr="+100 odwiedzających";
                webstorestr="+500 odwiedzających";
                sellpointstr="+10000 odwiedzających";

                radiostr="";
                smstr="";
                banerstr="";
                magazinesstr="";
                tvstr="";
                level="Poziom";
                /*Dla nazwy buta*/
                smartfonname="Smartfon";
                accesoirename="Akcesoria";
                pcname="PC i Notenook";
                applicientename="Urządzenia";
                autoname="Produkt automatyczny";

                sellskillstr="Sprzedaj umiejętność";
                storagename="Przechowywanie";
                obname="Reklamy";
                webstorename="Sklep internetowy";
                sellpointname="Punkt sprzedaży";

                radioname="Radio";
                smname="Media społecznościowe";
                banername="Sztandar";
                magazinesname="Czasopisma";
                tvname="telewizor";
                break;
            case "Ucraine":
                _4items="+4 елементи";
                sellstr="Успіх продажів";
                storagestr="+700 обсягів \nзберігання";
                obstr="+100 відвідувачів";
                webstorestr="+500 відвідувачів";
                sellpointstr="+10000 відвідувачів";

                radiostr="";
                smstr="";
                banerstr="";
                magazinesstr="";
                tvstr="";
                level="Рівень";
                /*Для основного імені*/
                smartfonname="Смартфон";
                accesoirename="Аксесуар";
                pcname="ПК і Notenook";
                applicientename="Програми";
                autoname="Автопродукт";

                sellskillstr="Продати навички";
                storagename="Сховище";
                obname="Оголошення";
                webstorename="Веб-магазин";
                sellpointname="Точка продажу";

                radioname="Радіо";
                smname="Соціальні мережі";
                banername="Банер";
                magazinesname="Журнали";
                tvname="телевізор";
                break;
            case "Italy":
                _4items="+4 elementi";
                sellstr="Vendite riuscite";
                storagestr="+700 capacità \ndi stoccaggio";
                obstr="+100 visitatori";
                webstorestr="+500 visitatori";
                sellpointstr="+10000 visitatori";

                radiostr="";
                smstr="";
                banerstr="";
                magazinesstr="";
                tvstr="";
                level="Livello";
                /*Per nome utente*/
                smartfonname="Smartfon";
                accesoirename="Accessoire";
                pcname="PC e Notenook";
                applicientename="Elettrodomestici";
                autoname="Prodotto automatico";

                sellskillstr="Abilità di vendita";
                storagename="Memoria";
                obname="Annunci";
                webstorename="Webstore";
                sellpointname="Punto vendita";

                radioname="Radio";
                smname="Social Media";
                banername="baner";
                magazinesname="Riviste";
                tvname="TV";
                break;
        }

        betch=new SpriteBatch();

        coin= new Texture("dollar.png");
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
       tb.getbuttons(game, stage);
skin=new Skin();
impr=new Improves();

/*Read JSON File*/
        file = Gdx.files.local("Improve.json");
        String itemparams = file.readString();
         imprfile=json.fromJson(Improves.class, itemparams);
System.out.println("Improve smartfonlevel"+imprfile.smartfonlevel);

        smartfonelevel=imprfile.smartfonlevel;
         accesoirelev=imprfile.accesoirelevel;
         pclevel=imprfile.pclevel;
        appliencelevel=imprfile.appliencelevel;
        autoproductlevel=imprfile.autolevel;

       sellesskillevel=imprfile.sellskilllevel;
        sellskillcoeficient=imprfile.sellskillcoeficient;
         storagelevel=imprfile.storagelevel;
         storecapacity=imprfile.storecapacity;
         obiavlenialevel=imprfile.obiavlenialevel;
        webstorelevel=imprfile.webstorelevel;
         salepointlevel=imprfile.sellpointlevel;

         radiolevel=imprfile.radiolevel;
         socialmedialevel=imprfile.smmlevel;
         baennerlevel=imprfile.banerlevel;
         newspaperlevel=imprfile.magazineslevel;
         tvlevel=imprfile.tvlevel;

        smartfonfrice=5000*smartfonelevel;
         accesoireprice=5000*accesoirelev;
        pcprice=5000*pclevel;
        applienceprice=5000*appliencelevel;
        autoproductprice=5000*autoproductlevel;

         storageprice=15000*storagelevel;
        sellskilprice=500*sellesskillevel;
         obiavleniaprice=200*obiavlenialevel;
        webstoreprice=5000*webstorelevel;
        sellpointprice=50000*sellesskillevel;

       newspaperprice=2000*newspaperlevel;
        radioprice=3000*radiolevel;
       socialmediaprice=5000*socialmedialevel;
        banerprice=7000*baennerlevel;
        tvprice=15000*tvlevel;

        window=new Texture("Windowgray.png");
table=new Texture("magazin_big_table.png");

levelfont=new BitmapFont(Gdx.files.internal("Fonts/progress.fnt"));
levelfont.setColor(Color.WHITE);
//levelfont.getData().setScale(5/2f, 5/2f);

achievefont=new BitmapFont(Gdx.files.internal("Fonts/progress.fnt"));
achievefont.setColor(Color.ORANGE);
//achievefont.getData().setScale(2f, 2f);

        ifont=new BitmapFont(Gdx.files.internal("Fonts/progress.fnt"));
        iatlas=new TextureAtlas(Gdx.files.internal("devui/blue.pack"));
        skin.addRegions(iatlas);
        istyle=new TextButton.TextButtonStyle();
        istyle.font=ifont;
        istyle.fontColor=Color.WHITE;
        istyle.up=skin.getDrawable("bluebutton");
        istyle.unpressedOffsetY=-20;
       // ifont.getData().setScale(2,2);

        afont=new BitmapFont();
        aatlas=new TextureAtlas(Gdx.files.internal("devui/blue.pack"));
        skin.addRegions(iatlas);
        astyle=new TextButton.TextButtonStyle();
        astyle.font=afont;
        astyle.fontColor=Color.WHITE;
        astyle.up=skin.getDrawable("bluebutton");
        afont.getData().setScale(2,2);

smartfon=new TextButton(smartfonname, istyle);
smartfon.setPosition(smartfonx,smartfony);
smartfon.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
smartfon.setScale(5,5);
smartfon.getLabel().setAlignment(Align.top);



accesoire=new TextButton(accesoirename, istyle);
accesoire.setPosition(accesoirex,accesoirey);
accesoire.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
accesoire.setScale(5,5);
accesoire.getLabel().setAlignment(Align.top);



        PC=new TextButton(pcname, istyle);

        PC.setPosition(pcx, pcy);
        PC.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        PC.setScale(5,5);
        PC.getLabel().setAlignment(Align.top);



        Applience=new TextButton(applicientename, istyle);

        Applience.setPosition(appliencex, appliencey);
        Applience.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        Applience.setScale(5,5);
        Applience.getLabel().setAlignment(Align.top);



        autoproduct=new TextButton(autoname, istyle);

        autoproduct.setPosition(autoproductx, autoproducty);
        autoproduct.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        autoproduct.setScale(5,5);
        autoproduct.getLabel().setAlignment(Align.top);



        skillsell=new TextButton(sellskillstr, istyle);

        skillsell.setPosition(skillx,skilly);
        skillsell.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        skillsell.setScale(5,5);
        skillsell.getLabel().setAlignment(Align.top);



        storage=new TextButton(storagename, istyle);

        storage.setPosition(storagex, storagey);
        storage.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        storage.setScale(5,5);
        storage.getLabel().setAlignment(Align.top);



        obiavleniabutton=new TextButton(obname, istyle);

        obiavleniabutton.setPosition(obx, oby);
        obiavleniabutton.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        obiavleniabutton.setScale(5,5);
        obiavleniabutton.getLabel().setAlignment(Align.top);


        webstorebutton=new TextButton(webstorename, istyle);

        webstorebutton.setPosition(webstorex, webstorey);
        webstorebutton.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        webstorebutton.setScale(5,5);
        webstorebutton.getLabel().setAlignment(Align.top);



        Salespoint=new TextButton(sellpointname, istyle);

        Salespoint.setPosition(spointx, spointy);
        Salespoint.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        Salespoint.setScale(5,5);
        Salespoint.getLabel().setAlignment(Align.top);


        radiobuttom=new TextButton(radioname, istyle);

        radiobuttom.setPosition(radiox,radioy);
        radiobuttom.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        radiobuttom.setScale(5,5);
        radiobuttom.getLabel().setAlignment(Align.top);


        socialmediabutton=new TextButton(smname, istyle);

        socialmediabutton.setPosition(smx,smy);
        socialmediabutton.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        socialmediabutton.setScale(5,5);
        socialmediabutton.getLabel().setAlignment(Align.top);


        Bannerbutton=new TextButton(banername, istyle);

        Bannerbutton.setPosition(banerx,banery);
        Bannerbutton.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        Bannerbutton.setScale(5,5);
        Bannerbutton.getLabel().setAlignment(Align.top);



        Newspapersbutton=new TextButton(magazinesname, istyle);

        Newspapersbutton.setPosition(newspx,newpy);
        Newspapersbutton.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        Newspapersbutton.setScale(5,5);
        Newspapersbutton.getLabel().setAlignment(Align.top);


        TVbutton=new TextButton(tvname, istyle);

        TVbutton.setPosition(tvx,tvy);
        TVbutton.setSize(Gdx.graphics.getWidth()*10/100f, Gdx.graphics.getWidth()*10/100f);
        TVbutton.setScale(5,5);
        TVbutton.getLabel().setAlignment(Align.top);



leveltable=new Texture("devui/leveltable1.png");





        stage.addActor(radiobuttom);
        stage.addActor(socialmediabutton);
        stage.addActor(Bannerbutton);
        stage.addActor(Newspapersbutton);
        stage.addActor(TVbutton);


        stage.addActor(skillsell);
        stage.addActor(storage);
        stage.addActor(obiavleniabutton);
        stage.addActor(webstorebutton);
        stage.addActor(Salespoint);


stage.addActor(smartfon);
stage.addActor(accesoire);
stage.addActor(PC);
stage.addActor(Applience);
stage.addActor(autoproduct);





        System.out.println("HelloA"+smartfon);

        smartfon.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
if (smartfonelevel<10 && smartfonfrice<=tb.value) {
    System.out.println("Smartfon" + event);
    tb.value -= smartfonfrice;
    smartfonelevel++;
    smartfonfrice = 5000 * smartfonelevel;
}

            }});
        accesoire.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (accesoirelev<10 && accesoireprice<=tb.value) {
                    tb.value -= accesoireprice;
                    accesoirelev++;
                    accesoireprice = 5000 * accesoirelev;
                }
            }});
        PC.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (pclevel<10 && pcprice<=tb.value) {
                    tb.value -= pcprice;
                    pclevel++;
                    pcprice = 5000 * pclevel;
                }
            }});
        Applience.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (appliencelevel<10 && applienceprice<=tb.value) {
                    tb.value -= applienceprice;
                    appliencelevel++;
                    applienceprice = 5000 * appliencelevel;
                }
            }});

        autoproduct.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (autoproductlevel<10 && autoproductprice<=tb.value) {
                    tb.value -= autoproductprice;
                    autoproductlevel++;
                    autoproductprice = 5000 * autoproductlevel;
                }
            }});


        skillsell.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (sellesskillevel<10 && sellskilprice<=tb.value) {
                    tb.value -= sellskilprice;
                    sellesskillevel++;
                    sellskillcoeficient+=2;
                    sellskilprice = 500 * sellesskillevel;
                }
            }});
        storage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (storagelevel<10 && storageprice<=tb.value) {
                    tb.value -= storageprice;
                    storagelevel++;
                    storecapacity+=700;
                    storageprice = 15000 * storagelevel;
                }
            }});
        obiavleniabutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (obiavlenialevel<10 && obiavleniaprice<=tb.value) {
                    tb.value -= obiavleniaprice;
                    obiavlenialevel++;
                    obiavleniaprice = 200 * obiavlenialevel;
                    tb.watches+=100;
                }
            }});
        webstorebutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (webstorelevel<10 && webstoreprice<=tb.value) {
                    tb.value -= webstoreprice;
                    webstorelevel++;
                    webstoreprice = 5000 * webstorelevel;
                    tb.watches+=500;
                }
            }});
        Salespoint.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (salepointlevel<25 && sellpointprice<=tb.value) {
                    tb.value -= sellpointprice;
                    salepointlevel++;
                    sellpointprice = 50000 ;
                    tb.watches+=10000;
                }
            }});


        radiobuttom.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (radiolevel<10 && radioprice<=tb.value) {
                    tb.value -= radioprice;
                    radiolevel++;
                    radioprice = 3000 * radiolevel;
                }
            }});
        socialmediabutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (socialmedialevel<10 && socialmediaprice<=tb.value) {
                    tb.value -= socialmediaprice;
                    socialmedialevel++;
                    socialmediaprice = 5000 * socialmedialevel;
                }
            }});
        Bannerbutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (baennerlevel<10 && banerprice<=tb.value) {
                    tb.value -= banerprice;
                    baennerlevel++;
                    banerprice = 7000 * baennerlevel;
                }
            }});
        Newspapersbutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (newspaperlevel<10 && newspaperprice<=tb.value) {
                    tb.value -= newspaperprice;
                    newspaperlevel++;
                    newspaperprice = 2000 * newspaperlevel;
                }
            }});
        TVbutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (tvlevel<10 && tvprice<=tb.value) {
                    tb.value -= tvprice;
                    tvlevel++;
                    tvprice = 14000 * tvlevel;
                }
            }});



        //stage.setKeyboardFocus(bad);



    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(255f/255f, 45f/255f, 16f/255f, 1f);
        tb.getBar();
        tb.setPicture();
        camera.update();
        betch.setProjectionMatrix(camera.combined);
        betch.begin();

        //betch.draw(window, Gdx.graphics.getWidth()*15/100f, Gdx.graphics.getHeight()*15/100f,Gdx.graphics.getWidth()*72/100f,Gdx.graphics.getHeight()*72/100f);
        betch.draw(table, Gdx.graphics.getWidth()*17/100f, Gdx.graphics.getHeight()*15/100f,Gdx.graphics.getWidth()*60/100f,Gdx.graphics.getHeight()*72/100f);

       // System.out.println("Improve storage"+ sellskillcoeficient);


     /*Smartfon*/

      levelfont.draw(betch,level+" "+smartfonelevel, smartfonx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*74/100f);

      /*Accesoire*/
      levelfont.draw(betch, level+" "+accesoirelev, accesoirex+Gdx.graphics.getWidth()*2/100f, Gdx.graphics.getHeight()*74/100f);
       levelfont.draw(betch, level+" "+pclevel, pcx+Gdx.graphics.getWidth()*5/2/100f,Gdx.graphics.getHeight()*74/100f);
       levelfont.draw(betch, level+" "+appliencelevel, appliencex+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*74/100f);
       levelfont.draw(betch, level+" "+autoproductlevel, autoproductx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*74/100f);

       levelfont.draw(betch, level+" "+sellesskillevel, skillx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*50/100f);
        levelfont.draw(betch, level+" "+storagelevel, storagex+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*50/100f);
        levelfont.draw(betch, level+" "+obiavlenialevel, obx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*50/100f);
        levelfont.draw(betch, level+" "+webstorelevel, webstorex+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*50/100f);
        levelfont.draw(betch, "Quantity "+salepointlevel, spointx+Gdx.graphics.getWidth()*3/2/100f, Gdx.graphics.getHeight()*50/100f);

        levelfont.draw(betch, level+" "+radiolevel, radiox+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*27/100f);
        levelfont.draw(betch, level+" "+socialmedialevel, smx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*27/100f);
        levelfont.draw(betch, level+" "+baennerlevel, banerx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*27/100f);
        levelfont.draw(betch, level+" "+newspaperlevel, newspx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*27/100f);
        levelfont.draw(betch, level+" "+tvlevel, tvx+Gdx.graphics.getWidth()*5/2/100f, Gdx.graphics.getHeight()*27/100f);
/*For price*/
        levelfont.draw(betch, ""+smartfonfrice, smartfonx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*69/100f);
        levelfont.draw(betch, ""+accesoireprice, accesoirex+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*69/100f);
        levelfont.draw(betch, ""+pcprice, pcx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*69/100f);
        levelfont.draw(betch, ""+applienceprice, appliencex+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*69/100f);
        levelfont.draw(betch, ""+autoproductprice, autoproductx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*69/100f);

        levelfont.draw(betch, ""+sellskilprice, skillx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*46/100f);
        levelfont.draw(betch, ""+storageprice, storagex+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*46/100f);
        levelfont.draw(betch, ""+obiavleniaprice, obx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*46/100f);
        levelfont.draw(betch, ""+webstoreprice, webstorex+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*46/100f);
        levelfont.draw(betch, ""+sellpointprice, spointx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*46/100f);

        levelfont.draw(betch, ""+radioprice, radiox+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*23/100f);
        levelfont.draw(betch, ""+socialmediaprice, smx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*23/100f);
        levelfont.draw(betch, ""+banerprice, banerx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*23/100f);
        levelfont.draw(betch, ""+newspaperprice, newspx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*23/100f);
        levelfont.draw(betch, ""+tvprice, tvx+Gdx.graphics.getWidth()*3/100f,Gdx.graphics.getHeight()*23/100f);



        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        betch.draw(coin, smartfonx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*66/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, accesoirex+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*66/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, pcx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*66/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, appliencex+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*66/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, autoproductx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*66/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);

        betch.draw(coin, skillx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*43/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, storagex+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*43/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, obx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*43/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, webstorex+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*43/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, spointx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*43/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);

        betch.draw(coin, radiox+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*20/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, smx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*20/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, banerx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*20/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, newspx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*20/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);
        betch.draw(coin, tvx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*20/100f,Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getWidth()*3/2/100f);

        /*Achiavefont*/
        achievefont.draw(betch, _4items, smartfonx+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*79/100f);
        achievefont.draw(betch, _4items, accesoirex+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*79/100f);
        achievefont.draw(betch, _4items, pcx+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*79/100f);
        achievefont.draw(betch, _4items, appliencex+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*79/100f);
        achievefont.draw(betch, _4items, autoproductx+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*79/100f);

        achievefont.draw(betch, sellstr+"\n"+sellskillcoeficient*100/24+"%", smartfonx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*56/100f);
        achievefont.draw(betch, storagestr, accesoirex+Gdx.graphics.getWidth()*1/2/100f,Gdx.graphics.getHeight()*56/100f);
        achievefont.draw(betch, obstr, pcx+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*56/100f);
        achievefont.draw(betch, webstorestr, appliencex+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*56/100f);
        achievefont.draw(betch, sellpointstr, autoproductx+Gdx.graphics.getWidth()*0.5f/100f,Gdx.graphics.getHeight()*56/100f);

        achievefont.draw(betch, "", smartfonx+Gdx.graphics.getWidth()*1/100f,Gdx.graphics.getHeight()*33/100f);
        achievefont.draw(betch, "", accesoirex+Gdx.graphics.getWidth()*1/2/100f,Gdx.graphics.getHeight()*33/100f);
        achievefont.draw(betch, "", pcx+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*33/100f);
        achievefont.draw(betch, "", appliencex+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*33/100f);
        achievefont.draw(betch, "", autoproductx+Gdx.graphics.getWidth()*3/2/100f,Gdx.graphics.getHeight()*33/100f);


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
        impr.smartfonlevel=smartfonelevel;
        impr.accesoirelevel=accesoirelev;
        impr.pclevel=pclevel;
        impr.appliencelevel=appliencelevel;
        impr.autolevel=autoproductlevel;

        impr.sellskilllevel=sellesskillevel;
        impr.sellskillcoeficient=sellskillcoeficient;
        impr.storagelevel=storagelevel;
        impr.storecapacity=storecapacity;
        impr.obiavlenialevel=obiavlenialevel;
        impr.webstorelevel=webstorelevel;
        impr.sellpointlevel=salepointlevel;

        impr.radiolevel=radiolevel;
        impr.smmlevel=socialmedialevel;
        impr.banerlevel=baennerlevel;
        impr.magazineslevel=newspaperlevel;
        impr.tvlevel=tvlevel;
        String imprtext= json.toJson(impr);
       file.writeString(imprtext, false);
        tb.bardispose();

        skin.dispose();
        betch.dispose();
        stage.dispose();
        coin.dispose();
        window.dispose();
        table.dispose();
        leveltable.dispose();

        ifont.dispose();
        afont.dispose();
        levelfont.dispose();
        achievefont.dispose();


    }

    @Override
    public void dispose() {
        impr.smartfonlevel=smartfonelevel;
        impr.accesoirelevel=accesoirelev;
        impr.pclevel=pclevel;
        impr.appliencelevel=appliencelevel;
        impr.autolevel=autoproductlevel;

        impr.sellskilllevel=sellesskillevel;
        impr.sellskillcoeficient=sellskillcoeficient;
        impr.storagelevel=storagelevel;
        impr.storecapacity=storecapacity;
        impr.obiavlenialevel=obiavlenialevel;
        impr.webstorelevel=webstorelevel;
        impr.sellpointlevel=salepointlevel;

        impr.radiolevel=radiolevel;
        impr.smmlevel=socialmedialevel;
        impr.banerlevel=baennerlevel;
        impr.magazineslevel=newspaperlevel;
        impr.tvlevel=tvlevel;
        String imprtext= json.toJson(impr);
        file.writeString(imprtext, false);
        tb.bardispose();

        skin.dispose();
        betch.dispose();
        stage.dispose();
        coin.dispose();
        window.dispose();
        table.dispose();
        leveltable.dispose();

        ifont.dispose();
        afont.dispose();
        levelfont.dispose();
        achievefont.dispose();

    }
}
