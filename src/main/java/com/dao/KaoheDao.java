package com.dao;

import com.entity.KaoheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoheView;

/**
 * 考核信息 Dao 接口
 *
 * @author 
 */
public interface KaoheDao extends BaseMapper<KaoheEntity> {

   List<KaoheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
