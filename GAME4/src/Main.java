import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя героя:");
        String heroName = scanner.nextLine();
        Game game = new Game(heroName);
        game.start();
    }
}
