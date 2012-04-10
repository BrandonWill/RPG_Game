package src;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Brandon
 * Date: 4/4/12
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Monster {
    static long currentHP;
    static long totalHP;
    static long currentMana;
    static long totalMana;
    static long level;
    static long killXP;
    static long killMoney;
    static long damage;
    static long armor;
    static long attackTimes;

    public static void getNewMonster() {
        if (Player.getLocation().equals("Tutorial")) {
            Random r = new Random();
            int rand = r.nextInt(1);
            switch (rand) {
                case 0:
                    new Monster(10, 10, 100, 100, Player.getLevel(), Player.getLevel() * 5, Player.getLevel(), 10, 15, 1);
                    break;
            }
        }
    }

//    public Monster(long curhp, long tothp, long curmana, long totmana, long att, long def) {
//        new Monster(curhp, tothp, curmana, totmana, 0, Player.getLevel() * 5, Player.getLevel(), att, def, 1);
//    }
//
//    public Monster(long curhp, long tothp, long curmana, long totmana, long lvl, long killxp, long money, long att, long def) {
//        new Monster(curhp, tothp, curmana, totmana, lvl, killxp, money, att, def, 1);
//    }
//
//    public Monster(long curhp, long tothp, long curmana, long totmana, long killxp, long money, long att, long def) {
//        new Monster(curhp, tothp, curmana, totmana, 0, killxp, money, att, def, 1);
//    }

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
}
