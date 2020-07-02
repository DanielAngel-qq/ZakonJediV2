package JediZarzadzanie;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("System zarządzania Jedi");

        window.add(new System());

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();

    }
}
