package music;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-11-29 22:15
 */
public class MusicUtil {

//    public static void playMp4(String path) {
//        File file = new  File("F:\\KuGou\\张婉清、童英然、薛之谦、黄云龙 - 丑八怪.mp3");
//        Player player = Manager.createPlayer(file.toURL());
//        player.start();//开始播放
//    }

    public static void playWav(String path)  {
        try (Scanner scanner = new Scanner(System.in);) {
            File sound1 = new File(path);
            URL url = sound1.toURI().toURL();
            System.out.println(url);
            AudioClip sound_choose1 = Applet.newAudioClip(url);
            sound_choose1.play();   //播放音效
            if (scanner.next().equals("0")){
                return;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
