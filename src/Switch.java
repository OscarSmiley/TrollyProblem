import java.util.ArrayList;
public class Switch{
     private int position;
     private ArrayList<Track> Connections;

     public Switch(){
          position = 0;
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
