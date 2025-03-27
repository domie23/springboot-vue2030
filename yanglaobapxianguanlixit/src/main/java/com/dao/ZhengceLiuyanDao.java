package com.dao;

import com.entity.ZhengceLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengceLiuyanView;

/**
 * 养老政策留言 Dao 接口
 *
 * @author 
 */
public interface ZhengceLiuyanDao extends BaseMapper<ZhengceLiuyanEntity> {

   List<ZhengceLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
