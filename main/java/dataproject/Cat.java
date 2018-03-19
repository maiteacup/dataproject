
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import org.immutables.value.Value;
/**
 * Created by mait on 1/18/18.
 */

@Value.Immutable
public abstract class Cat {
  public abstract String date();
  public abstract String name();
  public abstract String company();
  public abstract String color();
  public abstract Image image();
  /*
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

  public void setDate(String date){
    this.date.set(date);
  }

  public String getName() {
    String name = this.name.get();

    return name;
  }
  public void setName(String name){
    this.name.set(name);
  }

  public String getCompany() {
    String company = this.company.get();

    return company;
  }

  public void setCompany(String company){
    this.company.set(company);
  }
  public String getColor() {
    String color = this.color.get();

    return color;
  }
  public void setColor(String color){
    this.color.set(color);
  }
  public Image getImage() {
    return this.image;
  }

  public void setImage(Image image){
    this.image = image;
  }
  public String toString() {
    return ("Meow" + "\n" + this.getDate() + "\n" + this.getName() + "\n" + this.getCompany() + "\n" + this.getColor()
            + "\n");
  }
*/
}
