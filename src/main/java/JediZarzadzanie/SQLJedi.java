package JediZarzadzanie;

import java.util.ArrayList;
import java.util.List;

public class SQLJedi {
    public static List<SQLJedi> listaJedi1 = new ArrayList<>();

    private String NazwaJedi;
    private String KolorMiecza;
    private int MocJedi;
    private String StronaMocy;


      public SQLJedi(String nazwaJedi, String kolormiecza, int mocJedi, String stronaMocy) {
        this.NazwaJedi = nazwaJedi;
        this.KolorMiecza = kolormiecza;
        this.MocJedi = mocJedi;
        this.StronaMocy = stronaMocy;
        listaJedi1.add(this);
    }

    @Override
    public String toString() {
        return "{" +
                " " + NazwaJedi + '\'' +
                ", Kolor Miecza: " + KolorMiecza +
                ", Moc: " + MocJedi +
                ", Strona: " + StronaMocy + '\'' +
                '}';
    }
}
