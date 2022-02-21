import java.awt.*;

public abstract class gameobject {
    protected int x,y;
    protected ID id;
    public gameobject(int x,int y,ID id){
        this.x=x;
        this.y=y;
        this.id=id;

    }
    public abstract void render(Graphics g);

    public void Setx(int x){
        this.x=x;

    }
    public void Sety(int y){
        this.y=y;

    }
    public int Getx(){
        return x;
    }
    public int Gety(){
        return y;
    }
    public void SetID(ID id){
        this.id=id;
    }
    public ID GetID(){
        return id;
    }
}
