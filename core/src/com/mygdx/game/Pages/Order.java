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
import com.badlogic.gdx.utils.Timer;
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Order implements Screen {
int click;
    int sellskill=10;/*Min sellskil=10*/
    int pc=4;
    int orders=0;/*Количество заказов*/


String photo1;
    String photo2;
    String photo3;
    String photo4;

    String sellstr;
    String sellall;
    String sellsucces;
    String sellfail;

    ArrayList <Integer> pclist;
    ArrayList <Integer> incomelist;
    ArrayList <String> photolist;
    ArrayList<String> jsonname;

    String jsonitems[]={"smartfonitem_1_1.json","smartfonitem_1_2.json","smartfonitem_1_3.json","smartfonitem_1_4.json","smartfonitem_1_4.json","smartfonitem_1_5.json","smartfonitem_2_1.json","smartfonitem_2_2.json","smartfonitem_2_3.json","smartfonitem_2_4.json","smartfonitem_2_5.json","smartfonitem_3_1.json","smartfonitem_3_2.json","smartfonitem_3_3.json","smartfonitem_3_4.json","smartfonitem_3_5.json","smartfonitem_4_1.json","smartfonitem_4_2.json","smartfonitem_4_3.json","smartfonitem_4_4.json","smartfonitem_4_5.json"};

    final Launch game;
    OrthographicCamera camera;
    SpriteBatch betch;
    Skin skin;
    Stage stage;
    ControlBar tb;

    Texture window;
    Texture tablesell;

    Texture item1;
    Texture item2;
    Texture item3;
    Texture item4;

    BitmapFont sfont;

    TextureAtlas satlas;
    TextureAtlas successatlas;

    TextButton.TextButtonStyle sstyle;
    TextButton.TextButtonStyle successstyle;

    TextButton sell;
    TextButton sell2;
    TextButton sell3;
    TextButton sell4;
    TextButton sellskip;

    TextButton selltrue;

    ArrayList<Texture> item;
    ArrayList<TextButton> button;
    FileHandle acount;
    FileHandle file;
    FileHandle skill;
Items items;
Example expl;
Improves impr;
float imagey;

    public Order(final Launch game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
    @Override
    public void show() {
        Improves imprfile=new Improves();
        impr=new Improves();
        FileHandle skill=Gdx.files.local("Improve.json");
        String itemparams = skill.readString();
        imprfile = json.fromJson(Improves.class, itemparams);
        sellskill=imprfile.sellskillcoeficient;

        tb = new ControlBar();
        tb.createbar();

        switch (tb.language){
            case "English":
                sellstr="Sell";
                sellall="Sell All";
                sellsucces="Item saled";
                sellfail="Item is not saled";
                break;
            case "France":
                sellstr="Vendre";
                sellall="Vendre tout";
                sellsucces="Article vendu";
                sellfail="L'article n'est pas vendu";
                break;
            case "Russian":
                sellstr="Продать";
                sellall="Продать все";
                sellsucces="Товар продан";
                sellfail="Товар не продан";
                break;
            case "Spanish":
                sellstr="Vender";
                sellall="Vender todo";
                sellsucces="Artículo vendido";
                sellfail="Artículo no vendido";
                break;

            case "Germany":
                sellstr="Verkaufen";
                sellall="Alle verkaufen";
                sellsucces="Artikel verkauft";
                sellfail="Artikel ist nicht verkauft";
                break;
            case "Poland":
                sellstr="Sprzedaj";
                sellall="Sprzedaj wszystko";
                sellsucces="Przedmiot sprzedany";
                sellfail="Przedmiot nie jest sprzedany";
                break;
            case "Ucraine":
                sellstr="Продати";
                sellall="Продати все";
                sellsucces="Товар продано";
                sellfail="Товар не продано";
                break;
            case "Italy":
                sellstr="Vendi";
                sellall="Vendi tutto";
                sellsucces="Articolo venduto";
                sellfail="L'oggetto non è stato venduto";
                break;
        }

        if(tb.percentincome<15){
            orders=tb.watches* 3/100;
        }
        if (tb.percentincome>=15 && tb.percentincome<50) {
            orders = tb.watches * 2 / 100;
        }
        if(tb.percentincome>=50 && tb.percentincome<125){
            orders=tb.watches * 1/100;
        }
        if(tb.percentincome>=125){
            orders= tb.watches*1/2/100;
        }


        betch = new SpriteBatch();
        ScreenViewport viewport = new ScreenViewport();
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        tb.getbuttons(game,stage);
        window = new Texture("magazin_big_table.png");




tablesell=new Texture("orderui/Ordertable.png");




skin=new Skin();

        sfont=new BitmapFont(Gdx.files.internal("Fonts/order.fnt"));
        satlas=new TextureAtlas(Gdx.files.internal("Ui/newbuttom.pack"));
        skin.addRegions(satlas);
        sstyle=new TextButton.TextButtonStyle();
        sstyle.font=sfont;
sstyle.up=skin.getDrawable("greenbutton");

        successatlas=new TextureAtlas(Gdx.files.internal("orderui/selltrue.pack"));
        skin.addRegions(successatlas);
        successstyle=new TextButton.TextButtonStyle();
        //successstyle.up=skin.getDrawable("greenb");
        successstyle.font=sfont;



        sfont.getData().setScale(2,2);

sell=new TextButton(sellstr, sstyle);
        sell.setPosition(Gdx.graphics.getWidth()*55/100f, Gdx.graphics.getHeight()*22/100f);
        sell.setSize(Gdx.graphics.getWidth()*10/100f,Gdx.graphics.getHeight()*6/100f);

   sell2=new TextButton(sellstr, sstyle);
        sell2.setPosition(Gdx.graphics.getWidth()*55/100f, Gdx.graphics.getHeight()*39/100f);
        sell2.setSize(Gdx.graphics.getWidth()*10/100f,Gdx.graphics.getHeight()*6/100f);

        sell3=new TextButton(sellstr, sstyle);
        sell3.setPosition(Gdx.graphics.getWidth()*55/100f, Gdx.graphics.getHeight()*56/100f);
        sell3.setSize(Gdx.graphics.getWidth()*10/100f,Gdx.graphics.getHeight()*6/100f);

        sell4=new TextButton(sellstr, sstyle);
        sell4.setPosition(Gdx.graphics.getWidth()*55/100f, Gdx.graphics.getHeight()*73/100f);
        sell4.setSize(Gdx.graphics.getWidth()*10/100f,Gdx.graphics.getHeight()*6/100f);

        sellskip=new TextButton(sellall, sstyle);
        sellskip.setPosition(Gdx.graphics.getWidth()*80/100f, Gdx.graphics.getHeight()*20/100f);
        sellskip.setSize(Gdx.graphics.getWidth()*12/100f,Gdx.graphics.getHeight()*6/100f);

selltrue=new TextButton("Sold", successstyle);
//selltrue.setPosition(Gdx.graphics.getWidth()*40/100f, Gdx.graphics.getHeight()*23/100f);
        selltrue.setSize(Gdx.graphics.getWidth()*14/100f,Gdx.graphics.getHeight()*6/100f);

        button=new ArrayList<TextButton>();
        button.add(sell);
        button.add(sell2);
        button.add(sell3);
        button.add(sell4);




        expl = new Example();

        acount = Gdx.files.local("scores.json");
        String score = acount.readString();
        System.out.println("File "+score);
        Example exampl = json.fromJson(Example.class, score);
        System.out.println(exampl.ordertime);



        pclist = new ArrayList<Integer>();
        incomelist = new ArrayList<Integer>();
        photolist = new ArrayList<String>();
        jsonname = new ArrayList<String>();
        for (int j = 0; j <= jsonitems.length; j++) {
            try {
                file = Gdx.files.local(jsonitems[j]);
            } catch (RuntimeException a) {
                System.out.println("Error file");
                a.printStackTrace();
            }

            if (file.exists()) {

                String scores = file.readString();
                System.out.println("File read" + scores);
                Items itms = json.fromJson(Items.class, scores);

                pclist.add(itms.pieces);
                incomelist.add(itms.value);
                photolist.add(itms.imgname);
                jsonname.add(file.name());
                System.out.println("Pieces" + pclist);

            }


        }

        System.out.println("Orders time "+exampl.ordertime +"Time"+tb.time);
        if (exampl.ordertime >= tb.time ) {
            pc=0;
            orders=0;
            //     button.clear();
        }else{
            //pc=4;
            tb.ordertime= tb.time;
            System.out.println("Orders "+orders+" jsonsize "+jsonname.size());
            if(orders>jsonname.size()){
                orders=jsonname.size();
            }else{
                // orders=tb.watches*1/100;
            }
            System.out.println("Orders size"+orders);
            switch (orders) {
                case 4:
                    pc = 4;
                    stage.addActor(button.get(0));
                    stage.addActor(button.get(1));
                    stage.addActor(button.get(2));
                    stage.addActor(button.get(3));
                    break;
                case 3:
                    pc = 3;
                    stage.addActor(button.get(0));
                    stage.addActor(button.get(1));
                    stage.addActor(button.get(2));
                    break;
                case 2:
                    pc = 2;
                    stage.addActor(button.get(0));
                    stage.addActor(button.get(1));
                    break;
                case 1:
                    pc = 1;
                    stage.addActor(button.get(0));
                    break;
                case 0:
                    pc=0;
                    break;

                default:
                    pc=4;
                    stage.addActor(button.get(0));
                    stage.addActor(button.get(1));
                    stage.addActor(button.get(2));
                    stage.addActor(button.get(3));
                    break;
            }
        }



try {
    photo1 = photolist.get(0);
}catch (RuntimeException e){
    photo1="dollar.png";
}
        try {
            photo2 = photolist.get(1);
        }catch (RuntimeException e){
            photo2="dollar.png";
        }
        try {
            photo3 = photolist.get(2);
        }catch (RuntimeException e){
            photo3="dollar.png";
        }
        try {
            photo4 = photolist.get(3);
        }catch (RuntimeException e){
            photo4="dollar.png";
        }


    item1 = new Texture(photo1);
    item2 = new Texture(photo2);
    item3 = new Texture(photo3);
    item4 = new Texture(photo4);




if(orders!=0){
    stage.addActor(sellskip);
}

        item=new ArrayList<Texture>();
        item.add(item1);
        item.add(item2);
        item.add(item3);
        item.add(item4);
/*Кнопка пропустить когда игрок нажимет то должен появлятса реклама*/

        sellskip.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

sellskip.setText("Wait");
Random srand=new Random();
int sum=0;
for(int j=0;j<orders;j++) {
    int rnum = srand.nextInt(20);
if(rnum<sellskill){
    FileHandle file = Gdx.files.local(jsonname.get(j));

    String scores = file.readString();
   // System.out.println("File read"+scores);
    Items itms=json.fromJson(Items.class, scores);
   /* System.out.println("Photo"+itms.imgname);
    System.out.println("Pieces"+itms.pieces);
    System.out.println("Price"+itms.value);*/
    Items items=new Items();

    items.pieces=itms.pieces-1;
    items.imgname=itms.imgname;
    items.value=itms.value;
    sum+=incomelist.get(j)+ incomelist.get(j)*tb.percentincome/100;


    System.out.println("Item Pieces"+items.pieces);

    String text = json.toJson(items);
if(items.pieces<1||items.pieces==0){
    file.delete();
}else {
    file.writeString(text, false);
}


}else{
    System.out.println("Sell NO");
}
    try {
        Thread.sleep(20);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
tb.value+=sum;
               pc=0;
                button.get(0).remove();
                button.get(1).remove();
                button.get(2).remove();
                button.get(3).remove();
                sellskip.remove();
            }   });




        /*Sell Buttons*/
        sell2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                sellorder(1);
            }

        });

        sell.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

sellorder(0);
 }
        });

        sell3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                sellorder(2);
            }

        });
        sell4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                sellorder(3);
            }

        });

    }

    public  void sellorder(int a){

        stage.addActor(selltrue);
        Random rand=new Random();
        int num=rand.nextInt(20);


        FileHandle file = Gdx.files.local(jsonname.get(a));

        String scores = file.readString();
        Items itms=json.fromJson(Items.class, scores);
        Items items=new Items();
        if(num<=sellskill){
           // selltrue.setColor(Color.GREEN);
            selltrue.getStyle().up=skin.getDrawable("greenbutton");
            selltrue.setText(sellsucces);
            float height;
            switch (a){
                case 0: height=Gdx.graphics.getHeight()*22/100f;break;
                case 1: height=Gdx.graphics.getHeight()*39/100f;break;
                case 2: height=Gdx.graphics.getHeight()*56/100f;break;
                case 3: height=Gdx.graphics.getHeight()*73/100f;break;
                default: height=Gdx.graphics.getHeight()*22/100f;break;
            }
            selltrue.setPosition(Gdx.graphics.getWidth()*40/100f, height);//23 //40 //57
            selltrue.getStyle().up=skin.getDrawable("greenb");
            stage.addActor(selltrue);
            items.pieces=itms.pieces-1;
            items.imgname=itms.imgname;
            items.value=itms.value;

            tb.value+=incomelist.get(a)+incomelist.get(a)*tb.percentincome/100;
if(tb.percentincome<=15){
    tb.watches+= tb.watches*2/100;
}
if(tb.percentincome>15 && tb.percentincome<50){
    tb.watches+= tb.watches*1/100;
}
if(tb.percentincome>=125){
    tb.watches-= tb.watches*2/100;
}
            System.out.println("Item Pieces"+items.pieces);

            String text = json.toJson(items);

            file.writeString(text, false);
            if (items.pieces<=1){
                file.delete();
            }

        }else{

            float height;
            switch (a){
                case 0: height=Gdx.graphics.getHeight()*22/100f;break;
                case 1: height=Gdx.graphics.getHeight()*39/100f;break;
                case 2: height=Gdx.graphics.getHeight()*56/100f;break;
                case 3: height=Gdx.graphics.getHeight()*73/100f;break;
                default: height=Gdx.graphics.getHeight()*22/100f;break;
            }
            selltrue.setPosition(Gdx.graphics.getWidth()*40/100f, height);
            selltrue.getStyle().up=skin.getDrawable("redbuttom");
            selltrue.setText(sellfail);
            stage.addActor(selltrue);
        }


        Timer timer = new Timer();
        Timer.Task task = timer.scheduleTask(new Timer.Task() {
            @Override
            public void run () {
                orders--;
                switch (orders) {
                    case 3:
                        pc = 3;
                        button.get(pc).remove();
                        break;
                    case 2:
                        pc = 2;
                        button.get(pc).remove();
                        break;
                    case 1:
                        pc = 1;
                        button.get(pc).remove();
                        break;
                    case 0:
                        pc = 0;
                        button.get(pc).remove();
                        break;
                }

                selltrue.remove();
            }
        }, 1);

        jsonname.remove(a);
        pclist.remove(a);
        photolist.remove(a);
        incomelist.remove(a);

        try {
            item1 = new Texture(photolist.get(0));
            item2 = new Texture(photolist.get(1));
            item3 = new Texture(photolist.get(2));
            item4 = new Texture(photolist.get(3));
        }catch (RuntimeException ie){
//System.out.println("Exception" +ie);
        }

        item.clear();
        item.add(item1);
        item.add(item2);
        item.add(item3);
        item.add(item4);

        FileHandle improvefile = Gdx.files.local("Improve.json");

        String score = improvefile.readString();
        System.out.println(scores);
        Improves imp=json.fromJson(Improves.class, score);

        impr.smartfonlevel=imp.smartfonlevel;
        impr.accesoirelevel=imp.accesoirelevel;
        impr.pclevel=imp.pclevel;
        impr.appliencelevel=imp.appliencelevel;
        impr.autolevel=imp.autolevel;

        impr.sellskilllevel=imp.sellskilllevel;
        impr.sellskillcoeficient=imp.sellskillcoeficient;
        impr.storagelevel=imp.storagelevel;
        impr.storecapacity=imp.storecapacity+1;
        impr.obiavlenialevel=imp.obiavlenialevel;
        impr.webstorelevel=imp.webstorelevel;
        impr.sellpointlevel=imp.sellpointlevel;


        impr.radiolevel=imp.radiolevel;
        impr.smmlevel=imp.smmlevel;
        impr.banerlevel=imp.banerlevel;
        impr.magazineslevel=imp.magazineslevel;
        impr.tvlevel=imp.tvlevel;

        String imprtext= json.toJson(impr);
        improvefile.writeString(imprtext, false);
    }


    @Override
    public void render(float delta) {
if(orders<1) sellskip.remove();
        ScreenUtils.clear(255f/255f, 45f/255f, 16f/255f, 1f);
        tb.getBar();
        tb.setPicture();
        camera.update();
        betch.setProjectionMatrix(camera.combined);
        betch.begin();
//System.out.println("Orders"+orders);
        imagey=3f;
        betch.draw(window, Gdx.graphics.getWidth()*22/100f, Gdx.graphics.getHeight()*15/100f,Gdx.graphics.getWidth()*50/100f, Gdx.graphics.getHeight()*72/100f);

        for(int i=pc;i>0;i--){

            betch.draw(tablesell, Gdx.graphics.getWidth()*27/100f, Gdx.graphics.getHeight()*17*i/100f,Gdx.graphics.getWidth()*40/100f, Gdx.graphics.getHeight()*15/100f);
        betch.draw(item.get(i-1), Gdx.graphics.getWidth()*28/100f, Gdx.graphics.getHeight()*17*i/100f+Gdx.graphics.getHeight()*1/100f,Gdx.graphics.getHeight()*12/100f,Gdx.graphics.getHeight()*12/100f);
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
        betch.dispose();
        skin.dispose();
        stage.dispose();
        window.dispose();
        tablesell.dispose();
        item1.dispose();
        item2.dispose();
        item3.dispose();
        item4.dispose();
        sfont.dispose();
        satlas.dispose();
        successatlas.dispose();
    }

    @Override
    public void dispose() {
        tb.bardispose();
        betch.dispose();
        skin.dispose();
        stage.dispose();
        window.dispose();
        tablesell.dispose();
        item1.dispose();
        item2.dispose();
        item3.dispose();
        item4.dispose();
        sfont.dispose();
        satlas.dispose();
        successatlas.dispose();
    }
}
