import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by michael chen on 11/29/17.
 */
public class GamePanel extends JPanel{

    //=====instance field=====

    public static int n = 100;
    //controls how many squares are wanted in the JPanel

    public static Cell[][] cellGrid = new Cell[n][n];
    //this initialized the grid that will contains all the cells

    private int[][] numNeighbors = new int[n][n];
    //this initialized the grid that will contains the number of neighbors for each cell

    public int width, height;
    //sets two public variables to the width and the height of the panel

    private int fps = 10;

    private Timer lifeLength;

    private int cellHeight, cellWidth;

    public static boolean trail;

    private int spawnmode = 0;
    //0 spawns a cell
    //1 spawns a acorn
    //2 spawns an glider

    //=====gamePanel (constructor, initializes stuff)=====

    public GamePanel(int w, int h){

        setSize(w, h);

        width = w;
        height = h;
        //initializes height and width

        cellHeight = width / n;
        //controls size of the squares

        cellWidth = height / n;
        //also controls size of squares

        //initialization of cells
        for (int r = 0; r < cellGrid.length; r++) {

            for (int c = 0; c < cellGrid[0].length; c++) {

                cellGrid[r][c] = new Cell(r, c, false, cellWidth, cellHeight);

            }//end for

        }//end for
        //the double for loops create a bunch of cells
        //sets their location to be the corresponding location in the grid
        //sets all the cells to be dead

        trail = true;
        //initializes trails to be true

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }//end mouseClicked

            @Override
            public void mousePressed(MouseEvent e) {
                //spawn and kills cells using the mouse

                int x = e.getX();
                //sets x to the x coord of the mouse
                int y = e.getY();
                //sets y to the y coord of the mouse

                int w = width / n;
                int h = height / n;
                //these guys give us the size of the squares

                int r = y / h;
                int c = x / w;
                //this code tells us which square our cursor is currently inside

                //-----------------

                if(spawnmode == 0) {
                    //spawns cells the old fashioned way

                    if (!cellGrid[r][c].getIsAlive()) {

                        cellGrid[r][c].spawn();

                    }//end if
                    else {

                        cellGrid[r][c].kill();

                    }//end else

                }//end if

                if(spawnmode == 1){
                    //spawns an acorn wherever the user clicks

                    cellGrid[r][c].spawn();
                    cellGrid[r + 1][c + 2].spawn();
                    cellGrid[r + 2][c].spawn();
                    cellGrid[r + 2][c - 1].spawn();
                    cellGrid[r + 2][c + 3].spawn();
                    cellGrid[r + 2][c + 4].spawn();
                    cellGrid[r + 2][c + 5].spawn();

                }//end if

                if(spawnmode == 2){
                    //spawns a glider wherever the user clicks

                    cellGrid[r][c].spawn();
                    cellGrid[r + 1][c + 1].spawn();
                    cellGrid[r + 2][c + 1].spawn();
                    cellGrid[r + 2][c].spawn();
                    cellGrid[r + 2][c - 1].spawn();

                }//end if

                repaint();

            }//end mousePressed

            @Override
            public void mouseReleased(MouseEvent e) {

            }//end mouseReleased

            @Override
            public void mouseEntered(MouseEvent e) {

            }//end mouseEntered

            @Override
            public void mouseExited(MouseEvent e) {

            }//end mouseExited
        });//end mouseListener

        KeyListener keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }//end keyTyped

            @Override
            public void keyPressed(KeyEvent e) {

                int keyCode = e.getKeyCode();

                //-----------------

                if(keyCode == e.VK_SPACE){
                    //pauses and plays the timer

                    if(lifeLength.isRunning()) {

                        lifeLength.stop();

                        System.out.println("GAME PAUSED");

                        System.out.println("================");

                    }//end if

                    else {

                        lifeLength.start();

                        System.out.println("GAME RESUMED");

                        System.out.println("================");

                    }//end else

                }//end if

                //-----------------

                if(keyCode == e.VK_R){
                    //resets the board

                    for (int r = 0; r < cellGrid.length; r++) {

                        for (int c = 0; c < cellGrid[0].length; c++) {

                            cellGrid[r][c] = new Cell(r, c, false, cellWidth, cellHeight);

                            repaint();

                        }//end for

                    }//end for

                    System.out.println("BOARD RESET");

                    System.out.println("================");

                }//end if

                //-----------------

                if(keyCode == e.VK_1){
                    //sets spawner to default mode

                    spawnmode = 0;
                    //0 = default

                    System.out.println("SPAWNER: DEFAULT");

                    System.out.println("================");

                }//end if

                if(keyCode == e.VK_2){
                    //sets spawner to acorn mode

                    spawnmode = 2;
                    //2 = acorn

                    System.out.println("SPAWNER: ACORN");

                    System.out.println("================");

                }//end if

                if(keyCode == e.VK_3){
                    //sets spawner to glider mode

                    spawnmode = 1;

                    System.out.println("SPAWNER: GLIDER");

                    System.out.println("================");

                }//end if

                //-----------------

                if(keyCode == e.VK_W){
                //enable or disable trails

                if(trail){

                    trail = false;

                    repaint();

                    System.out.println("TRAILS DISABLED");

                    System.out.println("================");

                }//end if
                else{

                    trail = true;

                    repaint();

                    System.out.println("TRAILS ENABLED");

                    System.out.println("================");

                }//end else

            }//end if

                //-----------------

                if(keyCode == e.VK_DOWN){

                    if(fps > 10){

                        fps = fps - 10;

                        System.out.println("CURRENT FPS: " + fps);

                        System.out.println("================");

                    }//end if
                    else{

                        System.out.println("FPS IS ALREADY AT MINIMUM (10)");

                        System.out.println("================");

                    }//end if

                }//end if

                if(keyCode == e.VK_UP){

                    if(fps < 120){

                        fps = fps + 10;

                        System.out.println("CURRENT FPS: " + fps);

                        System.out.println("================");

                        lifeLength.setDelay(1000/fps);

                    }//end if
                    else{

                        System.out.println("FPS IS ALREADY AT MAXIMUM: " + fps);

                        System.out.println("================");

                        lifeLength.setDelay(1000/fps);

                    }//end if

                }//end if

                //-----------------

            }//end keyPressed

            @Override
            public void keyReleased(KeyEvent e) {

            }//end keyReleased

        };//end KeyListener

        addKeyListener(keyListener);

        lifeLength = new Timer(1000/fps, new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                //anything in here happens 60 times per sec.

                for (int r = 0; r < cellGrid.length; r++) {

                    for (int c = 0; c < cellGrid[0].length; c++) {

                        numNeighbors[r][c] = cellGrid[r][c].numNeighbors();

                    }//end for

                }//end for

                for (int j = 0; j < numNeighbors.length; j++) {

                    for (int k = 0; k < numNeighbors[0].length; k++) {
                        //rules of the game are controlled here

                        //1. Any live cell with fewer than two live neighbours dies (referred to as underpopulation or exposure).
                        //2. Any live cell with more than three live neighbours dies (referred to as overpopulation or overcrowding).
                        //3. Any live cell with two or three live neighbours lives, unchanged, to the next generation.
                        //4. Any dead cell with exactly three live neighbours will come to life.

                        if(numNeighbors[j][k] > 3 && cellGrid[j][k].getIsAlive()){

                            cellGrid[j][k].kill();

                        }//end if

                        if(numNeighbors[j][k] == 3 || cellGrid[j][k].numNeighbors() == 2 && cellGrid[j][k].getIsAlive()){

                            cellGrid[j][k].spawn();

                        }//end if

                        if(numNeighbors[j][k] < 2 && cellGrid[j][k].getIsAlive()){

                            cellGrid[j][k].kill();

                        }//end if

                        if(numNeighbors[j][k] == 3 && cellGrid[j][k].getIsAlive()){

                            cellGrid[j][k].spawn();

                        }//end if

                    }//end for

                }//end for

                repaint();

            }//end actionPerformed

        });//end timer

    }//end GamePanel

    //=====paint component=====

    public void paintComponent(Graphics g){
        //draws the cells, does nothing else
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        for (int r = 0; r < cellGrid.length; r++){

            for (int c = 0; c < cellGrid[0].length; c++){

                cellGrid[r][c].draw(g2, r, c);

            }//end for

        }//end for

    }//end paintComponent

}//end class
