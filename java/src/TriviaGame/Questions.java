/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TriviaGame;

import java.util.LinkedList;

/**
 *
 * @author Acer
 */
public class Questions {

    LinkedList<String> rockQuestions = new LinkedList<String>();
    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    
    public void making_question()
    {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(("Rock Question " + i));
        }
    }
    
    public String newQuestion(String category) {
        if (category == "Pop")
            return popQuestions.getFirst();
            
        if (category == "Science")
            return scienceQuestions.removeFirst();
        if (category == "Sports")
            return sportsQuestions.removeFirst();
        if (category == "Rock")
            return rockQuestions.removeFirst();
        return null;
    }
}
