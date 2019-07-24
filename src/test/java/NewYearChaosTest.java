import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

        assertEquals("Too chaotic", outContent.toString());
    }

    @Test
    public void shouldComputeProperOutputForDoubleBribes() {
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

        NewYearChaos.minimumBribes(q);

        assertEquals("7", outContent.toString());
    }

    @Test
    public void shouldDoInsertionSortBetweenIndices() {
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

        NewYearChaos.insertion(q, 1, 4);

        int[] expected = {1, 7, 2, 5, 3, 8, 6, 4};

        assertThat(q, is(expected));
    }

    @Test
    public void shouldFindNum() {
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

        final int num = NewYearChaos.findNum(q, 4);

        assertEquals(7, num);
    }


    @Test
    public void shouldGetNumberOfBribesForSimplerSum() {
        int[] q = {2, 1, 5, 3, 4};

        NewYearChaos.minimumBribesSimpler(q);

        assertEquals("3", outContent.toString());
    }

    @Test
    public void shouldThrowTooChaoticMessageForSimpler() {
        int[] q = {2, 5, 1, 3, 4};

        NewYearChaos.minimumBribesSimpler(q);

        assertEquals("Too chaotic\n", outContent.toString());
    }

    @Test
    public void shouldComputeProperOutputForDoubleBribesForSimpler() {
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

        NewYearChaos.minimumBribesSimpler(q);

        assertEquals("7", outContent.toString());
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}