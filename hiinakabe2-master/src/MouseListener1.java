import javax.sound.sampled.*;
import java.io.File;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import static java.lang.Math.abs;

public class MouseListener1 extends MouseAdapter  {
    private handeler handeler;
    public int arv1 = 0;
    public gameobject tempnupp;
    public int käik = 1;
    private int käikudearv;
    private mäng mang;
    public static HashMap<String, asukoht> kohad;
    private int tekstimaaraja=0;
    private ArrayList<Integer> lopud = new ArrayList();
    private HashMap<Integer, ArrayList<String>> algused = Importalgused.Importalgused();
    private int lopetamine=0;
    private boolean jarg=true;
    private int tekst=0;
    static {
        try {
            kohad = ImportAsukohad.ImportAsukohad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MouseListener1(handeler handeler, int käikudearv, mäng mang) throws IOException{
        this.handeler = handeler;
        this.käikudearv = käikudearv;
        this.mang = mang;
    }

    @Override
    public void mousePressed(MouseEvent e){
        tekstimaaraja=1;
        if(Menu.mouseover(e.getX(),e.getY(),mäng.scale(1719),1,mäng.scale(200),mäng.scale(60))){
            for( int x=0; x<handeler.object.size();x++){
            handeler.removegameobject(handeler.object.get(x));
              x=-1;
            }
            mang.removeMouseListener(this);
            mang.gamestate=mäng.state.menu;
        }
        if(Menu.mouseover(e.getX(),e.getY(),mäng.scale(1395), mäng.scale(750), mäng.scale(430),mäng.scale(60)) & (lopetamine==1)){
            käik=käik/10;
        }
        if (käik == 1) {
            for (int i = 0; i < handeler.object.size(); i++) {
                gameobject tempobject = handeler.object.get(i);
                if (tempobject.GetID() == ID.mangija1) {
                    if (abs(e.getX() - (tempobject.Getx() + mäng.scale(20))) < mäng.scale(25) & abs(e.getY() - (tempobject.Gety()) - mäng.scale(20)) < mäng.scale(25)) {
                        for (int c = 0; c < handeler.object.size(); c++) {
                            if (handeler.object.get(c).GetID() == ID.volts) {
                                handeler.removegameobject(handeler.object.get(c));
                                c = 0;
                            }
                        }
                        arv1 = 1;
                        tempnupp = tempobject;

                    }
                }
            }
        }
            if (((arv1 == 1)&(käik==1))||(käik==100)) {
                for (int c = 0; c < handeler.object.size(); c++) {
                    gameobject tempobejct2 = handeler.object.get(c);
                    jarg=true;
                    if (tempobejct2.GetID() == ID.enemy& jarg==true) {
                        if ((abs(e.getX() - (tempobejct2.Getx() + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (tempobejct2.Gety()) - mäng.scale(20)) < mäng.scale(25))) {
                            ArrayList<asukoht> list = new ArrayList<asukoht>(kohad.values());
                            for (int k = 0; k < list.size(); k++) {
                                asukoht tempkordinaat = list.get(k);
                                if ((tempnupp.Getx() == mäng.scale(tempkordinaat.x)) & (tempnupp.Gety() == mäng.scale(tempkordinaat.y))& jarg) {
                                    String[] list2 = tempkordinaat.korval;
                                    for (int b = 0; b < list2.length; b++) {
                                            if((käik==1)||(käik==100)){
                                                if(käik==1) {handeler.addgameobject(new volts(mäng.scale(kohad.get(list2[b]).x),mäng.scale(kohad.get(list2[b]).y),ID.volts,ID.volts));}
                                        for (int v = 0; v < handeler.object.size(); v++) {
                                                if (handeler.object.get(v).GetID() != ID.enemy & handeler.object.get(v).GetID() != ID.volts &jarg) {
                                                        for (int x = 0; x < handeler.object.size(); x++) {
                                                            if (handeler.object.get(x).GetID() == ID.volts) {
                                                                if ((handeler.object.get(x).Gety() == handeler.object.get(v).Gety()) & (handeler.object.get(x).Getx() == handeler.object.get(v).Getx())) {
                                                                    handeler.removegameobject(handeler.object.get(x));
                                                                }
                                                            }
                                                        }
                                                }
                                                if (v < handeler.object.size()) {
                                                    if (!handeler.object.get(v).GetID().equals(ID.enemy) & !handeler.object.get(v).GetID().equals(ID.volts)& jarg) {
                                                        if (kohad.get(list2[b]) != null) {
                                                            if ((mäng.scale((kohad.get(list2[b])).x) == handeler.object.get(v).x) & (mäng.scale(kohad.get(list2[b]).y) == handeler.object.get(v).y)) {
                                                                for (int l = 0; l < list2.length; l++) {
                                                                    if (mäng.scale(kohad.get(list2[l]).y) == handeler.object.get(v).y & mäng.scale(kohad.get(list2[l]).x) == handeler.object.get(v).x & jarg) {
                                                                        try {
                                                                            handeler.addgameobject(new volts(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[b]).nimi, kohad)).x),mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[b]).nimi, kohad)).y),ID.volts,ID.volts));
                                                                            for(int z=0;z<handeler.object.size();z++){
                                                                                if (handeler.object.get(z).GetID() != ID.enemy & handeler.object.get(z).GetID() != ID.volts &jarg) {
                                                                                    for (int x = 0; x < handeler.object.size(); x++) {
                                                                                        if (handeler.object.get(x).GetID() == ID.volts) {
                                                                                            if ((handeler.object.get(x).Gety() == handeler.object.get(z).Gety()) & (handeler.object.get(x).Getx() == handeler.object.get(z).Getx())) {
                                                                                                handeler.removegameobject(handeler.object.get(x));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }

                                                                            if ((abs(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x + mäng.scale(20)) - e.getX()) < 25) & ((abs((mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y) + mäng.scale(20)) - e.getY()) < 25))&((käik==1)||(käik==100))& jarg&kontroll(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x),mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y))) {
                                                                                tempnupp.Setx(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x));
                                                                                tempnupp.Sety(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y));
                                                                                sound.sound();
                                                                                try {for (int x = 0; x < handeler.object.size(); x++) {
                                                                                    if (handeler.object.get(x).GetID() == ID.volts) {
                                                                                        handeler.removegameobject(handeler.object.get(x));
                                                                                        x = 0;
                                                                                    }
                                                                                }}catch (Exception ol){}

                                                                                    käik=100;
                                                                                    if(lopetamine==0)
                                                                                    {lopetamine=1;}
                                                                                    jarg=false;
                                                                                if(tekst==0){
                                                                                    handeler.addgameobject(new tekst(mäng.scale(1400), mäng.scale(800),ID.tekst,"LÕPETAN KÄIGU", mäng.scale(50)));
                                                                                    tekst=1;
                                                                                }
                                                                                c=0;
                                                                                l=0;
                                                                                k=0;
                                                                                b=0;
                                                                                v=0;
                                                                            }




                                                                        } catch (Exception as) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                        if ((abs(e.getX() - (mäng.scale((kohad.get(list2[b])).x) + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (mäng.scale((kohad.get(list2[b])).y) + mäng.scale(20))) < mäng.scale(25))&käik==1&kontroll(mäng.scale((kohad.get(list2[b])).x),mäng.scale((kohad.get(list2[b])).y))) {
                                                for (int x = 0; x < handeler.object.size(); x++) {
                                                    if(handeler.object.get(x).GetID()==ID.volts){
                                                        handeler.removegameobject(handeler.object.get(x));
                                                        x=0;
                                                    }}
                                            handeler.removegameobject(handeler.object.get(handeler.object.size() - 1));
                                            tekstimaaraja=0;
                                            handeler.addgameobject(new tekst(mäng.scale(100),mäng.scale(800),ID.tekst,"ROHELISE KÄIK", mäng.scale(50)));

                                            arv1 = 0;
                                            tempnupp.Sety(tempobejct2.Gety());
                                            tempnupp.Setx(tempobejct2.Getx());
                                            try {
                                                sound.sound();
                                            } catch (LineUnavailableException ex) {
                                                ex.printStackTrace();
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            } catch (UnsupportedAudioFileException ex) {
                                                ex.printStackTrace();
                                            }
                                            käik = 2;

                                            käik = kasvoitis();
                                            if(käik ==0){
                                                handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "SININE VÕITIS!", mäng.scale(100)));
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }


            }}
        if (käik==10){
            for (int x = 0; x < handeler.object.size(); x++) {
                if (handeler.object.get(x).GetID() == ID.volts) {
                    handeler.removegameobject(handeler.object.get(x));
                    x = 0;
                }
            }
            lopetamine=0;
            handeler.removegameobject(handeler.object.get(handeler.object.size() - 1));
            handeler.removegameobject(handeler.object.get(handeler.object.size() - 1));
            handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "ROHELISE KÄIK", mäng.scale(50)));
            tekstimaaraja = 0;
            käik = 2;
            tekst=0;
            arv1=0;
            käik = kasvoitis();
            if(käik ==0){
                handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "SININE VÕITIS!", mäng.scale(100)));
            }

        }


        else if (käik == 2||käik==20||käik==200) {
            try {
                käik=mangijad(2, käik,käikudearv,kohad,handeler,ID.mangija2,e);
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (käik == 3||käik==30||käik==300) {
            try {
                käik=mangijad(3, käik,käikudearv,kohad,handeler,ID.mangija3,e);
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (käik == 4||käik==40||käik==400) {
            try {
                käik=mangijad(4, käik,käikudearv,kohad,handeler,ID.mangija4,e);
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (käik == 5||käik==50||käik==500) {
            try {
                käik=mangijad(5,käik,käikudearv,kohad,handeler,ID.mangija5,e);
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (käik == 6||käik==60||käik==600) {
            try {
                käik=mangijad(6,käik,käikudearv,kohad,handeler,ID.mangija6,e);
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public String ylehype(String koht1, String koht2, HashMap<String, asukoht> list) {
        String vastus = "";


        ArrayList<String> vordub1list = new ArrayList<String>();
        int i = 0;
        while (i < list.get(koht2).korval.length) {
            int sarnased = 0;
            for (int k = 0; k < list.get(list.get(koht2).korval[i]).korval.length; k++) {
                try {
                    if (Arrays.stream(list.get(koht1).korval).anyMatch(list.get(list.get(list.get(koht2).korval[i]).korval[k]).nimi::equals)&&!Arrays.stream(list.get(list.get(koht2).korval[i]).korval).anyMatch(koht1::equals)) {
                        sarnased++;
                    }
                }catch (Exception e){}

            }
            if (sarnased == 1) {
                vordub1list.add(list.get(koht2).korval[i]);
            }
            i++;
        }

        if (vordub1list.size() == 1) {
            vastus = (vordub1list.get(0));
        }
        else if(vordub1list.size() == 0){
            vastus="";
        }
        else {

            if (list.get(vordub1list.get(0)).korval.length > list.get(vordub1list.get(1)).korval.length) {
                vastus = vordub1list.get(0);

            } else {
                vastus = vordub1list.get(1);
            }
        }
        return vastus;
    }
    public int mangijad(int mängija, int käik, int käikudearv, HashMap<String, asukoht> kohad, handeler handeler, ID id, MouseEvent e) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            if(käik==mängija){
                for (int i = 0; i < handeler.object.size(); i++) {
                gameobject tempobject = handeler.object.get(i);
                if (tempobject.GetID() == id) {
                    if (abs(e.getX() - (tempobject.Getx() + mäng.scale(20))) < mäng.scale(25) & abs(e.getY() - (tempobject.Gety()) - mäng.scale(20)) < mäng.scale(25)) {
                        for (int c = 0; c < handeler.object.size(); c++) {
                            if(handeler.object.get(c).GetID()==ID.volts){
                                handeler.removegameobject(handeler.object.get(c));
                                c=0;
                            }
                        }
                        arv1 = 1;
                        tempnupp = tempobject;

                    }
                }
            }}
            if (((arv1 == 1)&(käik==mängija))||(käik==100*mängija)) {
                for (int c = 0; c < handeler.object.size(); c++) {
                    gameobject tempobejct2 = handeler.object.get(c);
                    jarg = true;
                    if (tempobejct2.GetID() == ID.enemy & jarg ) {
                        if ((abs(e.getX() - (tempobejct2.Getx() + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (tempobejct2.Gety()) - mäng.scale(20)) < mäng.scale(25))) {
                            ArrayList<asukoht> list = new ArrayList<asukoht>(kohad.values());
                            for (int k = 0; k < list.size(); k++) {
                                asukoht tempkordinaat = list.get(k);
                                if ((tempnupp.Getx() == mäng.scale(tempkordinaat.x)) & (tempnupp.Gety() == mäng.scale(tempkordinaat.y)) & jarg) {
                                    String[] list2 = tempkordinaat.korval;
                                    for (int b = 0; b < list2.length; b++) {
                                        if ((käik == mängija) || (käik == 100 * mängija)) {
                                            if (käik == mängija) {
                                                handeler.addgameobject(new volts(mäng.scale(kohad.get(list2[b]).x), mäng.scale(kohad.get(list2[b]).y), ID.volts, ID.volts));
                                            }
                                            for (int v = 0; v < handeler.object.size(); v++) {
                                                if (handeler.object.get(v).GetID() != ID.enemy & handeler.object.get(v).GetID() != ID.volts & jarg) {
                                                    for (int x = 0; x < handeler.object.size(); x++) {
                                                        if (handeler.object.get(x).GetID() == ID.volts) {
                                                            if ((handeler.object.get(x).Gety() == handeler.object.get(v).Gety()) & (handeler.object.get(x).Getx() == handeler.object.get(v).Getx())) {
                                                                handeler.removegameobject(handeler.object.get(x));
                                                            }
                                                        }
                                                    }
                                                }
                                                if (v < handeler.object.size()) {
                                                    if (!handeler.object.get(v).GetID().equals(ID.enemy) & !handeler.object.get(v).GetID().equals(ID.volts) & jarg) {
                                                        if (kohad.get(list2[b]) != null) {
                                                            if ((mäng.scale((kohad.get(list2[b])).x) == handeler.object.get(v).x) & (mäng.scale(kohad.get(list2[b]).y) == handeler.object.get(v).y)) {
                                                                for (int l = 0; l < list2.length; l++) {
                                                                    if (mäng.scale(kohad.get(list2[l]).y) == handeler.object.get(v).y & mäng.scale(kohad.get(list2[l]).x) == handeler.object.get(v).x & jarg) {
                                                                        try {
                                                                            handeler.addgameobject(new volts(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[b]).nimi, kohad)).x), mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[b]).nimi, kohad)).y), ID.volts, ID.volts));
                                                                            for(int z=0;z<handeler.object.size();z++){
                                                                                if (handeler.object.get(z).GetID() != ID.enemy & handeler.object.get(z).GetID() != ID.volts &jarg) {
                                                                                    for (int x = 0; x < handeler.object.size(); x++) {
                                                                                        if (handeler.object.get(x).GetID() == ID.volts) {
                                                                                            if ((handeler.object.get(x).Gety() == handeler.object.get(z).Gety()) & (handeler.object.get(x).Getx() == handeler.object.get(z).Getx())) {
                                                                                                handeler.removegameobject(handeler.object.get(x));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if ((abs(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x + mäng.scale(20)) - e.getX()) < 25) & ((abs((mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y) + mäng.scale(20)) - e.getY()) < 25)) & ((käik == 1*mängija) || (käik == 100*mängija)) & jarg&kontroll(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x),mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y))) {
                                                                                tempnupp.Setx(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).x));
                                                                                tempnupp.Sety(mäng.scale(kohad.get(ylehype(tempkordinaat.nimi, kohad.get(list2[l]).nimi, kohad)).y));
                                                                                sound.sound();
                                                                                try {
                                                                                    for (int x = 0; x < handeler.object.size(); x++) {
                                                                                        if (handeler.object.get(x).GetID() == ID.volts) {
                                                                                            handeler.removegameobject(handeler.object.get(x));
                                                                                            x = 0;
                                                                                        }
                                                                                    }
                                                                                } catch (Exception ol) {
                                                                                }

                                                                                käik = 100*mängija;
                                                                                if (lopetamine == 0) {
                                                                                    lopetamine = 1;
                                                                                }
                                                                                jarg = false;
                                                                                if (tekst == 0) {
                                                                                    handeler.addgameobject(new tekst(mäng.scale(1400), mäng.scale(800), ID.tekst, "LÕPETAN KÄIGU", mäng.scale(50)));
                                                                                    tekst = 1;
                                                                                }
                                                                                c = 0;
                                                                                l = 0;
                                                                                k = 0;
                                                                                b = 0;
                                                                                v = 0;
                                                                            }


                                                                        } catch (Exception as) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            if ((abs(e.getX() - (mäng.scale((kohad.get(list2[b])).x) + mäng.scale(20))) < mäng.scale(25)) & (abs(e.getY() - (mäng.scale((kohad.get(list2[b])).y) + mäng.scale(20))) < mäng.scale(25))&kontroll(mäng.scale((kohad.get(list2[b])).x),mäng.scale((kohad.get(list2[b])).y))&käik==mängija) {
                                                for (int x = 0; x < handeler.object.size(); x++) {
                                                    if (handeler.object.get(x).GetID() == ID.volts) {
                                                        handeler.removegameobject(handeler.object.get(x));
                                                        x = 0;
                                                    }
                                                }
                                                handeler.removegameobject(handeler.object.get(handeler.object.size() - 1));
                                                tekstimaaraja = 0;

                                                arv1 = 0;

                                                tempnupp.Sety(tempobejct2.Gety());
                                                tempnupp.Setx(tempobejct2.Getx());
                                                sound.sound();


                                                käik = kasvoitis();
                                                if(käik ==0){
                                                    if(mängija==20){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "ROHELINE VÕITIS!", mäng.scale(100)));}
                                                    if(mängija==30){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "HELESININE VÕITIS!", mäng.scale(100)));}
                                                    if(mängija==40){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "VALGE VÕITIS!", mäng.scale(100)));}
                                                    if(mängija==50){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "LILLA VÕITIS!", mäng.scale(100)));}
                                                    if(mängija==60){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "PUNANE VÕITIS!", mäng.scale(100)));}
                                                    return(0);}
                                                if(käik==käikudearv){
                                                    handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "SINISE KÄIK",mäng.scale(50)));
                                                    return(1);
                                                }
                                                if(käik==2)
                                                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "HELESINISE KÄIK", mäng.scale(50)));
                                                    return(3);
                                                }
                                                if(käik==3)
                                                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "VALGE KÄIK", mäng.scale(50)));
                                                    return(4);
                                                }
                                                if(käik==4)
                                                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "LILLA KÄIK", mäng.scale(50)));
                                                    return(5);
                                                }
                                                if(käik==5)
                                                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "PUNASE KÄIK", mäng.scale(50)));
                                                    return(6);
                                                }

                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }


                }
            }
            if (käik==mängija*10){
                for (int x = 0; x < handeler.object.size(); x++) {
                    if (handeler.object.get(x).GetID() == ID.volts) {
                        handeler.removegameobject(handeler.object.get(x));
                        x = 0;
                    }
                }
                käik = kasvoitis();
                if(käik ==0){
                if(mängija==20){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "ROHELINE VÕITIS!", mäng.scale(100)));}
                if(mängija==30){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "HELESININE VÕITIS!", mäng.scale(100)));}
                if(mängija==40){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "VALGE VÕITIS!", mäng.scale(100)));}
                if(mängija==50){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "LILLA VÕITIS!", mäng.scale(100)));}
                if(mängija==60){handeler.addgameobject(new tekst(mäng.scale(600), mäng.scale(600), ID.tekst, "PUNANE VÕITIS!", mäng.scale(100)));}
                return(0);}
                lopetamine=0;
                handeler.removegameobject(handeler.object.get(handeler.object.size() - 1));
                handeler.removegameobject(handeler.object.get(handeler.object.size() - 1));
                tekstimaaraja = 0;
                tekst=0;
                if(käik/10==käikudearv){
                    handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "SINISE KÄIK", mäng.scale(50)));
                    return(1);
                }
                else if(käik==20)
                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "HELESINISE KÄIK", mäng.scale(50)));
                    return(3);
                }
                else if(käik==30)
                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "VALGE KÄIK", mäng.scale(50)));
                    return(4);
                }
                else if(käik==40)
                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "LILLA KÄIK", mäng.scale(50)));
                    return(5);
                }
                else if(käik==50)
                {handeler.addgameobject(new tekst(mäng.scale(100), mäng.scale(800), ID.tekst, "PUNASE KÄIK", mäng.scale(50)));
                    return(6);
                }

            }
                return käik;

        }
    public boolean kontroll(int x, int y){
        for(int i=0;i<handeler.object.size();i++){
            if(handeler.object.get(i).GetID()==ID.mangija1||handeler.object.get(i).GetID()==ID.mangija2||handeler.object.get(i).GetID()==ID.mangija3||handeler.object.get(i).GetID()==ID.mangija4||handeler.object.get(i).GetID()==ID.mangija5||handeler.object.get(i).GetID()==ID.mangija6){
                if(handeler.object.get(i).x==x & handeler.object.get(i).y==y){
                    return false;
                }
            }
        }
        return true;
    }

    public static void renders(Graphics g){
            Font fnt = new Font("arial", 1, mäng.scale(50));
            g.setFont(fnt);
            g.drawRect(mäng.scale(1719),1,mäng.scale(200),mäng.scale(60));
        g.drawString("MENU",mäng.scale(1745),mäng.scale(50));
        }
        public static void tick(){};
    public int kasvoitis(){

        ArrayList<Integer> lopud = new ArrayList();

        if (käikudearv == 2) {
            lopud.add(1);
            lopud.add(4);
        }
        if (käikudearv == 3) {
            lopud.add(1);
            lopud.add(3);
            lopud.add(5);
        }
        if (käikudearv == 4) {
            lopud.add(1);
            lopud.add(2);
            lopud.add(4);
            lopud.add(5);
        }

        if (käikudearv == 6) {
            lopud.add(1);
            lopud.add(2);
            lopud.add(3);
            lopud.add(4);
            lopud.add(5);
            lopud.add(6);
        }
        for (int i = 0; i < lopud.size(); i++) {
            boolean leitud = false;

            int onkohal = 0;
            for (int f = 0; f < 10; f++) {
                int tempnumber = lopud.get(i) + 3;
                if (tempnumber > 6) {
                    tempnumber = tempnumber - 6;
                }
                int vaadatavX = kohad.get((algused.get(tempnumber)).get(f)).x;

                int vaadatavY = kohad.get((algused.get(tempnumber)).get(f)).y;


                leitud = false;

                for (int s = 0; s < handeler.object.size(); s++) {
                    String idstring = handeler.object.get(s).GetID().toString();
                    int idd = i+1;



                    if (handeler.object.get(s).x == mäng.scale(vaadatavX) && handeler.object.get(s).y == mäng.scale(vaadatavY) && idstring.equals("mangija"+idd)) {
                        leitud = true;
                        break;
                    }
                }
                if (leitud) {
                    onkohal++;
                }

            }
            if (onkohal == 10) {
                käik = 0;
            }
        }
        return käik;
    }
    }



