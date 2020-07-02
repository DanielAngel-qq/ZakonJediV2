package JediZarzadzanie;

import javax.swing.*;
import java.awt.*;

public class System extends JPanel  {

    static JTextField inputNazwa;
    static JTextField inputNazwaZakon;
    static JComboBox comboBox;
    static JSlider jMoc;
    static ButtonGroup group;
    static String[] kolorMiecza = {" ","Zielony", "Czerwony","Niebieski"};

    static JTextArea areaJedi;
    static JTextArea areaListaZakonyJedi;
    static JRadioButton JRBJasna;
    static JRadioButton JRBCiemna;
    static JList bezZakonu;
    static JButton JIZakon;

    public System() {
        setLayout(null);

        JLabel zakon = new JLabel("zakon Jedi");
        zakon.setFont(new Font("Star Jedi",Font.PLAIN,13));
        zakon.setBounds(190, 5, 120, 20);
        add(zakon);

        JLabel LJedi = new JLabel("Jedi ");
        LJedi.setFont(new Font("Star Jedi",Font.PLAIN,13));
        LJedi.setBounds(650, 5, 100, 20);
        add(LJedi);

        JLabel RJedi = new JLabel("Rejestracja Jedi");
        RJedi.setFont(new Font ("Star Jedi",Font.PLAIN,13));
        RJedi.setBounds(600, 340, 150, 20);
        add(RJedi);


        JLabel JNazwa = new JLabel("Nazwa : ");
        JNazwa.setBounds(450, 380, 100, 20);
        add(JNazwa);

        inputNazwa = new JTextField();
        inputNazwa.setBounds(550, 380, 250, 20);
        add(inputNazwa);

        JLabel JLKolor = new JLabel("Kolor miecza :");
        JLKolor.setBounds(450, 410, 100, 20);
        add(JLKolor);

        comboBox = new JComboBox(kolorMiecza);
        comboBox.setBounds(550, 400, 250, 40);
        add(comboBox);

        //////////////////////////////////////////////////

        JLabel JLMoc = new JLabel("Moc :");
        JLMoc.setBounds(450, 440, 100, 20);
        add(JLMoc);

        jMoc = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        jMoc.setMinorTickSpacing(5);
        jMoc.setMajorTickSpacing(10);
        jMoc.setPaintTicks(true);
        jMoc.setPaintLabels(true);
        jMoc.setBounds(550, 440, 250, 40);
        add(jMoc);

        JLabel JLStronaMocy = new JLabel("Strona Mocy :");
        JLStronaMocy.setBounds(550, 500, 100, 20);
        add(JLStronaMocy);

        JRBCiemna = new JRadioButton("Ciemna");
        JRBCiemna.setActionCommand("Ciemna");
        JRBCiemna.setBounds(650, 500, 100, 20);
        add(JRBCiemna);

        JRBJasna = new JRadioButton("Jasna");
        JRBJasna.setActionCommand("Jasna");
        JRBJasna.setBounds(730, 500, 100, 20);
        add(JRBJasna);

        group = new ButtonGroup();
        group.add(JRBCiemna);
        group.add(JRBJasna);

        JButton JImportJedi = new JButton("Import");
        JImportJedi.addActionListener(new ImportExport.SQLJediImport());

        JImportJedi.setBounds(450, 540, 90, 20);
        add(JImportJedi);

        JButton JExportJedi = new JButton("Export");
        JExportJedi.addActionListener(new ImportExport.JediExportPlik());
        JExportJedi.addActionListener(new ImportExport.SQLJediExport());

        JExportJedi.setBounds(450, 570, 90, 20);
        add(JExportJedi);

        JTextField JPlikJedi = new JTextField("D://Projekty//Jedi//src/main//Jedi");
        JPlikJedi.setBounds(550, 545,250,30);
        add(JPlikJedi);

        JButton BJRejestracja = new JButton("Rejestracja");
        BJRejestracja.setBounds(570,600,100,20);
        BJRejestracja.addActionListener(new Listenery.ZarejestrujJedi());
        add(BJRejestracja);

        JButton BJWyczysc = new JButton("Wyczyść");
        BJWyczysc.setBounds(680,600,100,20);
        BJWyczysc.addActionListener(new Listenery.WyczyscJedi());
        add(BJWyczysc);

////////////////////////////////////////////////////////////////////////////

        JLabel RZakon = new JLabel("Rejestracja zakonu Jedi");
        RZakon.setFont(new Font("Star Jedi",Font.PLAIN,13));
        RZakon.setBounds(130, 340, 200, 20);
        add(RZakon);

        JLabel JRZNazwa = new JLabel("Nazwa :");
        JRZNazwa.setBounds(20,380,100,20);
        add(JRZNazwa);

        JButton Wybierz = new JButton("Wybierz");
        Wybierz.addActionListener(new Listenery.Wybierz());
        Wybierz.setBounds(20, 420,100,20);
        add(Wybierz);

        inputNazwaZakon = new JTextField();
        inputNazwaZakon.setBounds(140,380,250,20);
        add(inputNazwaZakon);

        bezZakonu = new JList();
        bezZakonu.setBounds(140,410,250,100);
        add(bezZakonu);

        JIZakon = new JButton("Import");
        //JIZakon.addActionListener(new Listenery.ImportZakonPlik());
        JIZakon.addActionListener(new ImportExport.SQLZakonImport());
        JIZakon.setBounds(20,540,100,20);
        add(JIZakon);

        JButton JEZakon = new JButton("Export");
        JEZakon.addActionListener(new ImportExport.SQLZakonExport());
        JEZakon.setBounds(20 ,570,100,20);
        add(JEZakon);

        JTextField JZakonPlik = new JTextField("D://Projekty//Jedi//src/main//Zakon");
        JZakonPlik.setBounds(140,545,250,30);
        add(JZakonPlik);

        JButton JZZakon =new JButton("Zarejestruj");
        JZZakon.addActionListener(new ImportExport.ZarejestrujZakon());
        JZZakon.setBounds(140,600,100,20);
        add(JZZakon);

        JButton JZWyczysc = new JButton("Wyczyść");
        JZWyczysc.setBounds(250,600,100,20);
        JZWyczysc.addActionListener(new Listenery.WyczyscZakon());
        add(JZWyczysc);

        areaListaZakonyJedi = new JTextArea();
        areaListaZakonyJedi.setBounds(10, 30, 400, 300);
        add(areaListaZakonyJedi);

        areaJedi = new JTextArea("");
        areaJedi.setBounds(450, 30, 400, 300);
        add(areaJedi);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(425,20,100,720);
        add(separator);

    }

    public Dimension getPreferredSize() {

        return new Dimension(870, 750);
    }
}
