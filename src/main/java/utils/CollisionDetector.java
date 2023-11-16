package main.java.utils;
import java.awt.Rectangle;
import java.util.List;

public class CollisionDetector {

    public static boolean checkBirdCollision(Bird bird, List<Pipe> pipes) {
        Rectangle birdBounds = bird.getBounds();

        for (Pipe pipe : pipes) {
            if (birdBounds.intersects(pipe.getBounds())) {
                return true; // Collision detected
            }
        }

        // Check if the bird hits the ground or goes off the screen
        if (bird.getY() + bird.getHeight() >= Constants.SCREEN_HEIGHT || bird.getY() <= 0) {
            return true; // Ground collision detected
        }

        return false; // No collision
    }
}
