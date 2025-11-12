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

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    String option="";
    boolean play = true;
    while (play)
    {
      option=in.nextLine();
      if (option.equals("right")||option.equals("r")){
        game.movePlayer(1,0);
      }
      else if (option.equals("left")||option.equals("l")){
        game.movePlayer(-1,0) ; 
      }
      else if (option.equals("up")||option.equals("u")){
        game.movePlayer(0, -1);
      }
      else if(option.equals("down")||option.equals("d")){
        game.movePlayer(0,1);
      }
      else if(option.equals("jump")||option.equals("jr")){
        game.movePlayer(50,0);
      }
      else if(option.equals("jumpleft")||(option.equals("jl"))){
        game.movePlayer(-50,0);
      }
      else if(option.equals("jumpup")||option.equals("ju")){
        game.movePlayer(0,-50);

      }
      else if(option.equals("jumpdown")||option.equals("jd")){
        game.movePlayer(0,50);
      }
      else if(option.equals("pickup")||option.equals("p")){
        game.pickupPrize();

      }
      else if(option.equals("quit")||option.equals("q")){
        game.endGame();
      }
      else if(option.equals("replay")){
        System.out.println("Walked"+game.getSteps());
        game.replay();
      }
    }

  score += game.endGame();

    System.out.println("score=" + score);
      System.out.println("steps=" + game.getSteps());
    }
  }


        