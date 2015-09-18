package jp.co.worksap;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by zuozuo on 15/9/18.
 */
public class ImageRandomer {

    public static final String IMAGE_BASE = "images";

    private static List<File> images = new ArrayList<File>();

    static {
        try {
            // load all images
            File base = new File(IMAGE_BASE);
            if (!base.exists() || base.isFile()) {
                if (!base.mkdir()) {
                    throw new IOException("cannot create folder images");
                }
                FileUtils.moveFile(new File("sample.png"), new File(base, "sample.png"));
            }
            Collection<File> files = FileUtils.listFiles(base, new String[]{"jpg", "png"}, false);
            images.addAll(files);
            System.out.println("" + files.size() + " images loaded");
            if (images.size() == 0) {
                throw new IOException("no images loaded");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    private static int cursor = 0;

    public static File next() throws IOException {
        File f = images.get(cursor++);
        cursor = cursor % images.size();
        return f;
    }
}
