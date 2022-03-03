package TriviaGame;

import TriviaGame.Questions;
import TriviaGame.Players;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriviaGame {
    
    List<CategoryMatcher> categoryMatchers;
    Players players = new Players();
    Questions questions = new Questions();
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame(Players players) {
        this.players = players;
        questions.making_question();
    }
    public boolean isPlayable() {
        return (players.howManyPlayers()>= 2);
    }

    public void printPlayersPlace()
    {
        announce(players.getPlayers_name().get(currentPlayer)
                        + "'s new location is "
                        + players.getPlaces(currentPlayer));
                announce("The category is " + currentCategory());
    }
    public void printPlayerPursue()
    {
        announce(players.getPlayers_name().get(currentPlayer)
                        + " now has "
                        + players.getPurses()[currentPlayer]
                        + " Gold Coins.");
    }
    
    public void roll(int roll) {
        announce(players.getPlayers_name().get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        if (players.getInPenaltyBox()[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                announce(players.getPlayers_name().get(currentPlayer) + " is getting out of the penalty box");
                players.addToPlaces(currentPlayer, roll);
                
                if (players.getPlaces(currentPlayer) > 11) players.addToPlaces(currentPlayer, -12);

                printPlayersPlace();
                askQuestion();
            } else {
                announce(players.getPlayers_name().get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            players.addToPlaces(currentPlayer, roll);
            if (players.getPlaces(currentPlayer) > 11) players.addToPlaces(currentPlayer, -12);

            printPlayersPlace();
            askQuestion();
        }

    }

    private void askQuestion() {
        
        announce(questions.newQuestion(currentCategory()));
        
    }


    private String currentCategory() {
        for(CategoryMatcher categoryMatcher : categoryMatchers)
            if(categoryMatcher.matches(players.getPlaces(currentPlayer))) return categoryMatcher.generatecategory();
        
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (players.getInPenaltyBox()[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                players.getPurses()[currentPlayer]++;
                printPlayerPursue();

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.getPlayers_name().size()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.getPlayers_name().size()) currentPlayer = 0;
                return true;
            }


        } else {

            announce("Answer was correct!!!!");
            players.getPurses()[currentPlayer]++;
            printPlayerPursue();

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.getPlayers_name().size()) currentPlayer = 0;

            return winner;
        }
    }

    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(players.getPlayers_name().get(currentPlayer) + " was sent to the penalty box");
        players.getInPenaltyBox()[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.getPlayers_name().size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(players.getPurses()[currentPlayer] == 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}