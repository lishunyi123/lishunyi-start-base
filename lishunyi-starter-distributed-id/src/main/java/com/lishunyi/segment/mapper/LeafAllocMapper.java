package com.lishunyi.segment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lishunyi.segment.model.LeafAlloc;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @InterfaceName LeafAllocMapper
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/19 10:28
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/19 10:28
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface LeafAllocMapper extends BaseMapper<LeafAlloc> {

    @Update("UPDATE leaf_alloc SET max_id = max_id + #{step} WHERE biz_tag = #{key}")
    void updateMaxIdByCustomStep(@Param("leafAlloc") LeafAlloc leafAlloc);
}
