package org.nix.utils.excel;

/**
 * excel表
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/29
 */
public interface Excel {
    /**
     * 为excel表添加一行数据
     * @param row 行级元素
     */
    void addRow(Row row);

    /**
     * 获取当前表格中的一行数据
     * @param index 行级坐标
     * @return 当前表格中的一行数据
     */
    Row getRow(int index);

    /**
     * 移除一行数据
     * @param index 行级坐标
     */
    void removeRow(int index);

}
