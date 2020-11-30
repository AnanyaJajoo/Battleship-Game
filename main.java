// Main.java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
      //Introduction
      Scanner in = new Scanner(System.in);
		  System.out.println("Welcome to Battleship! Let's start by setting up the game.");
		  System.out.println("How tall should the board be? ");
		  int length = in.nextInt();
		  System.out.println("How wide should the board be? ");
		  int width = in.nextInt();
		  System.out.println("How many two-unit ships should each player have?:  ");
		  int twoPlayer1 = in.nextInt();
		  System.out.println("How many three-unit ships should each player have?:  ");
		  int threePlayer1 = in.nextInt();
		  System.out.println("How many four-unit ships should each player have?:  ");
		  int fourPlayer1 = in.nextInt();
		  
      //Makes game board, player 1 board, player 2 board
      String[][] game = new String[length][width];
      String[][] game2 = new String[length][width];
      
      //Boards for the players
      String[][] player1game = new String[length][width];
      String[][] player2game = new String[length][width];
      
      //First board to print out
    	String[][] board = table(game);
    	
    	//Boards that store the ships that players put
    	String[][] player1board = table(game);
    	String[][] player2board = table(game2);
    	
    	//Starting game boards
    	String[][] newboard1 = table(player1game);
    	String[][] newboard2 = table(player2game);
    	
      for(String[] i: board){
        for(String j: i){
          System.out.print(j);
        }
        System.out.println();
      }
      
      //PLAYER 1 TWO-UNIT SHIPS
      System.out.println();
      System.out.println("Okay, it's time for Player 1 to set up their two-unit ships! You will be asked to type in coordinates for each of your ships.");
      
      
      System.out.println("Now entering coordinates for you " + twoPlayer1 + " 2-unit ships");
      

      System.out.println("You have completed placing your 2-unit ships. Here is what your board currently looks like: ");
      int numOfTwo = twoPlayer1*2;
      drawingBoard(numOfTwo, player1board);
      
      
      //PLAYER 1 THREE-UNIT SHIPS
      System.out.println("Now entering coordinates for your " + threePlayer1 + " 3-unit ships");
      int numOfThree = threePlayer1*3;
      
      System.out.println("You have completed placing your 3-unit ships. Here is what your board currently looks like: ");
      drawingBoard(numOfThree, player1board);
      
      //PLAYER 1 FOUR-UNIT SHIPS
      System.out.println("Now entering coordinates for your " + fourPlayer1 + " 4-unit ships");
      int numOfFour = fourPlayer1*4;
      
      System.out.println("You have completed placing your 4-unit ships. Here is what your board currently looks like: ");
      drawingBoard(numOfFour, player1board);
      
      
      //END OF PLAYER 1
      System.out.println();
      System.out.println("PLAYER TWO'S TURN!");
      
      //PLAYER 2 TWO-UNIT SHIPS
      System.out.println();
      System.out.println("Okay, it's time for Player 2 to set up their two-unit ships! You will be asked to type in coordinates for each of your ships.");
      
      
      System.out.println("Now entering coordinates for you " + twoPlayer1 + " 2-unit ships");

      System.out.println("You have completed placing your 2-unit ships. Here is what your board currently looks like: ");
      int numOfTwo2 = twoPlayer1*2;
      drawingBoard(numOfTwo2, player2board);
      
      
      //PLAYER 2 THREE-UNIT SHIPS
      System.out.println("Now entering coordinates for your " + threePlayer1 + " 3-unit ships");
      int numOfThree3 = threePlayer1*3;
      
      System.out.println("You have completed placing your 3-unit ships. Here is what your board currently looks like: ");
      drawingBoard(numOfThree3, player2board);
      
      //PLAYER 2 FOUR-UNIT SHIPS
      System.out.println("Now entering coordinates for your " + fourPlayer1 + " 4-unit ships");
      int numOfFour4 = fourPlayer1*4;
      
      System.out.println("You have completed placing your 4-unit ships. Here is what your board currently looks like: ");
      drawingBoard(numOfFour4, player2board);
      
      System.out.println("The game begins!");
      
      
      int count1 = 0;

      //Player 1 total X's to defeat
      for(int i=0; i<player1board.length; i++){
        for(int j=0; j<player1board[i].length; j++){
          if (player1board[i][j].equals("X ")){
            count1++;
          }
        }
      }
      
      int actual1 = 0;
      int actual2 = 0;
      
      //GAME STARTING
      while(true){
        //Player 1
        System.out.println("Player 1, here's your board: ");
        printplayer1(newboard1);
        System.out.println("Pick a row: ");
        int guess1 = in.nextInt();
        System.out.println("Pick a column: ");
        int guess2 = in.nextInt();
        System.out.println(question1(guess1, guess2, player2board, newboard1));
        if(question1(guess1, guess2, player2board, newboard1).equals("Hit!")){
          newboard1[guess1][guess2] =  player2board[guess1][guess2] ;
          actual2++;
        }
        
        //Player 2
        System.out.println("Player 2, here's your board: ");
        printplayer1(newboard2);
        System.out.println("Pick a row: ");
        int guessPlayer1 = in.nextInt();
        System.out.println("Pick a column: ");
        int guessPlayer2 = in.nextInt();
        System.out.println(question1(guessPlayer1, guessPlayer2, player1board, newboard2));
        if(question1(guessPlayer1, guessPlayer2, player1board, newboard2).equals("Hit!")){
          newboard2[guessPlayer1][guessPlayer2] = player1board[guessPlayer1][guessPlayer2];
          actual1++;
        }
        
        
        //who won?
        if(actual2 == count1){
          System.out.println("END");
          System.out.println("Player 1 has won!");
          break;
        }
        else if(actual1 == count1){
          System.out.println("END");
          System.out.println("Player 2 has won!");
          break;
        }
      }
      
    }
  
    
    //creates board PLAYER 1
    public static String[][] table(String[][] board){
      for(int i=0; i<board.length; i++){
    	  for(int j=0; j<board[i].length; j++){
    	    if(i==0){
    	      board[i][j] = Integer.toString(j) + " ";
    	    }
    	    else if(j==0&&i>0){
    	      board[i][j] = Integer.toString(i) + " ";
    	    }
    	    else{
    	      board[i][j] = "- ";
    	    }
    	    
    	  }
    	}
    	return board;
    }
    
    //drawing board player 1
    public static String[][] coord(int x, int y, String[][] board){
      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
          if(i==x && j==y){
            board[i][j] = "X ";
          }
        }
      }
      
      return board;
    }

    //prints board
    public static void printplayer1(String[][] board){
      for(String[] i: board){
        for(String j: i){
          System.out.print(j);
        }
        System.out.println();
      }
    }
    
    //DRAWS PLAYER 1 BOARD WITH RESPECTIVE COORDINATES
    public static void drawingBoard(int two, String[][] player1board) {
      Scanner in = new Scanner(System.in);
      int i=1;
      
      while(i <= two) {
        System.out.println("Pick a row: ");
        int rowPlayer1 = in.nextInt();
        System.out.println("Pick a column: ");
        int columnPlayer1 = in.nextInt();
        //ship[i-1] = columnPlayer1;
        
        
        if (rowPlayer1 > player1board.length-1 || columnPlayer1 > player1board[0].length){
          System.out.println("Sorry those coordinates are out of bounds");
          two++;
        }
        
        else if (player1board[rowPlayer1][columnPlayer1].equals("X ")){
          System.out.println("You already placed a ship there!");
          two++;
        }
        
        player1board = coord(rowPlayer1, columnPlayer1, player1board);
        i++;
    }
      printplayer1(player1board);
    }
    
    
    //Starting of player 1
    public static String question1(int guess1, int guess2, String[][] player2board, String[][] newboard1) { 
        
        //Hit or miss
        if(player2board[guess1][guess2].equals("X ")){
              return "Hit!";
            }
        else {
          return "Miss!";
        }
    }
    
/*    //Starting of player 2
    public static String question2(int guessPlayer1, int guessPlayer2, String[][] player1board, String[][] newboard2) { 
        
        //Hit or miss
        if(player1board[guessPlayer1][guessPlayer2].equals("X")){
              return "Hit!";
            }
        else {
          return "Miss!";
        }
    }*/
}
