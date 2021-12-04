package cosc456_project;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ui.HomeScreen;

public class Main {
    public static void main(String[] args) {
      var db = TritonDB.getInstance();
      String[] columNames = {"Name", "EyeColor", "Gender"};
      Object[][] data = {{"Bill", "Hazel", "M"},{"Bill", "Hazel", "M"}};
      try{
          var result = db.executeQuery("SELECT * FROM twilli70db.Employees;");
          columNames = db.getResultColumns(result);
          data = db.getResultRows(result);
      }
      catch (Exception e){
          e.printStackTrace();
      }
      
      var table = new JTable(data, columNames);
      var scrollPane = new JScrollPane(table);
      table.setFillsViewportHeight(true);
      var mainWindow = new JFrame();
      table.setLocation(50, 50);
      
      mainWindow.setLayout(new CardLayout());
      mainWindow.setContentPane(scrollPane);
      mainWindow.setSize(500, 500);
      mainWindow.setVisible(true);

      
    } 
}

