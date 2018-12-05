import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class NetflixCopyA{
  public static void main(String[] args){

    String[][] movieData = readData();
    Scanner sc = new Scanner(System.in);

    System.out.println("Insert the minimum rating you would watch:");
    int rating = sc.nextInt();
    System.out.println("Insert the required year:");
    int year = sc.nextInt();
    System.out.println("Would you like a TV, PG or R type?");
    String inputType = (sc.nextLine()).substring(0);
    int counter = 0;

    for(int i = 0 ; i < movieData.length; i++){
      int intRating = Integer.parseInt(movieData[i][2]);
      int intYear = Integer.parseInt(movieData[i][3]);
      String type = movieData[i][1].substring(0);
      if(intRating>=rating && intYear==year && type==inputType){
        counter++;
      }
      String[][] options = new String[counter+1][4];
      int num = 0;
      for(int j = 0 ; j < movieData.length; j++){
        if(intRating>=rating && intYear==year && type==inputType){
          options[num][4] = movieData[j][4];
          num+=1;
        }
      }
      String suggestion = randomMovie(options,num);
    }
  }


  public static String[][] readData(){
    String[][] data = new String[1000][4];

    try {
        String DataSet = "Netflix_Shows.csv";
        File file = new File(DataSet);
        Scanner fileScanner = new Scanner(file);
        int row=0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            if (line != null && !line.trim().isEmpty()) {
              data[row]= line.split(",");
              row+=1; //+= instead of ++
          }
        }
          fileScanner.close();
    } catch (FileNotFoundException e) {
          System.out.println("File not found!");
      }
      return data;
  }

  public static String randomMovie(String[][] options, int num){

    int randomMovieIndex =(int)(Math.random()*num+1);
    String suggestion = options[randomMovieIndex][0];
    System.out.println(suggestion);

    return suggestion;
  }
}
