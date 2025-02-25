package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.dao.XiangmujinduDao;
import com.entity.XiangmujinduEntity;
import com.service.XiangmujinduService;
import com.service.impl.YuyuexinxiServiceImpl;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.entity.YuyuexinxiEntity;
import com.entity.view.YuyuexinxiView;

import com.service.YuyuexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;


/**
 * 预约信息
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@RestController
@RequestMapping("/yuyuexinxi")
public class YuyuexinxiController {
    private static final Logger log = LoggerFactory.getLogger(YuyuexinxiController.class);
    @Autowired
    private YuyuexinxiService yuyuexinxiService;

    @Resource
    private XiangmujinduService xiangmujinduService;



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuexinxiEntity yuyuexinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongsi")) {
			yuyuexinxi.setGongsimingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yezhu")) {
			yuyuexinxi.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuexinxiEntity> ew = new EntityWrapper<YuyuexinxiEntity>();

		PageUtils page = yuyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuexinxiEntity yuyuexinxi, 
		HttpServletRequest request){
        EntityWrapper<YuyuexinxiEntity> ew = new EntityWrapper<YuyuexinxiEntity>();

		PageUtils page = yuyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuexinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuexinxiEntity yuyuexinxi){
       	EntityWrapper<YuyuexinxiEntity> ew = new EntityWrapper<YuyuexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuexinxi, "yuyuexinxi")); 
        return R.ok().put("data", yuyuexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuexinxiEntity yuyuexinxi){
        EntityWrapper< YuyuexinxiEntity> ew = new EntityWrapper< YuyuexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuexinxi, "yuyuexinxi")); 
		YuyuexinxiView yuyuexinxiView =  yuyuexinxiService.selectView(ew);
		return R.ok("查询预约信息成功").put("data", yuyuexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuexinxiEntity yuyuexinxi = yuyuexinxiService.selectById(id);
        return R.ok().put("data", yuyuexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuexinxiEntity yuyuexinxi = yuyuexinxiService.selectById(id);
        return R.ok().put("data", yuyuexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuexinxiEntity yuyuexinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuyuexinxi);
        yuyuexinxiService.insert(yuyuexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuexinxiEntity yuyuexinxi, HttpServletRequest request){
        String verifyResult = yuyuexinxiService.verifyYuyuexinxi(yuyuexinxi);
        if(!Objects.equals(verifyResult, "预约通过")){
            return R.error(verifyResult);
        }
        //ValidatorUtils.validateEntity(yuyuexinxi);
        yuyuexinxiService.insert(yuyuexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuexinxiEntity yuyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuexinxi);
        yuyuexinxiService.updateById(yuyuexinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuyuexinxiEntity> list = new ArrayList<YuyuexinxiEntity>();
        for(Long id : ids) {
            YuyuexinxiEntity yuyuexinxi = yuyuexinxiService.selectById(id);
            yuyuexinxi.setSfsh(sfsh);
            yuyuexinxi.setShhf(shhf);
            list.add(yuyuexinxi);
        }
        yuyuexinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
