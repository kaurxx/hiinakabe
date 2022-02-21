import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class sound {
    public static void sound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sound.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        clip.start();

    }
}
