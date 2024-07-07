import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
class Box {

	public void addPhysics(Physics physics) {
	a
	}

	public void paint(Graphics g) {
		Graphics box = (Graphics2D) g;
		super.paint(g);
		box.setColor(Color.blue);
		box.fillRect(physics.x,physics.y,40,40);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		physics.bounce();
		physics.addCollision();
		repaint();
	}
}*/

class Window extends JPanel implements ActionListener {
    Timer timer;
    Movement physics;
    JLabel stats;
    Window() {
        this.setPreferredSize(new Dimension(800,800));
        this.setBackground(Color.black);
        physics = new Movement();
        physics.x=400;
        physics.y=10;
        physics.setxVelocity(1.0);
        physics.setyVelocity(1.0);
        this.instLabel();
        timer = new Timer(10,this);
        timer.start();
    }

    public void instLabel() {
        stats = new JLabel();
        stats.setForeground(Color.white);
    }

    public void stats(Physics phy) {
        stats.setText("<html><p style="+"margin-right:520px;"+">" +
                "xVel: " + String.valueOf((int) physics.xVel)+
                "<br/>yVel: " + String.valueOf((int) physics.yVel) +
                "<br/>Acc: " + String.valueOf((double) physics.acc) + "</p></html>");
        this.add(stats);
    }

    public void paint(Graphics g) {
        Graphics box = (Graphics2D) g;
        super.paint(g);
        box.setColor(Color.blue);
        box.fillRect(physics.x,physics.y,40,40);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        physics.rigid();
        this.stats(physics);
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
