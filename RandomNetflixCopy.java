import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class RandomNetflixCopy{
  public static void main(String[] args){

    String[][] movieData = readData();
    Scanner sc = new Scanner(System.in);

    System.out.println("Insert the minimum rating you would watch:");
    int rating = sc.nextInt();
    System.out.println("Insert the required year:");
    int year = sc.nextInt();
    for(int i = 0 ; i < movieData.length; i++){
      /*System.out.println(movieData[i][0]);
      System.out.println(movieData[i][1]);
      System.out.println(movieData[i][2]);
      System.out.println(movieData[i][3]);
      System.out.println(movieData[i][4]);*/
      int intRating = Integer.parseInt(movieData[i][2]);
      for(intRating = rating; intRating <= 125; intRating++){

        /*System.out.println(movieData[i][0]);
        System.out.println(movieData[i][1]);
        System.out.println(movieData[i][2]);
        System.out.println(movieData[i][3]);
        System.out.println(movieData[i][4]);*/
        int intYear = Integer.parseInt(movieData[i][3]);
        if(intYear == year){

          System.out.println("Would you like a TV, PG or R type?");
          String inputType = sc.nextLine();
          String type = movieData[i][1].substring(0);

          if(inputType.equals("TV") && type.equals("T")){
            String tvShow = randomMovie(movieData);
            System.out.println(tvShow);

          } if(inputType.equals("PG") && type.equals("P")){
            String pgMovie = randomMovie(movieData);
            System.out.println(pgMovie);

          } if(inputType.equals("R") && type.equals("R")){
            String rMovie = randomMovie(movieData);
            System.out.println(rMovie);
          }
          else{
            System.out.println("I am sorry, it doesn't seem like we can help you.");
          }
        }
      }
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

  public static String randomMovie(String[][] movieData){

    int randomMovieIndex =(int)(Math.random()*1000);
    String suggestion = movieData[randomMovieIndex][0];
    System.out.println(suggestion);

    return suggestion;
  }
}
