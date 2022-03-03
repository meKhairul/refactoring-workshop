/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HtmlConvertPackage;

import workshop.PatternMatcher;

/**
 *
 * @author Acer
 */
public class AndMatcher implements PatternMatcher {

     public boolean matches(char chartoconvert) {
        return chartoconvert=='&'; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateRresponse() {
        return "&amp"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean matches(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
