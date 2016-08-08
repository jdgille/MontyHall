import java.util.Random;
import java.util.Scanner;

/**
 * Created by jonagill1 on 8/8/2016.
 */
public class MontyHall {
    //region SetupGame
        /*
        * Created By Alex and Rob
        * sets new variable, doors(Array of integers), playersChoice (integer), playerInput(Scanner) and winningDoor(Integer)
        * This method will print out some doors, and prompt the user to select a door(1, 2 or 3).
        * Upon selection, the playerInput becomes playerChoice after subtracting one to be concurrent with the array index.
        */
    int[]doors = {0,0,0}; //doors variable
    int playersChoice;  //playerChoice is the number chosen by the player
    static Scanner playerInput = new Scanner(System.in); //playerInput will take the value entered by the player, passed to playerChoice
    int winningDoor = 0; //winningDoor is the door where the prize lives, get you one!
    public void GameStart(){
        System.out.print("\n" +
                        "            __________   __________   __________\n" +
                        "           |  __  __  | |  __  __  | |  __  __  |\n" +  //THESE
                        "           | |  ||  | | | |  ||  | | | |  ||  | |\n" +  //ARE
                        "           | |  ||  | | | |  ||  | | | |  ||  | |\n" +  //SOME
                        "           | |__||__| | | |__||__| | | |__||__| |\n" +  //DOORS
                        "           |  __01__()| |  __02__()| |  __03__()|\n" +  //AREN'T
                        "           | |  ||  | | | |  ||  | | | |  ||  | |\n" +  //THEY
                        "           | |  ||  | | | |  ||  | | | |  ||  | |\n" +  //PRETTY?
                        "           | |  ||  | | | |  ||  | | | |  ||  | |\n" +  //AREN'T
                        "           | |  ||  | | | |  ||  | | | |  ||  | |\n" +  //THEY
                        "           | |__||__| | | |__||__| | | |__||__| |\n" +  //COOL?
                        "           |__________| |__________| |__________|\n\n"
        );
        System.out.println("Please Enter a door(1,2,3)");  //prompts user
        playersChoice = playerInput.nextInt()-1; //playerInput -1 becomes playerChoice (subtracted to coincide with index values!!!)
        Play();
    }
    //endregion
    //region PlayGame
    /*
       Charleto
       Eric
       created on: 8-8-2016
       * We are developing the method that takes in user input, and computer input for a spot in the array.
        * Following that we are going to get rid of the door that is not the user input.
       * */
    private void Play()
    {
        //initializing ints used
        int x = -1;
        int y = -1;
        //creates winning door using generate number
        doors[GenerateNumber()] = 1;
        //assigns the winning doors index to an integer
        for (int i = 0; i < doors.length; ++i) {
            if (doors[i] == 1) {
                winningDoor = doors[i];
            }
            //deciding which door to open randomly
            while (x < 0) {
                y = GenerateNumber();
                if (y != playersChoice && y != winningDoor) {
                    System.out.println(
                            "   /|\n" +
                                    "  / |\n" +
                                    " /__|______\n" +
                                    "|  __  __  |\n" +
                                    "| |  ||  | |\n" +
                                    "| |  ||  | |\n" +
                                    "| |__||__| |\n" +
                                    "|  __" + (y+1) + " __()|\n" +
                                    "| |  ||  | |\n" +
                                    "| |  ||  | |\n" +
                                    "| |  ||  | |\n" +
                                    "| |__||__| |\n" +
                                    "|__________|");
                    System.out.println("Door " + (y+1) + " is opened");
                    doors[y] = 9001;
                    x = 0;
                }
            }
        }
        // selects a new door as a choice for the user
        System.out.println("if you'd like to change your door, please enter a new choice");
        Scanner findChoice = new Scanner(System.in);
        // player input is being assigned to the player's original choice
        int newDoor = findChoice.nextInt();
        playersChoice = newDoor - 1;
        Win();
    }
    //endregion
    //region Win
        /*
        Nick
        Brendan
        Win method!
        */
    //Checks if players choice is winning door, and allows user the choice to play again
    private void Win(){
        /*
            Variables:
                doors: Array
                playersChoice int
        */
        // Check door at position playersChoice to see if the value
        // is equal to one(i.e. winning value)
        if(doors[playersChoice] == 1) {
            System.out.println("                                    \n" +
                    "                                 _..-------++._\n" +
                    "                             _.-'/ |      _||  \\\"--._\n" +
                    "                       __.--'`._/_\\j_____/_||___\\    `----.\n" +
                    "                  _.--'_____    |          \\     _____    /\n" +
                    "                _j    /,---.\\   |        =o |   /,---.\\   |_\n" +
                    "               [__]==// .-. \\\\==`===========/==// .-. \\\\=[__]\n" +
                    "                 `-._|\\ `-' /|___\\_________/___|\\ `-' /|_.'     \n" +
                    "                       `---'                     `---'");
            System.out.println("Congratulations");
        }
        else {
            System.out.println(
                    "                           ___.\n" +
                            "                         //  \\\\\n" +
                            "                        ((   ''\n" +
                            "                         \\\\__,\n" +
                            "                        /6 (%)\\,\n" +
                            "                       (__/:\";,;\\--____----_\n" +
                            "                        ;; :';,:';`;,';,;';`,`_\n" +
                            "                          ;:,;;';';,;':,';';,-Y\\\n" +
                            "                           ;,;,;';';,;':;';'; Z/\n" +
                            "                           / ;,';';,;';,;';;'\n" +
                            "                          / / |';/~~~~~\\';;'\n" +
                            "                         ( K  | |      || |\n" +
                            "                          \\_\\ | |      || |\n" +
                            "                           \\Z | |      || |\n" +
                            "                              L_|      LL_|\n" +
                            "                              LW/      LLW/");
            System.out.println("Better luck next time chump");
        }
        //Take user input
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter yes if you want to play again!!");
//        String s = sc.nextLine();
//        //If user enters String: "yes" restart game
//        if(s.equals("yes"))
//            GenerateNumber();
    }
    //endregion
    //region GenerateNumber
    /*
       Team: Gabriel and Andy
       Intention: Create a number generator that defaults to between 0-3
   */
    public int GenerateNumber()
    {
        //Declare a Random object
        Random random = new Random();
        //Return a random number that is below the number being passed as an argument to nextInt but equal to or greater
        //than zero
        return random.nextInt(3);
    }
    public static int GenerateNumber(int max)
    {
        //Declare a Random object
        Random random = new Random();
        //Return a random number that is below the number being passed as an argument to nextInt but equal to or greater
        //than zero
        return random.nextInt(max);
    }
    //endregion
}
