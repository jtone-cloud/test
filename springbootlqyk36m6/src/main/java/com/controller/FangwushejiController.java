package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FangwushejiEntity;
import com.entity.view.FangwushejiView;

import com.service.FangwushejiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 房屋设计
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@RestController
@RequestMapping("/fangwusheji")
public class FangwushejiController {
    @Autowired
    private FangwushejiService fangwushejiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwushejiEntity fangwusheji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongsi")) {
			fangwusheji.setGongsimingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yezhu")) {
			fangwusheji.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangwushejiEntity> ew = new EntityWrapper<FangwushejiEntity>();

		PageUtils page = fangwushejiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwusheji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwushejiEntity fangwusheji, 
		HttpServletRequest request){
        EntityWrapper<FangwushejiEntity> ew = new EntityWrapper<FangwushejiEntity>();

		PageUtils page = fangwushejiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwusheji), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwushejiEntity fangwusheji){
       	EntityWrapper<FangwushejiEntity> ew = new EntityWrapper<FangwushejiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwusheji, "fangwusheji")); 
        return R.ok().put("data", fangwushejiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwushejiEntity fangwusheji){
        EntityWrapper< FangwushejiEntity> ew = new EntityWrapper< FangwushejiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwusheji, "fangwusheji")); 
		FangwushejiView fangwushejiView =  fangwushejiService.selectView(ew);
		return R.ok("查询房屋设计成功").put("data", fangwushejiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwushejiEntity fangwusheji = fangwushejiService.selectById(id);
        return R.ok().put("data", fangwusheji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwushejiEntity fangwusheji = fangwushejiService.selectById(id);
        return R.ok().put("data", fangwusheji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangwushejiEntity fangwusheji, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwusheji);
        fangwushejiService.insert(fangwusheji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwushejiEntity fangwusheji, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwusheji);
        fangwushejiService.insert(fangwusheji);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangwushejiEntity fangwusheji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwusheji);
        fangwushejiService.updateById(fangwusheji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangwushejiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
