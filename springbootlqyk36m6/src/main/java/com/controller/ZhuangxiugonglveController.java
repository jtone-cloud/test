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

import com.entity.ZhuangxiugonglveEntity;
import com.entity.view.ZhuangxiugonglveView;

import com.service.ZhuangxiugonglveService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 装修攻略
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@RestController
@RequestMapping("/zhuangxiugonglve")
public class ZhuangxiugonglveController {
    @Autowired
    private ZhuangxiugonglveService zhuangxiugonglveService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuangxiugonglveEntity zhuangxiugonglve,
		HttpServletRequest request){
        EntityWrapper<ZhuangxiugonglveEntity> ew = new EntityWrapper<ZhuangxiugonglveEntity>();

		PageUtils page = zhuangxiugonglveService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangxiugonglve), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuangxiugonglveEntity zhuangxiugonglve, 
		HttpServletRequest request){
        EntityWrapper<ZhuangxiugonglveEntity> ew = new EntityWrapper<ZhuangxiugonglveEntity>();

		PageUtils page = zhuangxiugonglveService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangxiugonglve), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuangxiugonglveEntity zhuangxiugonglve){
       	EntityWrapper<ZhuangxiugonglveEntity> ew = new EntityWrapper<ZhuangxiugonglveEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuangxiugonglve, "zhuangxiugonglve")); 
        return R.ok().put("data", zhuangxiugonglveService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuangxiugonglveEntity zhuangxiugonglve){
        EntityWrapper< ZhuangxiugonglveEntity> ew = new EntityWrapper< ZhuangxiugonglveEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuangxiugonglve, "zhuangxiugonglve")); 
		ZhuangxiugonglveView zhuangxiugonglveView =  zhuangxiugonglveService.selectView(ew);
		return R.ok("查询装修攻略成功").put("data", zhuangxiugonglveView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuangxiugonglveEntity zhuangxiugonglve = zhuangxiugonglveService.selectById(id);
		zhuangxiugonglve.setClicknum(zhuangxiugonglve.getClicknum()+1);
		zhuangxiugonglve.setClicktime(new Date());
		zhuangxiugonglveService.updateById(zhuangxiugonglve);
        zhuangxiugonglve = zhuangxiugonglveService.selectView(new EntityWrapper<ZhuangxiugonglveEntity>().eq("id", id));
        return R.ok().put("data", zhuangxiugonglve);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuangxiugonglveEntity zhuangxiugonglve = zhuangxiugonglveService.selectById(id);
		zhuangxiugonglve.setClicknum(zhuangxiugonglve.getClicknum()+1);
		zhuangxiugonglve.setClicktime(new Date());
		zhuangxiugonglveService.updateById(zhuangxiugonglve);
        zhuangxiugonglve = zhuangxiugonglveService.selectView(new EntityWrapper<ZhuangxiugonglveEntity>().eq("id", id));
        return R.ok().put("data", zhuangxiugonglve);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuangxiugonglveEntity zhuangxiugonglve, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhuangxiugonglve);
        zhuangxiugonglveService.insert(zhuangxiugonglve);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuangxiugonglveEntity zhuangxiugonglve, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhuangxiugonglve);
        zhuangxiugonglveService.insert(zhuangxiugonglve);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuangxiugonglveEntity zhuangxiugonglve, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuangxiugonglve);
        zhuangxiugonglveService.updateById(zhuangxiugonglve);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuangxiugonglveService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhuangxiugonglveEntity zhuangxiugonglve, HttpServletRequest request,String pre){
        EntityWrapper<ZhuangxiugonglveEntity> ew = new EntityWrapper<ZhuangxiugonglveEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = zhuangxiugonglveService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangxiugonglve), params), params));
        return R.ok().put("data", page);
    }










}
