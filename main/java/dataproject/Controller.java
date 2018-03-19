

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by mait on 1/25/18.
 */
public class Controller {

  ReadFileToObject readFileToObject = new ReadFileToObject();
  @FXML
  private AnchorPane parentPane;
  @FXML
  private ComboBox colorComboBox;
  @FXML
  private TableView<Cat> catTable;
  @FXML
  private TableColumn<Cat, String> catDate;
  @FXML
  private TableColumn<Cat, String> catName;
  @FXML
  private TableColumn<Cat, String> catCompany;
  @FXML
  private TableColumn<Cat, String> catColor;
  @FXML
  private Label catNameLabel;
  @FXML
  private ImageView catImage;
  @FXML
  private Label colorLabel;
  ObservableList<Cat> cats = FXCollections.observableList(readFileToObject.getCatList());
  ArrayList<String> colorList = new ArrayList<>(readFileToObject.getColorList());
  ReadCatPics readCatPics = new ReadCatPics();

  @FXML
  private void initialize() {
    System.out.print(cats.get(0).date());
    colorComboBox.setItems(FXCollections.observableList(colorList));
    catDate.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().date()));
    catName.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().name()));
    catCompany.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().company()));
   catColor.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().color()));
    colorComboBox.getSelectionModel().selectFirst();
    System.out.println(catDate.getCellData(0));
    catTable.setItems(cats);
    catTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
  }

  public void sortCatList() {
    String colorValue = colorComboBox.getValue().toString();
    if (colorValue.equals("All")) {
      ObservableList<Cat> sortedCatList = FXCollections.observableList(cats);
      catTable.setItems(sortedCatList);
    } else {
      List<Cat> sortingCatList = cats.stream()
          .filter(x -> colorValue.equals(x.color()))
          .collect(Collectors.toList());
      ObservableList<Cat> sortedCatList = FXCollections.observableList(sortingCatList);
      catTable.setItems(sortedCatList);
    }
    setColorBackground(colorValue);
  }

  public void setColorBackground(String color) {
    if (color.equals("Green")) {
      parentPane.setStyle("-fx-background-color: #0FCB3A;");
    } else if (color.equals("Yellow")) {
      parentPane.setStyle("-fx-background-color: #ffff99;");
    } else if (color.equals("Red")) {
      parentPane.setStyle("-fx-background-color: #ff0000;");
    } else if (color.equals("Violet")) {
      parentPane.setStyle("-fx-background-color: #f6bcf6;");
    } else if (color.equals("Blue")) {

      parentPane.setStyle("-fx-background-color: #6699ff;");
    } else if (color.equals("Orange")) {
      parentPane.setStyle("-fx-background-color: #ff9966;");
    } else if (color.equals("Indigo")) {
      parentPane.setStyle("-fx-background-color: #4b0082;");
      catNameLabel.setTextFill(Color.web("ffffff"));
    } else {
      parentPane.setStyle("-fx-background-color: #FFFFFF;");
    }

    if (color.equals("Indigo")) {
      catNameLabel.setTextFill(Color.web("ffffff"));
      colorLabel.setTextFill(Color.web("ffffff"));
    } else {
      catNameLabel.setTextFill(Color.web("000000"));
      colorLabel.setTextFill(Color.web("000000"));
    }
  }

  public void selectingCat() {
    if (catTable.getSelectionModel().getSelectedItem() != null) {
      Cat cat = catTable.getSelectionModel().getSelectedItem();
      String catName = cat.name();
      String color = cat.color();
      catNameLabel.setFont(Font.font("Cambria", 25));
      catNameLabel.setText(catName);
      catImage.setImage(cat.image());
      setColorBackground(color);
    }
  }
  public void randomCat(){
    // This returns a random cat object
    Cat randomCat = readFileToObject.randomCat();
    catImage.setImage(randomCat.image());
    String color = randomCat.color();
    catNameLabel.setFont(Font.font("Cambria", 25));
    catNameLabel.setText(randomCat.name().toString());
    setColorBackground(color);


  }
  public void randomCatPic(){
    catImage.setImage(readFileToObject.catAPI());
    catNameLabel.setText("");
    parentPane.setStyle("-fx-background-color: #FFFFFF;");
  }

  public void randomCatGIF(){
    catImage.setImage(readFileToObject.catGIFAPI());
    catNameLabel.setText("");
    parentPane.setStyle("-fx-background-color: #FFFFFF;");
  }
}