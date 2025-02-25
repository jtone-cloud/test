package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FangwushejiDao;
import com.entity.FangwushejiEntity;
import com.service.FangwushejiService;
import com.entity.vo.FangwushejiVO;
import com.entity.view.FangwushejiView;

@Service("fangwushejiService")
public class FangwushejiServiceImpl extends ServiceImpl<FangwushejiDao, FangwushejiEntity> implements FangwushejiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwushejiEntity> page = this.selectPage(
                new Query<FangwushejiEntity>(params).getPage(),
                new EntityWrapper<FangwushejiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwushejiEntity> wrapper) {
		  Page<FangwushejiView> page =new Query<FangwushejiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FangwushejiVO> selectListVO(Wrapper<FangwushejiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangwushejiVO selectVO(Wrapper<FangwushejiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangwushejiView> selectListView(Wrapper<FangwushejiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwushejiView selectView(Wrapper<FangwushejiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
