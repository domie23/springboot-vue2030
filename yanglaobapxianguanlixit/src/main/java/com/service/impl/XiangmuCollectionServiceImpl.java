package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.XiangmuCollectionDao;
import com.entity.XiangmuCollectionEntity;
import com.service.XiangmuCollectionService;
import com.entity.view.XiangmuCollectionView;

/**
 * 项目收藏 服务实现类
 */
@Service("xiangmuCollectionService")
@Transactional
public class XiangmuCollectionServiceImpl extends ServiceImpl<XiangmuCollectionDao, XiangmuCollectionEntity> implements XiangmuCollectionService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<XiangmuCollectionView> page =new Query<XiangmuCollectionView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
