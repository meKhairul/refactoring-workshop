package TriviaGame;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private ArrayList<String> players_name = new ArrayList<String>();
    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];

    public Players() {
        
    }
    public int howManyPlayers() {
        return players_name.size();
    }

    public boolean add_players(String name) {


        players_name.add(name);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        System.out.println(name + " was added");
        System.out.println("They are player number " + players_name.size());
        return true;
    }
    
    

    public int getPlaces(int player_number) {
        return places[player_number];
    }
    
    public void addToPlaces(int player_number,int add_roll_value)
    {
        places[player_number] = places[player_number] + add_roll_value;
    }

    public int[] getPurses() {
        return purses;
    }

    public ArrayList<String> getPlayers_name() {
        return players_name;
    }

    public boolean[] getInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean[] inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }
    
    
    
}