package jp.co.worksap;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by zuozuo on 15/9/18.
 */
public class Pattern {

    private static final int UNIT = Program.IMAGE_UNIT;

    public static int[][] readPattern(final char c) {
        int[][] r = new int[UNIT][UNIT];
        char ch = Character.toUpperCase(c);
        InputStream pattern = Pattern.class.getClassLoader().getResourceAsStream("patterns/" + ch);
        List<String> strings = null;
        try {
            strings = IOUtils.readLines(pattern);
        } catch (IOException e) {
            System.out.println("no pattern for " + ch);
            System.exit(-1);
        }
        for (int i = 0; i < strings.size(); i++) {
            for ( int j = 0; j < UNIT; j++) {
                r[i][j] = strings.get(i).charAt(j) == '1'?1:0;
            }
        }
        return r;
    }
}
