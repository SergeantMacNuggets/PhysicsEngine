import java.awt.*;

public abstract class Physics {
    public int x,y;
    public int shape_width, shape_height;
    public int win_Width, win_Height;
    public double vel, acc;
    public double xVel, yVel;
    public double time;
    public double gravity = 0.981;
}
class Movement extends Physics {
    Collision collision;
    Movement(int x, int y, int shape_width, int shape_height) {
        this.x = x;
        this.y = y;
        this.shape_width = shape_width;
        this.shape_height = shape_height;
        collision = new Collision(this);
    }

    public void setxVelocity(double xVel) {
        this.xVel = xVel;
    }

    public void setyVelocity(double yVel) {
        this.yVel = yVel;
    }

    public double addAcceleration(double a) {
        return a;
    }

    public void addxVelocity() {
        x += (int) xVel;
    }
    public void addGravity() {
        this.yVel += gravity;
    }
    public void addxVelocity(double a) {
        a = (xVel < 0) ? (-1) * a : a;
        xVel += a;
        x += (int) xVel;
    }

    public void addyVelocity() {
        y += (int) yVel;
    }
    public void addyVelocity(double a) {
        a = (yVel < 0) ? (-1) * a : a;
        yVel += a;
        y += (int) yVel;
    }

    public void rigid() {
        this.addGravity();
        this.addyVelocity();
        if(collision.detectCollisionY()) {
            yVel=0;
            y = win_Height - shape_height;
        }
    }

    public void bounce() {
        this.addGravity();
        this.addyVelocity();
        collision.addCollisionY();
    }

}

class Collision {
    Movement m;
    Collision(Movement m) {
        this.m = m;
    }
    public boolean detectCollisionX() {
        if((m.x+m.shape_width) >= m.win_Width || m.x < 0)
            return true;
        return false;
    }
    public boolean detectCollisionX(Box b) {
        if((m.x+m.shape_width) >= m.win_Width || m.x < 0)
            return true;
        //Create a code here that detect if it collides with other shapes
        return false;
    }

    public boolean detectCollisionY() {
        if((m.y+m.shape_height) >= m.win_Height || m.y <0)
            return true;
        return false;
    }

    public void addCollisionX() {
        if(detectCollisionX())
            m.xVel *= (-1);
    }

    public void addCollisionY() {
        if(detectCollisionY())
            m.yVel *= (-1);
    }
}


