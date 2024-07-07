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
    Window() {
        this.setPreferredSize(new Dimension(800,800));
        this.setBackground(Color.black);
        physics = new Movement();
        physics.x=40;
        physics.y=10;
        physics.setxVelocity(5.0);
        physics.setyVelocity(0.0);
        timer = new Timer(10,this);
        timer.start();
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
