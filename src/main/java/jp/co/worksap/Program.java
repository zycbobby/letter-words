package jp.co.worksap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zuozuo on 15/9/18.
 */
public class Program {

    public static final int IMAGE_PIXEL_HEIGHT = 32;
    public static final int IMAGE_PIXEL_WIDTH = 42;

    public static final int IMAGE_UNIT = 9;

    public static final String OUTPUT = "output";

    public static void main(String[] args) throws IOException {

        String words = args.length > 0 ? args[0]:"WAPATESH$";
        System.out.println("WORD: " + words);

        File file = new File(OUTPUT);
        if (!file.exists() || file.isFile()) {
            if (!file.mkdir()) {
                System.exit(-1);
            }
        }

        int w = IMAGE_PIXEL_WIDTH * IMAGE_UNIT;
        int h = IMAGE_PIXEL_HEIGHT * IMAGE_UNIT;
        char[] chars = words.toCharArray();
        for (int k = 0; k < chars.length; k++) {
            char c = chars[k];
            int[][] ws = Pattern.readPattern(c);
            BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            for (int i = 0; i < ws.length; i++) {
                for(int j = 0; j < ws[i].length; j++) {
                    if (ws[i][j] == 1) {
                        Graphics g = combined.getGraphics();
                        BufferedImage image = ImageIO.read(ImageRandomer.next());
                        g.drawImage(image, j * IMAGE_PIXEL_WIDTH, i * IMAGE_PIXEL_HEIGHT, IMAGE_PIXEL_WIDTH, IMAGE_PIXEL_HEIGHT, null);
                    }
                }
            }
            ImageIO.write(combined, "PNG", new File( OUTPUT, "0" + k + "_" + c + ".png"));
        }
    }
}
