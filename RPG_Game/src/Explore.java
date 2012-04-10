import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Brandon
 * Date: 4/4/12
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Explore {
    static String loc;
    static int loc2;

    public enum locations {
        TUTORIAL, NONE;

        public static locations toLoc(String str) {
            str = str.toUpperCase();
            try {
                return valueOf(str);
            } catch (Exception ex) {
                return NONE;
            }
        }
    }

    public static void search(String place) {
        Random r = new Random();
        int rand = r.nextInt(2);

        if (rand == 0) {
            IdleGame.status = "Going alternative searching route!";
            noMonsterSearch();
        }

        switch (locations.toLoc(place)) {

            case TUTORIAL:
                IdleGame.status = "Searching tutorial area!";
                break;

            case NONE:
                IdleGame.status = "Lost... how?";
                break;
        }
    }

    private static void noMonsterSearch() {
        Random r = new Random();
        int rand = r.nextInt(2);
        switch (rand) {
            case 0:
                int r1 = r.nextInt(10);
                IdleGame.status = "Explored: I found " + r1 + "gold";
                Player.setGold(r1);
                break;

            case 1:
                IdleGame.status = "Explored: Found nothing!";
                break;
        }
    }

    public Explore() {
        loc = Player.getLocation().toUpperCase();
    }
}
