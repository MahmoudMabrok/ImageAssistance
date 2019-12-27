/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.mahmoudmabrok.imagehelper;

import javax.swing.JFrame;
import javax.swing.JPanel;
import tools.mahmoudmabrok.imagehelper.logic.ImagesController;

/**
 *
 * @author mo3tamed
 */
public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("IMage Helper");
        Home home = new Home();
        System.out.println("home = " + home.getWidth());
        System.out.println("home = " + home.getHeight());
        f.add(home);
        f.setSize(700, 500);
        f.setVisible(true);

        System.out.println("home = " + (home instanceof JPanel));
    }

}
