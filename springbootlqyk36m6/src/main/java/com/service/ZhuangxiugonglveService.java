package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuangxiugonglveEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuangxiugonglveVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuangxiugonglveView;


/**
 * 装修攻略
 *
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface ZhuangxiugonglveService extends IService<ZhuangxiugonglveEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuangxiugonglveVO> selectListVO(Wrapper<ZhuangxiugonglveEntity> wrapper);
   	
   	ZhuangxiugonglveVO selectVO(@Param("ew") Wrapper<ZhuangxiugonglveEntity> wrapper);
   	
   	List<ZhuangxiugonglveView> selectListView(Wrapper<ZhuangxiugonglveEntity> wrapper);
   	
   	ZhuangxiugonglveView selectView(@Param("ew") Wrapper<ZhuangxiugonglveEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuangxiugonglveEntity> wrapper);

   	

}

