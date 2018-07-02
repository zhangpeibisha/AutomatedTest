package org.nix.utils.excel;

import org.nix.exceptions.ExcelException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/29
 */
public class ExcelTable implements Excel {

    /**
     * 表格数据集合
     */
    private List<Row> rows;
    /**
     * 当前行级坐标值，每增加一行数据自增一
     */
    private int currentRowIndex;
    /**
     * 默认数组大小
     */
    private final static int DEFAULT_XCELL_NUMBER = 4;

    /**
     * 为表格新增一行数据
     *
     * @param row 行级元素
     */
    @Override
    public void addRow(Row row) {
        if (row == null) {
            throw new NullPointerException();
        }

        if (rows == null) {
            rows = new ArrayList<>(DEFAULT_XCELL_NUMBER);
            currentRowIndex = 0;
            rows.add(row);
        } else {
            if (currentRowIndex != row.getRowIndex()) {
                throw new ExcelException(row + " 与当前数据表的数据完整性不吻合");
            }
            rows.add(row);
            currentRowIndex++;
        }
    }

    /**
     * @param index 行级坐标
     * @return 指定行级元素
     */
    @Override
    public Row getRow(int index) {
        if (rows == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > currentRowIndex) {
            throw new IndexOutOfBoundsException();
        }
        return rows.get(index);
    }

    @Override
    public void removeRow(int index) {
        if (rows == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > currentRowIndex) {
            throw new IndexOutOfBoundsException();
        }
        rows.remove(index);
        currentRowIndex--;
        for (int i = index;i<currentRowIndex;i++){
            rows.get(i).setRowIndex(i);
        }
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        // 按行号排序
        Collections.sort(rows);
        for (Row row : rows) {
            addRow(row);
        }
    }

    public int getCurrentRowIndex() {
        return currentRowIndex;
    }

}
