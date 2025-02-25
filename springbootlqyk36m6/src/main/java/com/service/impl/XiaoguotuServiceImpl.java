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


import com.dao.XiaoguotuDao;
import com.entity.XiaoguotuEntity;
import com.service.XiaoguotuService;
import com.entity.vo.XiaoguotuVO;
import com.entity.view.XiaoguotuView;

@Service("xiaoguotuService")
public class XiaoguotuServiceImpl extends ServiceImpl<XiaoguotuDao, XiaoguotuEntity> implements XiaoguotuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoguotuEntity> page = this.selectPage(
                new Query<XiaoguotuEntity>(params).getPage(),
                new EntityWrapper<XiaoguotuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoguotuEntity> wrapper) {
		  Page<XiaoguotuView> page =new Query<XiaoguotuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XiaoguotuVO> selectListVO(Wrapper<XiaoguotuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoguotuVO selectVO(Wrapper<XiaoguotuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoguotuView> selectListView(Wrapper<XiaoguotuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoguotuView selectView(Wrapper<XiaoguotuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
