package JediZarzadzanie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PolaczenieJedi {

    private String nazwaZakon;
    private String nazwaJedi;
    private String kolorMiecza;
    private int mocJedi;
    private String stronaMocy;
    private String zaznacone;


    public static List<PolaczenieJedi> listaPolacz = new ArrayList<>();

    public PolaczenieJedi(String nazwaZakon, String zaznacone) {
        this.nazwaZakon = nazwaZakon;
        this.zaznacone = zaznacone;
        listaPolacz.add(this);
    }

    @Override
    public String toString() {
        return "PolaczenieJedi{" +
                "nazwaZakon='" + nazwaZakon + '\'' +
                ", zaznacone='" + zaznacone + '\'' +
                '}';
    }
}
