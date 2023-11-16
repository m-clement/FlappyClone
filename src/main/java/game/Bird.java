package main.java.game;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird {
    private float x, y;
    private int width, height;
    private float velocity;
    private float gravity = 0.5f;

    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.velocity = 0;
        this.width = width;
        this.height = height;
    }

    public void update() {
        // Apply gravity to the bird's velocity
        velocity += gravity;
        y += velocity;

        // Prevent the bird from falling off the screen
        if (y > 600 - height) {
            y = 600 - height;
            velocity = 0;
        }
    }

    public void jump() {
        velocity = -10;
    }

    public void render(Graphics g) {
        // Draw the bird
        g.fillRect((int)x, (int)y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
