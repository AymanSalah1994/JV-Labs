package fourthlab;

import java.sql.*;

public class FourthLab {

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb", "root", "");
            PreparedStatement pst1 = con.prepareStatement("UPDATE employee SET Vacation_Balance = 45 WHERE Age >= ?");
            PreparedStatement pst2 = con.prepareStatement(
                    "UPDATE employee SET F_Name = CASE WHEN Gender = ? THEN CONCAT(? , F_Name) WHEN Gender = ? THEN CONCAT(? , F_Name) END WHERE  Age >= 45");

            con.setAutoCommit(false);

            // 1
            pst1.setInt(1, 45); // Age Field
            pst1.addBatch();

            // 2
            pst2.setString(1, "M"); // Male
            pst2.setString(2, "MR."); // MR
            pst2.setString(3, "F"); // Female
            pst2.setString(4, "MRS."); // MRS
            pst2.addBatch();

            int[] count = pst1.executeBatch();
            int[] count2 = pst2.executeBatch();
            con.commit();

            System.out.println("The Number of effected Rows : " + count.length);
            System.out.println("The Number of effected SECOND Rows : " + count2.length);
            // This is Wrong But I just want to Print Anything to Make Sure
        } catch (SQLException e) {
        }
    } // End Of Main

}

// UPDATE employee
// SET Vacation_Balance = 45
// WHERE Age >= 45;

// UPDATE employee
// SET F_Name = CASE WHEN Gender = "M" THEN CONCAT("Mr." , F_Name)
// WHEN Gender = "F" THEN CONCAT("Mrs." , F_Name)
// END
// WHERE Age >= 45;
