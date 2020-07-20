package JediZarzadzanie;

import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class ImportExport {

    private static String inputNazwaString = System.inputNazwa.toString();
    private static String inputZakonString = System.inputNazwaZakon.toString();
    private static File file;
    private static String currentline;


    static class ZarejestrujZakon implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Zakon(System.inputNazwaZakon.getText());
            Zakon.zapisDoPlikuZakon();
            java.lang.System.out.println(System.inputNazwaZakon.toString());
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class SQLZakonImport implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Class.forName("org.postgresql.Driver");

                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaZakonu", "postgres",
                        "Dyndalec1");

                Statement statement = connection.createStatement();

                ResultSet data = statement.executeQuery("Select * FROM Zakon;");

                while (data.next())
                    new SQLZakon(data.getString("NazwaZakonu"), data.getString("NazwaJedi"), data.getString("Kolormiecza"), data.getInt("MocJedi"), data.getString("StronaMocy"));


                System.areaListaZakonyJedi.append(SQLZakon.listaZakon2.toString());
                SQLZakon.listaZakon2.clear();

                for (SQLZakon s : SQLZakon.listaZakon2)
                    java.lang.System.out.println(s);


            } catch (Exception f) {
                f.printStackTrace();
            }
        }
    }

    static class SQLZakonExport implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Class.forName("org.postgresql.Driver");

                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaZakonu", "postgres",
                        "Dyndalec1");

                PreparedStatement pst = connection.prepareStatement("INSERT INTO Zakon( NazwaZakonu,NazwaJedi,KolorMiecza,MocJedi,StronaMocy) VALUES ( ?,?,?,?,?)");

                if (!((inputNazwaString == "") && (inputZakonString == ""))) {
                    pst.setString(1, System.inputNazwaZakon.getText());
                    pst.setString(2, System.inputNazwa.getText());
                    pst.setString(3, System.comboBox.getSelectedItem().toString());
                    pst.setInt(4, System.jMoc.getValue());
                    pst.setString(5, System.group.getSelection().getActionCommand());
                    pst.executeUpdate();
                } else
                    java.lang.System.out.println("nie mozna");

                java.lang.System.out.println(pst);
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class SQLJediImport implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Class.forName("org.postgresql.Driver");

                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaJedi", "postgres",
                        "Dyndalec1");

                Statement statement = connection.createStatement();

                ResultSet data = statement.executeQuery("Select * FROM Jedi;");

                while (data.next())
                    new SQLJedi(data.getString("NazwaJedi"), data.getString("KolorMiecza"), data.getInt("MocJedi"), data.getString("StronaMocy"));

                System.areaJedi.append(SQLJedi.listaJedi1.toString());
                SQLJedi.listaJedi1.clear();

                for (SQLJedi s : SQLJedi.listaJedi1)
                    java.lang.System.out.println(s);


            } catch (Exception x) {
                x.printStackTrace();
            }

        }
    }

    static class SQLJediExport implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Class.forName("org.postgresql.Driver");

                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaJedi", "postgres",
                        "Dyndalec1");

                PreparedStatement pst = connection.prepareStatement("INSERT INTO Jedi(NazwaJedi,Kolormiecza,MocJedi,StronaMocy) VALUES ( ?,?,?,?)");

                pst.setString(1, System.inputNazwa.getText());
                pst.setInt(2, System.comboBox.getSelectedIndex());
                pst.setInt(3, System.jMoc.getValue());
                pst.setString(4, System.group.getSelection().getActionCommand());
                pst.executeUpdate();


            } catch (Exception x) {
                x.printStackTrace();
            }

        }
    }

    static class JediImportPlik implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            Jedi.odczytZPliku();
        }
    }

    static class JediExportPlik implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            Jedi.zapisDoPliku();

        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class ImportZakonPlik implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooserZakony = new JFileChooser();
            fileChooserZakony.setCurrentDirectory(new File("//Users//danny//IdeaProjects//"));
            fileChooserZakony.setDialogTitle("Wybierz Plik Zakonu");
            int result = fileChooserZakony.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooserZakony.getSelectedFile();
            }
            try {
                BufferedReader br = new BufferedReader((new FileReader(file)));

                while ((currentline = br.readLine()) != null) {
                    java.lang.System.out.println(currentline);
                }

            } catch (Exception error) {
                error.printStackTrace();
            }
        }
    }
}


