package org.nix.utils.excel;

/**
 * 定义一个单元级元素的基本操作
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/29
 */
public interface Cell {
    /**
     * 获取到单元格的行坐标
     * @return 单元格的行坐标
     */
    int getRowIndex();

    /**
     * 获取到单元格的列坐标
     * @return 单元格的列坐标
     */
    int getColumnIndex();
}
