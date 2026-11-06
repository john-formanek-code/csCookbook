import java.util.Scanner;

public class mesic {

    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadej měsíc: ");
        int a = scanner.nextInt();

        switch (a) {
            case 1:
                System.out.print("Leden");
                break;
            case 2:
                System.out.print("únor");
                break;
            case 3:
                System.out.print("březen");
                break;
            case 4:
                System.out.print("duben");
                break;
            case 5:
                System.out.print("květen");
                break;
            case 6:
                System.out.print("červen");
                break;
            case 7:
                System.out.print("červenec");
                break;
            case 8:
                System.out.print("srpen");
                break;
            case 9:
                System.out.print("září");
                break;
            case 10:
                System.out.print("říjen");
                break;
            case 11:
                System.out.print("listopad");
                break;
            case 12:
                System.out.print("prosinec");
                break;
            default:
                System.out.print("něco špatně");
                break;
        }
        scanner.close();
    }

    }

