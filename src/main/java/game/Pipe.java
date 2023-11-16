package main.java.game;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pipe {
    private int x,y;
    private int width, height;
    private boolean scored;

    public Pipe(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height;
        this.scored = false;
    }

    public void update(){
        x -= 2;
    }

    public void render(Graphics g){
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public boolean isScored(boolean scored) {
        return this.scored;
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }
}
