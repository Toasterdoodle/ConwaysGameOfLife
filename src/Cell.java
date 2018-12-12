import java.awt.*;

/**
 * Created by Michael Chen on 11/29/17.
 */

public class Cell {

    //=====instance field=====

    private boolean isAlive, wasAlive;

    private int r, c, w, h;

    //=====constructor=====

    public Cell(int r, int c, boolean isAlive, int w, int h){

        this.r = r;
        this.c = c;
        this.w = w;
        this.h = h;
        this.isAlive = isAlive;

    }//end Cell

    //=====methods=====

    public int numNeighbors(){

        int count = 0;

        //-----ROW R-1-----

        if(r - 1 >= 0){

            if(c - 1 >= 0) {

                if(GamePanel.cellGrid[r - 1][c - 1].getIsAlive()) {

                    count++;

                }//end if

            }//end if

            if(GamePanel.cellGrid[r - 1][c].getIsAlive()) {

                count++;

            }//end if

            if(c + 1 < GamePanel.cellGrid[0].length) {

                if(GamePanel.cellGrid[r - 1][c + 1].getIsAlive()) {

                    count++;

                }//end if

            }//end if

        }//if

        //----ROW R-----

        if(c - 1 >= 0) {

            if (GamePanel.cellGrid[r][c - 1].getIsAlive()) {

                count++;

            }//end if

        }//end if

        if(c + 1 < GamePanel.cellGrid.length){

            if (GamePanel.cellGrid[r][c + 1].getIsAlive()) {

                count++;

            }//end if

        }//end if

        //----ROW R+1-----

        if(r + 1 < GamePanel.cellGrid.length) {

            if(c - 1 >= 0) {

                if (GamePanel.cellGrid[r + 1][c - 1].getIsAlive()) {

                    count++;

                }//end if

            }//end if

            if (GamePanel.cellGrid[r + 1][c].getIsAlive()) {

                count++;

            }//end if

            if(c + 1 < GamePanel.cellGrid.length) {

                if (GamePanel.cellGrid[r + 1][c + 1].getIsAlive()) {

                    count++;

                }//end if

            }//end if

        }//end if

        return count;

    }//end int

    //-----------------

    public boolean getIsAlive(){

        return isAlive;

    }//end getIsAlive

    //-----------------

    public void kill(){

        isAlive = false;

        wasAlive = true;

    }//end kill

    //-----------------

    public void spawn(){

        isAlive = true;

        wasAlive = true;

    }//end spawn

    //-----------------

    public void draw(Graphics2D g2, int r, int c){

                if(getIsAlive()){

                    g2.setStroke(new BasicStroke(1));
                    g2.setColor(new Color(255, 232, 91));
                    g2.fillRect(c * w, r * h, w, h);
                    g2.setColor(new Color(203, 203, 203));
                    g2.drawRect(c * w, r * h, w, h);

                }//end if

                if(!getIsAlive()){

                    if(GamePanel.trail){

                        if(!wasAlive){

                            g2.setStroke(new BasicStroke(1));
                            g2.setColor(new Color(45, 45, 45));
                            g2.fillRect(c * w, r * h, w, h);
                            g2.setColor(new Color(100, 100, 100));
                            g2.drawRect(c * w, r * h, w, h);

                        }//end if

                        if(wasAlive){

                            g2.setStroke(new BasicStroke(1));
                            g2.setColor(new Color(63, 161, 48));
                            g2.fillRect(c * w, r * h, w, h);
                            g2.setColor(new Color(200, 200, 200));
                            g2.drawRect(c * w, r * h, w, h);

                        }//end if

                    }//end if

                    else{

                        g2.setStroke(new BasicStroke(1));
                        g2.setColor(new Color(45, 45, 45));
                        g2.fillRect(c * w, r * h, w, h);
                        g2.setColor(new Color(100, 100, 100));
                        g2.drawRect(c * w, r * h, w, h);

                    }//end else

                }//end if

    }//end draw

    //-----------------

}//end class
