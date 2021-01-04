package view;


import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class MusicPlay {
    private static Clip bgm;//背景乐
    private static Clip hit;//音效
    private static AudioInputStream ais;
  
    public static void play(){
        try {
            bgm=AudioSystem.getClip();
            InputStream is=MusicPlay.class.getClassLoader().getResourceAsStream("music/bgm.mp3");
             
            if (is != null) {
                ais=AudioSystem.getAudioInputStream(is);
            }
            bgm.open(ais);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        bgm.start();
       bgm.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public static void stop()
    {
        if(ais!=null)
            bgm.close();
    }
}