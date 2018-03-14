package main.java.dataproject;


import com.sun.xml.internal.ws.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.LinkedHashSet;

import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

/**
 * Created by mait on 1/18/18.
 */
public class ReadFileToObject {

  private static ArrayList<Cat> catsList = new ArrayList<>();
  ReadCatPics readCatPics = new ReadCatPics();

  public ReadFileToObject() {

    String file = "/vnx1/home/mait/IdeaProjects/dataproject/src/dataproject/project-data.txt";
    try (
        BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
      String line;
      int count = 0;
      while ((line = br.readLine()) != null) {
        if (line.contains("Date:")) {

          String date = line.split(":")[1];
          String name = br.readLine().split(":")[1];
          String company = br.readLine().split(":")[1];
          String color = br.readLine().split(":")[1];
          date = StringUtils.capitalize(date);
          name = StringUtils.capitalize(name);
          company = StringUtils.capitalize(company);
          color = StringUtils.capitalize(color);
          Image image = readCatPics.getImageCollection().get(count);
          count++;
          catsList.add(new Cat(date, name, company, color, image));
        }

      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
  }


  public ObservableList<Cat> getCatList() {
    ObservableList<Cat> catList = FXCollections.observableList(catsList);
    return catList;
  }

  public Set getColorList() {
    ArrayList<String> catsColors = new ArrayList<>();
    String trimColor = "Color:";
    catsColors.add("All");
    for (int i = 0; i < catsList.size(); i++) {
      catsColors.add(catsList.get(i).getColor());
    }
    Set<String> colorList = new LinkedHashSet<String>(catsColors);
    return colorList;
  }

  public Cat randomCat(){
    Random r = new Random();
    int Low = 0;
    int High = readCatPics.getImageCollection().size();
    int result = r.nextInt(High-Low) + Low;
    Cat cat = getCatList().get(result);
    return cat;
  }
  public static void main(String[] args) {
    new ReadFileToObject();
  }

  public Image catAPI() {
    Image image = null;
    try {
      URL url = new URL("http://thecatapi.com/api/images/get?");
      image = new Image(url.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }
  public Image catGIFAPI() {
    Image image = null;
    try {
      URL url = new URL("http://thecatapi.com/api/images/get?format=src&type=gif");
      image = new Image(url.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }
}




