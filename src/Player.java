/**
 * Created by IntelliJ IDEA.
 * User: Brandon
 * Date: 4/4/12
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private static long currentHealth = 0;
    private static long totalHealth = 0;
    private static long currentMana = 0;
    private static long totalMana = 0;
    private static long experience = 0;
    private static long level = 0;
    private static long gold = 0;
    private static long experienceToLevel = 0;
    private static String location = "NONE";

    public Player(long currHP, long totHP, long currMana, long totMana, long xp, long lvl, long money, long xpToLvl, String loc) {
        currentHealth = currHP;
        totalHealth = totHP;
        currentMana = currMana;
        totalMana = totMana;
        experience = xp;
        level = lvl;
        gold = money;
        experienceToLevel = xpToLvl;
        location = loc;
    }

    public static void setCurrentHealth(long amount) {
        currentHealth = currentHealth == 0 ? amount : currentHealth+amount;
    }

    public static long getCurrentHealth() {
        return currentHealth;
    }

    public static void setTotalHealth(long amount) {
        totalHealth = amount;
    }

    public static long getTotalHealth() {
        return totalHealth;
    }

    public static void setCurrentMana(long amount) {
        currentMana = currentMana == 0 ? amount : currentMana+amount;
    }

    public static long getCurrentMana() {
        return currentMana;
    }

    public static void setTotalMana(long amount) {
        totalMana = amount;
    }

    public static long getTotalMana() {
        return totalMana;
    }

    //Allows setting and adding experience
    public static void setExperience(long amount) {
        experience += amount;
    }

    public static long getExperience() {
        return experience;
    }

    public static void setLevel(int lvl) {
        level = lvl;
    }

    public static long getLevel() {
        return level;
    }

    public static void setGold(long amount) {
        gold += amount;
    }

    public static long getGold() {
        return gold;
    }

    public static void setExperienceToLevel(long amount) {
        experienceToLevel = amount;
    }

    public static long getExperienceToLevel() {
        return experienceToLevel;
    }

    public static void setLocation(String loc) {
        location = loc;
    }

    public static String getLocation() {
        return location;
    }

}
