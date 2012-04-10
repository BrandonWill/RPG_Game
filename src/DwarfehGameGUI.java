import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by IntelliJ IDEA.
 * User: Brandon
 * Date: 4/4/12
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class DwarfehGameGUI extends JFrame implements ComponentListener {
    private static final Rectangle menuRect = new Rectangle(50, 50, 61, 15);
    private static int panelHeight;
    private static int panelWidth;

    public DwarfehGameGUI() {
        addComponentListener(this);
        initComponents();
    }

    public void initComponents() {
        setTitle("Dwarfeh's Basic Game");
        setMinimumSize(new Dimension(600, 450));
        addWindowListener(new FrameListener());
        jPanel1 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawLayout(g);
                drawStickFigure(g);
                drawMenu(g);
                drawStatus(g);
//                g.fillOval(x-2, y-2, 4, 4);
//                g.drawString(System.getProperty("user.dir"), 10, 50);

            }
        };

        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(jPanel1);

        jMenu1.setText("File");
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed();
            }
        });
        jMenu1.add(jMenuItem1);

        jMenu2.setText("Edit");
        jMenu3.setText("Options");

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        panelHeight = jPanel1.getHeight();
        panelWidth = jPanel1.getWidth();
    }

    private void jMenuItem1ActionPerformed() {
        new FrameListener();
        DwarfehGameGUI.this.dispose();
        IdleGame.run = false;
        System.exit(0);
    }

    public static JPanel jPanel1;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;


    private void drawStickFigure(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
//        graphic.
//        graphic.setColor(Color.red);
//        graphic.setStroke(new BasicStroke(1));
//        System.out.println("Width: " +jPanel1.getWidth() +" Height: " +jPanel1.getHeight());
//        graphic.create(20, 20, 20, 20);
//        graphic.drawOval ( 36,  36, 24,  24 );      // head
//        graphic.drawLine ( 48,  60, 48, 108 );      // body
//        graphic.drawLine ( 30,  78, 66,  78 );      // arms
//        graphic.drawLine ( 48, 108, 30, 126 );      // left leg
//        graphic.drawLine ( 48, 108, 66, 126 );      // right leg
    }

    private void drawMenu(Graphics g) {
//        Graphics2D graphic = (Graphics2D) g;
//        graphic.setStroke(new BasicStroke(1));
//        graphic.setColor(Color.red);
//        graphic.draw(menuRect);
    }

    private void drawLayout(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(Color.BLACK);
        graphic.fillRect(0, 0, 1023, 695);
        graphic.setColor(Color.GRAY);
        graphic.setStroke(new BasicStroke(10));
        graphic.drawRect(0, 0, 1023, 695);
    }

    public static void drawStatus(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(Color.red);
        graphic.drawString("Health: " + Player.getCurrentHealth() + '/' + Player.getTotalHealth(), 10, 15);
        graphic.drawString("Magic:  " + Player.getCurrentMana() + '/' + Player.getTotalMana(), 10, 27);
        graphic.drawString("Exp:    " + Player.getExperience() + '/' + Player.getExperienceToLevel(), 10, 39);
        graphic.drawString("Level:    " + Player.getLevel(), 10, 52);
        graphic.drawString("Gold:   " + Player.getGold(), 10, 64);
        graphic.draw3DRect(5, panelHeight - 30, panelWidth - 5, 30, true);
        graphic.drawString("Status of Bot: " + IdleGame.status, 10, panelHeight - 10);
    }

    public void componentResized(ComponentEvent e) {
        panelHeight = jPanel1.getHeight();
        panelWidth = jPanel1.getWidth();
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    class FrameListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            IdleGame.run = false;
            System.exit(0);
        }
    }
}
