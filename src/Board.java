import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
public class Board{
     Switch trackOrigin;
     /*
     //this may be a useless constructor
     Board(){
          trackOrigin = new Switch();
     }
     */
     void populateLevels(File boardmap){
          Pattern commentP = Pattern.compile("//*");  //discard a comment line
          Pattern openScopeP = Pattern.compile("{*"); //find a line with an open scope character
          Pattern closeScopeP = Pattern.compile("*}");
          Pattern switchP = Pattern.compile("^\\s*\\[\\s*(\\d):\\s*(\\d),\\s*(\\d),\\s*(\\d)\\s*\\](\\s*//.*|\\s*)$");
     }

     private Switch readSwitch(String line){
          Switch genSwitch = new Switch();
          return genSwitch;
     }
     /*
     private Track readTrack(ArrayList<Switch> switches, String line){
          Track genTrack = new Track();
          return genTrack;
     }
     */
}
