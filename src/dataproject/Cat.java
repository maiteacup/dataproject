package dataproject;

import com.sun.xml.internal.ws.util.StringUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 * Created by mait on 1/18/18.
 */

public class Cat {

  private SimpleStringProperty date;
  private SimpleStringProperty name;
  private SimpleStringProperty company;
  private SimpleStringProperty color;
  private Image image;

  public Cat(String date, String name, String company, String color, Image image) {
    this.date = new SimpleStringProperty(date);
    this.name = new SimpleStringProperty(name);
    this.company = new SimpleStringProperty(company);
    this.color = new SimpleStringProperty(color);
    this.image = image;

  }


  public String getDate() {
    String date = this.date.get();

    return date;
  }


  public String getName() {
    String name = this.name.get();

    return name;
  }


  public String getCompany() {
    String company = this.company.get();

    return company;
  }


  public String getColor() {
    String color = this.color.get();

    return color;
  }

  public Image getImage() {
    return this.image;
  }

  public String toString() {
    return ("Meow" + "\n" + this.getDate() + "\n" + this.getName() + "\n" + this.getCompany() + "\n" + this.getColor()
            + "\n");
  }

}
