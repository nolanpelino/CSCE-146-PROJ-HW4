/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**3
 *
 * @author Nolan Pelino
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TriangleCarpet extends Canvas{
    
    public static void main(String[] args) {
        JFrame pic = new JFrame("S's Triangle");
        pic.setSize(550, 550);
        TriangleCarpet tpDraw = new TriangleCarpet();
        
        pic.add(tpDraw);
        pic.setVisible(true);
        pic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics gphics){
        int[] xPoints = {250,0,500};
        int[] yPoints = {0,500,500};
        drawTriangleCarpet(xPoints, yPoints , gphics);
    }
    
    public void drawTriangleCarpet(int[] xPoints, int[] yPoints, Graphics g){
        if((xPoints[2] - xPoints[1]) > 4) // pixel limit check
        {
            g.drawPolygon(xPoints, yPoints, 3);
            
            //top new coordinates
            int[] topX = new int[3];
            int[] topY = new int[3];

            topX[0] = xPoints[0];
            topY[0] = yPoints[0];
            topX[1] = (xPoints[1] + xPoints[0]) / 2;
            topY[1] = (yPoints[1] + yPoints[0]) / 2;
            topX[2] = (xPoints[2] + xPoints[0]) / 2;
            topY[2] = (yPoints[2] + yPoints[0]) / 2;
            
            drawTriangleCarpet(topX, topY, g);
            
            // bottom left coordinatess
            int[] leftX = new int[3];
            int[] leftY = new int[3];

            leftX[0] = (xPoints[1] + xPoints[0]) / 2;
            leftY[0] = (yPoints[1] + yPoints[0]) / 2;
            leftX[1] = xPoints[1];
            leftY[1] = yPoints[1];
            leftX[2] = (xPoints[1] + xPoints[2]) / 2;
            leftY[2] = yPoints[1];
            
            drawTriangleCarpet(leftX, leftY, g);
            
            // bottom right coordinates
            int[] rightX = new int[3];
            int[] rightY = new int[3];
 
            rightX[0] = (xPoints[2] + xPoints[0]) / 2;
            rightY[0] = (yPoints[2] + yPoints[0]) / 2;
            rightX[1] = (xPoints[1] + xPoints[2]) / 2;
            rightY[1] = yPoints[1];
            rightX[2] = xPoints[2];
            rightY[2] = yPoints[2];
            
            drawTriangleCarpet(rightX, rightY, g);  // recursive statement
        }
    }
}//last brace


