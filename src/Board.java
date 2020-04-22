import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;
public class Board{
     Switch trackOrigin;
     void populate(File boardmap){
          /*
          populates the board class with the tracks and switches defined in a level file
          input:
               A level file File object boardmap
          Output:
               void (beginning of the level map referenced by the track origin)
          */
          //A list of switches to contian them before linking
          ArrayList <Switch> switchList = new ArrayList<Switch>();
          Pattern switchP = Pattern.compile("^\\s*\\[\\s*(\\d):\\s*(\\d),\\s*(\\d),\\s*(\\d)\\s*\\](\\s*//.*|\\s*)$");
          Pattern trackP = Pattern.compile("^\\s*\\(\\s*(\\d,\\d):\\s*(\\d\\s*)*;\\s*(\\d\\s*)*\\)(\\s*//.*|\\s*)$");
          //regex strings for situations where creating a matcher object is unnessesary
          String openScopeRegEx = "\\s*({*)\\s*(//.*)?";
          String blankLineRegEx = "\\s*(//.*)?"; //don't need a full matcher for detecting blank lines
          String closeScopeRegEx = "\\s*(*})\\s*(//.*)?";
          //scanner for reading file lines
          boolean switchblock = false;
          boolean trackblock = false;

          try {
               Scanner boardscn = new Scanner(boardmap);
               Matcher blankMatch;
               Matcher scopeMatch;
               while(boardscn.hasNextLine()){
                    String currline = boardscn.nextLine();
                    System.out.print(currline + "\t");
                    if(!currline.matches(blankLineRegEx)){
                         if(readSwitch(switchP.matcher(currline), switchList)){ //passes switchP matcher to currline, expects false if !matches()
                              System.out.print("--switch def");
                         }
                         else if(readTrack(trackP.matcher(currline), switchList)){
                              System.out.print("--track def");
                         }
                    }
                    System.out.println();
               }
          }
          catch(FileNotFoundException noSuchFile){
               System.out.println("No such board file found");
          }
     }

     private boolean readSwitch(Matcher matchedline, ArrayList<Switch> switchList){
          if(!matchedline.matches()){
               //if the input is not matched, return false
               return false;
          }
          //otherwise use it to define a switch;
          Switch genSwitch = new Switch();
          return true;


     }

     private boolean readTrack(Matcher matchedline, ArrayList<Switch> switchList){
          if(!matchedline.matches()){
               return false;
          }
          //Track genTrack = new Track();
          return true;
     }
}
