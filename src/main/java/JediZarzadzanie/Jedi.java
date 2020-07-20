package JediZarzadzanie;

import java.io.*;
import java.util.HashMap;

public class Jedi implements Serializable {

    private String nazwaJedi;
    private String kolorMiecza;
    private int mocJedi;
    private String stronaMocy;
    public static HashMap<String, Jedi> listaJedi = new HashMap<String, Jedi>();

    public Jedi(String nazwaJedi, String kolorMiecza, int mocJedi, String stronaMocy) {
        if (!(listaJedi.containsKey(nazwaJedi))) {
            this.nazwaJedi = nazwaJedi;
            this.kolorMiecza = kolorMiecza;
            this.mocJedi = mocJedi;
            this.stronaMocy = stronaMocy;
            listaJedi.put(nazwaJedi, this);
            zapisDoPliku();
        }
    }

    @Override
    public String toString() {
        return "{" +
                " '" + nazwaJedi + '\'' +
                ", Kolor Miecza: " + kolorMiecza +
                ", Moc: " + mocJedi +
                ", Strona Mocy: '" + stronaMocy + '\'' +
                '}';
    }

    public static void zapisDoPliku() {
        try {
            FileOutputStream fos = new FileOutputStream("ZakonJedi");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(listaJedi);

            oos.close();
            fos.close();

        } catch (Exception ex) {
        }
    }

    public static void odczytZPliku() {

        try {
            FileInputStream fis = new FileInputStream("ZakonJedi");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String, Jedi> list = (HashMap<String, Jedi>) ois.readObject();

            listaJedi = list;

            System.areaJedi.append(list.toString());

            for (String key : list.keySet())
                java.lang.System.out.println(key + " " + list.get(key).kolorMiecza + " " + list.get(key).mocJedi + " " + list.get(key).stronaMocy);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void odczytZPlikuBezZakonu() {

        try {
            FileInputStream fis = new FileInputStream("ZakonJedi");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String, Jedi> list1 = (HashMap<String, Jedi>) ois.readObject();

            listaJedi = list1;

            System.areaJedi.append(list1.toString());

            for (String key : list1.keySet())
                java.lang.System.out.println(key + " " + list1.get(key).kolorMiecza + " " + list1.get(key).mocJedi + " " + list1.get(key).stronaMocy);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
