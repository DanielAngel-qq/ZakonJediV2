package JediZarzadzanie;

import java.util.ArrayList;
import java.util.List;

public class SQLZakon {
    public static List<SQLZakon>listaZakon2 = new ArrayList<>();

    private String NazwaZakonu;
    private String NazwaJedi;
    private String KoloMiecza;
    private int MocJedi;
    private String StronaMocy;


    public SQLZakon(String nazwaZakonu, String nazwaJedi, String koloMiecza, int mocJedi, String stronaMocy) {
        this.NazwaZakonu = nazwaZakonu;
        this.NazwaJedi = nazwaJedi;
        this.KoloMiecza = koloMiecza;
        this.MocJedi = mocJedi;
        this.StronaMocy = stronaMocy;
        listaZakon2.add(this);
    }

    @Override
    public String toString() {
        return "{" +
                "Zakon: '" + NazwaZakonu + '\'' +
                ", NazwaJedi='" + NazwaJedi + '\'' +
                ", KoloMiecza='" + KoloMiecza + '\'' +
                ", MocJedi=" + MocJedi +
                ", StronaMocy='" + StronaMocy + '\'' +
                '}';
    }
}
