package com.dao;

import com.entity.ZhuangxiugonglveEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuangxiugonglveVO;
import com.entity.view.ZhuangxiugonglveView;


/**
 * 装修攻略
 * 
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface ZhuangxiugonglveDao extends BaseMapper<ZhuangxiugonglveEntity> {
	
	List<ZhuangxiugonglveVO> selectListVO(@Param("ew") Wrapper<ZhuangxiugonglveEntity> wrapper);
	
	ZhuangxiugonglveVO selectVO(@Param("ew") Wrapper<ZhuangxiugonglveEntity> wrapper);
	
	List<ZhuangxiugonglveView> selectListView(@Param("ew") Wrapper<ZhuangxiugonglveEntity> wrapper);

	List<ZhuangxiugonglveView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuangxiugonglveEntity> wrapper);

	
	ZhuangxiugonglveView selectView(@Param("ew") Wrapper<ZhuangxiugonglveEntity> wrapper);
	

}
