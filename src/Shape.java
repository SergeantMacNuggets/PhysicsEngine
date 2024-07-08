import javax.swing.*;
import java.awt.*;


public abstract class Shape extends JPanel {
    JLabel stats;
    int x,y;
    int width,height;
}

class Box extends Shape {
    Movement physics;
    Collision collisions;
    Box(int x, int y, int width, int height) {
        repaint();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        physics = new Movement(x,y,width,height);
        collisions = new Collision(physics);

    }
    public Graphics createBox(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(physics.x,physics.y,width,height);
        return g;
    }

    public void dynamicWindow(double width, double height) {
        physics.win_Width = (int) width;
        physics.win_Height = (int) height;
    }
}

//class Stats extends Box {
//    public void instLabel() {
//        stats = new JLabel();
//        stats.setForeground(Color.white);
//    }
//    public void stats(Physics phy) {
//        stats.setText("<html><p style="+"margin-right:520px;"+">" +
//                "xVel: " + String.valueOf((int) physics.xVel)+
//                "<br/>yVel: " + String.valueOf((int) physics.yVel) +
//                "<br/>Acc: " + String.valueOf((double) physics.acc) + "</p></html>");
//        this.add(stats);
//    }
//}
