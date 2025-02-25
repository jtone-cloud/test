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

import com.entity.ZhuangxiuwentiEntity;
import com.entity.view.ZhuangxiuwentiView;

import com.service.ZhuangxiuwentiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 装修问题
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@RestController
@RequestMapping("/zhuangxiuwenti")
public class ZhuangxiuwentiController {
    @Autowired
    private ZhuangxiuwentiService zhuangxiuwentiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuangxiuwentiEntity zhuangxiuwenti,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongsi")) {
			zhuangxiuwenti.setGongsimingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yezhu")) {
			zhuangxiuwenti.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhuangxiuwentiEntity> ew = new EntityWrapper<ZhuangxiuwentiEntity>();

		PageUtils page = zhuangxiuwentiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangxiuwenti), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuangxiuwentiEntity zhuangxiuwenti, 
		HttpServletRequest request){
        EntityWrapper<ZhuangxiuwentiEntity> ew = new EntityWrapper<ZhuangxiuwentiEntity>();

		PageUtils page = zhuangxiuwentiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangxiuwenti), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuangxiuwentiEntity zhuangxiuwenti){
       	EntityWrapper<ZhuangxiuwentiEntity> ew = new EntityWrapper<ZhuangxiuwentiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuangxiuwenti, "zhuangxiuwenti")); 
        return R.ok().put("data", zhuangxiuwentiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuangxiuwentiEntity zhuangxiuwenti){
        EntityWrapper< ZhuangxiuwentiEntity> ew = new EntityWrapper< ZhuangxiuwentiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuangxiuwenti, "zhuangxiuwenti")); 
		ZhuangxiuwentiView zhuangxiuwentiView =  zhuangxiuwentiService.selectView(ew);
		return R.ok("查询装修问题成功").put("data", zhuangxiuwentiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuangxiuwentiEntity zhuangxiuwenti = zhuangxiuwentiService.selectById(id);
        return R.ok().put("data", zhuangxiuwenti);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuangxiuwentiEntity zhuangxiuwenti = zhuangxiuwentiService.selectById(id);
        return R.ok().put("data", zhuangxiuwenti);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuangxiuwentiEntity zhuangxiuwenti, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhuangxiuwenti);
        zhuangxiuwentiService.insert(zhuangxiuwenti);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuangxiuwentiEntity zhuangxiuwenti, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhuangxiuwenti);
        zhuangxiuwentiService.insert(zhuangxiuwenti);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuangxiuwentiEntity zhuangxiuwenti, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuangxiuwenti);
        zhuangxiuwentiService.updateById(zhuangxiuwenti);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuangxiuwentiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
