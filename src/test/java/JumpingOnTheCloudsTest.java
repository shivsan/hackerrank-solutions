import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class JumpingOnTheCloudsTest {

    @Test
    public void shouldFindShortestPath() {
        int[] c = {0, 1, 0, 0, 1, 0};

        int result = JumpingOnTheClouds.shortest(c, c.length - 1);

        assertEquals(result, 3);
    }
}