import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

//Mr. Uhl
//Program description: For use with the Picture Lab
//Nov 28, 2017
/*
public class Picture
{
   private BufferedImage pic;
   private Pixel[][] pix;
   
   public Picture(String filename)
   {
    //LOAD IMAGE AS A BUFFERED IMAGE
      File f = new File("src/"+filename);
         try{
            pic = ImageIO.read(f);
//            pic = ImageIO.read(Picture.class.getResource(filename));
         } catch (IOException e){System.out.println("FILE NOT FOUND!");e.printStackTrace();}
         catch (IllegalArgumentException e){System.out.println("FILE ISSUE... " + filename);e.printStackTrace();}

         pix = getPixels2D(pic);
   }
   
   public static Pixel[][] getPixels2D(BufferedImage image)
   {
      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
      final int width = image.getWidth();
      final int height = image.getHeight();
      final boolean hasAlphaChannel = image.getAlphaRaster() != null;

      Pixel[][] result = new Pixel[height][width];
      if (hasAlphaChannel) {
         final int pixelLength = 4;
         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
            int r = 0; int g = 0; int b = 0; int a = 0;
            a = (((int) pixels[pixel] & 0xff)); // alpha
            b = ((int) pixels[pixel + 1] & 0xff); // blue
            g = (((int) pixels[pixel + 2] & 0xff)); // green
            r = (((int) pixels[pixel + 3] & 0xff)); // red
            result[row][col] = new Pixel(r, g, b, a);
            col++;
            if (col == width) {
               col = 0;
               row++;
            }
         }
      } else {
         final int pixelLength = 3;
         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
            int r = 0; int g = 0; int b = 0; int a;
            a = 255;//-16777216; // 255 alpha
            b = ((int) pixels[pixel] & 0xff); // blue
            g = (((int) pixels[pixel + 1] & 0xff)); // green
            r = (((int) pixels[pixel + 2] & 0xff)); // red
            result[row][col] = new Pixel(r, g, b, a);
            col++;
            if (col == width) {
               col = 0;
               row++;
            }
         }
      }
      
      return result;
   }
   
   public void drawPixels(Graphics2D g2, int x, int y)
   {
      for(int r = 0; r < pix.length; r++)
         for(int c = 0; c < pix[r].length; c++)
         {
            g2.setColor(pix[r][c].getColor());
            g2.drawLine(c+x, r+y, c+x, r+y);
         }
   }
   
   public int getWidth()
   {
      return pix[0].length;
   }
   
   public int getHeight()
   {
      return pix.length;
   }
   
   public void restore()
   {
      pix = getPixels2D(pic);
   }
   
   public Pixel getPixel(int row, int col)
   {
      return pix[row][col];
   }
   
   //ALL THE METHODS BELOW SHOULD BE WRITTEN AS PART OF THE PICTURE LAB
   
   public void savePic()
   {
      String filename = JOptionPane.showInputDialog("Enter the filename to save as:");
      filename += ".png";
      try{
         int width = pix[0].length;
         int height = pix.length;
         System.out.println(width + ", " + height);
         BufferedImage img = new BufferedImage( 
            width, height, BufferedImage.TYPE_INT_RGB);

         File f = new File(filename);

         for(int x = 0; x < height; x++){
            for(int y = 0; y < width; y++){
               int rgb = pix[x][y].getColor().getRGB();
               img.setRGB(y, x, rgb);
            }
         }
         ImageIO.write(img, "png", f);
      }
      catch(Exception ex){ex.printStackTrace();}
   }
   
   //This version checks horizontally and vertically at once
   public void myEdger(int edgeDist)
   {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel bottomPixel = null;
      Color rightColor = null;
      Color bottomColor = null;
      
      for (int row = 0; row < pix.length; row++)
      {
         for (int col = 0; col < pix[0].length; col++)
         {
            if((row!=0 && row!=pix.length-1 && col!=0 && col!=pix[0].length-1))
            {
               leftPixel = pix[row][col];
               rightPixel = pix[row][col+1];
               bottomPixel = pix[row+1][col];
               rightColor = rightPixel.getColor();
               bottomColor = bottomPixel.getColor();
               if (leftPixel.colorDistance(rightColor) > edgeDist
                     || leftPixel.colorDistance(bottomColor) > edgeDist)
                  leftPixel.setColor(0, 0, 0);
               else
                  leftPixel.setColor(255, 255, 255);
            }
            else pix[row][col].setColor(255, 255, 255);
         }
      }
   }
   
   //This version checks horizontally and vertically at once
   public void betterEdger(int edgeDist)
   {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel bottomPixel = null;
      Color rightColor = null;
      Color bottomColor = null;
      Pixel previousLeft = null;
      Pixel previousTop = null;
      
      for (int row = 0; row < pix.length; row++)
      {
         for (int col = 0; col < pix[0].length; col++)
         {
            if((row!=0 && row!=pix.length-1 && col!=0 && col!=pix[0].length-1))
            {
               previousLeft = pix[row][col-1];
               previousTop = pix[row-1][col];
               leftPixel = pix[row][col];
               rightPixel = pix[row][col+1];
               bottomPixel = pix[row+1][col];
               rightColor = rightPixel.getColor();
               bottomColor = bottomPixel.getColor();
               if ((leftPixel.colorDistance(rightColor) > edgeDist
                     || leftPixel.colorDistance(bottomColor) > edgeDist)
                     && previousLeft.colorDistance(Color.BLACK) > 1
//                     && previousLeft.getRed()!=0 && previousLeft.getGreen()!=0 && previousLeft.getBlue()!=0
//                     && previousTop.getRed()!=0 && previousTop.getGreen()!=0 && previousTop.getBlue()!=0
                     )
                  leftPixel.setColor(0, 0, 0);
               else
                  leftPixel.setColor(255, 255, 255);
            }
            else pix[row][col].setColor(255, 255, 255);
         }
      }
   }

   public void photoNegative()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            pix[r][c].setNegative();
   }
   
   public void zeroRed()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            pix[r][c].setRed(0);
   }
   
   public void zeroGreen()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            pix[r][c].setGreen(0);
   }
   
   public void zeroBlue()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            pix[r][c].setBlue(0);
   }
   
   public void grayscale()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            pix[r][c].setToGray();
   }
   
   public void mirrorLeftToRight()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length / 2; c++)
            pix[r][pix[0].length-1-c].setColor(pix[r][c].getColor());
   }
   
   public void mirrorRightToLeft()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length / 2; c++)
            pix[r][c].setColor(pix[r][pix[0].length-1-c].getColor());
   }
   
   public void mirrorTopToBottom()
   {
      for (int r = 0; r < pix.length / 2; r++)
         for (int c = 0; c < pix[0].length; c++)
            pix[pix.length-1-r][c].setColor(pix[r][c].getColor());
   }
   
   public void mirrorBottomToTop()
   {
      for (int r = 0; r < pix.length / 2; r++)
         for (int c = 0; c < pix[0].length; c++)
            pix[r][c].setColor(pix[pix.length-1-r][c].getColor());
   }
   
   public void decodeUsingRed()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            if(pix[r][c].getRed() % 2 == 1)
               pix[r][c].setColor(Color.BLACK);
            else
               pix[r][c].setColor(Color.WHITE);
   }
   
   public void decodeUsingGreen()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            if(pix[r][c].getGreen() % 2 == 1)
               pix[r][c].setColor(Color.BLACK);
            else
               pix[r][c].setColor(Color.WHITE);
   }
   
   public void decodeUsingBlue()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            if(pix[r][c].getBlue() % 2 == 1)
               pix[r][c].setColor(Color.BLACK);
            else
               pix[r][c].setColor(Color.WHITE);
   }
   
   public void encodeUsingRed(Picture message)
   {
      //Set all red values to even
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            if(pix[r][c].getRed() % 2 == 1)
               pix[r][c].setRed(pix[r][c].getRed() - 1);
      //Encode the message
      for (int r = 0; r < message.getHeight(); r++)
         for (int c = 0; c < message.getWidth(); c++)
            if(message.getPixel(r, c).colorDistance(Color.WHITE) > 150)
               pix[r][c].setRed(pix[r][c].getRed() + 1);
   }
   
   public void encodeUsingGreen(Picture message)
   {
      //Set all green values to even
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            if(pix[r][c].getGreen() % 2 == 1)
               pix[r][c].setGreen(pix[r][c].getGreen() - 1);
      //Encode the message
      for (int r = 0; r < message.getHeight(); r++)
         for (int c = 0; c < message.getWidth(); c++)
            if(message.getPixel(r, c).colorDistance(Color.WHITE) > 150)
               pix[r][c].setGreen(pix[r][c].getGreen() + 1);
   }
   
   public void encodeUsingBlue(Picture message)
   {
      //Set all blue values to even
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++)
            if(pix[r][c].getBlue() % 2 == 1)
               pix[r][c].setBlue(pix[r][c].getBlue() - 1);
      //Encode the message
      for (int r = 0; r < message.getHeight(); r++)
         for (int c = 0; c < message.getWidth(); c++)
            if(message.getPixel(r, c).colorDistance(Color.WHITE) > 150)
               pix[r][c].setBlue(pix[r][c].getBlue() + 1);
   }
   
   public void encodeUsingShades(Picture message)
   {
      //Set all color values to even
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++){
            if(pix[r][c].getRed() % 2 == 1)
               pix[r][c].setRed(pix[r][c].getRed() - 1);
            if(pix[r][c].getGreen() % 2 == 1)
               pix[r][c].setGreen(pix[r][c].getGreen() - 1);
            if(pix[r][c].getBlue() % 2 == 1)
               pix[r][c].setBlue(pix[r][c].getBlue() - 1);
         }
      //Encode the message
      for (int r = 0; r < message.getHeight(); r++)
         for (int c = 0; c < message.getWidth(); c++){
            if(message.getPixel(r, c).colorDistance(Color.WHITE) > 230)
               pix[r][c].setBlue(pix[r][c].getBlue() + 1);
            else if(message.getPixel(r, c).colorDistance(Color.WHITE) > 160)
               pix[r][c].setGreen(pix[r][c].getGreen() + 1);
            else if(message.getPixel(r, c).colorDistance(Color.WHITE) > 110)
               pix[r][c].setRed(pix[r][c].getRed() + 1);
         }
   }
   
   public void decodeUsingShades()
   {
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++){
            if(pix[r][c].getRed() % 2 == 1)
               pix[r][c].setColor(new Color(220, 220, 220));
            else if(pix[r][c].getGreen() % 2 == 1)
               pix[r][c].setColor(new Color(160, 160, 160));
            else if(pix[r][c].getBlue() % 2 == 1)
               pix[r][c].setColor(new Color(120, 120, 120));
            else
               pix[r][c].setColor(Color.WHITE);
         }
   }
   
   public void newBlur(int dist)
   {//This averages the original pixel with the average of the surrounding values
      for (int r = dist; r < pix.length-dist; r++)
         for (int c = dist; c < pix[0].length-dist; c++){
            pix[r][c].setRed((pix[r][c].getRed()+blurOnePixel(r, c, dist).getRed())/2);
            pix[r][c].setGreen((pix[r][c].getGreen()+blurOnePixel(r, c, dist).getGreen())/2);
            pix[r][c].setBlue((pix[r][c].getBlue()+blurOnePixel(r, c, dist).getBlue())/2);
         }
   }

   public void oldBlur(int dist)
   {
      for (int r = dist; r < pix.length-dist; r++)
         for (int c = dist; c < pix[0].length-dist; c++){
            pix[r][c].setColor(blurOnePixel(r, c, dist));
         }
   }
   
   public void newerBlur(int dist)
   {//this version uses a temporary array to average only the original values 
      Pixel[][] temp = new Pixel[pix.length][pix[0].length];
      for (int r = 0; r < pix.length; r++)
         for (int c = 0; c < pix[0].length; c++){
            temp[r][c] = new Pixel(0, 0, 0);
            temp[r][c].setColor(betterBlurOnePixel(r, c, dist));
         }
      pix = temp;
   }
   
   public Color betterBlurOnePixel(int r, int c, int dist)
   {//blur is accomplished by averaging the red, green and blue of a pixel block
    //this version goes to the edges of the image
      int sumR = 0; int sumG = 0; int sumB = 0;
      int count = 0;
      for(int i = r-dist; i <= r+dist; i++){
         for(int j = c-dist; j <= c+dist; j++){
            if((i>=0 && i<pix.length) && (j>=0 && j<pix[0].length)){
               sumR += pix[i][j].getRed();
               sumG += pix[i][j].getGreen();
               sumB += pix[i][j].getBlue();
               count++;
            }
         }
      }
      
      int avgR = sumR / count;
      int avgG = sumG / count;
      int avgB = sumB / count;
      
      return new Color(avgR, avgG, avgB);
   }

   
   public Color blurOnePixel(int r, int c, int dist)
   {//blur is accomplished by averaging the red, green and blue of a pixel block
      int sumR = 0; int sumG = 0; int sumB = 0;
      for(int i = r-dist; i <= r+dist; i++)
         for(int j = c-dist; j <= c+dist; j++){
            sumR += pix[i][j].getRed();
            sumG += pix[i][j].getGreen();
            sumB += pix[i][j].getBlue();
         }
      int avgR = sumR / ((2*dist+1)*(2*dist+1));
      int avgG = sumG / ((2*dist+1)*(2*dist+1));
      int avgB = sumB / ((2*dist+1)*(2*dist+1));
      
      return new Color(avgR, avgG, avgB);
   }
   
   public void createASCII(int edgeDist)
   {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel bottomPixel = null;
      Color rightColor = null;
      Color bottomColor = null;
      Pixel previousLeft = null;
      Pixel previousTop = null;
      
      for (int row = 0; row < pix.length; row++)
      {
         for (int col = 0; col < pix[0].length; col++)
         {
            if((row!=0 && row!=pix.length-1 && col!=0 && col!=pix[0].length-1))
            {
               previousLeft = pix[row][col-1];
               previousTop = pix[row-1][col];
               leftPixel = pix[row][col];
               rightPixel = pix[row][col+1];
               bottomPixel = pix[row+1][col];
               rightColor = rightPixel.getColor();
               bottomColor = bottomPixel.getColor();
               if ((leftPixel.colorDistance(rightColor) > edgeDist
                     || leftPixel.colorDistance(bottomColor) > edgeDist)
                     && previousLeft.colorDistance(Color.BLACK) > 1
//                     && previousLeft.getRed()!=0 && previousLeft.getGreen()!=0 && previousLeft.getBlue()!=0
//                     && previousTop.getRed()!=0 && previousTop.getGreen()!=0 && previousTop.getBlue()!=0
                     )
                  System.out.print("* ");
               else
                  System.out.print("  ");
            }
//            else pix[row][col].setColor(255, 255, 255);
         }
         System.out.println();
      }
   }
   
//   public void emboss()
//   {      
//      double filter[][] =
//         {
////EMBOSS               
////            {-1,  0, 0},
////            { 0,  1, 0},
////            { 0,  0, 0}
////Find Edges... contour
////               {-1,  -1, -1},
////               { -1,  8, -1},
////               { -1,  -1, -1}//bias = 256;
////Awesome emboss
////               {-1, -1, -1, -1,  0},
////               {-1, -1, -1,  0,  1},
////               {-1, -1,  0,  1,  1},
////               {-1,  0,  1,  1,  1},
////               { 0,  1,  1,  1,  1}//factor = 1.0; bias = 128;
////motion blur
////               {1, 0, 0, 0, 0, 0, 0, 0, 0},
////               {0, 1, 0, 0, 0, 0, 0, 0, 0},
////               {0, 0, 1, 0, 0, 0, 0, 0, 0},
////               {0, 0, 0, 1, 0, 0, 0, 0, 0},
////               {0, 0, 0, 0, 1, 0, 0, 0, 0},
////               {0, 0, 0, 0, 0, 1, 0, 0, 0},
////               {0, 0, 0, 0, 0, 0, 1, 0, 0},
////               {0, 0, 0, 0, 0, 0, 0, 0, 1},
////               {0, 0, 0, 0, 0, 0, 0, 0, 1},//factor = 1.0 / 9.0; bias = 0;
////Blur
////            {0,   0.2,   0},
////            {0.2, 0.2, 0.2},
////            { 0,  0.2, 0}
//               
//            {-1,  0, 0},
//            {0, 1, 0},
//            {0,  0, 0}
//            
//         
//         };
//      
//      int filterHeight = 3;
//      int filterWidth = 3;
//      double factor = 1.0;
//      double bias = 128;
//      
//      Pixel[][] temp = new Pixel[pix.length][pix[0].length];
//      for (int r = 0; r < pix.length; r++)
//         for (int c = 0; c < pix[0].length; c++){
//            temp[r][c] = new Pixel(pix[r][c].getRed(), pix[r][c].getGreen(), pix[r][c].getBlue());
//         }
//      
//      for (int row = 2; row < pix.length; row++)
//      {
//         for (int col = 0; col < pix[0].length-2; col++)
//         {
//            double red = 0.0, green = 0.0, blue = 0.0;
//
//            //multiply every value of the filter with corresponding image pixel
//            for(int filterY = 0; filterY < filterHeight; filterY++)
//               for(int filterX = 0; filterX < filterWidth; filterX++)
//               {
////                 int imageX = (col - filterWidth / 2 + filterX + pix[0].length) % pix[0].length;
////                 int imageY = (row - filterHeight / 2 + filterY + pix.length) % pix.length;
//                 int imageX = col + filterX;
//                 int imageY = row - filterY;
////                 System.out.println("("+imageY+", "+imageX+")");
//                 red   += pix[imageY][imageX].getRed() * filter[filterY][filterX];
//                 green += pix[imageY][imageX].getGreen() * filter[filterY][filterX];
//                 blue  += pix[imageY][imageX].getBlue() * filter[filterY][filterX];
//               }
////            Scanner s = new Scanner(System.in);
////            String pause = s.nextLine();
//            //truncate values smaller than zero and larger than 255
//            temp[row][col].setRed(Math.min(Math.max((int)(factor * red + bias), 0), 255));
//            temp[row][col].setGreen(Math.min(Math.max((int)(factor * green + bias), 0), 255));
//            temp[row][col].setBlue(Math.min(Math.max((int)(factor * blue + bias), 0), 255));
//         }
//      }
//      pix = temp;
//   }
}
*/