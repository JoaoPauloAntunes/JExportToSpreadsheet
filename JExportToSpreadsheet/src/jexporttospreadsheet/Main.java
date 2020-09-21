/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jexporttospreadsheet;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class Main {
    public static void main(String[] args) {
        
        String[] columnsName = {"col 0", "col 1", "col 2", "col 3"};
        String[][] content = {
            {"0", "1", "2", "3"},
            {"4", "5", "6", "7"}
        };
        JExport jExp = new JExport(columnsName, content);
        
        try {
            jExp.export("2020-09-20_example");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
