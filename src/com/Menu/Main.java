package com.Menu;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.Carrepair.*;
public class Main {
    public static void main(String[] args) {
        do {
            int input;
            do {
                System.out.println("********************************************************************************************************************************************************");
                System.out.println("AUTO REPAIR SHOP MANAGEMENT SYSTEM");
                System.out.println("********************************************************************************************************************************************************");
                System.out.println("PRESS 1 : ADD CUSTOMER");
                System.out.println("PRESS 2 : SHOW ALL CUSTOMERS");
                System.out.println("PRESS 3 : FIND CUSTOMER");
                System.out.println("PRESS 4 : DELETE CUSTOMER");
                System.out.println("PRESS 5 : UPDATE PHONE");
                System.out.println("PRESS 6 : EXIT");
                System.out.println("********************************************************************************************************************************************************");
                Scanner sc = new Scanner(System.in);
                System.out.print("ENTER YOUR CHOICE :: ");
                input = sc.nextInt();
                switch (input) {
                    case 1: addBooks();
                        break;
                    case 2: show();
                        break;
                    case 3: search();
                        break;
                    case 4:delete();
                        break;
                    case 5:Updatephno();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.print("The entered value is unrecognized!\n");
                        break;
                }
            } while (true);
        }while(true);
    }
    public static void addBooks(){
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER CUSTOMER NAME  :: ");
        String ctnm=sc.nextLine();
        System.out.print("ENTER CAR's MODEL    :: ");
        String carnm=sc.nextLine();
        System.out.print("ENTER NUMBER OF CAR  :: ");
        String carno=sc.nextLine();
        String temp1=carno.replaceAll("\\s+","").toLowerCase();
        String[] carnos=ConnectionsMethods.carnosArray();
        int flag=0;
        for(int i=0;i<carnos.length;i++) {
            String temp=carnos[i].replaceAll("\\s+","").toLowerCase();
            if(temp1.equals(temp)) {
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.print("CUSTOMER ADDRESS     :: ");
            String ctadd=sc.nextLine();
            System.out.print("CUSTOMER PHONE NUMBER:: ");
            String phno=sc.nextLine();
            System.out.print("ENTER TIME (IN DAYS):: ");
            String time=sc.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now=LocalDateTime.now();
            String datetime=dtf.format(now);
            Customer rt=new Customer(ctnm,carnm,carno,ctadd,phno,time,datetime);
            boolean success= ConnectionsMethods.InsertToDB(rt);
            if(success){
                System.out.println("Record Added Into your database successfully !!!");
            }
            else {
                System.out.println("Something went wrong !!!");
            }
        }
        else{
            System.out.println("This Car is already under repair....");
        }

    }
    public static void show(){
        ConnectionsMethods.show();
    }
    public static void search(){
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER THE CAR'S NUMBER :: ");
        String str=sc.nextLine();
        ConnectionsMethods.find(str);
    }
    public static void delete(){
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER CUSTOMER ID TO DELETE :: ");
        int id=sc.nextInt();
        ConnectionsMethods.delete(id);
    }

    public static void Updatephno(){
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER CUSTOMER ID TO UPDATE PHONE NUMBER :: ");
        int id=sc.nextInt();
        boolean up=ConnectionsMethods.updatephno(id);
        if(up){
            System.out.println("PHONE NUMBER IS SUCCESSFULLY UPDATED...");
        }
        else{
            System.out.println("Something Went Wrong....");
        }
    }

}
