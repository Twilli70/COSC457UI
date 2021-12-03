
package UI_DESIGN;

import java.sql.*;

public class MyJDBC {
    public static void main(String[]args){
    try{
            var connection = DriverManager.getConnection("jdbc:mysql://triton:3360/twilli70db", "twilli70", "COSC*3acm9");
            var statement = connection.createStatement();

            var result = statement.executeQuery("SELECT * FROM Client");
            while (result.next()){
                var printString = String.format("%s | %s | %s | %s", result.getString("cId"), result.getString("phone_number"), result.getString("cADDR"), result.getString("cEmail"));
                System.out.println(printString);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
