/*
This project is Non-commercial for people who want's to use it for that. You can share it and modify it to what you want.
Use this License in the file header of every file (so at the top).
 */


import sun.swing.BakedArrayList;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Display extends Component implements MouseListener, KeyListener, MouseMotionListener {

    static int x = 0;
    static int y = 0;


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if(e.getKeyCode() == 'A') {
            x -= 10;
        }
        if(e.getKeyCode() == 'S') {
            y += 10;
        }
        if(e.getKeyCode() == 'W') {
            y -= 10;
        }
        if(e.getKeyCode() == 'D') {
            x += 10;
        }
        repaint();
    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }

    @Override
    public void mouseClicked(final MouseEvent e) {

    }

    @Override
    public void mousePressed(final MouseEvent e) {

    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }

    @Override
    public void mouseDragged(final MouseEvent e) {

    }

    @Override
    public void mouseMoved(final MouseEvent e) {

    }
    private transient Object objectLock = new Object();



    ArrayList<int[]> mapGround = new BakedArrayList(Main.width*100);


    private boolean updateGround = false;

    private static transient final Level level = new Level();

    private boolean mapGen = true;

    private static int screenWidth = 0;
    @Override
    public void update(final Graphics g) {
        Random rand = new Random();
        super.update(g);
        if(mapGen = true) {
            /*
            * Format:
            * x,y,w,h
            */
            mapGround.add(new int[] {0,500,Main.width,10});


//            mapGround.add(new int[] {150,490,10,10});
            for(int i = screenWidth; i < Main.width * 2; i += 10) {
                if(rand.nextFloat() >= 0.7f) {
                    mapGround.add(new int[] {x + screenWidth + i,490,10,10});
                }
            }

            mapGen = false;
        }
        if(x > Main.width) {
            screenWidth += Main.width;
            x = 0;
            updateGround = true;
        }
        updateGround = false;

//        for(int i = 0; i < (640 * 2); i += 10) {
//            if(x >= (i-screenWidth) || x <= (i+screenWidth) | (i > screenWidth - x || updateGround)) {
//                g.drawRect(i,500 + new Random().nextInt(50),1,1);
//            }
//        }


//        mapGround.forEach((a) -> {
////            g.fillRect(a[0],a[1],a[2],a[3]);
//
//            level.drawBlock(g,a[0],a[1],a[2],a[3]);
//
//        });

        for(int i = screenWidth; i < x + screenWidth; i++) {
            if (i <= mapGround.size() && rand.nextFloat() >= 0.8f) {
                int[] a = mapGround.get(i);
                level.drawBlock(g, a[0], a[1], a[2], a[3]);
            }
        }


        g.fillRect(x,y,10,10);


        System.gc();
    }
}
