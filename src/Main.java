/*
This project is Non-commercial for people who want's to use it for that. You can share it and modify it to what you want.
Use this License in the file header of every file (so at the top).
 */


import javafx.print.Printer;
import jdk.internal.org.objectweb.asm.util.TraceMethodVisitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class Main {

    public static int width = 900, height = 600;
    public static final JFrame frame = new JFrame("Vector Game");

    static Thread thread;

    static Display display = new Display();
    public static void main(String[] args) {
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseListener(display);
        frame.addKeyListener(display);
        frame.add(display);

        Graphics g = display.getGraphics();
        while((frame.getDefaultCloseOperation() != JFrame.EXIT_ON_CLOSE) || KeyEvent.getKeyText('\n') == "Enter") {
//            System.out.println("Hello World");
            try {
                thread.sleep(1/16); // thread.sleep(1/16);
                g = display.getGraphics();
//                g.create();
                display.update(g);
                g = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
