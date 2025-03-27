package com.dao;

import com.entity.ZhengceCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengceCollectionView;

/**
 * 养老政策收藏 Dao 接口
 *
 * @author 
 */
public interface ZhengceCollectionDao extends BaseMapper<ZhengceCollectionEntity> {

   List<ZhengceCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
