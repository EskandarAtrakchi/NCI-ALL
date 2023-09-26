/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javabuffering;

/**
 *
 * @author escan
 */
public class JavaBuffering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String example = "Beep Boop";
        StringBuffer strBuff = new StringBuffer();
        strBuff.append(example.charAt(0));
        for(int i =1; i < example.length()-1; i++){//open
                strBuff.append('*');
         }//close

        strBuff.append(example.charAt(example.length()-1));
        String newWord = strBuff.toString();
        System.out.println(newWord);
    }
}
