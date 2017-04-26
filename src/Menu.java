/*
 * Menu Class
 *
 * This class is responsible for printing out the menu
 *
 * Created by Ningqi Lu on 3/22/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public class Menu {

    /**
     * show the main selection menu
     */
    public void menuShow() {
        String menu[] = {"\n Ozlympic Game",
                "===================================",
                "1. Select a game to run",
                "2. Predict the winner of the game",
                "3. Start the game",
                "4. Display the final results of all games",
                "5. Display the points of all athletes",
                "6. Exit",
                " Enter an option:"};
        for (int i = 0; i < menu.length; i++)
            System.out.println(menu[i]);
    }

    /**
     * show the game select menu
     */
    public void showGameSelect(){

        System.out.println("Please select one Ozlympic game to play:");
        System.out.println("1. Swimming");
        System.out.println("2. Cycling");
        System.out.println("3. Running");
    }


}
