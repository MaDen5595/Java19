package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortingStudentsByGPA {
    public static void Sortr(List<Student> students, int leftBorder, int rightBorder, Comp comp){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Student pivot = students.get((leftMarker + rightMarker) / 2);
        do {
            while (comp.compare(students.get(leftMarker),pivot)<0) {
                leftMarker++;
            }
            while (comp.compare(students.get(rightMarker),pivot)>0) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    Student tmp = students.get(leftMarker);
                    students.set(leftMarker, students.get(rightMarker));
                    students.set(rightMarker, tmp);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            Sortr(students, leftMarker, rightBorder,comp);
        }
        if (leftBorder < rightMarker) {
            Sortr(students, leftBorder, rightMarker,comp);
        }
    }
    public static void main(String[] args) throws NoStudentException {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        Comp comp = new Comp();
        int i = 891;
        System.out.println("Добро пожаловать!");
        while(i!=0){
            System.out.println("Для создания списка напишите 1\n" +
                    "Для вывода списка напишите 2\nДля поиска в списке напишите 3\n" +
                    "Для сортировки списка напишите 4\nДля выхода напишите 0");
            while(!sc.hasNextInt()){
                System.out.println("Цифру введи:");
                sc.nextLine();
            }
            i = sc.nextInt();
            if(i>4){
                System.out.println("Не та цифра");
            }
            switch(i){
                case(1) -> {
                    System.out.print("Number of students: ");
                    int n = sc.nextInt();
                    setArray(n,students);
                }
                case (2) -> {
                    outArray(students);
                }
                case(4) -> {
                    Sortr(students,0,students.size()-1,comp);
                }
                case(3) -> {
                    System.out.print("");
                    String rofls = sc.nextLine();
                    System.out.print("Enter name of Student: ");
                    String name = sc.nextLine();
                    System.out.print("Enter surname of Student: ");
                    String surname = sc.nextLine();
                    FoundStudent(students,name,surname);
                }
            }
        }
    }
    public static void setArray(int n,List<Student> students){
        Scanner sc = new Scanner(System.in);
        String name;
        String surname;
        int co;
        String spec;
        int group;
        int GPA;
        String lol;
        for(int i = 0;i<n;i++){
            int e = i+1;
            System.out.println("This is setArray, write something: ");
            lol = sc.nextLine();
            System.out.println("Name of "+ e +" student:");
            name = sc.nextLine();
            System.out.println("Surname of "+ e +" student:");
            surname = sc.nextLine();
            System.out.println("Spec of "+ e +" student:");
            spec = sc.nextLine();
            System.out.println("Course of "+ e +" student:");
            co = sc.nextInt();
            System.out.println("Group of "+ e +" student:");
            group = sc.nextInt();
            System.out.println("GPA of "+ e +" student:");
            GPA = sc.nextInt();
            students.add(new Student(name,surname,spec,co,group,GPA));
        }
    }
    public static void outArray(List<Student> students){
        for(int e = 0;e< students.size();e++){
            System.out.println(students.get(e).toString());
        }
    }
    public static void FoundStudent(List<Student> students,String name,String surname) throws NoStudentException {
        boolean flag = true;
        for(int i = 0;i< students.size();i++){
            Student buff = students.get(i);
            if(buff.getName().equals(name) & buff.getSurname().equals(surname)){
                flag = false;
                System.out.println(buff.toString());
            }
        }
        if(flag){
            throw new NoStudentException("Студента нет в списке");
        }
    }
}
