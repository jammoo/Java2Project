package pokedeck;
/**
 *
 * @author syed
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;



public class Display extends Application {
    //Array for pokemon names
   private String[] pokemonList = {"Pikachu", "Charmander", "Bulbasaur", "Evee", "Dragonite", "Lugia"};
   
   
   
   // Array for Pokemon images
   private ImageView[] ImageViews = {
   
   new ImageView("pokedeck/assets/Pikachu.png"),
   new ImageView("pokedeck/assets/Charmander.png"),
   new ImageView("pokedeck/assets/Bulbasaur.png"),
   new ImageView("pokedeck/assets/Evee.png"),
   new ImageView("pokedeck/assets/Dragonite.png"),
   new ImageView("pokedeck/assets/Lugia.png")
  
   };
    
    
    @Override
    public void start(Stage primaryStage){
    
    ListView<String> list = new ListView<>
      (FXCollections.observableArrayList(pokemonList));  
    
    list.setPrefSize(400, 400);
    list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
    
    FlowPane imagePane = new FlowPane(10, 10);
    BorderPane pane = new BorderPane();
    pane.setLeft(new ScrollPane(list));
    pane.setCenter(imagePane);
    
   
        
        
   list.getSelectionModel().selectedItemProperty().addListener(
 ov -> {
 imagePane.getChildren().clear();
for (Integer i: list.getSelectionModel().getSelectedIndices()) {
imagePane.getChildren().add(ImageViews[i]);     

}
 });
   
   
 Scene scene = new Scene(pane, 750, 450);
 primaryStage.setTitle("Select Pokemon");  
 primaryStage.setScene(scene); 
 primaryStage.show(); 
    }

        

    
    
    
    
    // Main method
  public static void main(String[] args){
    
    Application.launch(args);
    }
    
}
