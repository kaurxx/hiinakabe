import javax.swing.text.Style;
import java.awt.*;

public class tekst extends gameobject{
    protected String lause;
    protected int suurus;
    tekst(int x, int y, ID id, String lause, int suurus){
        super(x,y,id);
        this.lause=lause;
        this.suurus=suurus;
    }

    public void render(Graphics g){
        Font ft= new Font("arial", 1, suurus);
        g.setFont(ft);
        g.setColor(Color.black);
        g.drawString(lause,x,y);
    }
}
