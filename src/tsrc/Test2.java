import java.io.*;
import java.util.ArrayList;
class Test2MAIN{
     /*
     test file io, graph loading and population
     terminal: java TEST1 file path
     */
     public static void main(String[] args){
          File testFile = new File(args[0]);
          Board testBoard = new Board();
          testBoard.populate(testFile);
          ArrayList <Switch> Visited = new ArrayList <Switch>();
          System.out.println("Origin " + testBoard.trackOrigin.number);
          BoardBFS(testBoard.trackOrigin, Visited);
     }

     static void BoardBFS(Switch current, ArrayList <Switch> Visited){
          //System.out.println("BFS loaded board graph");
          System.out.println("---Switch " + current.number);
          current.setPosition(0);
          int nextposition = 1;
          //Track currentTrack;
          //work-around the private connections integers and arraylists in Switch
          for(int i = 0; i < current.trackNumber(); i++){
               Track currentTrack = current.getTrack();
               Switch nextSwitch = currentTrack.endSwitch;
               System.out.println("\titteration: " + i + " current: " + current.number + " next: " + nextSwitch.number);
               if(findSwitch(Visited, nextSwitch.number) == null){
                    System.out.println("\ttrack -> " + nextSwitch.number);
                    Visited.add(current);
                    BoardBFS(nextSwitch, Visited);
               }
          }
          System.out.println("---Switch " + current.number + " end");
     }

     static Switch findSwitch(ArrayList<Switch> SearchList, int number){
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
