/**
 * Created with IntelliJ IDEA.
 * User: Owner
 * Date: 4/10/12
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculations {
    private static double xpMultiplier = 1.01;

    public static int grabCurrentLevel() {
        long x = Player.getExperience();
        int y = 0;
        if (x >= 100) {
            while (x >= 100) {
                x = (int) (x / xpMultiplier);
                y++;
            }
        } else {
            y = 0;
        }
        return y;
    }

    public static void createNextLevel() {
        if (Player.getLevel() == 0) {
            Player.setExperienceToLevel(10);
        } else {
            if (Player.getExperience() >= Player.getExperienceToLevel()) {
                Player.setExperienceToLevel(Player.getExperience() + (long) (Player.getExperienceToLevel() * xpMultiplier));
//                System.out.println("xp to lvl:" + Player.getExperienceToLevel());
            }
        }
    }

}
