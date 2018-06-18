
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author concept
 */
public class toBinaryImage {
    
    BufferedImage image;
int width;
int height;
private final int threshold=127;

    toBinaryImage(String Original, String newFile)
    {
         try
    {
        
        File input=new File(Original);
        image=ImageIO.read(input);
        width=image.getWidth();
        height=image.getHeight();
        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
        int c=image.getRGB(i,j);
        int gray=(int)(c & 0xFF);
           
        if(gray < threshold)
            image.setRGB(i,j,0);
        else
            image.setRGB(i,j,255);
            }
        }
       String newFileName ="E:\\Image Processing\\Binary\\"+newFile +".jpg";
               File output=new File(newFileName);
        
        ImageIO.write(image,"jpg",output);
            
    }catch(Exception e){}
    }
    
}
