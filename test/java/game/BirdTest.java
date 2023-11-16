package test.java.game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BirdTest {
    private Bird bird;

    @Before
    public void setUp() {
        bird = new Bird(100, 300, 30, 30);
    }

    @Test
    public void testJump() {
        float initialY = bird.getY();
        bird.jump();
        bird.update();
        assertTrue("Bird should move up when jumping", bird.getY() < initialY);
    }

    @Test
    public void testGravityEffect() {
        float initialY = bird.getY();
        bird.update();
        assertTrue("Bird should fall due to gravity", bird.getY() > initialY);
    }
}
