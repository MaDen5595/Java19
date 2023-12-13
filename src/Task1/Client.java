package Task1;

import java.util.Scanner;
//пример верного ИНН 325507450247
public class Client {
    public static void main(String[] args) throws WrongInnException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите покупку:");
        String pokup = sc.nextLine();
        System.out.println("Введите имя:");
        String name = sc.nextLine();
        System.out.println("Введите номер ИНН:");
        String inn = sc.nextLine();
        if(inn.length()!=12){
            throw new WrongInnException("Неверный ИНН");
        }
        String kontr = String.valueOf((Integer.parseInt(inn.substring(0,1))*7+Integer.parseInt(inn.substring(1,2))*2
                +Integer.parseInt(inn.substring(2,3))*4+Integer.parseInt(inn.substring(3,4))*10
                +Integer.parseInt(inn.substring(4,5))*3+Integer.parseInt(inn.substring(5,6))*5
                +Integer.parseInt(inn.substring(6,7))*9+Integer.parseInt(inn.substring(7,8))*4
                +Integer.parseInt(inn.substring(8,9))*6+Integer.parseInt(inn.substring(9,10))*8)%11);
        int kontr1 = Integer.parseInt(kontr.substring(kontr.length()-1));
        kontr = String.valueOf((Integer.parseInt(inn.substring(0,1))*3+Integer.parseInt(inn.substring(1,2))*7
                +Integer.parseInt(inn.substring(2,3))*2+Integer.parseInt(inn.substring(3,4))*4
                +Integer.parseInt(inn.substring(4,5))*10+Integer.parseInt(inn.substring(5,6))*3
                +Integer.parseInt(inn.substring(6,7))*5+Integer.parseInt(inn.substring(7,8))*9
                +Integer.parseInt(inn.substring(8,9))*4+Integer.parseInt(inn.substring(9,10))*6
                +Integer.parseInt(inn.substring(10,11))*8)%11);
        int kontr2 = Integer.parseInt(kontr.substring(kontr.length()-1));
        if(kontr1 != Integer.parseInt(inn.substring(10,11))){
            throw new WrongInnException("Неверный ИНН");
        }
        if(kontr2 != Integer.parseInt(inn.substring(11,12))){
            throw new WrongInnException("Неверный ИНН");
        }
        System.out.println("Спасибо за покупку!");
    }
}
