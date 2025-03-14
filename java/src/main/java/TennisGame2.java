public class TennisGame2 implements TennisGame
{

    //initialize players and player scores
    public int player1Score = 0;
    public int player2Score = 0;
    private String player1Name;
    private String player2Name;

// call the player name constructor
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    //initialize the tennis scores names 
    private static final String[] tennisScore = {
        "Love", 
        "Fifteen", 
        "Thirty", 
        "Forty"
    };
// get the score
private String getMatchScore() {
    return tennisScore[player1Score] + "-" + tennisScore[player2Score];
}
// update the score for points won
public void wonPoint(String player) {
    if (player.equals(player1Name)) {
        player1Score++;
    } else {
        player2Score++;
    }
}
// get the player that is ahead
private String leadingPlayer() {
    return player1Score > player2Score ? player1Name : player2Name;
}

    //check if the score is deuce(40-40)
    private boolean isDeuce() {
        return player1Score >= 3 && player1Score == player2Score;
    }
// check if one player is ahead by 1 point after a
    private boolean isAdvantage() {
        return (player1Score >= 4|| player2Score >= 4) && Math.abs(player1Score - player2Score) == 1;
    }
// check if one player has won
    private boolean isWin() {
        return (player1Score >= 4 || player2Score >= 4) && Math.abs(player1Score - player2Score) >= 2;
    }

 //break the score into different cases
 public String getScore() {
    if (isDeuce()){
        return "Deuce";
    } 
    if (isAdvantage()) {
        return "Advantage " + leadingPlayer();
    };
    if (isWin()){
        return "Win for " + leadingPlayer();
    } ;
    if (player1Score == player2Score){
         return tennisScore[player1Score] + "-All";
    };
    return getMatchScore();
};
};


// Solid Principles Notes.......

// Single Responsibility Principle
// The TennisGame2 class has a single responsibility: to manage the score of a tennis game.This makes it easy to modify or extend the class without affecting other parts of the program.

// Open/Closed principle
// You can create new classes that implement the TennisGame interface to add new features or change the behavior of the game without modifying the TennisGame2 class.
    
// Liskov Substitution Principle
// The TennisGame2 class can be substituted for any other class that implements the TennisGame interface without affecting the behavior of the program.

// Interface Segregation Principle
// The TennisGame interface is segregated into separate methods for different aspects of the game, such as getting the score and updating the score.

// Dependency Inversion Principle
// The TennisGame2 class depends on the TennisGame interface, which allows it to be decoupled from specific implementations of the interface.

