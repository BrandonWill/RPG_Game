import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Brandon
 * Date: 4/4/12
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Monster {
    private static long currentHP;
    private static long totalHP;
    private static long currentMana;
    private static long totalMana;
    private static long level;
    private static long killXP;
    private static long killMoney;
    private static long damage;
    private static long armor;
    private static long attackTimes;

    public static void getNewMonster() {
        if (Player.getLocation().equals("Tutorial")) {
            Random r = new Random();
            int rand = r.nextInt(1);
            switch (rand) {
                case 0:
                    new Monster(10, 10, 100, 100, Player.getLevel(), 2, Player.getLevel(), 10, 15, 1);
                    break;
            }
        }
    }

    public Monster(long curhp, long tothp, long curmana, long totmana, long lvl, long killxp, long money, long att, long def, long timesToAttack) {
        currentHP = curhp;
        totalHP = tothp;
        currentMana = curmana;
        totalMana = totmana;
        level = lvl;
        killXP = killxp;
        killMoney = money;
        damage = att;
        armor = def;
        attackTimes = timesToAttack;
    }

    public static long getCurrentHP() {
        return currentHP;
    }

    public static void setCurrentHP(long currentHP) {
        Monster.currentHP = Monster.currentHP == 0 ? currentHP : Monster.currentHP+currentHP;
    }

    public static long getTotalHP() {
        return totalHP;
    }

    public static void setTotalHP(long totalHP) {
        Monster.totalHP = totalHP;
    }

    public static long getCurrentMana() {
        return currentMana;
    }

    public static void setCurrentMana(long currentMana) {
        Monster.currentMana = Monster.currentMana == 0 ? currentMana : Monster.currentMana+currentMana;
    }

    public static long getTotalMana() {
        return totalMana;
    }

    public static void setTotalMana(long totalMana) {
        Monster.totalMana = totalMana;
    }

    public static long getLevel() {
        return level;
    }

    public static long getKillXP() {
        return killXP;
    }

    public static long getKillMoney() {
        return killMoney;
    }

    public static long getDamage() {
        return damage;
    }

    public static long getArmor() {
        return armor;
    }

    public static long getAttackTimes() {
        return attackTimes;
    }
}
