import java.io.*;
class TEST1{
     /*
     test file io, graph loading and population
     terminal: java TEST1 file path
     */
     public static void main(String[] args){
          File testFile = new File(args[0]);
          Board testBoard = new Board();
          testBoard.populate(testFile);
     }
}
