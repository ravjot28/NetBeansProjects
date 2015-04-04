import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class GIFToJPG
{
public static void main(String a[])
{
  try{
  System.out.println("Enter image name\n");
  BufferedReader bf=new BufferedReader(new
 InputStreamReader(System.in));
  String imageName=bf.readLine();
  File input = new File(imageName);
  BufferedImage image = ImageIO.read(input);
  System.out.println("Enter the output image name(.jpg):\n");
  String imageName1=bf.readLine();
  File output = new File(imageName1);
  ImageIO.write(image, "jpg", output);
  System.out.println("Your image has been converted successfully");
}catch(FileNotFoundException e){
  System.out.println("Error:"+e.getMessage());
}catch(IOException e)
  {
  System.out.println("Error:"+e.getMessage());
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

}
}