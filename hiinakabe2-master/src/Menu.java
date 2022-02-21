import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Menu extends MouseAdapter {
    private handeler tegija;
    private mäng mang;
    public static Menu2 menu2;

    public Menu(mäng mäng, handeler handeler) {
        tegija=handeler;
        mang= mäng;
    }
    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
        if(mouseover(mx,my,mäng.scale(800),mäng.scale(100),mäng.scale(500),mäng.scale(100))&(mäng.gamestate==mäng.state.menu)){
            menu2=new Menu2(mang,tegija);
            mang.addMouseListener(menu2);
            mang.gamestate= mäng.state.menu2;


        }
        if(mouseover(mx,my,mäng.scale(800),mäng.scale(300),mäng.scale(500),mäng.scale(100))&(mäng.gamestate==mäng.state.menu)){
            System.exit(0);

        }

    }
    public void mouseReleased(MouseEvent e){

    }
    public static boolean mouseover(int mx, int my, int x, int y, int width, int height){
        if(mx>x && mx < x+width){
            if(my>y && my < y+height){
                return true;
            }
            else return false;
        }
        else return false;
    }

    public void render(Graphics g){
        Font fnt=new Font("arial",1,mäng.scale(50));
        g.setFont(fnt);
        g.drawString("alusta",mäng.scale(960),mäng.scale(175));
        g.drawRect(mäng.scale(800),mäng.scale(100),mäng.scale(500),mäng.scale(100));
        g.drawString("lõpeta",mäng.scale(960),mäng.scale(360));
        g.drawRect(mäng.scale(800),mäng.scale(300),mäng.scale(500),mäng.scale(100));
    }
}
