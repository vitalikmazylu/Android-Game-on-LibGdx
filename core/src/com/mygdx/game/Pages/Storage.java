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
import com.mygdx.game.Pages.DataBase.Items;

import java.util.ArrayList;

public class Storage implements Screen {
    int posx;
    int x;

    int percent;
byte pages=1;
    int total;
    int pagex;
    int px;
    int pageitem=0;
    int maxpage=1;
    byte pcitems=4;
    /*Gdx.graphics.getWidth()*35/100f, Gdx.graphics.getHeight()*75/100f*/
    float percx=Gdx.graphics.getWidth()*45/100f;
    float percy=Gdx.graphics.getHeight()*75/100f;
    String jsonname[]={"smartfonitem_1_1.json","smartfonitem_1_2.json","smartfonitem_1_3.json","smartfonitem_1_4.json","smartfonitem_1_4.json","smartfonitem_1_5.json","smartfonitem_2_1.json","smartfonitem_2_2.json","smartfonitem_2_3.json","smartfonitem_2_4.json","smartfonitem_2_5.json","smartfonitem_3_1.json","smartfonitem_3_2.json","smartfonitem_3_3.json","smartfonitem_3_4.json","smartfonitem_3_5.json","smartfonitem_4_1.json","smartfonitem_4_2.json","smartfonitem_4_3.json","smartfonitem_4_4.json","smartfonitem_4_5.json"};
String cheap;
    String good;
    String expensive;
    String tooexpensive;
    String income;

    ArrayList <Integer> pclist;
    ArrayList <Integer> incomelist;
    ArrayList <String> photolist;
    final Launch game;
    Skin skin;
    OrthographicCamera camera;
    SpriteBatch betch;
    Stage stage;
    Texture coin;
    Texture window;
    Texture table;
    Texture redtable;
    Texture photo1;
    Texture photo2;
    Texture photo3;
    Texture photo4;
    Texture percenttable;

    BitmapFont incomefont;
    BitmapFont pfont;
    BitmapFont pagefont;
    BitmapFont percnumber;
    BitmapFont bfont;
BitmapFont pcfont;
BitmapFont moneyfont;

BitmapFont curentpagefont;

    TextureAtlas patlas;
    TextureAtlas batlas;
    TextureAtlas pageatlas;


    TextButton.TextButtonStyle pstyle;
    TextButton.TextButtonStyle bstyle;
    TextButton.TextButtonStyle pagestyle;

    TextButton percplus;
    TextButton percminus;
    TextButton sell1;
    TextButton sell2;
    TextButton sell3;
    TextButton sell4;

    TextButton page;
    TextButton pageminus;

    TextButton cost;
    ControlBar tb;
    FileHandle file;

    String image1;
    String image2;
    String image3;
    String image4;

    public Storage(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
    @Override
    public void show() {

        tb=new ControlBar();
        tb.createbar();
        percent= tb.percentincome;
        betch=new SpriteBatch();
        skin=new Skin();

        switch (tb.language){
            case "English":
              cheap="Cheap";
              good="Good";
              expensive="Expensive";
              tooexpensive="Too Expensive";
              income="Income";

                break;
            case "France":
                cheap="Bon marché";
                good="Bien";
                expensive="Chere";
                tooexpensive="Trop cher";
                income="Revenu";
                break;
            case "Russian":
                cheap="Дешевый";
                good="Хорошo";
                expensive="Дорого";
                tooexpensive="Слишком дорого";
                income="Доход";
                break;
            case "Spanish":
                cheap="Barato";
                good="Bueno";
                expensive="Caro";
                tooexpensive="Muy caro";
                income="Ingreso";
                break;
            case "Germany":
                cheap="Billig";
                good="Gut";
                expensive="Teuer";
                tooexpensive="Zu teuer";
                income="Einkommen";
                ;break;
            case "Poland":
                cheap="Tani";
                good="Dobrze";
                expensive="Kosztowny";
                tooexpensive="Za drogie";
                income="Dochód";
                ;break;
            case "Ucraine":
                cheap="Дешевo";
                good="Добре";
                expensive="Дорого";
                tooexpensive="Занадто Дорого";
                income="Дохід";
                break;
            case "Italy":
                cheap="A buon mercato";
                good="Bene";
                expensive="Caro";
                tooexpensive="Troppo caro";
                income="Reddito";
                break;
        }

        window=new Texture("storageitems/bluetable.png");
        coin=new Texture("dollar.png");
        table=new Texture("magazin_big_table.png");
        redtable=new Texture("Store/redtable.png");

        percenttable=new Texture("storageitems/percenttable.png");



        incomefont=new BitmapFont(Gdx.files.internal("Fonts/progress.fnt"));

        incomefont.getData().setScale(2,2);
percnumber=new BitmapFont();
percnumber.setColor(Color.BLACK);
percnumber.getData().setScale(3,3);

pcfont=new BitmapFont();
pcfont.setColor(Color.WHITE);
pcfont.getData().setScale(3,3);

moneyfont=new BitmapFont();
moneyfont.setColor(Color.WHITE);
moneyfont.getData().setScale(5/2f,5/2f);

        ScreenViewport viewport=new ScreenViewport();
        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
       tb.getbuttons(game, stage);


        pfont=new BitmapFont(Gdx.files.internal("Fonts/kategoria.fnt"));
        patlas=new TextureAtlas(Gdx.files.internal("Store/textbutton.pack"));
        skin.addRegions(patlas);
        pstyle=new TextButton.TextButtonStyle();
        pstyle.font=pfont;
        pstyle.fontColor=Color.WHITE;
        pstyle.up=skin.getDrawable("yellowbutton");
       // pstyle.down=skin.getDrawable("minusplusdark");
        pfont.getData().setScale(2,2);
/*For items*/
        pclist=new ArrayList<Integer>();
        incomelist=new ArrayList<Integer>();
        photolist=new ArrayList<String>();



        for(int j=0;j<=jsonname.length;j++) {
            try {
               file = Gdx.files.local(jsonname[j]);
            }catch (RuntimeException a){
                System.out.println("Error file");
               a.printStackTrace();
            }
           // FileHandle file = Gdx.files.local(jsonname[j]);

            if (file.exists()){
                System.out.println("This json file exists");
                String scores = file.readString();
                System.out.println("File read"+scores);
                Items itms=json.fromJson(Items.class, scores);
                if (itms.pieces>=1){
                    System.out.println("Item has more than 1 pieces");
                    System.out.println("Time"+itms.timedeliever);
                    /*if(tb.timesecond>=itms.timedeliever) {*/
                        pclist.add(itms.pieces);
                        incomelist.add(itms.value);
                        photolist.add(itms.imgname);
                        System.out.println("Pieceslist" + pclist);
                        System.out.println("Pricelist" + incomelist);
                        System.out.println("Photolist" + photolist);
                    /*}*/
                }else{

                }
            }else{
                System.out.println("This json file not exists");
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        switch (pclist.size()){
            case 0:pcitems=0;break;
            case 1:pcitems=1;break;
            case 2: pcitems=2;break;
            case 3: pcitems=3;break;
            case 4:pcitems=4;break;
            default: pcitems=4;
        }

getitem(pageitem);



bfont=new BitmapFont();
batlas=new TextureAtlas(Gdx.files.internal("magazinui/pricebutton.pack"));
skin.addRegions(batlas);
        bstyle=new TextButton.TextButtonStyle();
        bstyle.font=bfont;
        bstyle.fontColor=Color.WHITE;
        bstyle.up=skin.getDrawable("pricebuttonup");
        bstyle.checked=skin.getDrawable("pricebuttondown");
        bfont.getData().setScale(2,2);

pagefont=new BitmapFont(Gdx.files.internal("Fonts/kategoria.fnt"));
pageatlas=new TextureAtlas(Gdx.files.internal("Store/textbutton.pack"));
skin.addRegions(pageatlas);
        pagestyle=new TextButton.TextButtonStyle();
        pagestyle.font=pagefont;
        pagestyle.fontColor=Color.WHITE;
        pagestyle.up=skin.getDrawable("yellowbutton");
        pagefont.getData().setScale(3,3);

total=25;


            page=new TextButton("+",pagestyle);
            page.setPosition(Gdx.graphics.getWidth()*70/100f, Gdx.graphics.getHeight()*25/100f);
            page.setSize(Gdx.graphics.getWidth()*4/100f,Gdx.graphics.getHeight()*5/100f);

            pageminus=new TextButton("-", pagestyle);
        pageminus.setPosition(Gdx.graphics.getWidth()*60/100f, Gdx.graphics.getHeight()*25/100f);
        pageminus.setSize(Gdx.graphics.getWidth()*4/100f,Gdx.graphics.getHeight()*5/100f);

curentpagefont=new BitmapFont();
curentpagefont.setColor(Color.BLACK);
curentpagefont.getData().setScale(3,3);

        /*Gdx.graphics.getWidth()*35/100f, Gdx.graphics.getHeight()*75/100f*/
        percplus=new TextButton("+", pstyle);
        percplus.setPosition(percx+Gdx.graphics.getWidth()*11/100f, percy);
        percplus.setSize(Gdx.graphics.getHeight()*5/100f,Gdx.graphics.getHeight()*5/100f);
        percminus=new TextButton("-", pstyle);
        percminus.setPosition(percx, percy);

        percminus.setSize(Gdx.graphics.getHeight()*5/100f,Gdx.graphics.getHeight()*5/100f);
cost=new TextButton("Good",pstyle);
        if (percent < 10) {
            cost.setColor(Color.GREEN);
            cost.setText(cheap);
        }
        if (percent > 10 && percent < 45) {
            cost.setColor(Color.YELLOW);
            cost.setText(good);
        }
        if (percent > 45 && percent < 120) {
            cost.setColor(Color.ORANGE);
            cost.setText(expensive);
        }
        if (percent > 120) {
            cost.setColor(Color.RED);
            cost.setText(tooexpensive);
        }
        cost.setPosition(Gdx.graphics.getWidth()*60/100f, Gdx.graphics.getHeight()*75/100f);
        cost.setSize(Gdx.graphics.getWidth()*12/100f,Gdx.graphics.getHeight()*5/100f);
        cost.setScale(5,5);

pageminus.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
        if (pageitem>0){
            pages--;
            pageitem-=4;
            pcitems=4;
            getitem(pageitem);
        }
    }
});

page.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {

if(pclist.size()%4==0){
    maxpage=pclist.size()/4;
}else{
    maxpage=pclist.size()/4+1;
}
        System.out.println("Max Pages"+maxpage);

        System.out.println("Pages item"+pageitem);
System.out.println(pclist.size()-pageitem);


if( pages<maxpage) {
    pageitem += 4;
    pages++;

    switch (pclist.size()-pageitem) {
        case 1: pcitems=1;
            break;
        case 2: pcitems=2;
            break;
        case 3: pcitems=3;break;
        default:pcitems=4;

    }
getitem(pageitem);
}

    }
});



        percplus.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if (percent<200){
                    percent += 5;
                    tb.percentincome = percent;
                    if (percent < 10) {
                        cost.setColor(Color.GREEN);
                        cost.setText(cheap);
                    }
                    if (percent > 10 && percent < 45) {
                        cost.setColor(Color.YELLOW);
                        cost.setText(good);
                    }
                    if (percent > 45 && percent < 120) {
                        cost.setColor(Color.ORANGE);
                        cost.setText(expensive);
                    }
                    if (percent > 120) {
                        cost.setColor(Color.RED);
                        cost.setText(tooexpensive);
                    }
            }

            }});

        percminus.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                System.out.println("Minus work 1");
                if(percent>0) {
                    percent -= 5;
                    tb.percentincome = percent;
                    if (percent < 10) {
                        cost.setColor(Color.GREEN);
                        cost.setText(cheap);
                    }
                    if (percent > 10 && percent < 45) {
                        cost.setColor(Color.YELLOW);
                        cost.setText(good);
                    }
                    if (percent > 45 && percent < 120) {
                        cost.setColor(Color.ORANGE);
                        cost.setText(expensive);
                    }
                    if (percent > 120) {
                        cost.setColor(Color.RED);
                        cost.setText(tooexpensive);
                    }

                }
            }});






    stage.addActor(percplus);
    stage.addActor(percminus);

stage.addActor(cost);
        if(pclist.size()>0) {
            stage.addActor(page);
            stage.addActor(pageminus);
        }
        //stage.setKeyboardFocus(bad);

    }

    public void getitem(int a){
        try {
            image1 = photolist.get(a);
        }catch (Exception e){
            image1 = "dollar.png";
        }
        try {
            image2 = photolist.get(a+1);
        }catch (Exception b){
            image2 = "dollar.png";
        }
        try {
            image3 = photolist.get(a+2);
        }catch (Exception c){
            image3 = "dollar.png";
        }
        try {
            image4 = photolist.get(a+3);
        }catch (Exception d){
            image4 = "dollar.png";
        }

        photo1=new Texture(image1);
        photo2=new Texture(image2);
        photo3=new Texture(image3);
        photo4=new Texture(image4);

    }

    @Override
    public void render(float delta) {

Texture photo[]={photo1,photo2,photo3,photo4};

        ScreenUtils.clear(255/255f, 45/255f, 16/255f, 1.0f);
        tb.getBar();
        tb.setPicture();
        camera.update();
        betch.setProjectionMatrix(camera.combined);
        betch.begin();

        betch.draw(window,Gdx.graphics.getWidth()*19/100f, Gdx.graphics.getHeight()*15/100f,Gdx.graphics.getWidth()*62/100f,Gdx.graphics.getHeight()*72/100f);

        betch.draw(table, Gdx.graphics.getWidth()*23/100f, Gdx.graphics.getHeight()*20/100f,Gdx.graphics.getWidth()*55/100f,Gdx.graphics.getHeight()*52/100f);
    betch.draw(coin , Gdx.graphics.getWidth()*25/100f, Gdx.graphics.getHeight()*75/100f,Gdx.graphics.getWidth()*2.5f/100f,Gdx.graphics.getWidth()*2.5f/100f);
    incomefont.draw(betch,income, Gdx.graphics.getWidth()*30/100f, Gdx.graphics.getHeight()*79/100f);
betch.draw(percenttable,percx,percy,Gdx.graphics.getWidth()*13/100f,Gdx.graphics.getHeight()*5/100f);

    percnumber.draw(betch, percent+"%", Gdx.graphics.getWidth()*50/100f, Gdx.graphics.getHeight()*79/100f);
    if(pclist.size()>0) {
        curentpagefont.draw(betch, pages + "", Gdx.graphics.getWidth() * 67 / 100f, Gdx.graphics.getHeight() * 29 / 100f);
    }

    for(int i=1; i<=pcitems;i++){
         x=12*i;
          posx=15+x;

         betch.draw(redtable, Gdx.graphics.getWidth()*posx/100f, Gdx.graphics.getHeight()*35/100f,Gdx.graphics.getWidth()*10/100f,Gdx.graphics.getHeight()*34/100f);
posx=16+x;
         betch.draw(photo[i-1], Gdx.graphics.getWidth()*posx/100f, Gdx.graphics.getHeight()*52/100f,Gdx.graphics.getWidth()*8/100f,Gdx.graphics.getHeight()*15/100f);

    betch.draw(coin,Gdx.graphics.getWidth()*posx/100f, Gdx.graphics.getHeight()*43/100f,Gdx.graphics.getHeight()*7/2/100f,Gdx.graphics.getHeight()*7/2/100f);
try {
    posx = 18 + x;
    moneyfont.draw(betch, incomelist.get(pageitem + i - 1) * percent / 100 + " /pc", Gdx.graphics.getWidth() * posx / 100f, Gdx.graphics.getHeight() * 46 / 100f);
    posx = 17 + x;
    pcfont.draw(betch, pclist.get(pageitem + i - 1) + "pc", Gdx.graphics.getWidth() * posx / 100f, Gdx.graphics.getHeight() * 51 / 100f);
}catch(RuntimeException r){

}
     }



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
        tb.bardispose();
        skin.dispose();
        betch.dispose();
        stage.dispose();
       coin.dispose();
        window.dispose();
        table.dispose();
        redtable.dispose();
        photo1.dispose();
        photo2.dispose();
        photo3.dispose();
       photo4.dispose();
        percenttable.dispose();

        incomefont.dispose();
        pfont.dispose();
        pagefont.dispose();
       percnumber.dispose();
       bfont.dispose();
       pcfont.dispose();
       moneyfont.dispose();
        curentpagefont.dispose();

         patlas.dispose();
      batlas.dispose();
         pageatlas.dispose();

    }

    @Override
    public void dispose() {
        tb.bardispose();
        skin.dispose();
        betch.dispose();
        stage.dispose();
        coin.dispose();
        window.dispose();
        table.dispose();
        redtable.dispose();
        photo1.dispose();
        photo2.dispose();
        photo3.dispose();
        photo4.dispose();
        percenttable.dispose();
        incomefont.dispose();
        pfont.dispose();
        pagefont.dispose();
        percnumber.dispose();
        bfont.dispose();
        pcfont.dispose();
        moneyfont.dispose();
        curentpagefont.dispose();
        patlas.dispose();
        batlas.dispose();
        pageatlas.dispose();
    }
}
