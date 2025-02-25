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


import com.dao.ZhuangxiugonglveDao;
import com.entity.ZhuangxiugonglveEntity;
import com.service.ZhuangxiugonglveService;
import com.entity.vo.ZhuangxiugonglveVO;
import com.entity.view.ZhuangxiugonglveView;

@Service("zhuangxiugonglveService")
public class ZhuangxiugonglveServiceImpl extends ServiceImpl<ZhuangxiugonglveDao, ZhuangxiugonglveEntity> implements ZhuangxiugonglveService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuangxiugonglveEntity> page = this.selectPage(
                new Query<ZhuangxiugonglveEntity>(params).getPage(),
                new EntityWrapper<ZhuangxiugonglveEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuangxiugonglveEntity> wrapper) {
		  Page<ZhuangxiugonglveView> page =new Query<ZhuangxiugonglveView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhuangxiugonglveVO> selectListVO(Wrapper<ZhuangxiugonglveEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuangxiugonglveVO selectVO(Wrapper<ZhuangxiugonglveEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuangxiugonglveView> selectListView(Wrapper<ZhuangxiugonglveEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuangxiugonglveView selectView(Wrapper<ZhuangxiugonglveEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
