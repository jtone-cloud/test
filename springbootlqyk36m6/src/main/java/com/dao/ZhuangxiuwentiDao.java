package com.dao;

import com.entity.ZhuangxiuwentiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuangxiuwentiVO;
import com.entity.view.ZhuangxiuwentiView;


/**
 * 装修问题
 * 
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface ZhuangxiuwentiDao extends BaseMapper<ZhuangxiuwentiEntity> {
	
	List<ZhuangxiuwentiVO> selectListVO(@Param("ew") Wrapper<ZhuangxiuwentiEntity> wrapper);
	
	ZhuangxiuwentiVO selectVO(@Param("ew") Wrapper<ZhuangxiuwentiEntity> wrapper);
	
	List<ZhuangxiuwentiView> selectListView(@Param("ew") Wrapper<ZhuangxiuwentiEntity> wrapper);

	List<ZhuangxiuwentiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuangxiuwentiEntity> wrapper);

	
	ZhuangxiuwentiView selectView(@Param("ew") Wrapper<ZhuangxiuwentiEntity> wrapper);
	

}
