package Lista_2;


import java.time.LocalDate;
import java.util.Scanner;

public class Zadanie_2 {
    public static void main(String[] args) {
        System.out.println("Please write a year RRRR");
        Scanner scanner = new Scanner(System.in);
        String userDateYearString=scanner.nextLine();
        System.out.println("Please write a month MM");
        String userDateMonthString=scanner.nextLine();
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append(userDateYearString);
        stringBuilder.append("-");
        stringBuilder.append(userDateMonthString);
        stringBuilder.append("-01");
        String userDateString=stringBuilder.toString();
        LocalDate userDate =LocalDate.parse(userDateString);
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        int nrOfDayInWeek=userDate.getDayOfWeek().getValue();
for (int i=1;i<=userDate.getMonth().length(userDate.getYear()%4==0);i++){

    if(i==1)
    for(int j=1;j<userDate.getDayOfWeek().getValue();j++)
        System.out.print("    ");
    if(i<10)
    System.out.print(i+"   ");
    else
        System.out.print(i+"  ");
    if(nrOfDayInWeek%7==0)
        System.out.println(" ");
    nrOfDayInWeek++;

}

    }


}
