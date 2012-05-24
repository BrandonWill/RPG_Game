import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IdleGame {
    public static String status = "None yet";
//    public static final File statsFile = new File(IdleGame.class.getResource("").getPath(), "DwarfehGameStatsFile.txt");

    //Player Strings
    public static String playerName = null;
    public static String playerWeapon = null;
    public static String playerShield = null;
    public static String playerHelm = null;
    public static String playerPlatebody = null;
    public static String playerPlatelegs = null;
    public static String playerBoots = null;

    public static boolean run = true;

    //TODO add player input, shop, etc
    //readFile() breaks it.
    public static void main(String args[]) {
//        if (readFile()) {
            new Player(10000000, 10000000, 100, 100, 121, 1, 0, 0, "Tutorial");
            Calculations.createNextLevel();
            Player.setLocation("Tutorial");
            Explore.search(Player.getLocation());
            Monster.getNewMonster();
            System.out.println(Monster.getCurrentHP());
        final DwarfehGameGUI gui = new DwarfehGameGUI();

        try {
            EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    gui.setVisible(true);
                }
            });
        } catch (Exception ignored) {
        }



        gameLoop.start();
    }

    static Thread gameLoop = new Thread(new Runnable() {
        public void run() {
            while (run) {
                if (Combat.isDead(true)) {
                    DwarfehGameGUI.jPanel1.repaint();
                    continue;
                }
                Player.setLevel(Calculations.grabCurrentLevel());
                Calculations.createNextLevel();
                if (Player.getCurrentHealth() > 0) {
                    Combat.setPlayersTurn(true);
                    Explore.search(Player.getLocation());
                    if (Combat.isPlayersTurn()) {
                        Monster.setCurrentHP(-5);
                        Combat.setPlayersTurn(false);
                        if (Combat.isDead(false)) {
                            Combat.setPlayersTurn(true);
                            Player.setGold(Monster.getKillMoney());

                            Player.setExperience(Monster.getKillXP());
                            Monster.getNewMonster();
                        }
                    }
                    if (!Combat.isPlayersTurn() && Combat.isAlive(false)) {
                        Player.setCurrentHealth(-(Monster.getDamage() * Monster.getAttackTimes()));
                    }
                }
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        DwarfehGameGUI.jPanel1.repaint();
                    }
                });
//            }
            }
        }
    });


    private static boolean readFile() {
        System.out.println("File Loc: " + IdleGame.class.getResource("").getPath());
        File statsFile = new File(IdleGame.class.getResource("").getPath(), "DwarfehGameStatsFile.txt");
        if (statsFile.exists()) {
            try {
                status = "Setting file found! Reading your current settings";
                String filename = IdleGame.class.getResource("").getPath() + "\\DwarfehGameStatsFile.txt";
                Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));
                String line;
                String[] opts = {};
                while (in.hasNext()) {
                    line = in.next();
                    if (line.contains(":")) {
                        opts = line.split(":");
                    }
                }
                in.close();
                if (opts.length > 1) {
                    //TODO finish file reader and writer
                }
                return true;
            } catch (final Exception e2) {
                status = "Error reading settings file!";
                e2.printStackTrace();
                return false;
            }
        } else {
            try {
                status = "Creating file for settings";
                return statsFile.createNewFile();
            } catch (IOException ignored) {
                status = "Error creating settings file!";
                return false;
            }
        }
    }





}

