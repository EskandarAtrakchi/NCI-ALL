/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopclasstest;

/**
 *
 * @author escan
 */
public class ProcessData {
    
    String sentence;

    //setter
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    
    
    
    public int countVowels () {//vowels
        
        int vowelsCount = 0;
        String vowels = "aioue";

        for ( char c : sentence.toCharArray()) {

            if ( vowels.contains(String.valueOf(c))) {

                vowelsCount++;

            }
        }
        return vowelsCount;
    }
    
    public int countConsonants () {//Consonants
        
        int consonantsCount = 0;
        String consonants = "bcdfghjklmnpqrstvwxyz";
        
        for ( char c : sentence.toCharArray()) {
            
            if ( consonants.contains(String.valueOf(c))) {
                
                consonantsCount ++;
                
            }
        }
        return consonantsCount;
    }
    
    public int wordCount () {//words
        
        String wordCount = " ";
        int SpaceCount = 0;
        
        for ( char c : sentence.toCharArray ()) {
            
            if ( wordCount.contains(String.valueOf(c))) {
                
               SpaceCount ++;
                
            }
        }
        return SpaceCount;
    }
    //number of the letter could be by doing the number of vowels + the number of consonants 
    //The number of words could be done by SpaceCount + 1
    
}
