package test.java.game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PipeTest {
    private Pipe pipe;

    @Before
    public void setUp() {
        pipe = new Pipe(800, 0, 50, 200);
    }

    @Test
    public void testPipeMovement() {
        int initialX = pipe.getX();
        pipe.update();
        assertTrue("Pipe should move left", pipe.getX() < initialX);
    }

    @Test
    public void testScoringFlag() {
        assertFalse("New pipe should not be scored", pipe.isScored());
        pipe.setScored(true);
        assertTrue("Pipe should be marked as scored", pipe.isScored());
    }
}
