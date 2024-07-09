import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JPanel implements ActionListener {
    Timer timer;
    JLabel stats;
    Box box1,box2,box3;
    int winWidth = 800;
    int winHeight = 800;
    Dimension d = new Dimension(800,800);
    Window() {
        this.setPreferredSize(d);
        this.setBackground(Color.black);
        box1 = new Box(0,0,40,40);
        box2 = new Box(400,0,40,40);
        timer = new Timer(10,this);
        box1.physics.setxVelocity(8);
        box2.physics.setxVelocity(4);
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
        box1.physics.addxVelocity();
        box2.physics.addxVelocity();
        box1.physics.bounce();
        box2.physics.bounce();
        box1.collisions.addCollisionX(box1.collisions.detectCollisionX(box2));
        box2.collisions.addCollisionX(box2.collisions.detectCollisionX(box1));
        box1.collisions.addCollisionY(box1.collisions.detectCollisionY(box2));
        box2.collisions.addCollisionY(box2.collisions.detectCollisionY(box1));
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
