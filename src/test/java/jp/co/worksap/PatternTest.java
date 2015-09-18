package jp.co.worksap;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by zuozuo on 15/9/18.
 */
public class PatternTest {

    @Test
    public void testReadPattern() throws IOException {
        int[][] ws = Pattern.readPattern('w');
        System.out.println(Arrays.deepToString(ws));
    }
}
