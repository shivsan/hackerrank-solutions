import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RepeatedStringTest {

    @Test
    @Parameters({"abcac, 10, 4",
                 "a, 1000000000000, 1000000000000"})
    public void getRepeatedA(String s, long n, long expected) {

        long result = RepeatedString.repeatedString(s, n);

        assertEquals(result, expected);
    }

}