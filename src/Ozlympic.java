import Game.Games;
import Game.Swimming;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/*
 * Ozympic Class
 *
 * This class is the entrance of
 *
 * Created by Ningqi Lu on 3/22/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */
public class Ozlympic extends Application {


    public static final int COLUMN_NUM = 5;
    public static String Type=null; //record the type of game selected in toggle group
    public Ozlympic() throws IOException {
    }

    /*    public static void main(String[] args) throws IOException {

            Driver driver = new Driver();
            driver.mainMenu();

        }*/
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        Scene scene = new Scene(getFirstPage(), 500, 500);
        primaryStage.setTitle("Ozlympic Game"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false);
        primaryStage.show(); // Display the stage
    }

    protected VBox getFirstPage() {
        // Hold two buttons in an HBox
        VBox titleInfo = new VBox();
        titleInfo.setSpacing(10);
        titleInfo.setAlignment(Pos.TOP_CENTER);
        titleInfo.setPadding(new Insets(10));

        //create the title of the game
        Text gameTitle = new Text(20, 20, "Welcome to the game Ozlympic!");
        gameTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25));

        // create the text to welcome the player and ask the selection
        Text welcomeAndAsk = new Text(60, 60, "The game will be starting soon~ Please choose a game to run!");
        titleInfo.getChildren().addAll(gameTitle, welcomeAndAsk);

        //Hold three radiobutton in gameselect vBox
        HBox gameselect = new HBox();
        gameselect.setSpacing(15);
        gameselect.setAlignment(Pos.TOP_CENTER);
        gameselect.setPadding(new Insets(5));

        //create a radio box to select the game
        ToggleGroup group = new ToggleGroup();
        RadioButton swimming = new RadioButton("Swimming");
        swimming.setToggleGroup(group);
        swimming.setUserData("swimming");

        RadioButton cycling = new RadioButton("Cycling");
        cycling.setToggleGroup(group);
        cycling.setUserData("cycling");

        RadioButton running = new RadioButton("Running");
        running.setToggleGroup(group);
        running.setUserData("running");

        gameselect.getChildren().addAll(swimming, cycling, running);

        //create the start button
        Button start = new Button("Start Game");
        start.setAlignment(Pos.TOP_CENTER);

        // return the type selected
        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
                Type= group.getSelectedToggle().getUserData().toString();
                System.out.println(Type);
        });

                // Create and register the handler
        start.setOnAction((ActionEvent e) -> {
            if(group.getSelectedToggle()!=null){
            try {
                getPredictStage();
            } catch (IOException e1) {
                e1.printStackTrace();
            }}else
            {
                Stage s=new Stage();
                Label warningMessage=new Label("Please select the game!");
                warningMessage.setAlignment(Pos.CENTER);
                Scene ss=new Scene(warningMessage,150,50);
                s.setTitle("WARNING");
                s.setScene(ss);
                s.setResizable(false);
                s.show();
            }
        });

        //BorderPane created,put the hBox into the boarderPane
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(titleInfo, gameselect, start);
        return vbox;
    }

    protected void getPredictStage() throws IOException {
        Driver driver=new Driver();
        //create a new stage to pop up a new window
        Stage predict =new Stage();

        //create new elements of in the new window
        //Label warningMessage=new Label("message");
        VBox titleInfo = new VBox();
        titleInfo.setSpacing(10);
        titleInfo.setAlignment(Pos.TOP_CENTER);
        titleInfo.setPadding(new Insets(10));

        //create the title of the game
        Text predictTitle = new Text(20, 20, "Here is the athlete attend the game you choosed\nPlease tick one as you predicted!");
        predictTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        titleInfo.getChildren().addAll(predictTitle);

        //Hold three radiobutton in gameselect vBox
        VBox winnerSelect = new VBox();
        winnerSelect.setSpacing(15);
        winnerSelect.setAlignment(Pos.TOP_CENTER);
        winnerSelect.setPadding(new Insets(5));

        //choice box to choose the winner
        driver.setType(Type);
        driver.showAthleteinSelectedGame();
        ChoiceBox<Object> cb=new ChoiceBox<>();
        for (int i = 0; i <Games.attendAthlete.size() ; i++) {
            cb.getItems().addAll(FXCollections.observableArrayList(
                                Games.attendAthlete.get(i)[0]+" "+Games.attendAthlete.get(i)[1]+" "
                                +Games.attendAthlete.get(i)[2]+" "+Games.attendAthlete.get(i)[3]+" "
                                +Games.attendAthlete.get(i)[4]));
        }

        cb.setTooltip(new Tooltip("Select the winner!"));
        winnerSelect.getChildren().addAll(cb);

        //create the start button
        Button btnPredict = new Button("Predict");
        btnPredict.setPadding(new Insets(10));
        // Create and register the handler

        btnPredict.setOnAction((ActionEvent e) -> predict.close());

        //Put in all elements to a VBox
        VBox wholePredictStage = new VBox();
        wholePredictStage.setSpacing(10);
        wholePredictStage.setAlignment(Pos.TOP_CENTER);
        wholePredictStage.getChildren().addAll(titleInfo,winnerSelect,btnPredict);

        Scene secondWindow=new Scene(wholePredictStage,400,200);
        predict.setTitle("Predict the winner!");
        predict.setScene(secondWindow);
        predict.setResizable(false);
        predict.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
