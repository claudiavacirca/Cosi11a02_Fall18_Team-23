import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class RandomNetflix{
  public static void main(String[] args){

    String[][] movieData = readData();
    Scanner sc = new Scanner(System.in);
//System.out.println(movieData[78][2]);
    System.out.println("Insert the minimum rating you would watch:");
    int rating = sc.nextInt();
    for(int i = 0 ; i < 999; i++){

      int intRating = Integer.parseInt(movieData[i][2]);
      for(intRating = rating; rating > 125; rating++){

        System.out.println("Insert the required year:");
        int year = sc.nextInt();
          //System.out.println(movieData[78][2]);
        int intYear = Integer.parseInt(movieData[i][3]);
        while(intYear == year){

          System.out.println("Would you like a TV, PG or R type?");
          String inputType = sc.nextLine();
          String type = movieData[i][1].substring(0);

          if(inputType.equals("TV") && type.equals("T")){
            String tvShow = randomMovie(movieData);

          } else if(inputType.equals("PG") && type.equals("P")){
            String pgMovie = randomMovie(movieData);

          } else if(inputType.equals("R") && type.equals("R")){
            String rMovie = randomMovie(movieData);
          }
          else{
            System.out.println("I am sorry, it doesn't seem like we can help you.");
          }
        }
      }
    }
  }

  public static String[][] readData(){

    String[][] data = new String[999][4];

    try {
        String DataSet = "Netflix_Shows.csv";
        File file = new File(DataSet);
        Scanner fileScanner = new Scanner(file);
        //int row=0;

        while (fileScanner.hasNextLine()) {
          String line = fileScanner.nextLine();
          for(int row = 0; row < data.length; row ++){
                      data[row+1] = line.split(",");
            for(int col = 0; col < data[row].length; col++){
              data[row][col] = fileScanner.nextLine();
          }
          }
        }
          fileScanner.close();
    } catch (FileNotFoundException e) {
          System.out.println("File not found!");
      }
      return data;
  }

  public static String randomMovie(String[][] movie){

    int randomMovieIndex =(int)(Math.random() * 999);
    String suggestion = movie[randomMovieIndex-1][0];
    System.out.println(suggestion);

    return suggestion;
  }
}
