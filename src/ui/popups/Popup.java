/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.popups;

import java.util.ArrayList;
import ui.DatabaseEditor;

/**
 *
 * @author ezeha
 */
public class Popup extends javax.swing.JFrame {

    protected ArrayList<DatabaseEditor> databases = new ArrayList<DatabaseEditor>();
    public boolean isEditMode = false;

    public void setDataComponent(String name, String value) {

    }

    public void addDatabaseEditor(DatabaseEditor db) {
        databases.add(db);
    }

    public void save() {
        databases.forEach(db -> {
            db.updateTable();
        });
    }
}
