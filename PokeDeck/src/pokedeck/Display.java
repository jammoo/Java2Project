package pokedeck;
/**
 *
 * @author syed
 */

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Display extends Application {
    // 
    Label title = new Label("POKEDECK");
    
   Storage bank = new Storage();
   private ImageView[] pokemonImages;
   // this is the index of the selected pokemon for performing operations
   private int selectedPokemon;
   // this is a list of the names of the pokemon
   ListView<String> list = new ListView<>(FXCollections.observableArrayList(bank.getNames()));;    
    
    @Override
    public void start(Stage primaryStage){
    // here we need to search for the data file and read it in if it exists
    bank.loadData();
    // after changes have been made, call the update method to ensure the display matches the pokemon
    updatePokemon();
    
    // add the list of pokemon names to the program
      list = new ListView<>(FXCollections.observableArrayList(bank.getNames()));
      list.setPrefSize(400, 400);
      list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


      FlowPane imagePane = new FlowPane();
      imagePane.setMinHeight(300);
      imagePane.setMinWidth(300);
      imagePane.setPadding(new Insets(50, 0, 50, 50));
      VBox data = new VBox();
      HBox imageAndData = new HBox();
      imageAndData.setPadding(new Insets(50, 50, 50, 10));
      data.setPadding(new Insets(50, 10, 50, 0));
      data.setMinHeight(300);
      data.setMinWidth(300);
      title.setPadding(new Insets(15, 15, 15, 600));
      title.setStyle("-fx-font: normal bold 60px 'serif'; -fx-text-fill:orange; -fx-text-alignment: center;"); // how to make it centered???

      BorderPane pane = new BorderPane();
      pane.setLeft(new ScrollPane(list));
      pane.setTop(title);
      pane.setRight(imageAndData);
      imageAndData.getChildren().add(imagePane);
      imageAndData.getChildren().add(data);


      //HBox For Buttons
      HBox buttons = new HBox(10);
      Button add = new Button("Add");
      add.setPadding(new Insets(30, 30, 30, 30));
      Button delete = new Button("Delete");
      delete.setPadding(new Insets(30, 30, 30, 30));
      Button getSearch = new Button("Search");
      getSearch.setPadding(new Insets(30, 30, 30, 30));
      Button edit = new Button("Edit");
      edit.setPadding(new Insets(30, 30, 30, 30));
      Button move = new Button("Move To Top");
      move.setPadding(new Insets(30, 30, 30, 30));
      pane.setBottom(buttons);
      buttons.getChildren().add(getSearch);
      buttons.getChildren().add(edit);
      buttons.getChildren().add(move);
      buttons.getChildren().add(add);
      buttons.getChildren().add(delete);
      buttons.setSpacing(170);
      buttons.setPadding(new Insets(50, 50, 50, 80));
   
        
        // listen for when a name is selected, then perform actions
      list.getSelectionModel().selectedItemProperty().addListener(
              ov -> {
                  imagePane.getChildren().clear();
                  data.getChildren().clear();
                  for (Integer i: list.getSelectionModel().getSelectedIndices()) {
                      selectedPokemon = i;
                      imagePane.getChildren().add(pokemonImages[i]);
                      data.getChildren().add(new Label("ID: " + bank.getListOfPokemon().get(i).getId()));
                      data.getChildren().add(new Label("Type: " + bank.getListOfPokemon().get(i).getType().name()));
                      data.getChildren().add(new Label("NickName: " + bank.getListOfPokemon().get(i).getNickName()));
                      data.getChildren().add(new Label("Hp: " + bank.getListOfPokemon().get(i).getHp()));
                      data.getChildren().add(new Label("Atk: " + bank.getListOfPokemon().get(i).getAtk()));
                      data.getChildren().add(new Label("Def: " + bank.getListOfPokemon().get(i).getDef()));
                      data.getChildren().add(new Label("SpAtk: " + bank.getListOfPokemon().get(i).getSpAtk()));
                      data.getChildren().add(new Label("SpDef: " + bank.getListOfPokemon().get(i).getSpDef()));
                      data.getChildren().add(new Label("Speed: " + bank.getListOfPokemon().get(i).getSpeed()));
                      data.getChildren().add(new Label("Level: " + bank.getListOfPokemon().get(i).getLevel()));
                      data.getChildren().add(new Label("Exp: " + bank.getListOfPokemon().get(i).getExp()));
                  }
                  // add functionality when clicking delete
                  delete.setOnAction(e -> {
                      bank.removePokemon(selectedPokemon);
                      updatePokemon();
                  });
                  // add functionality when clicking move
                  move.setOnAction(e -> {
                      
                      int temp = selectedPokemon;
                      list.getSelectionModel().selectedItemProperty().addListener(
                              selector -> {
                                  Collections.swap(bank.getListOfPokemon(), selectedPokemon, 0);
                              }
                      );
                      //bank.removePokemon(selectedPokemon); // not done yet!
                      updatePokemon();
                  });
                  // add functionality when clicking edit
                  edit.setOnAction(e -> {
                      // create a pop-up that displays the fields of the selected pokemon
                      VBox editPane = new VBox();
                      editPane.setMinWidth(200);
                      editPane.setMinHeight(400);
                      // create all the property labels and properties of the selected pokemon
                      Label t1 = new Label("Current");
                      Label t2 = new Label("Edit");
                      TextField eid = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getId());
                      ChoiceBox<TypePokemon> etype = new ChoiceBox<>();
                      for (int i = 1; i < TypePokemon.values().length; i++) {
                          etype.getItems().add(TypePokemon.values()[i]);
                      }
                      etype.setValue(bank.getListOfPokemon().get(selectedPokemon).getType());
                      TextField enickName = new TextField(bank.getListOfPokemon().get(selectedPokemon).getNickName());
                      TextField ehp = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getHp());
                      TextField eatk = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getAtk());
                      TextField edef = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getDef());
                      TextField espAtk = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getSpAtk());
                      TextField espDef = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getSpDef());
                      TextField espeed = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getSpeed());
                      TextField elevel = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getLevel());
                      TextField eexp = new TextField("" + bank.getListOfPokemon().get(selectedPokemon).getExp());
                      
                      Label id = new Label("ID: " + bank.getListOfPokemon().get(selectedPokemon).getId());
                      Label type = new Label("Type: " + bank.getListOfPokemon().get(selectedPokemon).getType().name());
                      Label nickName = new Label("NickName: " + bank.getListOfPokemon().get(selectedPokemon).getNickName());
                      Label hp = new Label("Hp: " + bank.getListOfPokemon().get(selectedPokemon).getHp());
                      Label atk = new Label("Atk: " + bank.getListOfPokemon().get(selectedPokemon).getAtk());
                      Label def = new Label("Def: " + bank.getListOfPokemon().get(selectedPokemon).getDef());
                      Label spAtk = new Label("SpAtk: " + bank.getListOfPokemon().get(selectedPokemon).getSpAtk());
                      Label spDef = new Label("SpDef: " + bank.getListOfPokemon().get(selectedPokemon).getSpDef());
                      Label speed = new Label("Speed: " + bank.getListOfPokemon().get(selectedPokemon).getSpeed());
                      Label level = new Label("Level: " + bank.getListOfPokemon().get(selectedPokemon).getLevel());
                      Label exp = new Label("Exp: " + bank.getListOfPokemon().get(selectedPokemon).getExp());
                      
                      // add all the elements to the pane
                      editPane.getChildren().addAll(new HBox(t1, t2));
                      editPane.getChildren().addAll(new HBox(id, eid));
                      editPane.getChildren().addAll(new HBox(type, etype));
                      editPane.getChildren().addAll(new HBox(nickName, enickName));
                      editPane.getChildren().addAll(new HBox(hp, ehp));
                      editPane.getChildren().addAll(new HBox(atk, eatk));
                      editPane.getChildren().addAll(new HBox(def, edef));
                      editPane.getChildren().addAll(new HBox(spAtk, espAtk));
                      editPane.getChildren().addAll(new HBox(spDef, espDef));
                      editPane.getChildren().addAll(new HBox(speed, espeed));
                      editPane.getChildren().addAll(new HBox(level, elevel));
                      editPane.getChildren().addAll(new HBox(exp, eexp));
                      Button submit = new Button("Confirm");
                      editPane.getChildren().addAll(submit);
                      // create all the property labels and properties of the selected pokemon
                      Scene editScene = new Scene(editPane, 500, 680);
                      Stage editStage = new Stage();
                      editStage.setTitle("Edit Pokemon");
                      editStage.setScene(editScene);
                      editPane.setSpacing(20);
                      editStage.show();
                      // then allow the user to change whichever fields they want
                      updatePokemon();
                      submit.setOnAction(f -> {
                          bank.replacePokemon(bank.getListOfPokemon().get(selectedPokemon),new Pokemon(Integer.parseInt(eid.getText()),
                                  etype.getValue(), enickName.getText(), Integer.parseInt(ehp.getText()), 
                                  Integer.parseInt(eatk.getText()), 
                                  Integer.parseInt(edef.getText()), 
                                  Integer.parseInt(espAtk.getText()), 
                                  Integer.parseInt(espDef.getText()), 
                                  Integer.parseInt(espeed.getText()), 
                                  Integer.parseInt(elevel.getText()), 
                                  Integer.parseInt(eexp.getText())));
                          updatePokemon();
                         editStage.close();
                      });
                  });
              });
      
      
                  // add functionality when clicking add
                  add.setOnAction(e -> {
                      ChoiceBox<TypePokemon> newType = new ChoiceBox<>();
                      for (int i = 1; i < TypePokemon.values().length; i++) {
                          newType.getItems().add(TypePokemon.values()[i]);
                      }
                      Button submit = new Button("Create");
                      VBox addBox = new VBox(newType, submit);
                      BorderPane content = new BorderPane();
                      content.setCenter(addBox);
                      Scene addScene = new Scene(content, 350, 200);
                      Stage addStage = new Stage();
                      addStage.setTitle("Add a Pokemon");
                      addStage.setScene(addScene);
                      addStage.show();
                      submit.setOnAction(eh -> {
                          bank.addPokemon(new Pokemon(newType.getValue()));
                          updatePokemon();
                          addStage.close();
                      });
                  });
   
   
 Scene scene = new Scene(pane, 1500, 700);
 primaryStage.setTitle("Select Pokemon");  
 primaryStage.setScene(scene); 
 primaryStage.show(); 
 
 getSearch.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent event)
         {
            //PopUp Search Pane
             ChoiceBox<TypePokemon> search = new ChoiceBox<>();
             for (int i = 0; i < TypePokemon.values().length; i++) {
                 search.getItems().add(TypePokemon.values()[i]);
             }
            TextField tf = new TextField();
            Button doSearch = new Button("Search");
            VBox pane2 = new VBox();
            pane2.getChildren().add(search);
            pane2.getChildren().add(doSearch);
            doSearch.setMinWidth(100);
            pane2.setAlignment(Pos.CENTER);
            pane2.setPadding(new Insets(5, 50, 50, 50));
            pane2.setSpacing(10);
            pane2.autosize();
            Scene scene2 = new Scene(pane2, 500, 200);
            Stage stage2 = new Stage();
            stage2.setTitle("Search Pokemon");
            stage2.setScene(scene2);
            stage2.show();
            doSearch.setOnAction(eh -> {
                if (search.getValue() == TypePokemon.EMPTY) {
                    updatePokemon();
                }
                else {
                    ArrayList<Pokemon> temp = bank.findPokemon(search.getValue());
                    updatePokemon(temp);
                }
                stage2.close();
            });
            //stage2.setScene(scene2);
         }
      });
 
    }
    
    public void updatePokemon() {
        // update the listed names of pokemon by clearing and re-adding them
        list.getItems().clear();
        list.getItems().addAll(bank.getNames());
        // update the list of the image files for the pokemon
        ImageView[] temp = new ImageView[bank.getListOfPokemon().size()];
        for (int i = 0; i < bank.getListOfPokemon().size(); i++) {
            temp[i] = new ImageView(bank.getListOfPokemon().get(i).getImg());
        }
        pokemonImages = temp;
    }
    
    public void updatePokemon(ArrayList<Pokemon> temps) {
        Storage temp = new Storage(temps);
        // update the listed names of pokemon by clearing and re-adding them
        list.getItems().clear();
        list.getItems().addAll(temp.getNames());
        // update the list of the image files for the pokemon
        ImageView[] tem = new ImageView[temp.getListOfPokemon().size()];
        for (int i = 0; i < bank.getListOfPokemon().size(); i++) {
            tem[i] = new ImageView(bank.getListOfPokemon().get(i).getImg());
        }
        pokemonImages = tem;
    }
    
    @Override
    public void stop(){
        System.out.println("Stage is closing");
        System.out.println("Save successful: " + bank.saveData());
    }

    // Main method
  public static void main(String[] args){
    
    Application.launch(args);
    }

    
}
