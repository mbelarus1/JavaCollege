import java.util.Random;
import java.util.Scanner;

public class SeizeTheStation {
    public static void main(String[] args) {
        // Declare Scanner and Random class objects
        Scanner scan = new Scanner(System.in);
        Random randomGen = new Random();

        // Variable to set the number of steps program must be completed within:
        final int STEPS = 20;
        // Variable to set initial distance to the goal;
        final int GOAL = 300;
        // Variable to set initial player health
        int health = 100;
        // Variable to decrease distance to the target
        int randAddDist = 0;
        // Variable to track remaining distance to target
        int randDistToMove = 0;
        // Variable to use to supplement player/game interaction
        int randInteract = 0;
        // Variable to define player obstacle
        char interact = '\0';
        // Variable to allow player to proceed to target
        char again = '\0';
        // Variable to track how many feet have taken place
        int distanceTravelled = 0;
        // Variable to keep track of attempts
        int attempts = 0;
        // Boolean for keeping track whether companion force is needed (initialized to False)
        boolean extraForce = false;
        // Start a program within a loop with at most 20 actions
        for (int count = 1; count <= STEPS; count++) {
            // Prompt the user what to do:
            System.out.println("\n------------------------------------");
            System.out.println("\n Are you ready to proceed? (Y or N) ");
            again = scan.next().charAt(0);
            if (again != 'Y') break;
            // Increase an attempt number
            attempts++;
            // define an obstacle
            interact = (char) (randomGen.nextInt(26) + 'a');
            // Piece of code that will determine if extra "Force" can be applied to a user
            // to reach the goal faster. By default, this option will be available after the 5th iteration
            if (count > 5 && interact == 'b') { // 'b' - random value that determines the success
                // Change extraForce variable to True
                extraForce = true;
                System.out.println("Wohooo!! Looks like you got very lucky! May force be with you!");
            }
            if (interact >= 'a' && interact <= 'm') {
                // random number sets the distance to move
                randDistToMove = 1 + randomGen.nextInt(20);
                // increase the total distance travelled
                //   a) by the exact random number (if extraForce is false)
                //   b) by the exact random number multiplied by 2
                randDistToMove = (extraForce == false) ? randDistToMove : randDistToMove * 2;
                distanceTravelled += randDistToMove;
                System.out.println("Move forward " + randDistToMove + " ft");
            } else {
                // decrease health points based on whether extraForce is applied
                health = (extraForce == false) ? health - 10 : health - 5;
                System.out.println("Ooops: circumvent the next obstacle");
                if (health <= 0) {
                    System.out.println("Bad luck...0 health points... Game over :(");
                    break;
                }
            }
            if (distanceTravelled >= GOAL) {
                System.out.println("Victory!!! ");
                break;
            }
        }
        // Display Program End output
        System.out.println("\n------------------------------------");
        System.out.println("Health Remaining: " + health);
        System.out.println("Distance to the target " + (GOAL - distanceTravelled) + " ft.");
        System.out.println("Number of attempts taken:" + attempts);
    }

}
