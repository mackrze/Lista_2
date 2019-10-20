package Lista_2;

import java.time.LocalDate;

/**
 * HealthProfile class represents patients parameters
 * @author mackr
 * @version 1.0
 * @since 19.10.2019
 */

public class HealthProfile {
    /**
     * represents Name and Surname
     */
    private String imieNazwisko;
    /**
     * represents gender
     */
    private String plec;
    /**
     * represents date of birth
     */
    private LocalDate dataUrodzenia;
    /**
     * represents high in cm
     */
    private int wzrost;
    /**
     * represents weight in kg
     */
    private int waga;


    public String getImieNazwisko() {
        return imieNazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public int getWzrost() {
        return wzrost;
    }

    public int getWaga() {
        return waga;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public void setWzrost(int wzrost) {
        this.wzrost = wzrost;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    /**
     *
     * @param imieNazwisko (typ String)
     * @param plec (typ String)
     * @param dataUrodzenia (typ Date)
     * @param wzrost (typ int)
     * @param waga (typ int)
     */
    public HealthProfile(String imieNazwisko, String plec, LocalDate dataUrodzenia, int wzrost, int waga) {
        this.imieNazwisko = imieNazwisko;
        this.plec = plec;
        this.dataUrodzenia = dataUrodzenia;
        this.wzrost = wzrost;
        this.waga = waga;
    }

    /**
     * method which counter an age of patient
     * @return wiek (typ int)
     */
    private    int wiek(){
        LocalDate terazniejszosc= LocalDate.now();
        int wiek = terazniejszosc.getYear()-dataUrodzenia.getYear();
        return wiek;
    }

    /**
     * method which counter a BMI of patient
     * @return bmi
     */
    private float bmi (){
        float bmi = (float)waga/(float)(Math.pow(wzrost,2));
        bmi=bmi*10000;
        return bmi;
    }
    /**
     * method which counter a max pulse of patient
     * @return tetnoMax
     */
    private float tentnoMax(){
        int wiek=wiek();
        float tentnoMax=220-wiek;
        return  tentnoMax;
    }
    /**
     * method which counter an averge pulse of patient
     * @return tetnoSrednie
     */
    private float tentnoSrednie(){
        float tenntoMax=tentnoMax();
        float tentnoSrednie=(float)(tenntoMax*0.6);
        return  tentnoSrednie;
    }

    /**
     * method which prints all parameters of patient
     */
    public void wyswietlProfil(){
        System.out.println(imieNazwisko);
        System.out.println(plec);
        System.out.println(waga);
        System.out.println(wzrost);
        System.out.println(dataUrodzenia);
        System.out.println(wiek());
        System.out.println(bmi());
        System.out.println(tentnoMax());
        System.out.println(tentnoSrednie());
    }


}
