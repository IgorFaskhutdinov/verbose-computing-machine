import java.util.Random;
import java.util.Scanner;

public class Character {
    protected String name;
    protected int maxHealth;
    protected int health;
    protected int strength;
    protected int dexterity;
    protected int experience;
    protected int gold;

    public Character(String name, int maxHealth, int health, int strength, int dexterity, int experience, int gold){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.experience = experience;
        this.gold = gold;
    }
    public void attack(Character enemy) {
        Random random = new Random();
        if (random.nextInt(100) < dexterity) {
            int damage = random.nextInt(strength);
            enemy.takeDamage(damage);
            System.out.println(name + " нанёс " + damage + " урона " + enemy.name);
        }else {
            System.out.println(name + " промахнулся ");
        }
    }
    public void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            health = 0;
            System.out.println(name + " погиб ");
        }
    }
    public void useHealthPotion(){
        if (gold >= 10) {
            gold -= 10;
            health += 20;
            if (health > maxHealth) {
                health = maxHealth;
            }
            System.out.println(name + " использовал зелье лечения ");
        }else {
            System.out.println("Нужно больше золота");
        }
    }
    public boolean isAlive(){
        return health > 0;
    }
    public void displayStats(){
        System.out.println("Имя: " + name);
        System.out.println("Здоровье: " + name);
        System.out.println("Сила: " + name);
        System.out.println("Опыт: " + name);
        System.out.println("Ловкость: " + name);
        System.out.println("Золото: " + name);
    }
}
