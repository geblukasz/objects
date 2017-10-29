import java.io.*;
import java.util.Scanner;

public class Pracownik implements Serializable{
    private String imie;
    private String nazwisko;
    private int placa;
    private char plec;
    private int dzial;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public int getDzial() {
        return dzial;
    }

    public void setDzial(int dzial) {
        this.dzial = dzial;
    }

    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, int placa, char plec, int dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;
    }

    public static Pracownik[] wczytajZPlikuTekstowego(String nazwaPlikuTekstowego, Pracownik[] pracownicy) throws FileNotFoundException {
        File file = new File(nazwaPlikuTekstowego);
        Scanner scanner = new Scanner(file);
        pracownicy = new Pracownik[100];
        int index = 0;
        while (scanner.hasNextLine()) {
            String linia = scanner.nextLine();
            String[] tab2 = linia.split(" ");
            Pracownik pracownik = new Pracownik(tab2[0], tab2[1], Integer.parseInt(tab2[2]), tab2[3].charAt(0), Integer.parseInt(tab2[4]));
            pracownicy[index] = pracownik;
            index++;
        }
        return pracownicy ;
    }

    public static int srednieZarobki(Pracownik[] pracownicy, int dzial, char plec){
        int sumaZarobkowZDzialu = 0;
        int licznikPracownikowZDzialu = 0;
        int sredniaZarobkowZDzialu = 0;
        for (int i = 0; i < pracownicy.length; i++){
            if (pracownicy[i] != null && pracownicy[i].dzial == dzial && pracownicy[i].plec == plec){
                sumaZarobkowZDzialu = sumaZarobkowZDzialu + pracownicy[i].placa;
                licznikPracownikowZDzialu++;
            }
        }
        sredniaZarobkowZDzialu = sumaZarobkowZDzialu/licznikPracownikowZDzialu;

        return sredniaZarobkowZDzialu;
    }

    public static void zapiszDoPliku(String NazwaPlikuDoZapisania, Pracownik[] pracownicy) throws IOException {
        PrintWriter zapisDoPliku = new PrintWriter(NazwaPlikuDoZapisania);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(NazwaPlikuDoZapisania));
        objectOutputStream.writeObject(pracownicy);
    }

    public static void odczytZPliku(String NazwaPlikuDoWczytania) throws IOException, ClassNotFoundException {
        Pracownik testowyPracownik = null;
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(NazwaPlikuDoWczytania));
        testowyPracownik = (Pracownik) inputStream.readObject();
        System.out.println(testowyPracownik.imie);
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", placa=" + placa +
                ", plec=" + plec +
                ", dzial=" + dzial +
                '}';
    }
}
