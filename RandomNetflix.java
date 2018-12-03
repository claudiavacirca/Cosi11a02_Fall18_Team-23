import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class RandomNetflix{
  public static void main(String[] args){

    String[][] movieData = readData();
    Scanner sc = new Scanner(System.in);

    System.out.println("Insert the minimum rating you would watch:");
    int rating = sc.nextInt();
    for(int i = 0 ; i < 1000; i++){
  //    System.out.println("aaaaa");
      int intRating = Integer.parseInt(movieData[i][2]);
      for(intRating = rating; rating >= 125; rating++){

        System.out.println("Insert the required year:");
        int year = sc.nextInt();
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
<<<<<<< HEAD
    String[][] data = new String[1000][5];

    try {
        String DataSet = "Netflix_Shows.csv";
        File file = new File(DataSet);
        Scanner fileScanner = new Scanner(file);
        int row=0;
=======
    //Title,Rating,Rating Description,Release year
    String[][] data = new String[1000][4];
    File file = new File("Netflix_Shows.csv");
    try {
        Scanner fileScanner = new Scanner(file);
        // next create a scanner to read from the file
        // now read the entire file and print it with line numbers:
>>>>>>> 09af4e70fbaad2b1235fd66031c235a471727e85
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            data[row++]= line.split(",");
        }
          fileScanner.close();
    } catch (FileNotFoundException e) {
          System.out.println("File not found!");
      }
      return data;
  }

  public static String randomMovie(String[][] movie){

    int randomMovieIndex =(int)Math.floor(Math.random()*1000);
    String suggestion = movie[randomMovieIndex][0];
    System.out.println(suggestion);

    return suggestion;
  }
}
