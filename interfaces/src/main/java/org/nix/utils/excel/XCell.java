package org.nix.utils.excel;

/**
 * excel单元格信息
 * @author zhangpei
 * @date 2018/6/29
 */
public class XCell implements Cell{
    /**
     * 当前单元格的行坐标
     */
    private int rowIndex;
    /**
     * 当前单元格的列坐标
     */
    private int columnIndex;
    /**
     * 当前单元格的值
     */
    private Object value;

    /**
     * 空值元素
     * @param rowIndex 元素行坐标
     * @param columnIndex 元素列坐标
     */
    public XCell(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    /**
     * 含值的单元元素
     * @param rowIndex 元素行坐标
     * @param columnIndex 元素列坐标
     * @param value 元素值
     */
    public XCell(int rowIndex, int columnIndex, Object value) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.value = value;
    }

    @Override
    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Override
    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "XCell{" +
                "rowIndex=" + rowIndex +
                ", columnIndex=" + columnIndex +
                ", value=" + value +
                '}';
    }
}
