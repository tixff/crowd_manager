package com.ti.crowd_manager.result;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Ti
 * @date 2019/1/26
 */
@Data
public class ItemCatTreeNode {
    private  Integer id;
    private String text;
    private ArrayList<ItemCatTreeNode> children;
}
