import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class NewYearChaosTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldGetNumberOfBribes() {
        int[] q = {2, 1, 5, 3, 4};

        NewYearChaos.minimumBribes(q);

        assertEquals("3", outContent.toString());

    }

    @Test
    public void shouldThrowTooChaoticMessage() {
        int[] q = {2, 5, 1, 3, 4};

        NewYearChaos.minimumBribes(q);

        assertEquals("7", outContent.toString());
    }

    @Test
    public void shouldComputeProperOutputForDoubleBribes() {
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

        NewYearChaos.minimumBribes(q);

        assertEquals("Too chaotic", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}