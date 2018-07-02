package org.nix.utils.excel;

import org.nix.exceptions.ExcelException;

import java.util.ArrayList;
import java.util.List;

/**
 * excel表一行的数据，一行数据包含了许多
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/29
 * @see XCell 中包含了值信息
 */
public class XRow implements Row{
    /**
     * 一行数据的集合
     */
    private List<Cell> cells;
    /**
     * 当前行号以0为开始
     */
    private int xRowIndex;
    /**
     * 默认数组大小
     */
    private final static int DEFAULT_XCELL_NUMBER = 4;

    /**
     * 添加一个单元元素进入行级元素，如果行级元素中
     * 数据为空，则创建一个列表来存储单元元素，如果行元素
     * 已经有了数据，那么每次加入单元信息的时候都会去检测
     * 该单元元素是否应该放在当前行和当前列
     * 如果不符合添加需求则抛出异常
     *
     * @param cell 单元元素信息对象
     * @throws org.nix.exceptions.ExcelException 业务操作异常
     * @throws NullPointerException              传入单元信息为空
     */
    @Override
    public void addCell(Cell cell) {
        if (cell == null) {
            throw new NullPointerException();
        }
        if (cells == null) {
            cells = new ArrayList<>(DEFAULT_XCELL_NUMBER);
            xRowIndex = cell.getRowIndex();
            cells.add(cell);
        } else {
            if (xRowIndex != cell.getRowIndex()) {
                throw new ExcelException(cell + "错误的放置在了" + xRowIndex + "行中");
            }
            cells.add(cell);
        }
    }

    /**
     * 移除当前行的指定元素
     * 如果 index > cells.size() 或者 index < 0 则抛出异常
     *
     * @param index 单元元素子当前行的列
     * @throws IndexOutOfBoundsException 当前坐标没有值
     * @throws NullPointerException 当前行没有数据
     */
    @Override
    public void removeCell(int index) {

        if (cells == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index > cells.size()) {
            throw new IndexOutOfBoundsException(index + "在集合中不存在");
        }

        cells.remove(index);
    }

    /**
     * 获取当前行的指定列的单元元素
     *
     * @param index 单元元素子当前行的列
     * @return index 列的元素
     * @throws IndexOutOfBoundsException 当前坐标没有值
     * @throws NullPointerException 当前行没有数据
     */
    @Override
    public Cell getCell(int index) {

        if (cells == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index > cells.size()) {
            throw new IndexOutOfBoundsException(index + "在集合中不存在");
        }

        return cells.get(index);
    }

    /**
     * @return 当前行级元素的行号
     */
    @Override
    public int getRowIndex() {
        return getxRowIndex();
    }

    @Override
    public void setRowIndex(int index) {
        setxRowIndex(index);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public int getxRowIndex() {
        return xRowIndex;
    }

    public void setxRowIndex(int xRowIndex) {
        this.xRowIndex = xRowIndex;
    }

    @Override
    public String toString() {
        return "XRow{" +
                "cells=" + cells +
                ", xRowIndex=" + xRowIndex +
                '}';
    }

    /**
     * 按行号排序
     * @param o 行级元素
     * @return 比较后的差值
     */
    @Override
    public int compareTo(Row o) {
        if (o == null){
            return 0;
        }
        return this.getRowIndex() - o.getRowIndex();
    }
}
