import java.util.ArrayList;
public class Switch{
     public int number; //number of the beast
     private ArrayList<Track> Connections;
     private int numberOfPositions; //number of connections - 0 is the first position. number - 1 is the last.
     private int position; //current position
     private int numberOfTaps; //number of taps. 0 = unlimited


     public Switch(int assignedNumber, int assignednumberPositions, int assignedTaps){
          numberOfPositions = assignednumberPositions;
          number = assignedNumber;
          position = 0;
          numberOfTaps = assignedTaps;
          Connections = new ArrayList<Track>();
     }
     public void addTrack(Track Addition){
          Connections.add(Addition);
     }
     public Track getTrack(){
          return Connections.get(position);
     }
     public int trackNumber(){
          return Connections.size();
     }

     public void setPosition(int pos){
          position = pos%numberOfPositions;
     }
     public int getPositon(){
          return position;
     }
}
