package HighSchool.Other;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.Arrays;

public class TylerFont {
    //private BufferedImage fullSheet;
    //private BufferedImage fullSheet1;
    private BufferedImage[][] preFont;
    private BufferedImage[][] postFont;
    private String folder;
    private String[] folderNames;

    public TylerFont(String phrase) {
        folderNames = "a b c d e f g h i j k l m n o p q r s t u v w x y z _A _B _C _D _E _F _G _H _I _J _K _L _M _N _O _P _Q _R _S _T _U _V _W _X _Y _Z 0 1 2 3 4 5 6 7 8 9 ! @ # $ % ^ & AK ( ) - = [ ] BS ; SQ , PD FS ~ _ + { } SS CO DQ LT GT QM".split(" ");
        folder = "letters";
        preFont = new BufferedImage[folderNames.length][19];
        postFont = new BufferedImage[folderNames.length][19];
        try {
            for (int i = 0; i < folderNames.length; i++) {
                for (int j = 0; j < 19; j++) {
                    preFont[i][j] = ImageIO.read(new File("letters\\" + folderNames[i] + "\\" + folderNames[i] + j + ".png"));
                }
            }
        }
        catch(Exception e) {
            System.out.println("ERROR");
        }

        /*BufferedImage subimage;
        BufferedImage subimage2;
        //String[] folderNames = "DQ LT GT QM".split(" ");
        for(int j = 0; j < 15; j++) {
            for (int i = 0; i < 19; i++) {
                /*subimage = fullSheet1.getSubimage(76 + 63 * i - (j/2) - i/4, 14 + j * 62 + (i/2), 63, 60);
                //System.out.println(j + ":" + i);
                File f = new File("letters\\" + folderNames[j] + "\\" + folderNames[j] + i + ".png");
                try {
                    ImageIO.write(subimage, "png", f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    subimage2 = ImageIO.read(new File("letters\\" + folderNames[j] + "\\" + folderNames[j] + i + ".png"));
                    tempFont[j][i] = subimage2;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //fontUniformer();
        }*/
        fontUniformer();
        fontResizer();
    }

    private void fontUniformer() {
        for (int i = 0; i < folderNames.length; i++) {
            for (int j = 0; j < 19; j++) {
                BufferedImage image = preFont[i][j];
                BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

                final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
                final int width = image.getWidth();
                final int height = image.getHeight();
                final boolean hasAlphaChannel = image.getAlphaRaster() != null;

                final int pixelLength = 4;
                for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                    int r = 0;
                    int g = 0;
                    int b = 0;
                    int a;
                    a = ((int) pixels[pixel] & 0xff);
                    b = ((int) pixels[pixel + 1] & 0xff); // blue
                    g = ((int) pixels[pixel + 2] & 0xff); // green
                    r = ((int) pixels[pixel + 3] & 0xff); // red

                    Color c = new Color(r, g, b, a);
                    int rgb = r > 236 ? -1 : -16777216;
                    img.setRGB(col, row, rgb);
                    /*if (r > 236) {
                        System.out.print(" ");
                    } else {
                        System.out.print("X");
                    }*/
                    col++;
                    if (col == width) {
                        col = 0;
                        row++;
                        //System.out.println();
                    }
                }
                postFont[i][j] = img;
            }
        }
    }

    private void fontResizer() {
        for (int i = 0; i < folderNames.length; i++) {
            for (int j = 0; j < 19; j++) {
                BufferedImage image = preFont[i][j];
                BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

                final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
                final int width = image.getWidth();
                final int height = image.getHeight();
                final boolean hasAlphaChannel = image.getAlphaRaster() != null;
                int xmin = width;
                int xmax = 0;
                int ymin = height;
                int ymax = 0;

                final int pixelLength = 4;
                for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                    int r = 0;
                    int g = 0;
                    int b = 0;
                    int a;
                    a = ((int) pixels[pixel] & 0xff);
                    b = ((int) pixels[pixel + 1] & 0xff); // blue
                    g = ((int) pixels[pixel + 2] & 0xff); // green
                    r = ((int) pixels[pixel + 3] & 0xff); // red

                    Color c = new Color(r, g, b, a);
                    int rgb = r > 236 ? -1 : -16777216;

                    if(rgb != -1) {
                        if(col < xmin) xmin = col;
                        if(col > xmax) xmax = col;
                        if(row < ymin) ymin = row;
                        if(row > ymax) ymax = row;
                    }

                    img.setRGB(col, row, rgb);
                    col++;
                    if (col == width) {
                        col = 0;
                        row++;
                    }
                }
                BufferedImage resized = new BufferedImage(xmax - xmin, ymax - ymin,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g = resized.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(img, 0, 0, xmax - xmin, ymax - ymin, xmin, ymin, xmax,
                        ymax, null);
                g.dispose();
                postFont[i][j] = resized;
            }
        }
    }

    public void drawCharacter(Graphics2D g2, int index1, int index2, int x, int y, JPanel panel) {
        g2.drawImage(postFont[index1][index2], x, y, panel);
    }

    public BufferedImage[][] getPostFont() {
        return postFont;
    }

    public int getIndexFromFolder(String folderName) {
        return Arrays.asList(folderNames).indexOf(folderName);
    }
}
