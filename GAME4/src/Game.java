import java.util.Scanner;

class Game {
    private Hero hero;

    public Game(String heroName) {
        this.hero = new Hero(heroName);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру!");

        while (hero.isAlive()) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Отправиться к торговцу за зельем");
            System.out.println("2. Пойти в лес");
            System.out.println("3. Выйти из игры");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    visitMerchant();
                    break;
                case 2:
                    goIntoForest();
                    break;
                case 3:
                    System.out.println("Игра завершена");
                    return;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
        System.out.println("Игра завершена. " + hero.name + " погиб.");
    }

    private void visitMerchant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Торговец предлагает зелье лечения за 10 золотых.");
        System.out.println("У вас " + hero.gold + " золотых.");
        System.out.println("Хотите купить зелье? (y/n)");

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            hero.useHealthPotion();
        }
    }

    private void goIntoForest() {
        Monster skeleton = new Monster("Скелетон",80,70,25,25,15,10);
        Monster goblin = new Monster("Гоблин",100,80,30,20,30,20);

        System.out.println("Вас атакует " + skeleton.name);

        while (hero.isAlive() && skeleton.isAlive()) {
            hero.attack(skeleton);
            if (skeleton.isAlive()) {
                skeleton.attack(hero);
            }
        }

        if (hero.isAlive()) {
            System.out.println("Вы победили " + skeleton.name);
            hero.experience += skeleton.experience;
            hero.gold += skeleton.gold;
            System.out.println(hero.name + " получает " + skeleton.experience + " опыта");
            System.out.println(hero.name + " получает " + skeleton.gold + " золота");
        }

        System.out.println("Вас атакует " + goblin.name);

        while (hero.isAlive() && goblin.isAlive()) {
            hero.attack(goblin);
            if (goblin.isAlive()) {
                goblin.attack(hero);
            }
        }

        if (hero.isAlive()) {
            System.out.println("Вы победили " + goblin.name);
            hero.experience += goblin.experience;
            hero.gold += goblin.gold;
            System.out.println(hero.name + " получает " + goblin.experience + " опыта");
            System.out.println(hero.name + " получает " + goblin.gold + " золота");
        }
    }
}