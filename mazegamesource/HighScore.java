import java.util.*;
import java.io.*;
import java.beans.*; 

public class HighScore {
    public void addHighScore(String name, int min, int sec,int level) {
        try{
            PrintWriter out = new PrintWriter(new FileOutputStream("scores.txt", true));
            out.println("");

            String outData = "PlayerName: " + name + 
                " Total Time for Levels:" + min + ":" + sec + "(Minutes:Seconds)" + 
                "Level Reached:*" + level;

            out.println(outData); // prints the highscore data to scores.txt

            out.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }  
}

