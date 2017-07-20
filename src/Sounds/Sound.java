package Sounds;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Created by Dima on 20.07.2017.
 */
public class Sound {
    URL url;
    AudioClip clip;

    public Sound(String path) {
        url = this.getClass().getClassLoader().getResource(path);
        clip = Applet.newAudioClip(url);
    }

    public void play() {
        clip.play();
    }
}
