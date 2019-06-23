/*
This project is Non-commercial for people who want's to use it for that. You can share it and modify it to what you want.
Use this License in the file header of every file (so at the top).
 */


import java.awt.*;

public class Level {

    public static int levelWidth;
    public transient int levelHeight; //TODO: Figure out if this is needed!




    Level() {

    }


    void drawBlock(Graphics g, int x, int y, int w, int h) {
        synchronized (g) {
            g.drawRect(x,y,w,h);
        }

    }




}
