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


import com.dao.ZhuangxiuwentiDao;
import com.entity.ZhuangxiuwentiEntity;
import com.service.ZhuangxiuwentiService;
import com.entity.vo.ZhuangxiuwentiVO;
import com.entity.view.ZhuangxiuwentiView;

@Service("zhuangxiuwentiService")
public class ZhuangxiuwentiServiceImpl extends ServiceImpl<ZhuangxiuwentiDao, ZhuangxiuwentiEntity> implements ZhuangxiuwentiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuangxiuwentiEntity> page = this.selectPage(
                new Query<ZhuangxiuwentiEntity>(params).getPage(),
                new EntityWrapper<ZhuangxiuwentiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuangxiuwentiEntity> wrapper) {
		  Page<ZhuangxiuwentiView> page =new Query<ZhuangxiuwentiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhuangxiuwentiVO> selectListVO(Wrapper<ZhuangxiuwentiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuangxiuwentiVO selectVO(Wrapper<ZhuangxiuwentiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuangxiuwentiView> selectListView(Wrapper<ZhuangxiuwentiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuangxiuwentiView selectView(Wrapper<ZhuangxiuwentiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
