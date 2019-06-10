import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    public static int width = 900, height = 600;
    public static final JFrame frame = new JFrame("Vector Game");

    static Thread thread;


    public static void main(String[] args) {
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Display display = new Display();
        frame.addMouseListener(display);
        frame.addKeyListener(display);
        frame.add(display);

        Graphics g = display.getGraphics();
        while((frame.getDefaultCloseOperation() != JFrame.EXIT_ON_CLOSE) || KeyEvent.getKeyText('\n') == "Enter") {
//            System.out.println("Hello World");
            try {
                thread.sleep(1/60);
                g = display.getGraphics();
                g.create().setXORMode(Color.YELLOW);
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
