package JediZarzadzanie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Listenery {

    private static HashMap <String,Jedi> tymlist = new HashMap<String, Jedi>();
    private static DefaultListModel<Jedi> tymlist1 = new DefaultListModel();
    private static DefaultListModel<PolaczenieJedi> listaPol = new DefaultListModel<>();
    private static DefaultListModel<String> zeruj = new DefaultListModel<>();

    static class WyczyscZakon implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            System.inputNazwaZakon.setText(" ");
            System.bezZakonu.setModel(zeruj);

        }
    }
    static class WyczyscJedi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.comboBox.setSelectedIndex(0);
            System.inputNazwa.setText("");
            System.jMoc.setValue(50);
            System.group.clearSelection();
            System.group.getSelection();
        }
    }

    static class ZarejestrujJedi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            tymlist1.addElement(new Jedi(System.inputNazwa.getText(),System.comboBox.getSelectedItem().toString(),System.jMoc.getValue(),System.group.getSelection().getActionCommand()));

            System.bezZakonu.setModel(tymlist1);
            tymlist.clear();
        }
    }

    static class Wybierz implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            listaPol.addElement(new PolaczenieJedi(System.inputNazwaZakon.getText(),System.bezZakonu.getSelectedValue().toString()));
            java.lang.System.out.println(listaPol);
            System.areaListaZakonyJedi.append(listaPol.toString());

            listaPol.clear();


        }
    }
}
