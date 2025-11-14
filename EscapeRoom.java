/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");

    GameGUI game = new GameGUI();
    game.createBoard();

    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "trap", "t", "quit", "q", "replay", "help", "?"};

    String option="";
    boolean play = true;
    while (play)
    {
      System.out.print("Enter command: ");
      option=in.nextLine();
      if (option.equals("right")||option.equals("r")){
        score += game.movePlayer(60,0);
      }
      else if (option.equals("left")||option.equals("l")){
        score += game.movePlayer(-60,0) ;
      }
      else if (option.equals("up")||option.equals("u")){
        score += game.movePlayer(0, -60);
      }
      else if(option.equals("down")||option.equals("d")){
        score += game.movePlayer(0,60);
      }
      else if(option.equals("jump")||option.equals("jr")){
        score += game.movePlayer(120,0);
      }
      else if(option.equals("jumpleft")||(option.equals("jl"))){
        score += game.movePlayer(-120,0);
      }
      else if(option.equals("jumpup")||option.equals("ju")){
        score += game.movePlayer(0,-120);
      }
      else if(option.equals("jumpdown")||option.equals("jd")){
        score += game.movePlayer(0,120);
      }
      else if(option.equals("pickup")||option.equals("p")){
        score += game.pickupPrize();
      }
      else if(option.equals("trap")||option.equals("t")){
        System.out.println("Which direction to check for trap? (r/l/u/d)");
        String direction = in.nextLine();
        if(direction.equals("r")){
          if(game.isTrap(60,0)){
            score = score+ game.springTrap(60,0);
          } else {
            score = score- game.springTrap(60,0);
          }
        }
        else if(direction.equals("l")){
          if(game.isTrap(-60,0)){
            score = score+ game.springTrap(-60,0);
          } else {
            score = score+ game.springTrap(-60,0);
          }
        }
        else if(direction.equals("u")){
          if(game.isTrap(0,-60)){
            score = score+game.springTrap(0,-60);
          } else {
            score = score+ game.springTrap(0,-60);
          }
        }
        else if(direction.equals("d")){
          if(game.isTrap(0,60)){
            score = score+ game.springTrap(0,60);
          } else {
            score = score+ game.springTrap(0,60);
          }
        }
      }
      else if(option.equals("help")||option.equals("?")){
        System.out.println("Choose your Command (don't type wrong or you lose points!):");
        System.out.println("  Movet: right/r, left/l, up/u, down/d");
        System.out.println("  Jump: jump/jr (right), jumpleft/jl, jumpup/ju (up), jumpdown/jd (down)");
        System.out.println("  Actions: pickup/p (pick up prize), trap/t (spring trap)");
        System.out.println("  Game: quit/q, replay, help/?");
        System.out.println("Goal: Reach the far right side and collect all prizes");
      }
      else if(option.equals("quit")||option.equals("q")){
        play=false;
      }
      else if(option.equals("replay")){
        System.out.println("Steps taken: " + game.getSteps());
        score += game.replay();
      }
      else {
        System.out.println("Invalid command. Type 'help' for available commands.");
      }
    }

    score += game.endGame();

    System.out.println("Wins=" + score);
    System.out.println("Attempts=" + game.getSteps());
    }
}


        