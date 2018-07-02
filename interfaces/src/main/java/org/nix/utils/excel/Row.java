package org.nix.utils.excel;

/**
 * 定义一个行级数据的基本操作
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/29
 */
public interface Row extends Comparable<Row>{
    /**
     * 添加一个单元进入当前行级元素中
     * @param cell 单元元素信息对象
     */
    void addCell(Cell cell);

    /**
     * 删除当前行级元素中指定下标的单元元素
     * @param index 单元元素子当前行的列
     */
    void removeCell(int index);

    /**
     * 获取到当前行级元素中的指定单元元素
     * @param index 单元元素子当前行的列
     * @return 单元元素信息
     */
    Cell getCell(int index);

    /**
     * 获取行级元素的行号
     * @return 获取当前行级元素的行坐标
     */
    int getRowIndex();

    /**
     * 设置行级元素的行号
     * @param index 设置行号
     */
    void setRowIndex(int index);
}
