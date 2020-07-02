package JediZarzadzanie;

import javax.swing.*;
import java.awt.*;

public class Zarejestrowano extends JPanel {

    public Zarejestrowano() {
        setLayout(null);

        JLabel UdaloSie = new JLabel("Zarejestrowany !!");
        UdaloSie.setBounds(10, 10, 150, 20);
        add(UdaloSie);
    }
    public Dimension getPreferredSize(){
        return  new Dimension(200,200);
    }
}



