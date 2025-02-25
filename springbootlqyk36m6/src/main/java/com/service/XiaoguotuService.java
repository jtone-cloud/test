package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoguotuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoguotuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoguotuView;


/**
 * 效果图
 *
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface XiaoguotuService extends IService<XiaoguotuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoguotuVO> selectListVO(Wrapper<XiaoguotuEntity> wrapper);
   	
   	XiaoguotuVO selectVO(@Param("ew") Wrapper<XiaoguotuEntity> wrapper);
   	
   	List<XiaoguotuView> selectListView(Wrapper<XiaoguotuEntity> wrapper);
   	
   	XiaoguotuView selectView(@Param("ew") Wrapper<XiaoguotuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoguotuEntity> wrapper);

   	

}

