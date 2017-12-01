/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gorev;

/**
 *
 * @author Muaz Ahmed
 */
public class RowData {
    private String text;
        private boolean deletable;

        public RowData(int row) {
            text = "Row " + row;
            deletable = Math.round(Math.random() * 1) == 0;
        }

        public String getText() {
            return text;
        }

        public boolean isDeletable() {
            return deletable;
        }       
}
