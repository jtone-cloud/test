package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangwushejiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangwushejiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwushejiView;


/**
 * 房屋设计
 *
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface FangwushejiService extends IService<FangwushejiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwushejiVO> selectListVO(Wrapper<FangwushejiEntity> wrapper);
   	
   	FangwushejiVO selectVO(@Param("ew") Wrapper<FangwushejiEntity> wrapper);
   	
   	List<FangwushejiView> selectListView(Wrapper<FangwushejiEntity> wrapper);
   	
   	FangwushejiView selectView(@Param("ew") Wrapper<FangwushejiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwushejiEntity> wrapper);

   	

}

