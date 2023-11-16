package main.java.game;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    private Thread thread;
    private boolean running;
    private Bird bird;
    private ArrayList<Pipe> pipes;
    private Random rand;
    private int score;

    public GamePanel() {
        setFocusable(true);
        bird = new Bird(100, 300, 30, 30);
        pipes = new ArrayList<>();
        rand = new Random();
        score = 0;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bird.jump();
                }
            }
        });
        start();
    }

    private void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (running) {
            update();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        bird.update();
        managePipes();
        checkCollisions();
    }

    private void managePipes() {
        // Pipe generation and movement logic
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.update();

            // Remove pipes that are off the screen
            if (pipe.getX() + pipe.getWidth() < 0) {
                pipes.remove(pipe);
                i--;
            }

            // Increment score
            if (!pipe.isScored() && pipe.getX() < bird.getX()) {
                score++;
                pipe.setScored(true);
            }
        }

        // Add new pipes
        if (pipes.size() < 5) {
            int height = 200 + rand.nextInt(200);
            pipes.add(new Pipe(800, 0, 50, height));
            pipes.add(new Pipe(800, height + 100, 50, 600 - height - 100));
        }
    }

    private void checkCollisions() {
        // Collision logic
        for (Pipe pipe : pipes) {
            if (pipe.getBounds().intersects(bird.getBounds())) {
                running = false; // End the game
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Drawing the game
        bird.render(g);
        for (Pipe pipe : pipes) {
            pipe.render(g);
        }

        // Draw the score
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 20, 20);
    }
}
