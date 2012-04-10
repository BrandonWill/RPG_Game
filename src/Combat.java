/**
 * Created by IntelliJ IDEA.
 * User: Brandon
 * Date: 4/4/12
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Combat {

    private static boolean playersTurn = true;

    public static boolean isDead(boolean isPlayer) {
        return isPlayer ? Player.getCurrentHealth() <= 0 : Monster.getCurrentHP() <= 0;
    }

    public static boolean isAlive(boolean isPlayer) {
        return isPlayer ? Player.getCurrentHealth() > 0 : Monster.getCurrentHP() > 0;
    }

    public static void fight() {
        if (isDead(true)) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
            }
        }
        if (isDead(false)) {

        }
        if (!isDead(false)) {

        }
    }

    public static boolean isPlayersTurn() {
        return playersTurn;
    }

    public static void setPlayersTurn(boolean playersTurn) {
        Combat.playersTurn = playersTurn;
    }

}
