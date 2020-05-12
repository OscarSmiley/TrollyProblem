import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;
public class Board{
     //debug output
     public static final boolean DEBUG = false;

     public Switch trackOrigin;
     private ArrayList <Switch> switchList = new ArrayList<Switch>();
     //private ArrayList <Track> TrackList = new ArrayList<Track>();
     public void populate(File boardmap){
          /*
          populates the board class with the tracks and switches defined in a level file
          input:
               A level file File object boardmap
          Output:
               void (beginning of the level map referenced by the track origin)
          */
          //A list of switches to contian them before linking
          Pattern switchP = Pattern.compile("^\\s*\\[\\s*(\\d):\\s*(\\d),\\s*(\\d),\\s*(\\d)\\s*\\](\\s*//.*|\\s*)$");
          Pattern trackP = Pattern.compile("^\\s*\\(\\s*(\\d),\\s*(\\d):\\s*(\\d\\s*)*;\\s*(\\d\\s*)*\\)(\\s*//.*|\\s*)$");
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
                    if(readSwitch(switchP.matcher(currline), switchList)){
                    }
                    else if(readTrack(trackP.matcher(currline), switchList)){
                    }
                    if(DEBUG){
                         System.out.println(currline);
                    }
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
          Switch genSwitch = new Switch(Integer.parseInt(matchedline.group(1)), Integer.parseInt(matchedline.group(2)), Integer.parseInt(matchedline.group(4)));
          if(Integer.parseInt(matchedline.group(1)) == 0){
               trackOrigin = genSwitch;
          }
          genSwitch.setPosition(Integer.parseInt(matchedline.group(3)));
          switchList.add(genSwitch);
          return true;


     }

     private boolean readTrack(Matcher matchedline, ArrayList<Switch> switchList){
          if(!matchedline.matches()){
               return false;
          }

          Switch start = findSwitch(switchList, Integer.parseInt(matchedline.group(1)));
          Switch end = findSwitch(switchList, Integer.parseInt(matchedline.group(2)));
          if(start == null || end == null){
               System.out.println("start or end null");
               //thow exeption
          }
          Track genTrack = new Track(start, end);
          start.addTrack(genTrack);
          //end.addTrack(genTrack); //bug found by test2.
                                    //linking the track to the end switch track lists effectively links the end switch to itself.
                                    //track start and end points implicitly define switch track links as outgoing directional tracks
          return true;
     }
     private Switch findSwitch(ArrayList<Switch> SearchList, int number){
          //linear search by switchnumber
          //find out if you can use ArrayList.contains() to do this
          for(int i = 0; i < SearchList.size(); i++){
               if(SearchList.get(i).number == number){
                    return SearchList.get(i);
               }
          }
          return null;
     }
}
