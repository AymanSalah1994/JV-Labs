
package thirdlab;

import java.sql.*;

public class ThirdLab {

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb", "root", "");
            PreparedStatement pst = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?,?)");

            con.setAutoCommit(false);

            // 1
            pst.setInt(1, 1); // ID
            pst.setString(2, "Ali"); // F_Name
            pst.setString(3, "Ahmed"); // L_Name
            pst.setString(4, "M"); // Gender
            pst.setInt(5, 22); // Age
            pst.setString(6, "3 Egypt , Cairo"); // Address
            pst.setString(7, "3456474"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 2
            pst.setInt(1, 2); // ID
            pst.setString(2, "Samy"); // F_Name
            pst.setString(3, "Mahmoud"); // L_Name
            pst.setString(4, "M"); // Gender
            pst.setInt(5, 45); // Age
            pst.setString(6, "Manoura"); // Address
            pst.setString(7, "76768456"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 3
            pst.setInt(1, 3); // ID
            pst.setString(2, "Samar"); // F_Name
            pst.setString(3, "Fathy"); // L_Name
            pst.setString(4, "F"); // Gender
            pst.setInt(5, 34); // Age
            pst.setString(6, "Zagazig"); // Address
            pst.setString(7, "568768976"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 4
            pst.setInt(1, 4); // ID
            pst.setString(2, "Sana"); // F_Name
            pst.setString(3, "Azouz"); // L_Name
            pst.setString(4, "F"); // Gender
            pst.setInt(5, 49); // Age
            pst.setString(6, "South Valey"); // Address
            pst.setString(7, "67567567"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 5
            pst.setInt(1, 5); // ID
            pst.setString(2, "Khaled"); // F_Name
            pst.setString(3, "Rady"); // L_Name
            pst.setString(4, "M"); // Gender
            pst.setInt(5, 19); // Age
            pst.setString(6, "3 China , Cairo"); // Address
            pst.setString(7, "54657567"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 6
            pst.setInt(1, 6); // ID
            pst.setString(2, "Sherine"); // F_Name
            pst.setString(3, "Yehya"); // L_Name
            pst.setString(4, "F"); // Gender
            pst.setInt(5, 67); // Age
            pst.setString(6, "3 Sudan , Cairo"); // Address
            pst.setString(7, "34546456"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 7
            pst.setInt(1, 7); // ID
            pst.setString(2, "Salah"); // F_Name
            pst.setString(3, "Falawkas"); // L_Name
            pst.setString(4, "M"); // Gender
            pst.setInt(5, 37); // Age
            pst.setString(6, "3 Mokattam , Cairo"); // Address
            pst.setString(7, "6756t345"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 8
            pst.setInt(1, 8); // ID
            pst.setString(2, "Nadia"); // F_Name
            pst.setString(3, "Adham"); // L_Name
            pst.setString(4, "F"); // Gender
            pst.setInt(5, 60); // Age
            pst.setString(6, "Japan , Cairo"); // Address
            pst.setString(7, "6765"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 9
            pst.setInt(1, 9); // ID
            pst.setString(2, "Adham"); // F_Name
            pst.setString(3, "Sabry"); // L_Name
            pst.setString(4, "M"); // Gender
            pst.setInt(5, 23); // Age
            pst.setString(6, "Germany , Deuchland"); // Address
            pst.setString(7, "12312323"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            // 10
            pst.setInt(1, 10); // ID
            pst.setString(2, "Samaher"); // F_Name
            pst.setString(3, "Elsharkawy"); // L_Name
            pst.setString(4, "F"); // Gender
            pst.setInt(5, 50); // Age
            pst.setString(6, "Amstrdam"); // Address
            pst.setString(7, "3456345345"); // Phone_Number
            pst.setInt(8, 30); // Vacation_Balance
            pst.addBatch();

            int[] count = pst.executeBatch();
            con.commit();

            System.out.println("The Number of effected Rows : " + count.length);
            // This is Wrong But I just want to Print Anything to Make Sure 
        } catch (SQLException e) {
        }
    } // End Of Main
} // End of ThirdLab Class
