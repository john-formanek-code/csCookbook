import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 1) NENÍ polymorfismus – vytvářím přímo Movie.
        //   Běhový typ = Movie, volá se Movie.watchMovie().
        // Movie theMovie = new Movie("John Wick");
        // theMovie.watchMovie();


        // 2) POLYMORFISMUS – proměnná je typu Movie,
        //    ale běhový objekt je Adventure (potomek).
        //    Volání theFilm.watchMovie() se v běhu přesměruje
        //    na Adventure.watchMovie() (dynamické vysílání).
        // Movie theFilm = new Adventure("Indiana Jones");
        // theFilm.watchMovie();

        // 3) Taky funguje (bez polymorfismu přes referenci),
        //    ale je to méně obecné: typ proměnné = Adventure,
        //    objekt = Adventure → volá se Adventure.watchMovie().
        // Adventure adventure = new Adventure("Jumanji");
        // adventure.watchMovie();



        // Movie theMovie = Movie.getMovie("A", "Hangover");
        // theMovie.watchMovie();


        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter the type of movie (A, C, D) or Q to quit:");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("Q")){
                break;
            }
            System.out.println("Enter the title of the movie:");
            String title = scanner.nextLine();
            Movie theMovie = Movie.getMovie(type, title);
            theMovie.watchMovie();
        }
        scanner.close();

    }
}

