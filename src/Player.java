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
        Equipment.Weapon.getDamage();
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

    public static String playerName = null;
    public static String playerWeapon = null;
    public static String playerShield = null;
    public static String playerHelm = null;
    public static String playerPlatebody = null;
    public static String playerPlatelegs = null;
    public static String playerBoots = null;

    public static class Equipment {
        public static Weapon weapon = null;


        public Equipment(String name, long damageReduction, EquipmentType equipmentType) {
        }

        public static class Weapon {
            private static String name;
            private static long damage = 0;

            Weapon(String name, long damage) {
                Weapon.name = name;
                Weapon.damage = damage;
            }

            public static long getDamage() {
                return damage;
            }

            public static String getName() {
                return name;
            }
        }

        public static class Shield {
            private static String name;
            private static long armor = 0;

            Shield(String name, long damageReduction) {
                Shield.name = name;
                Shield.armor = damageReduction;
            }

            public static long getArmor() {
                return armor;
            }

            public static String getName() {
                return name;
            }
        }

        //TODO finish converting equipmentType to classes



       public enum EquipmentType {
           WEAPON(),
           SHIELD(),
           HELM,
           BODY,
           LEGS,
           BOOTS,
           RING,
           NULL;

           private EquipmentType() {

           }

           public static EquipmentType toArmor(String str) {
               str = str.toUpperCase();
               try {
                   return valueOf(str);
               } catch (Exception ex) {
                   return NULL;
               }
           }
       }
    }

}
