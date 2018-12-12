import javax.swing.*;
import java.awt.*;

/**
 * Created by michael_hopps on 11/14/17.
 */

/**
 *
 *
 *  _______ _    _ ______    _____          __  __ ______    ____  ______   _      _____ ______ ______
 * |__   __| |  | |  ____|  / ____|   /\   |  \/  |  ____|  / __ \|  ____| | |    |_   _|  ____|  ____|
 *    | |  | |__| | |__    | |  __   /  \  | \  / | |__    | |  | | |__    | |      | | | |__  | |__
 *    | |  |  __  |  __|   | | |_ | / /\ \ | |\/| |  __|   | |  | |  __|   | |      | | |  __| |  __|
 *    | |  | |  | | |____  | |__| |/ ____ \| |  | | |____  | |__| | |      | |____ _| |_| |    | |____
 *    |_|  |_|  |_|______|  \_____/_/    \_\_|  |_|______|  \____/|_|      |______|_____|_|    |______|
 *
 * INSTRUCTIONS FOR PLAYING THIS GAME:
 *
 * SPACE BAR PAUSES THE TIMER AND ALLOWS YOU TO MAKE CELLS
 *
 * CLICK TO SPAWN OR KILL CELLS
 *
 * R BUTTON RESETS THE BOARD
 *
 * PRESS THE 1 BUTTON TO CHANGE THE SPAWNER TO DEFAULT MODE
 *
 * PRESS THE 2 BUTTON TO CHANGE THE SPAWNER TO ACORN MODE
 *
 * PRESS THE 3 BUTTON TO CHANGE THE SPAWNER TO GLIDER MODE
 *
 * PRESS THE W BUTTON TO ENABLE OR DISABLE TRAILS
 *
 * ENJOY!!
 *
 */

public class GameMain extends JPanel{

    public static void main(String[] args) {

        //===========Jframe==========
        JFrame frame = new JFrame("THE SIMS: CELL EDITION");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 700;
        int height = 700;
        frame.setPreferredSize(new Dimension(width, height + 22));

        //============JPanel===========
        JPanel panel = new GamePanel(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        //============JFrame============
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }//end psvm

}//end class