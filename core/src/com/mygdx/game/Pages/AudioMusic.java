package com.mygdx.game.Pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Launch;

public class AudioMusic  {

    Music music= Gdx.audio.newMusic(Gdx.files.internal("music/windows.mp3"));;
  Launch launch;

    public void createmusic() {
       //Music music= Gdx.audio.newMusic(Gdx.files.internal("music/windows.mp3"));
        music=launch.sings;
        music.setVolume(1.0f);
        music.setLooping(false);
        music.play();

    }
 //   public boolean audioplay= music.isPlaying();
    public void removemusic(){
      /*  System.out.println("Music"+music);

            System.out.println("Music Playing");
            music.stop();
*/
    }
}
