package HighSchool.Other;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class AverageImageSize {
    public static void main(String[] args) {
        File directory = new File("Images");
        File[] files = directory.listFiles();
        BufferedImage[] imgs = new  BufferedImage[files.length];
        for (int i = 0; i < imgs.length; i++) {
            try {
                imgs[i] = ImageIO.read(files[i]);
            }
            catch(Exception e) {
                System.out.println("Error at " + i);
            }
        }
        int totalWidth = 0;
        int totalHeight = 0;
        for (int i = 0; i < imgs.length; i++) {
            totalWidth += imgs[i].getWidth();
            totalHeight += imgs[i].getHeight();
            //System.out.println(imgs[i].getWidth() + "x" + imgs[i].getHeight());
        }
        System.out.println(totalWidth/imgs.length + "x" + totalHeight/imgs.length);
        //double ratio = (double) totalWidth/totalHeight;
        double ratio = 0.6512;
        System.out.println(100*ratio + "x" + 100);
        System.out.println(200*ratio + "x" + 200);
        System.out.println(300*ratio + "x" + 300);
        System.out.println(400*ratio + "x" + 400);
        System.out.println(500*ratio + "x" + 500);
        System.out.println(600*ratio + "x" + 600);
        System.out.println(700*ratio + "x" + 700);
        System.out.println(800*ratio + "x" + 800);

        System.out.println(100*(1/ratio) + "x" + 100);
        System.out.println(200*(1/ratio) + "x" + 200);
        System.out.println(300*(1/ratio) + "x" + 300);
        System.out.println(400*(1/ratio) + "x" + 400);
        System.out.println(500*(1/ratio) + "x" + 500);
        System.out.println(600*(1/ratio) + "x" + 600);
        System.out.println(700*(1/ratio) + "x" + 700);
        System.out.println(800*(1/ratio) + "x" + 800);
    }
}
