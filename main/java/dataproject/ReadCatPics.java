package main.java.dataproject;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * Created by mait on 2/6/18.
 */
public class ReadCatPics {
  List<Image> imageCollection = new ArrayList<Image>();
  public ReadCatPics() {
    imageCollection = lookPicsFromFolder();
  }
  public List lookPicsFromFolder(){
    File path = new File("/vnx1/home/mait/IdeaProjects/dataproject/CatPics");
    try{
      File [] files = path.listFiles();
    for(int i =0; i <files.length; i++){
      if(files[i].isFile()){
        BufferedImage imageRead = ImageIO.read(files[i]);
        Image image = SwingFXUtils.toFXImage(imageRead, null);
        imageCollection.add(image);
      }
    }
  } catch (
  IOException e) {
    e.printStackTrace();
  }
  return imageCollection;
  }

public List<Image> getImageCollection() {
return imageCollection;
  }
}