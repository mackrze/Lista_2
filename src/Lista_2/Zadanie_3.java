package Lista_2;


import java.time.LocalDate;
import java.util.Scanner;

public class Zadanie_3 {
    public static void main(String[] args) {
        System.out.println("Prosze podac kolejno: Imie i nazwisko razem, pleć, date urodzenia (RRRR-MM-DD),wzrost, wage ");
        Scanner scanner = new Scanner(System.in);
        String imieNazwisko=scanner.nextLine();
        String plec=scanner.nextLine();
        String dataString=scanner.nextLine();
        LocalDate date=LocalDate.parse(dataString);
        String wzrostString=scanner.nextLine();
        int wzrost= Integer.valueOf(wzrostString);
        String wagaString=scanner.nextLine();
        int waga= Integer.valueOf(wagaString);
        HealthProfile t1 = new HealthProfile(imieNazwisko,plec,date,wzrost,waga);
       t1.wyswietlProfil();

    }
}
