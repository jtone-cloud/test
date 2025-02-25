package com.dao;

import com.entity.XiaoguotuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoguotuVO;
import com.entity.view.XiaoguotuView;


/**
 * 效果图
 * 
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface XiaoguotuDao extends BaseMapper<XiaoguotuEntity> {
	
	List<XiaoguotuVO> selectListVO(@Param("ew") Wrapper<XiaoguotuEntity> wrapper);
	
	XiaoguotuVO selectVO(@Param("ew") Wrapper<XiaoguotuEntity> wrapper);
	
	List<XiaoguotuView> selectListView(@Param("ew") Wrapper<XiaoguotuEntity> wrapper);

	List<XiaoguotuView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoguotuEntity> wrapper);

	
	XiaoguotuView selectView(@Param("ew") Wrapper<XiaoguotuEntity> wrapper);
	

}
