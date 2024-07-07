public abstract class Physics {
    public int x,y;
    public double vel, acc;
    public double xVel, yVel;
    public double time;
    public double gravity = 0.981;
}

class Movement extends Physics {

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
        x+=(int) xVel;
    }
    public void addGravity() {
        this.yVel += gravity;
    }
    public void addxVelocity(double a) {
        a = (xVel < 0) ? (-1) * a : a;
        xVel+=a;
        x+=(int) xVel;
    }

    public void addyVelocity() {
        y+=(int) yVel;
    }
    public void addyVelocity(double a) {
        a = (yVel < 0) ? (-1) * a : a;
        yVel+=a;
        y+=(int) yVel;
    }
    private boolean detectCollisionX() {
        if(x+40 >= 800 || x < 0)
            return true;
        return false;
    }

    private boolean detectCollisionY() {
        if(y+40 >= 800 || y <0)
            return true;
        return false;
    }

    public void addCollisionX() {
        if(detectCollisionX())
            xVel*=(-1);
    }

    public void addCollisionY() {
        if(detectCollisionY())
            yVel *= (-1);
    }

    public void rigid() {
        this.addGravity();
        this.addyVelocity();
        if(detectCollisionY()) {
            yVel=0;
            y = 760;
        }
    }

    public void bounce() {
        this.addGravity();
        this.addyVelocity();
        this.addCollisionY();
    }

}




