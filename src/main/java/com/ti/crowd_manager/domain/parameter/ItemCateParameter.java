package com.ti.crowd_manager.domain.parameter;

import com.ti.crowd_manager.domain.ItemCat;
import lombok.Data;

/**
 * @author Ti
 * @date 2019/1/28
 */
@Data
public class ItemCateParameter extends ItemCat {

    public  static final String SAME_LEVEL="sameLevel";
    public  static final String SON_LEVEL="sonLevel";
    private String addway;


}
