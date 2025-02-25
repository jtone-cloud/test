package com.entity.view;

import com.entity.XiaoguotuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 效果图
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@TableName("xiaoguotu")
public class XiaoguotuView  extends XiaoguotuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoguotuView(){
	}
 
 	public XiaoguotuView(XiaoguotuEntity xiaoguotuEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoguotuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
