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

import com.entity.LiuyanxinxiEntity;
import com.entity.view.LiuyanxinxiView;

import com.service.LiuyanxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 留言信息
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@RestController
@RequestMapping("/liuyanxinxi")
public class LiuyanxinxiController {
    @Autowired
    private LiuyanxinxiService liuyanxinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LiuyanxinxiEntity liuyanxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			liuyanxinxi.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LiuyanxinxiEntity> ew = new EntityWrapper<LiuyanxinxiEntity>();

		PageUtils page = liuyanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LiuyanxinxiEntity liuyanxinxi, 
		HttpServletRequest request){
        EntityWrapper<LiuyanxinxiEntity> ew = new EntityWrapper<LiuyanxinxiEntity>();

		PageUtils page = liuyanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LiuyanxinxiEntity liuyanxinxi){
       	EntityWrapper<LiuyanxinxiEntity> ew = new EntityWrapper<LiuyanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( liuyanxinxi, "liuyanxinxi")); 
        return R.ok().put("data", liuyanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LiuyanxinxiEntity liuyanxinxi){
        EntityWrapper< LiuyanxinxiEntity> ew = new EntityWrapper< LiuyanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( liuyanxinxi, "liuyanxinxi")); 
		LiuyanxinxiView liuyanxinxiView =  liuyanxinxiService.selectView(ew);
		return R.ok("查询留言信息成功").put("data", liuyanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LiuyanxinxiEntity liuyanxinxi = liuyanxinxiService.selectById(id);
        return R.ok().put("data", liuyanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LiuyanxinxiEntity liuyanxinxi = liuyanxinxiService.selectById(id);
        return R.ok().put("data", liuyanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LiuyanxinxiEntity liuyanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(liuyanxinxi);
        liuyanxinxiService.insert(liuyanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LiuyanxinxiEntity liuyanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(liuyanxinxi);
        liuyanxinxiService.insert(liuyanxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LiuyanxinxiEntity liuyanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(liuyanxinxi);
        liuyanxinxiService.updateById(liuyanxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LiuyanxinxiEntity> list = new ArrayList<LiuyanxinxiEntity>();
        for(Long id : ids) {
            LiuyanxinxiEntity liuyanxinxi = liuyanxinxiService.selectById(id);
            liuyanxinxi.setSfsh(sfsh);
            liuyanxinxi.setShhf(shhf);
            list.add(liuyanxinxi);
        }
        liuyanxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        liuyanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
