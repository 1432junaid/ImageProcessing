
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author concept
 */
public class RemoveNoise {
    BufferedImage image;
int width;
int height;

RemoveNoise (String original, String newFileName)
{
    try
    {
        
        File input=new File(original);
        image=ImageIO.read(input);
        width=image.getWidth();
        height=image.getHeight();
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
        Color c=new Color(image.getRGB(j, i));
        int red=(int)(c.getRed());
        int green=(int)(c.getGreen());
        int blue=(int)(c.getBlue());
            Color newColor=new Color(0,0,0);
       if( red < 162 && green < 162 && blue < 162)
            image.setRGB(j,i,newColor.getRGB());
            }
        }
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
        Color c=new Color(image.getRGB(j, i));
        int red=(int)(c.getRed());
        int green=(int)(c.getGreen());
        int blue=(int)(c.getBlue());
            Color newColor=new Color(255,255,255);
       if( red < 162 && green < 162 && blue < 162)
            image.setRGB(j,i,newColor.getRGB());
            }
        }
        String newFile="E:\\Image Processing\\Noise_reduced\\"+newFileName+".jpg";
               File output=new File(newFile);
        
        ImageIO.write(image,"jpeg",output);  

    }catch(Exception ex){System.err.println(""+ex);}
}

    
}
