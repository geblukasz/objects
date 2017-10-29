import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Pracownik[] tab = Pracownik.wczytajZPlikuTekstowego("Pracownicy.txt", new Pracownik[1]);
        int srednieZarobkiZPodanegoDziału = Pracownik.srednieZarobki(tab,3, 'K');
        System.out.println(srednieZarobkiZPodanegoDziału);
        Pracownik.zapiszDoPliku("12abcnba",tab);
        //Pracownik.odczytZPliku("abcnba");
    }
}
