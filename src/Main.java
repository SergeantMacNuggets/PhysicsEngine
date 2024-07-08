import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JPanel implements ActionListener {
    Timer timer;
    JLabel stats;
    Box box1,box2;
    int winWidth = 800;
    int winHeight = 800;
    Dimension d = new Dimension(800,800);
    Window() {
        this.setPreferredSize(d);
        this.setBackground(Color.black);
        box1 = new Box(400,10,40,40);
        box2 = new Box(80,200,40,40);
        timer = new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        box1.createBox(g);
        box2.createBox(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        box1.dynamicWindow(getWidth(),getHeight());
        box2.dynamicWindow(getWidth(),getHeight());
        box1.physics.bounce();
        box2.physics.bounce();
        repaint();
    }
}
class UI extends JFrame {
    Window window;
    UI() {
        window = new Window();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(window);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        new UI();
    }

}
