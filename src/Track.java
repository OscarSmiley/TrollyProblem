import java.util.ArrayList;
public class Track{
     private int length;
     private ArrayList <Trackpeople> Peoples; //Always in order
     public Switch startSwitch;
     public Switch endSwitch;

     public Track(Switch start, Switch end){
          startSwitch = start;
          endSwitch = end;
          Peoples = new ArrayList <Trackpeople>();
     }
     public void AddPeople(int number, int percent){
          //adds a number of people at a % of the track length
          float trackLengh = (float)length;
          float trackRatio = ((float)percent)/(float)100;
          Trackpeople addition = new Trackpeople(number, (int)(trackLengh * trackRatio));
     }
     public int[] Traverse(){
          //returns an array of the peoples squished
          int[] squished = new int[Peoples.size()];
          for(int i = 0; i < Peoples.size(); i++){
               squished[i] = Peoples.get(0).squish()[0];
          }
          return squished;
     }

}
