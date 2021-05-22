package com.Carrepair;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectionsMethods {
    public static boolean InsertToDB(Customer rt){
        boolean f=false;
        try{
            Connection con = ConnectionProvider.CreateConnection();
            String Query="insert into car_repair(customer_nm,car_model,car_number,customer_phno,time_repair,date_time,address) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(Query);
            pst.setString(1,rt.getCustomerNm());
            pst.setString(2,rt.getCarsModel());
            pst.setString(3,rt.getCarsnumber());
            pst.setString(4,rt.getCustomerPHno());
            pst.setString(5,rt.getTime());
            pst.setString(6,rt.getDatetime());
            pst.setString(7,rt.getCarAdd());
            pst.executeUpdate();
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static void show(){
        try{
            Connection con=ConnectionProvider.CreateConnection();
            String Query="select * from car_repair";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(Query);
            System.out.println("********************************************************************************************************************************************************");
            System.out.printf("%-10s%-50s%-25s%-25s%-25s\n","ID","CUSTOMER NAME","CAR MODEL","CAR'S NUMBER.","DATE & TIME");
            System.out.println("********************************************************************************************************************************************************");

            if(rs.next()){
                do{
                    System.out.printf("%-10s%-50s%-25s%-25s%-25s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7));
                    System.out.println();
                }while(rs.next());
            }
            else {
                System.out.println("NO RECORDS ADDED YET....");
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void find(String carno){
        try{
            Connection con=ConnectionProvider.CreateConnection();
            String Query="select serial_number,customer_nm,car_model,car_number,customer_phno,time_repair,date_time,address from car_repair where car_number="+"\""+carno+"\"";
            Statement smt=con.createStatement();
            ResultSet rs = smt.executeQuery(Query);
            if(rs.next()) {
                do {
                    System.out.println("SERIAL NUMBER OF CUSTOMER :: "+rs.getString(1));
                    System.out.println("NAME OF CUSTOMER          :: "+rs.getString(2));
                    System.out.println("MODEL OF THE CAR FOR RENT :: "+rs.getString(3));
                    System.out.println("CAR'S NUMBER OF CUSTOMER  :: "+rs.getString(4));
                    System.out.println("PHONE NUMBER OF CUSTOMER  :: "+rs.getString(5));
                    System.out.println("TIME PERIOD FOR REPAIR    :: "+rs.getString(6)+" DAYS");
                    System.out.println("RENTAL RECORD ADDED AT    :: "+rs.getString(7));
                    System.out.println("ADDRESS OF CUSTOMER       :: "+rs.getString(8));
                }while(rs.next());}
            else {
                System.out.println("Record Not Found...");
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void delete(int id) {
        try {
            Connection con=ConnectionProvider.CreateConnection();
            String Query1=String.format("select customer_nm from car_repair where serial_number=%d",id);
            Statement smt=con.createStatement();
            ResultSet rs = smt.executeQuery(Query1);
            if(rs.next()) {
                do {
                    System.out.println("CUSTOMER NAME :: "+rs.getString(1));
                    System.out.println("DELETED SUCCESSFULLY !!!!");
                }while(rs.next());}
            else {
                System.out.println("Record Not Found...");
            }
            String Query="delete from car_repair where serial_number=?";
            PreparedStatement pstmt=con.prepareStatement(Query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            autoIdUpdate();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    public static void autoIdUpdate() {
        try {
            String Q1="SET  @num := 0";
            String Q2="UPDATE car_repair SET serial_number = @num := (@num+1)";
            String Q3="ALTER TABLE car_repair AUTO_INCREMENT =1";
            Connection con=ConnectionProvider.CreateConnection();
            PreparedStatement pst1=con.prepareStatement(Q1);
            PreparedStatement pst2=con.prepareStatement(Q2);
            PreparedStatement pst3=con.prepareStatement(Q3);
            pst1.executeUpdate();
            pst2.executeUpdate();
            pst3.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static String[] carnosArray() {
        String  carnos[] = new String[0];
        try {
            Connection con=ConnectionProvider.CreateConnection();
            String Q="select car_number from car_repair";
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery(Q);

            int i=0;
            if(rs.next()) {
                do {
                    carnos= Arrays.copyOf(carnos,carnos.length+1);
                    carnos[i]=rs.getString(1);
                    i++;

                }while(rs.next());
                return carnos;
            }
            return carnos;


        }catch(Exception e)
        {
            e.printStackTrace();
            return carnos;
        }
    }
    public static boolean updatephno(int id){
        boolean f=false;
        try{
            Connection con=ConnectionProvider.CreateConnection();
            String IQ=String.format("select customer_nm,customer_phno from car_repair where serial_number=%d",id);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(IQ);

            if(rs.next()){
                do{
                    System.out.println("CUSTOMER NAME :: "+rs.getString(1));
                    System.out.println("PHONE NUMBER  :: "+rs.getString(2));
                }while(rs.next());
                String FQ="update car_repair set customer_phno=? where serial_number=?";
                System.out.print("Enter the Updated Phone Number :: ");
                Scanner sc=new Scanner(System.in);
                String phno=sc.nextLine();
                PreparedStatement pst=con.prepareStatement(FQ);
                pst.setString(1,phno);
                pst.setInt(2,id);
                pst.executeUpdate();
                f=true;
                return f;
            }
            else{
                System.out.println("Record Not Found");
                return f;
            }

        }catch (Exception e){
            System.out.println("Error Occured :: "+e.getMessage());
            return f;
        }
    }
}
