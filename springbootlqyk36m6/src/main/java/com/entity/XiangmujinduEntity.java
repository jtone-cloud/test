package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 项目进度
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@TableName("xiangmujindu")
public class XiangmujinduEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiangmujinduEntity() {
		
	}
	
	public XiangmujinduEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 装修公司名称
	 */
					
	private String gongsimingcheng;
	
	/**
	 * 负责人
	 */
					
	private String fuzeren;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 空间
	 */
					
	private String kongjian;
	
	/**
	 * 软装
	 */
					
	private String ruanzhuang;
	
	/**
	 * 硬装
	 */
					
	private String yingzhuang;
	
	/**
	 * 装修风格
	 */
					
	private String zhuangxiufengge;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 开始时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date kaishishijian;
	
	/**
	 * 结束时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jieshushijian;
	
	/**
	 * 项目进度
	 */
					
	private String xiangmujindu;
	
	/**
	 * 完成情况
	 */
					
	private String wanchengqingkuang;
	
	/**
	 * 业主账号
	 */
					
	private String yezhuzhanghao;
	
	/**
	 * 业主姓名
	 */
					
	private String yezhuxingming;
	
	/**
	 * 房屋名称
	 */
					
	private String fangwumingcheng;
	
	/**
	 * 楼层
	 */
					
	private String louceng;
	
	/**
	 * 房间号
	 */
					
	private String fangjianhao;
	
	/**
	 * 面积
	 */
					
	private String mianji;
	
	/**
	 * 房型
	 */
					
	private String fangxing;
	
	/**
	 * 位置
	 */
					
	private String weizhi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：装修公司名称
	 */
	public void setGongsimingcheng(String gongsimingcheng) {
		this.gongsimingcheng = gongsimingcheng;
	}
	/**
	 * 获取：装修公司名称
	 */
	public String getGongsimingcheng() {
		return gongsimingcheng;
	}
	/**
	 * 设置：负责人
	 */
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：空间
	 */
	public void setKongjian(String kongjian) {
		this.kongjian = kongjian;
	}
	/**
	 * 获取：空间
	 */
	public String getKongjian() {
		return kongjian;
	}
	/**
	 * 设置：软装
	 */
	public void setRuanzhuang(String ruanzhuang) {
		this.ruanzhuang = ruanzhuang;
	}
	/**
	 * 获取：软装
	 */
	public String getRuanzhuang() {
		return ruanzhuang;
	}
	/**
	 * 设置：硬装
	 */
	public void setYingzhuang(String yingzhuang) {
		this.yingzhuang = yingzhuang;
	}
	/**
	 * 获取：硬装
	 */
	public String getYingzhuang() {
		return yingzhuang;
	}
	/**
	 * 设置：装修风格
	 */
	public void setZhuangxiufengge(String zhuangxiufengge) {
		this.zhuangxiufengge = zhuangxiufengge;
	}
	/**
	 * 获取：装修风格
	 */
	public String getZhuangxiufengge() {
		return zhuangxiufengge;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：开始时间
	 */
	public void setKaishishijian(Date kaishishijian) {
		this.kaishishijian = kaishishijian;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getKaishishijian() {
		return kaishishijian;
	}
	/**
	 * 设置：结束时间
	 */
	public void setJieshushijian(Date jieshushijian) {
		this.jieshushijian = jieshushijian;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getJieshushijian() {
		return jieshushijian;
	}
	/**
	 * 设置：项目进度
	 */
	public void setXiangmujindu(String xiangmujindu) {
		this.xiangmujindu = xiangmujindu;
	}
	/**
	 * 获取：项目进度
	 */
	public String getXiangmujindu() {
		return xiangmujindu;
	}
	/**
	 * 设置：完成情况
	 */
	public void setWanchengqingkuang(String wanchengqingkuang) {
		this.wanchengqingkuang = wanchengqingkuang;
	}
	/**
	 * 获取：完成情况
	 */
	public String getWanchengqingkuang() {
		return wanchengqingkuang;
	}
	/**
	 * 设置：业主账号
	 */
	public void setYezhuzhanghao(String yezhuzhanghao) {
		this.yezhuzhanghao = yezhuzhanghao;
	}
	/**
	 * 获取：业主账号
	 */
	public String getYezhuzhanghao() {
		return yezhuzhanghao;
	}
	/**
	 * 设置：业主姓名
	 */
	public void setYezhuxingming(String yezhuxingming) {
		this.yezhuxingming = yezhuxingming;
	}
	/**
	 * 获取：业主姓名
	 */
	public String getYezhuxingming() {
		return yezhuxingming;
	}
	/**
	 * 设置：房屋名称
	 */
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
	/**
	 * 设置：楼层
	 */
	public void setLouceng(String louceng) {
		this.louceng = louceng;
	}
	/**
	 * 获取：楼层
	 */
	public String getLouceng() {
		return louceng;
	}
	/**
	 * 设置：房间号
	 */
	public void setFangjianhao(String fangjianhao) {
		this.fangjianhao = fangjianhao;
	}
	/**
	 * 获取：房间号
	 */
	public String getFangjianhao() {
		return fangjianhao;
	}
	/**
	 * 设置：面积
	 */
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	/**
	 * 获取：面积
	 */
	public String getMianji() {
		return mianji;
	}
	/**
	 * 设置：房型
	 */
	public void setFangxing(String fangxing) {
		this.fangxing = fangxing;
	}
	/**
	 * 获取：房型
	 */
	public String getFangxing() {
		return fangxing;
	}
	/**
	 * 设置：位置
	 */
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	/**
	 * 获取：位置
	 */
	public String getWeizhi() {
		return weizhi;
	}

	@Override
	public String toString() {
		return "XiangmujinduEntity{" +
				"id=" + id +
				", gongsimingcheng='" + gongsimingcheng + '\'' +
				", fuzeren='" + fuzeren + '\'' +
				", lianxifangshi='" + lianxifangshi + '\'' +
				", kongjian='" + kongjian + '\'' +
				", ruanzhuang='" + ruanzhuang + '\'' +
				", yingzhuang='" + yingzhuang + '\'' +
				", zhuangxiufengge='" + zhuangxiufengge + '\'' +
				", tupian='" + tupian + '\'' +
				", kaishishijian=" + kaishishijian +
				", jieshushijian=" + jieshushijian +
				", xiangmujindu='" + xiangmujindu + '\'' +
				", wanchengqingkuang='" + wanchengqingkuang + '\'' +
				", yezhuzhanghao='" + yezhuzhanghao + '\'' +
				", yezhuxingming='" + yezhuxingming + '\'' +
				", fangwumingcheng='" + fangwumingcheng + '\'' +
				", louceng='" + louceng + '\'' +
				", fangjianhao='" + fangjianhao + '\'' +
				", mianji='" + mianji + '\'' +
				", fangxing='" + fangxing + '\'' +
				", weizhi='" + weizhi + '\'' +
				", addtime=" + addtime +
				'}';
	}
}
