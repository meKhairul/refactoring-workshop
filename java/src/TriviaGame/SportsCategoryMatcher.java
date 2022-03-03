/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TriviaGame;

import TriviaGame.CategoryMatcher;

/**
 *
 * @author Acer
 */
public class SportsCategoryMatcher implements CategoryMatcher{
    @Override
    public boolean matches(int number) {
         if(number==6 || number==2)return true;
         return false;
    }

    @Override
    public String generatecategory() {
        return "Sports";
    }
}
