package com.mygdx.game;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Buttons.Bankbutton;
import com.mygdx.game.Buttons.Homebutton;
import com.mygdx.game.Buttons.Magazinebutton;
import com.mygdx.game.Buttons.Marketingbutton;
import com.mygdx.game.Buttons.Orderbutton;
import com.mygdx.game.Buttons.Pausebutton;
import com.mygdx.game.Buttons.Progresbutton;
import com.mygdx.game.Buttons.Statisticbutton;
import com.mygdx.game.Buttons.Storagebutton;
import com.mygdx.game.Pages.DataBase.Example;
import com.mygdx.game.Pages.DataBase.Language;
import com.mygdx.game.Pages.DataBase.Market;

public class ControlBar  {
public String language;
    public int time=0/*exampl.time*/;
    public int ordertime;
    public int value= 0/*exampl.price*/;
    public int percentincome;
    int markettime;
    int marketview;
   public int timesecond;

    FileHandle file = Gdx.files.local("scores.json");
    FileHandle mfile;
    FileHandle lfile;


    int x=0;
    int y = Gdx.graphics.getHeight()*87/100;
    float width=Gdx.graphics.getWidth();
    float height=Gdx.graphics.getHeight()*15/100f;

    int ybottom=0;
  float heightbottom=Gdx.graphics.getHeight()*15/100f;

    String data;

    private int seconds=0;

   public int watches;
    String see;

    String sum;

public void value(){
    value++;

}


/*Clases*/

SpriteBatch batch=new SpriteBatch();
    ShapeRenderer shape=new ShapeRenderer();

    Stage stage;
    Launch launches;
HomeGame homes;

  /*Images*/
    Texture coin=new Texture("money.png");
    Texture calendar=new Texture("clock.png");
    Texture eye=new Texture("visitors.png");
    Texture home=new Texture("home.png");
    Texture magazine=new Texture("packages.png");
    Texture storage=new Texture("boxes.png");
    Texture bank=new Texture("plusbuttom.png");
    Texture develop=new Texture("profits.png");
    Texture order=new Texture("shopping-list.png");
    Texture statistic=new Texture("statistic.png");
    Texture marketing=new Texture("megaphone.png");
    Texture pause=new Texture("pause.png");
    Texture redpoint=new Texture("redpoint.png");

    /*Text*/
    BitmapFont font=new BitmapFont();
BitmapFont view=new BitmapFont();
BitmapFont money=new BitmapFont();

public void getbuttons(Launch launches, Stage st){
    /*Home*/
    Homebutton homeb=new Homebutton(launches);
    homeb.setPosition(Gdx.graphics.getWidth()*17/100f, Gdx.graphics.getHeight()*3/100f);
    /*Magazine*/
    Magazinebutton magaz=new Magazinebutton(launches);
    magaz.setPosition(Gdx.graphics.getWidth()*27/100f, Gdx.graphics.getHeight()*3/100f);
    /*Storage*/
    Storagebutton storagebutton=new Storagebutton(launches);
    storagebutton.setPosition(Gdx.graphics.getWidth()*37/100f, Gdx.graphics.getHeight()*3/100f);
    /*Bank*/
    Bankbutton bank=new Bankbutton(launches);
    bank.setPosition(Gdx.graphics.getWidth()*90/100f, Gdx.graphics.getHeight()*91/100f);
    /*Progres*/
    Progresbutton progres=new Progresbutton(launches);
    progres.setPosition(Gdx.graphics.getWidth()*47/100f, Gdx.graphics.getHeight()*3/100f);
    /*Orders*/
    Orderbutton order=new Orderbutton(launches);
    order.setColor(Color.BLACK);
    order.setPosition(Gdx.graphics.getWidth()*57/100f, Gdx.graphics.getHeight()*3/100f);
    /*Statistica*/
    /*Statisticbutton statistica=new Statisticbutton(launches);
    statistica.setPosition(Gdx.graphics.getWidth()*68/100f, Gdx.graphics.getHeight()*3/100f);*/
    /*Marketing*/
    Marketingbutton marketing=new Marketingbutton(launches);
    marketing.setPosition(Gdx.graphics.getWidth()*67/100f, Gdx.graphics.getHeight()*3/100f);
    /*Pause*/
    Pausebutton pause=new Pausebutton(launches);
    pause.setPosition(Gdx.graphics.getWidth()*78/100f, Gdx.graphics.getHeight()*3/100f);

    st.addActor(homeb);
    st.addActor(magaz);
    st.addActor(storagebutton);
    st.addActor(bank);
    st.addActor(progres);

        st.addActor(order);
    //st.addActor(statistica);
    st.addActor(marketing);
    st.addActor(pause);

}

public void createbar(){
    System.out.println("Scores  "+file.exists());
    if(file.exists()) {
        String scores = file.readString();
        Example exampl = json.fromJson(Example.class, scores);

        time = exampl.time;
        seconds=exampl.second;
        ordertime=exampl.ordertime;
        value = exampl.price;
        watches=exampl.watches;
        percentincome= exampl.salepercent;
        mfile = Gdx.files.local("marketing.json");
        if(mfile.exists()) {
            String mark = mfile.readString();
            Market mk = json.fromJson(Market.class, mark);
            markettime = mk.time;
            marketview = mk.viewes;
            System.out.println("Markettime " + markettime + "Market view" + marketview);
        }
        /*For read language*/
        lfile=Gdx.files.local("language.json");
        String lang=lfile.readString();
        Language lng=json.fromJson(Language.class, lang);
        language= lng.lang;
    }


}
    public void getBar(){

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.BLACK);
        shape.rect(x,y, width,height);

        shape.setColor(Color.BLUE);
        shape.rect(x,ybottom, width,heightbottom);
        shape.end();

    }
    public void setPicture(){



      /*  stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();*/
float fontsize=Gdx.graphics.getHeight()*7/2/1000f;
float imgsize=Gdx.graphics.getHeight()*5/100f;
        font.setColor(Color.WHITE);
        font.getData().setScale(fontsize, fontsize);
        view.setColor(Color.WHITE);
        view.getData().setScale(fontsize, fontsize);
        money.setColor(Color.WHITE);
        money.getData().setScale(fontsize, fontsize);
        batch.begin();
       // batch.draw(img, 150, 150);
        /*Time*/
        batch.draw(calendar,50,Gdx.graphics.getHeight()*95.5f/100f-imgsize,imgsize,imgsize);
        font.draw(batch,data.valueOf(time),200,Gdx.graphics.getHeight()*95/100f);
/*View*/
        batch.draw(eye,Gdx.graphics.getWidth()*60/100f,Gdx.graphics.getHeight()*95.5f/100f-imgsize,imgsize,imgsize);
view.draw(batch, see.valueOf(watches), Gdx.graphics.getWidth()*64/100f, Gdx.graphics.getHeight()*95/100f);
/*Money*/
        batch.draw(coin,Gdx.graphics.getWidth()*76/100f,Gdx.graphics.getHeight()*95.5f/100f-imgsize,imgsize,imgsize);
        money.draw(batch, sum.valueOf(value), Gdx.graphics.getWidth()*80/100f,Gdx.graphics.getHeight()*95/100f);



        //System.out.println("Язык"+ordertime);
seconds++;
        if (time % 4 == 0 && seconds==0) {
            System.out.println("Reklama");

        }

if(seconds>=50f*60){
    time++;
    seconds=0;
}
if(time>ordertime){
    batch.draw(redpoint, Gdx.graphics.getWidth()*62/100f,Gdx.graphics.getHeight()*11/100f,15,15);
}

        batch.end();
//System.out.println("Markettime "+markettime+"Market view"+marketview);
        if(markettime==time && seconds==0){
            watches-=marketview;
            mfile.delete();
        }
        //stage.setKeyboardFocus(bad);



    }
public void bardispose(){
    Example ex=new Example();
    ex.time=time;
    ex.second=seconds;
    ex.ordertime=ordertime;
    ex.price=value;
    ex.salepercent=percentincome;
    ex.watches=watches;
    String text = json.toJson(ex);

    file.writeString(text, false);
    System.out.println("Text"+text);


        coin.dispose();
        batch.dispose();
        font.dispose();
        calendar.dispose();
        eye.dispose();
        view.dispose();
        money.dispose();
        home.dispose();
        magazine.dispose();
        storage.dispose();
        bank.dispose();
        develop.dispose();
        order.dispose();
        statistic.dispose();
        marketing.dispose();
        pause.dispose();
shape.dispose();
   // stage.dispose();
}



}
