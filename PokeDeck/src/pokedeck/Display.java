package pokedeck;
import java.io.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Display extends Application
{
   //Array for pokemon names
   private String[] pokemonList = {"Pikachu", "Charmander", "Bulbasaur", "Evee", "Dragonite", "Lugia"};
   ListView<String> list = new ListView<>(FXCollections.observableArrayList(pokemonList));

   private String chosenPokemon;

   // Array for Pokemon images
   protected ImageView[] ImageViews = {
      new ImageView("Pikachu.png"),
      new ImageView("Charmander.png"),
      new ImageView("Bulbasaur.png"),
      new ImageView("Evee.png"),
      new ImageView("Dragonite.png"),
      new ImageView("Lugia.png")
   };


   @Override
   public void start (Stage primaryStage)
   {
//     ListView<String> list = new ListView<>(FXCollections.observableArrayList(pokemonList));
      list.setPrefSize(400, 400);
      list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
      list.getOnMouseClicked();
      HBox pane2 = new HBox(10);
      pane2.setAlignment(Pos.BOTTOM_CENTER);


      FlowPane imagePane = new FlowPane(10, 10);
      BorderPane pane = new BorderPane();
      pane.setLeft(new ScrollPane(list));
      pane.setCenter(imagePane);

      Button add = new Button("Add");
      Button remove = new Button("Remove");
      AddC addEvent = new AddC();
      RemoveC removeEvent = new RemoveC();
      add.setOnAction(addEvent);
      remove.setOnAction(removeEvent);
      pane2.getChildren().addAll(add, remove);

      list.getSelectionModel().selectedItemProperty().addListener(
              ov -> {
                 imagePane.getChildren().clear();
                 list.getSelectionModel().getSelectedIndices().forEach((i) -> {
                    imagePane.getChildren().add(ImageViews[i]);
                    chosenPokemon = pokemonList[i];
                 });
              });

      StackPane rootPane = new StackPane();

      Scene scene;
      scene = new Scene(rootPane, 750, 450);
      rootPane.getChildren().addAll(pane, pane2);

      primaryStage.setTitle("Select Pokemon");
      primaryStage.setScene(scene);
      primaryStage.show();

   }





//    Main method
   public static void main (String[] args) throws IOException
   {

      Application.launch(args);
   }


   class AddC implements EventHandler<ActionEvent>
   {


      @Override
      public void handle (ActionEvent e)
      {
         System.out.println(chosenPokemon);
         Storage a = new Storage();
         if ("Pikachu".equals(chosenPokemon)) {
            Pokemon p1 = new Pokemon(30, TypePokemon.PIKACHU, "Pica");
            a.addPokemon(p1);
         }

         try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));

            try {
               output.writeUTF("pickachou");
               output.writeDouble(30);
               output.writeUTF("Pikachi");
            }
            catch (IOException ex) {
               System.out.println("no");
            }
         }
         catch (IOException ex) {
            System.out.println("no");
         }
      }


   }




   class RemoveC implements EventHandler<ActionEvent>
   {
      @Override
      public void handle (ActionEvent e)
      {
         System.out.println("Cancel button clicked");
         try {
            DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"));
            System.out.println(input.readUTF() + " " + input.readDouble());
         }

         catch (IOException ex) {
            System.out.println("no");
         }

      }
   }
}
