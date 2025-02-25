package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuangxiuwentiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuangxiuwentiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuangxiuwentiView;


/**
 * 装修问题
 *
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public interface ZhuangxiuwentiService extends IService<ZhuangxiuwentiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuangxiuwentiVO> selectListVO(Wrapper<ZhuangxiuwentiEntity> wrapper);
   	
   	ZhuangxiuwentiVO selectVO(@Param("ew") Wrapper<ZhuangxiuwentiEntity> wrapper);
   	
   	List<ZhuangxiuwentiView> selectListView(Wrapper<ZhuangxiuwentiEntity> wrapper);
   	
   	ZhuangxiuwentiView selectView(@Param("ew") Wrapper<ZhuangxiuwentiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuangxiuwentiEntity> wrapper);

   	

}

