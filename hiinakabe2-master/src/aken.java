import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serial;


public class aken extends Canvas {
    public aken(String nimi, mäng game, int x, int y){

        JFrame aken1 = new JFrame(nimi);
        aken1.setPreferredSize(new Dimension(x,y));
        aken1.setMaximumSize(new Dimension(x,y));
        aken1.setMinimumSize(new Dimension(x,y));
        aken1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken1.setVisible(true);

        aken1.setResizable(false);
        aken1.setLocationRelativeTo(null);
        aken1.setState(aken1.NORMAL);
        aken1.add(game);

        game.start();



    }

}
