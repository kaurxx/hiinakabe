import java.awt.*;

public class volts extends gameobject{
    private ID id2;
        volts(int x, int y, ID id, ID id2){
            super(x,y,id);
            this.id2=id2;
        }


        @Override
        public void render(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillOval(x,y,mäng.scale(40),mäng.scale(40));

        }

    }

