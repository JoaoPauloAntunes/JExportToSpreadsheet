/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jexporttospreadsheet;

import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author joao
 */
public class JExport {
    private String[] columnsName;
    private String[][] content;
    public JExport(String[] columnsName, String[][] content) {
        this.columnsName = columnsName;
        this.content = content;
    }
    
    public void export(String fileName) throws FileNotFoundException {
        String contentThead = "";
        String contentTbody = "";
        String contentTr = "";
        Formatter arq = null;
        
        arq = new Formatter(fileName + ".xlsx");

        for(String col : columnsName) {
            contentThead += "\t\t\t\t<th style='background:#083923; color: #fff; text-align: center'>" + col + "</th>\n";
        }
        arq.format("<div>\n\t<table class='table table-hover'>\n\t\t<thead>\n\t\t\t<tr height='height: 30px;'>\n%s\t\t\t</tr>\n\t\t</thead>\n", contentThead);

        for(String[] row : content) {
            contentTr = "";

            for(String col : row) {
                contentTr += "\t\t\t\t<td style='border-bottom: 2px solid #878484; vertical-align: middle;'>" + col + "</td>\n";
            }
            contentTbody += "\t\t\t<tr>\n" + contentTr + "\t\t\t</tr>\n";
        }
        arq.format("\t\t<tbody>\n%s\t\t</tbody>\n\t</table>\n", contentTbody);
        arq.format("</div>\n<div style='page-break-before: always;'></div>");
        arq.close();
    }
}
