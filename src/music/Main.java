package music;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-02-27 21:21
 */
public class Main {


    public static void main(String[] args) throws IOException {
//
//        FileInputStream fileau=new FileInputStream("src/sounds/a.wav");
//        AudioStream as=new AudioStream(fileau);
//        AudioPlayer.player.start(as);

        Scanner scanner = new Scanner(System.in);
        File sound1=new File("src/sounds/a.wav");
        URL url = sound1.toURI().toURL();
        System.out.println(url);
        AudioClip sound_choose1= Applet.newAudioClip(url);

        sound_choose1.play();   //播放音效
        scanner.nextInt();


    }
}
