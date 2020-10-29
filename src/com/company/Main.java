package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    final int BF_WIDTH = 572;
    final int BF_HEIGHT = 572;

    //    1 - up, 2 - down, 3-left , 4 - right
    int direction = 4;
    int bulletx = 320, bullety = 320;
    int x = 256,y = 256;
    void move(int dir) throws Exception{
        if (dir == 1) {
            direction = dir;
            while (y != 0) {

                y--;
                Thread.sleep(34);
                repaint();
            }
        }
        else if (dir == 2){
            while (y != BF_HEIGHT - 64){
                direction = 2;
                y++;
                Thread.sleep(34);
                repaint();
             }
        }
        else if (dir == 3){
            while (x != 0){
                direction = 3;
                x--;
                Thread.sleep(34);
                repaint();
            }
        }
        else if (dir == 4){
            while (x != BF_WIDTH - 64){
                direction = 4;
                x++;
                Thread.sleep(30);
                repaint();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.move(4);
    }
    Main(){
        JFrame frame = new JFrame("Tanks");
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT));
        frame.getContentPane().add(this);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.cyan);
        g.fillRect(x, y, 60, 60);

        g.setColor(Color.black);
        if (direction == 1) {
            g.fillRect(x + 16, y , 24, 34);

        } else if (direction == 2) {
            g.fillRect(x + 17, y + 24, 24, 34);

        } else if (direction == 3) {
            g.fillRect(x, y + 20, 34, 24);
        } else if (direction == 4) {
            g.fillRect(x + 24, y + 20, 34, 24);
        }

        g.setColor(Color.yellow);
        g.fillRect(bulletx,bullety,14,14);
    }
}

