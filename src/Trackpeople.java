public class Trackpeople{
     private int number;
     private int position;
     public Trackpeople(int num, int pos){
          number = num;
          position = pos;
     }
     public int[] squish(){
          int[] numPos = new int[2];
          numPos[0] = number;
          numPos[1] = position;
          return numPos;
     }
}
