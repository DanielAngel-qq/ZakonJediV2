package JediZarzadzanie;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class Zakon implements Serializable {

    private String nazwaZakon;
    public static HashMap<String, Zakon> listaZakon = new HashMap<>();


    public Zakon(String nazwaZakon) {
        this.nazwaZakon = nazwaZakon;
        listaZakon.put(nazwaZakon,this);
    }

    @Override
    public String toString() {
        return "Zakon{" +
                "nazwaZakon='" + nazwaZakon + '\'' +
                '}';
    }

    public static void zapisDoPlikuZakon() {
        try {
            FileOutputStream fos = new FileOutputStream("Zakon");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(listaZakon);
            oos.close();
            fos.close();

        } catch (Exception ex) {
        }
    }

    public static void odczytZPlikuZakon() {

        try {
            FileInputStream fis = new FileInputStream("Zakon");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String, Zakon> listZakon1 = (HashMap<String, Zakon>) ois.readObject();

            listaZakon = listZakon1;

            System.areaListaZakonyJedi.append(listZakon1.keySet().toString());

            java.lang.System.out.println(listZakon1.keySet());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
