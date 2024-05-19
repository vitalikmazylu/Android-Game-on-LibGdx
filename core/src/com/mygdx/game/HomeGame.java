package com.mygdx.game;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
import com.mygdx.game.Pages.Bank;
import com.mygdx.game.Pages.DataBase.Items;

import java.awt.Window;

import javax.swing.text.View;

public class HomeGame implements Screen {

    //public Texture img;
OrthographicCamera camera;

    String jsonname[]={"smartfonitem_1_1.json","smartfonitem_1_2.json","smartfonitem_1_3.json","smartfonitem_1_4.json","smartfonitem_1_4.json","smartfonitem_1_5.json","smartfonitem_2_1.json","smartfonitem_2_2.json","smartfonitem_2_3.json","smartfonitem_2_4.json","smartfonitem_2_5.json","smartfonitem_3_1.json","smartfonitem_3_2.json","smartfonitem_3_3.json","smartfonitem_3_4.json","smartfonitem_3_5.json","smartfonitem_4_1.json","smartfonitem_4_2.json","smartfonitem_4_3.json","smartfonitem_4_4.json","smartfonitem_4_5.json"};
    FileHandle file;
    int money;
    int visitors;
    int place=200;
    int productquantity;
    int capital;
    int rating;//Capital*Visitors
int toprating=1000000000;
    String moneystring;
    String visitorsstring;
    String placestring;
    String productstring;
    String capitalstring;
    String title;

    BitmapFont paramsfont;
    BitmapFont placefont;
    BitmapFont titlefont;

    float titlex;
    float barpercent=4.3f;
    ControlBar tb;
    Stage stage;
final Launch launches;
    SpriteBatch batch;
    ShapeRenderer shape;



    public HomeGame(final Launch launch){
        this.launches=launch;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }


    @Override
    public void show () {
        batch=new SpriteBatch();
        shape=new ShapeRenderer();

        tb=new ControlBar();
       tb.createbar();
       money= tb.value;
       visitors= tb.watches;


       switch (tb.language) {
           case "English":
               moneystring="Money";
               visitorsstring="Visitors per day";
               placestring="Your place";
               productstring="Products Quantity";
               capitalstring="Capitalization";
               title="Rating of Webstore";
               titlex=Gdx.graphics.getWidth()*28/100f;
               break;

           case "France":
               moneystring="Argent";
               visitorsstring="Visiteurs par jour";
               placestring="Votre lieu";
               productstring="Quantité de produits";
               capitalstring="Majuscule";
               title="Évaluation de la boutique en ligne";
               titlex=Gdx.graphics.getWidth()*13/100f;
               break;
           case "Russian":
               moneystring="Деньги";
               visitorsstring="Посетители в день";
               placestring="Ваше место";
               productstring="Количество товаров";
               capitalstring="Капитал";
               title="Рейтинг интернет-магазина";
               titlex=Gdx.graphics.getWidth()*17/100f;
               break;
           case "Spanish":
               moneystring="Dinero";
               visitorsstring="Visitantes por día";
               placestring="Tu lugar";
               productstring="Cantidad de productos";
               capitalstring="Capitalización";
               title="Valoración de la tienda web";
               titlex=Gdx.graphics.getWidth()*20/100f;
               break;
           case "Germany":
               moneystring="Geld";
               visitorsstring="Besucher pro Tag";
               placestring="Ihr Platz";
               productstring="Produktmenge";
               capitalstring="Großschreibung";
               title="Bewertung des Webshops";
               titlex=Gdx.graphics.getWidth()*20/100f;
               break;
           case "Poland":
               moneystring="Pieniądze";
               visitorsstring="Odwiedzający dziennie";
               placestring="Twoje miejsce";
               productstring="Ilość produktów";
               capitalstring="Wielkie litery";
               title="Ocena sklepu internetowego";
               titlex=Gdx.graphics.getWidth()*20/100f;
               break;
           case "Ucraine":
               moneystring="Гроші";
               visitorsstring="Відвідувачів за день";
               placestring="Ваше місце";
               productstring="Кількість продуктів";
               capitalstring="Введення великих літер";
               title="Рейтинг інтернет-магазину";
               titlex=Gdx.graphics.getWidth()*19/100f;
               break;
           case "Italy":
               moneystring="Denaro";
               visitorsstring="Visitatori al giorno";
               placestring="Il tuo posto";
               productstring="Quantità prodotti";
               capitalstring="Maiuscole";
               title="Valutazione del Webstore";
               titlex=Gdx.graphics.getWidth()*20/100f;
               break;
       }

           for(int j=0;j<=jsonname.length;j++) {
               try {
                   file = Gdx.files.local(jsonname[j]);
               }catch (RuntimeException a){
                   System.out.println("Error file");
                   a.printStackTrace();
               }

               if (file.exists()){
                   System.out.println("This json file exists");
                   String scores = file.readString();
                   System.out.println("File read"+scores);
                   Items itms=json.fromJson(Items.class, scores);
                   if (itms.pieces>=1){
                       System.out.println("Item has more than 1 pieces");
                       System.out.println("Time"+itms.timedeliever);
                       /*if(tb.timesecond>=itms.timedeliever) {*/
                       capital+=itms.value*itms.pieces;
                       productquantity+=itms.pieces;


                   }else{

                   }
               }else{

               }

               try {
                   Thread.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

rating=capital*visitors;

if (rating>toprating) {
    place = 1;
    System.out.println("Place" + place);
}else{
    place-=rating/(toprating/200);
}

       paramsfont=new BitmapFont(Gdx.files.internal("Fonts/paramfont.fnt"));
paramsfont.getData().setScale(1.5f, 1.5f);
paramsfont.setColor(Color.WHITE);

       placefont=new BitmapFont(Gdx.files.internal("Fonts/placefont.fnt"));
        placefont.getData().setScale(1.5f, 1.5f);
        placefont.setColor(Color.WHITE);

      titlefont=new BitmapFont(Gdx.files.internal("Fonts/titlefont.fnt"));
        titlefont.getData().setScale(2, 2);
       titlefont.setColor(Color.WHITE);

        System.out.println("Width device"+Gdx.graphics.getWidth());
        System.out.println("Height device"+Gdx.graphics.getHeight());
        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

       tb.getbuttons(launches,stage);

        initialize(new Bank(launches), false);
        //stage.setKeyboardFocus(bad);


    }

    private void initialize(Bank bank, boolean b) {
    }


    @Override
    public void render (float delta) {
       //super.render();

		ScreenUtils.clear(1, 0f, 0f, 1f);
		//tb.time=time;

        tb.getBar();
        tb.setPicture();

       stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
batch.begin();
titlefont.draw(batch, title, titlex, Gdx.graphics.getHeight()*82/100f);
placefont.draw(batch, placestring+" "+place+"/200", Gdx.graphics.getWidth()*36/100f, Gdx.graphics.getHeight()*65/100f);

paramsfont.draw(batch, moneystring+": "+money, Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*45/100f);
paramsfont.draw(batch, productstring+": "+productquantity, Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*35/100f);

paramsfont.draw(batch,visitorsstring+": "+visitors,Gdx.graphics.getWidth()*55/100f, Gdx.graphics.getHeight()*45/100f);
paramsfont.draw(batch, capitalstring+": "+capital, Gdx.graphics.getWidth()*55/100f, Gdx.graphics.getHeight()*35/100f);


batch.end();
        //shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(Color.YELLOW);
        shape.line(Gdx.graphics.getWidth()*25/100f, Gdx.graphics.getHeight()*55/100f, Gdx.graphics.getWidth()*76/100f, Gdx.graphics.getHeight()*55/100f);
        shape.end();
        Gdx.gl.glLineWidth(15);



        //tb.bardispose();



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        System.out.println("HomeGame pause");
    }

    @Override
    public void resume() {
        System.out.println("HomeGame resume");
    }

    @Override
    public void hide() {
        stage.dispose();
        paramsfont.dispose();
        placefont.dispose();
        titlefont.dispose();
        batch.dispose();
        tb.bardispose();
       // launches.tb.bardispose();
    }

    @Override
    public void dispose () {

        stage.dispose();
       paramsfont.dispose();
       placefont.dispose();
        titlefont.dispose();
batch.dispose();
        tb.bardispose();
       launches.tb.bardispose();


    }



}
