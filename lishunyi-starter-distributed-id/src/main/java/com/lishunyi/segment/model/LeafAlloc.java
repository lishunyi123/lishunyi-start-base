package com.lishunyi.segment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class LeafAlloc {

    @TableField("biz_tag")
	private String idKey;
	private Long maxId;
    private Integer step;
    private String description;
    private String updateTime;
}
