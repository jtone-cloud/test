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

import com.entity.XiaoguotuEntity;
import com.entity.view.XiaoguotuView;

import com.service.XiaoguotuService;
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
 * 效果图
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@RestController
@RequestMapping("/xiaoguotu")
public class XiaoguotuController {
    @Autowired
    private XiaoguotuService xiaoguotuService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoguotuEntity xiaoguotu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongsi")) {
			xiaoguotu.setGongsimingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaoguotuEntity> ew = new EntityWrapper<XiaoguotuEntity>();

		PageUtils page = xiaoguotuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoguotu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoguotuEntity xiaoguotu, 
		HttpServletRequest request){
        EntityWrapper<XiaoguotuEntity> ew = new EntityWrapper<XiaoguotuEntity>();

		PageUtils page = xiaoguotuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoguotu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoguotuEntity xiaoguotu){
       	EntityWrapper<XiaoguotuEntity> ew = new EntityWrapper<XiaoguotuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoguotu, "xiaoguotu")); 
        return R.ok().put("data", xiaoguotuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoguotuEntity xiaoguotu){
        EntityWrapper< XiaoguotuEntity> ew = new EntityWrapper< XiaoguotuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoguotu, "xiaoguotu")); 
		XiaoguotuView xiaoguotuView =  xiaoguotuService.selectView(ew);
		return R.ok("查询效果图成功").put("data", xiaoguotuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoguotuEntity xiaoguotu = xiaoguotuService.selectById(id);
		xiaoguotu.setClicknum(xiaoguotu.getClicknum()+1);
		xiaoguotu.setClicktime(new Date());
		xiaoguotuService.updateById(xiaoguotu);
        xiaoguotu = xiaoguotuService.selectView(new EntityWrapper<XiaoguotuEntity>().eq("id", id));
        return R.ok().put("data", xiaoguotu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoguotuEntity xiaoguotu = xiaoguotuService.selectById(id);
		xiaoguotu.setClicknum(xiaoguotu.getClicknum()+1);
		xiaoguotu.setClicktime(new Date());
		xiaoguotuService.updateById(xiaoguotu);
        xiaoguotu = xiaoguotuService.selectView(new EntityWrapper<XiaoguotuEntity>().eq("id", id));
        return R.ok().put("data", xiaoguotu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoguotuEntity xiaoguotu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoguotu);
        xiaoguotuService.insert(xiaoguotu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoguotuEntity xiaoguotu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoguotu);
        xiaoguotuService.insert(xiaoguotu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoguotuEntity xiaoguotu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoguotu);
        xiaoguotuService.updateById(xiaoguotu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XiaoguotuEntity> list = new ArrayList<XiaoguotuEntity>();
        for(Long id : ids) {
            XiaoguotuEntity xiaoguotu = xiaoguotuService.selectById(id);
            xiaoguotu.setSfsh(sfsh);
            xiaoguotu.setShhf(shhf);
            list.add(xiaoguotu);
        }
        xiaoguotuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoguotuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XiaoguotuEntity xiaoguotu, HttpServletRequest request,String pre){
        EntityWrapper<XiaoguotuEntity> ew = new EntityWrapper<XiaoguotuEntity>();
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
		PageUtils page = xiaoguotuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoguotu), params), params));
        return R.ok().put("data", page);
    }










}
