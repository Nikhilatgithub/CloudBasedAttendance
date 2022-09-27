/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Attendance;

import java.sql.*;

/**
 *
 * @author HP
 */
public class AttendanceFeacher {

    public void GetAllInfo() {

        boolean flag = false;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancesystem", "root", "root");
            Statement st1 = con.createStatement();
            Statement st2 = con.createStatement();

            String query = "select * from attendanceinfo";

            ResultSet rs1 = st1.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(query);

            int row = 0;
            while (rs1.next()) {
                row++;

            }

            String data[][] = new String[row][11];

            int i = 0;

            while (rs2.next()) {
                //  // date, dept, sem, student, sub, status, feedby, disc
                String acno = rs2.getString(1);
                String fname = rs2.getString(2);
                String faname = rs2.getString(3);
                String dob = rs2.getString(4);
                String sex = rs2.getString(5);
                String currentadd = rs2.getString(6);
                String city = rs2.getString(7);
                String pin = rs2.getString(8);
              
                    

           //pass to matrix  Rollno, Name, Percentage
                data[i][0] = acno;
                data[i][1] = fname;
                data[i][2] = faname;
                data[i][3] = dob;
                data[i][4] = sex;
                data[i][5] = currentadd;
                data[i][6] = city;
                data[i][7] = pin;
            

                i++;

            }
            ViewAttendanceFrame.data = data;
   con.close();
        } catch (Exception e) {
            System.out.println("Exception in GetAllInfo of viewDBdata class " + e);
            flag = false;
        }

    }
}
