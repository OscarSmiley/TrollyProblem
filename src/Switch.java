import java.util.ArrayList;
public class Switch{
     public int number; //number of the beast
     private int numberOfPositions; //number of connections
     private int position; //current position
     private int numberOfTaps; //number of taps. 0 = unlimited
     private ArrayList<Track> Connections;

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

     public void setPosition(int pos){
          position = pos;
     }
     public int getPositon(){
          return position;
     }
}
