package com.service.impl;

import com.entity.XiangmujinduEntity;
import com.service.XiangmujinduService;
import com.utils.R;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import java.util.Objects;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuyuexinxiDao;
import com.entity.YuyuexinxiEntity;
import com.service.YuyuexinxiService;
import com.entity.vo.YuyuexinxiVO;
import com.entity.view.YuyuexinxiView;

import javax.annotation.Resource;

@Service("yuyuexinxiService")
public class YuyuexinxiServiceImpl extends ServiceImpl<YuyuexinxiDao, YuyuexinxiEntity> implements YuyuexinxiService {
	
	@Resource
	private XiangmujinduService xiangmujinduService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuexinxiEntity> page = this.selectPage(
                new Query<YuyuexinxiEntity>(params).getPage(),
                new EntityWrapper<YuyuexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuexinxiEntity> wrapper) {
		  Page<YuyuexinxiView> page =new Query<YuyuexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
    public String verifyYuyuexinxi(YuyuexinxiEntity yuyuexinxi) {
		Wrapper<XiangmujinduEntity> wrapper = new EntityWrapper();
		wrapper.eq("yezhuzhanghao", yuyuexinxi.getYezhuzhanghao())
				.eq("gongsimingcheng", yuyuexinxi.getGongsimingcheng());
		List<XiangmujinduEntity> list = xiangmujinduService.selectList(wrapper);
		if(list.size() == 0) {
			return "您前面预约的项目还未审核，请等待审核";
		}
		for(XiangmujinduEntity xiangmujindu : list) {
			if(!Objects.equals(xiangmujindu.getWanchengqingkuang(), "已完成")) {
				return "您有正在进行中的项目，请等项目完成后再预约";
			}
		}
		return "预约通过";
    }


    @Override
	public List<YuyuexinxiVO> selectListVO(Wrapper<YuyuexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyuexinxiVO selectVO(Wrapper<YuyuexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyuexinxiView> selectListView(Wrapper<YuyuexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuexinxiView selectView(Wrapper<YuyuexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
