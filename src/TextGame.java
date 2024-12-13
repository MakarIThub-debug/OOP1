import java.util.Random;

public class TextGame {

    public static class Player {
        private String name;
        private int health;
        private Weapon weapon;

        public Player(String name, int health, Weapon weapon) {
            this.name = name;
            this.health = health;
            this.weapon = weapon;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public Weapon getWeapon() {
            return weapon;
        }

        public void setWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

        public void attack(Enemy enemy) {
            int damage = weapon.getDamage();
            int damageDealt = new Random().nextInt(damage) + 1; //Random damage within weapon's range
            enemy.takeDamage(damageDealt);
            System.out.println(name + " attacks " + enemy.getName() + " for " + damageDealt + " damage!");
        }
    }

    public static class Enemy {
        private String name;
        private int health;

        public Enemy(String name, int health) {
            this.name = name;
            this.health = health;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public void takeDamage(int damage) {
            health -= damage;
            if (health <= 0) {
                System.out.println(name + " has been defeated!");
            }
        }
    }


    public static class Weapon {
        private String name;
        private int damage;

        public Weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }
    }

    public static void main(String[] args) {
        // Create player, enemy, and weapon
        Weapon sword = new Weapon("Sword", 10);
        Player player = new Player("Hero", 100, sword);
        Enemy goblin = new Enemy("Goblin", 50);

        // Game loop
        while (player.getHealth() > 0 && goblin.getHealth() > 0) {
            player.attack(goblin);
            if (goblin.getHealth() <= 0) break; //Check if goblin is dead

            // Enemy attacks (simple example)
            int enemyDamage = new Random().nextInt(5) + 1; //Goblin deals 1-5 damage
            player.setHealth(player.getHealth() - enemyDamage);
            System.out.println("Goblin attacks " + player.getName() + " for " + enemyDamage + " damage!");
        }

        // Game over message
        if (player.getHealth() <= 0) {
            System.out.println("Game Over! You have been defeated.");
        } else {
            System.out.println("Congratulations! You have won!");
        }
    }
}
