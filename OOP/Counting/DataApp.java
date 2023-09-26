/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopclasstest;

import javax.swing.JOptionPane;

/**
 *
 * @author escan
 */
public class DataApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String sentence = JOptionPane.showInputDialog( null , "Enter a sentence ");
        
        ProcessData app = new ProcessData ();
        
        app.setSentence(sentence);
        int numLetters = app.countVowels() + app.countConsonants();
        int numberOfWords = app.wordCount() + 1;
        
        JOptionPane.showMessageDialog( null , "Number of vowels are: " + app.countVowels() 
                + "\nNumber of consonants are: " + app.countConsonants() 
                + "\nNumber of words are: " + numberOfWords
                + "\nNumber of letters are: " + numLetters);
        
    }
    
}
