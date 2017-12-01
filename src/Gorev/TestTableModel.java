/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gorev;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muaz Ahmed
 */
public class TestTableModel {
    private List<RowData> rowData;

        public TestTableModel() {
            rowData = new ArrayList<RowData>(25);
            for (int index = 0; index < 10; index++) {
                rowData.add(new RowData(index));
            }
        }

//        @Override
        public String getColumnName(int column) {
            return column == 0 ? "Text" : "X";
        }

//        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            RowData rd = rowData.get(rowIndex);
            return rd.isDeletable();
        }

//        @Override
        public int getRowCount() {
            return rowData.size();
        }

//        @Override
        public int getColumnCount() {
            return 2;
        }

//        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            RowData rd = rowData.get(rowIndex);
            return columnIndex == 0 ? rd.getText() : rd.isDeletable();
        }

//        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            RowData rd = rowData.get(rowIndex);
            if (columnIndex == 1) {
                if (aValue instanceof Boolean && (Boolean)aValue) {
                    rowData.remove(rd);
//                    fireTableRowsDeleted(rowIndex, rowIndex);
                }
            }
        }
}
