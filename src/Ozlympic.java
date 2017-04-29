
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

    /*    public static void main(String[] args) throws IOException {

            Driver driver = new Driver();
            driver.mainMenu();

        }*/
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Hold two buttons in an HBox
        VBox titleInfo = new VBox();
        titleInfo.setSpacing(10);
        titleInfo.setAlignment(Pos.TOP_CENTER);

        //create the title of the game
        Text gameTitle = new Text(20, 20, "Welcome to the game Ozlympic!");
        gameTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));

        // create the text to welcome the player and ask the selection
        Text welcomeAndAsk = new Text(60, 60, "The game will be starting soon~\nPlease choose a game to run!");
        titleInfo.getChildren().addAll(gameTitle,welcomeAndAsk);

        //Hold three radiobutton in gameselect vBox
        VBox gameselect =new VBox();
        gameselect.setSpacing(15);
        gameselect.setAlignment(Pos.TOP_CENTER);
        gameselect.setPadding(new Insets(10,10,10,10));

        //create a radio box to select the game
        ToggleGroup group = new ToggleGroup();
        RadioButton swimming = new RadioButton("Swimming");
        swimming.setToggleGroup(group);
        swimming.setSelected(true);

        RadioButton cycling = new RadioButton("Cycling     ");
        cycling.setToggleGroup(group);

        RadioButton running = new RadioButton("Running   ");
        running.setToggleGroup(group);

        gameselect.getChildren().addAll(swimming,cycling,running);

        //create the start button
        Button start = new Button("Start Game");
        start.setAlignment(Pos.TOP_CENTER);


        // Create and register the handler
        start.setOnAction((ActionEvent e) -> {
            System.out.println("Game started");
        });

        //BorderPane created,put the hBox into the boarderPane
        VBox vbox=new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(titleInfo,gameselect,start);

        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setTitle("Ozlympic Game"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


}
