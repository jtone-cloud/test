package com.dao;

import com.entity.GongsiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongsiVO;
import com.entity.view.GongsiView;


/**
 * 装修公司
 * 
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface GongsiDao extends BaseMapper<GongsiEntity> {
	
	List<GongsiVO> selectListVO(@Param("ew") Wrapper<GongsiEntity> wrapper);
	
	GongsiVO selectVO(@Param("ew") Wrapper<GongsiEntity> wrapper);
	
	List<GongsiView> selectListView(@Param("ew") Wrapper<GongsiEntity> wrapper);

	List<GongsiView> selectListView(Pagination page,@Param("ew") Wrapper<GongsiEntity> wrapper);

	
	GongsiView selectView(@Param("ew") Wrapper<GongsiEntity> wrapper);
	

}
