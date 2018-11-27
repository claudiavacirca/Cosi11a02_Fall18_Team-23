import java.util.Scanner;
import java.io.File;

public class RandomNetflix{
  public static void main(Sting[] args){
    String[][] movieData = readData();
    writeData(storeData);
  }
  public static String[][] readData(){
    //Title,Rating,Rating Description,Release year
    String[][] data = new String[1000][4];
    try {
        String DataSet = "Netflix Shows.csv";
        File file = new File(DataSet);
        // next create a scanner to read from the file
        Scanner fileScanner = new Scanner(file);

        // now read the entire file and print it with line numbers:
        int row=0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            data[row++]= line.split(",");
        }
          fileScanner.close();
     }
     catch (Exception ex) {       //????
          ex.printStackTrace();
      }
      return data;
    }
  public static void writeData(String[][] data){
    String[] cols =
      {"Title","Rating","Rating Description","Release Year"};
/*    for(int i=0; i<data.length; i++){
      System.out.printf("%5d ",i);
      for(int j=0;j<4;j++){
        System.out.printf("%5s ",data[i][j]);
      }
      System.out.println();*/
    }
  }
}

//How do we read though a file and have it store information in an array that we can use?

System.out.println("Insert the minimum rating you would watch:");
int rating = TextIO.getlnInt();
for(int i = rating; i >= 1; i++){
  System.out.println("Insert the required year:");
  int year = TextIO.getlnInt();
