package Lista_2;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class Zadanie_1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader;
        fileReader=new FileReader("Text.txt");
        bufferedReader = new BufferedReader(fileReader);

        ArrayList<String [] > listaGraczy=new ArrayList<String[]>() {};
        String textLine=bufferedReader.readLine();
        do {
            String [] elements=textLine.split("\t");
            listaGraczy.add(elements);
            textLine= bufferedReader.readLine();
        } while (textLine!=null);
        bufferedReader.close();
        //System.out.println(listaGraczy.get(0)[2]);
        System.out.println(nrPozycjiGracza(listaGraczy,"Hubert Hurkacz"));
        System.out.println(liczbaGraczyZKraju(listaGraczy,"POL"));
        System.out.println("srednia= "+sredniaOdchylenie(listaGraczy)[0]+" odchylenie standardowe= "+sredniaOdchylenie(listaGraczy)[1]);
        System.out.println("roznica pkt miedzy Djokovic a Nadal= "+roznica(listaGraczy,"Novak Djokovic","Rafael Nadal"));
        zapis(listaGraczy);

    }
    public static int nrPozycjiGracza (ArrayList<String[]> strings,String gracz) {
        int nrPozycjiGracza=0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i)[2].equalsIgnoreCase(gracz)) {
                nrPozycjiGracza=Integer.valueOf(strings.get(i)[0]);
                break;
            }

        }
        return nrPozycjiGracza;
}
public static int liczbaGraczyZKraju (ArrayList<String[]> strings,String kraj){
        int liczbaGraczy=0;
    for (int i = 0; i < strings.size(); i++) {
        if (strings.get(i)[1].equalsIgnoreCase(kraj)) {
            liczbaGraczy++;
        }
    }
    return liczbaGraczy;
}
public static double [] sredniaOdchylenie (ArrayList<String []> strings){
       double [] sredniaOdchylenie=new double[2];
       sredniaOdchylenie[0]=0;
       sredniaOdchylenie[1]=0;
       double licznik=0;
       for(int i=0;i<10;i++)
           sredniaOdchylenie[0] += Double.valueOf(strings.get(i)[3]) / 10;
       for(int i=0;i<10;i++)
           licznik+= Math.pow((Double.valueOf(strings.get(i)[3])-sredniaOdchylenie[0]),2);
       licznik=licznik/9;
       sredniaOdchylenie[1]=Math.sqrt(licznik);
       return sredniaOdchylenie;
    }
    public static int roznica(ArrayList<String[]> strings,String gracz_1,String gracz_2){
        int pkt_1=0;
        int pkt_2=0;
        for (int i=0;i<strings.size();i++){
            if(strings.get(i)[2].equalsIgnoreCase(gracz_1))
                pkt_1=Integer.valueOf(strings.get(i)[4]);
            if (strings.get(i)[2].equalsIgnoreCase(gracz_2))
                pkt_2=Integer.valueOf(strings.get(i)[4]);

        }
        int roznica=Math.abs(pkt_1-pkt_2);
        return roznica;
    }
    public static void zapis(ArrayList<String []>strings) throws IOException {
        FileWriter fileWriter=null;
        File file = new File("LiczbaTurniejow.txt");
        fileWriter =new FileWriter(file,false);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for(int i=0;i<strings.size();i++) {
            String doZapisu = strings.get(i)[5];
            bufferedWriter.write(doZapisu);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }

}
