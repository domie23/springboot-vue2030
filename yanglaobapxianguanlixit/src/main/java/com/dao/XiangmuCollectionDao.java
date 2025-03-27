package com.dao;

import com.entity.XiangmuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuCollectionView;

/**
 * 项目收藏 Dao 接口
 *
 * @author 
 */
public interface XiangmuCollectionDao extends BaseMapper<XiangmuCollectionEntity> {

   List<XiangmuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
