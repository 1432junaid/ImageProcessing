/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author concept
 */
public class toGrayScale {

BufferedImage image;
int width;
int height;

toGrayScale(String original, String newFileName)
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
        int red=(int)(c.getRed()*.299);
        int green=(int)(c.getGreen()*.587);
        int blue=(int)(c.getBlue()*.114);
        Color newColor=new Color(red+green+blue,red+green+blue,red+green+blue);
           
            image.setRGB(j,i,newColor.getRGB());
            }
        }
        String newFile="E:\\Image Processing\\Greyscale\\"+newFileName+".jpg";
               File output=new File(newFile);
        
        ImageIO.write(image,"jpeg",output);  

        saveToDB(newFile,(int)output.length());
    }catch(Exception ex){System.err.println(""+ex);}
}


private void saveToDB(String fileName, int size) throws Exception
{
    DBConnect dbc=new DBConnect();
    dbc.setDataGS(fileName, size);
}

}  