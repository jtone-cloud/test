package com.dao;

import com.entity.FangwushejiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwushejiVO;
import com.entity.view.FangwushejiView;


/**
 * 房屋设计
 * 
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface FangwushejiDao extends BaseMapper<FangwushejiEntity> {
	
	List<FangwushejiVO> selectListVO(@Param("ew") Wrapper<FangwushejiEntity> wrapper);
	
	FangwushejiVO selectVO(@Param("ew") Wrapper<FangwushejiEntity> wrapper);
	
	List<FangwushejiView> selectListView(@Param("ew") Wrapper<FangwushejiEntity> wrapper);

	List<FangwushejiView> selectListView(Pagination page,@Param("ew") Wrapper<FangwushejiEntity> wrapper);

	
	FangwushejiView selectView(@Param("ew") Wrapper<FangwushejiEntity> wrapper);
	

}
