package com.entity.vo;

import com.entity.FangwushejiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房屋设计
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
public class FangwushejiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 装修公司封面
	 */
	
	private String gongsifengmian;
		
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
	 * 报价
	 */
	
	private Double baojia;
		
	/**
	 * 装修风格
	 */
	
	private String zhuangxiufengge;
		
	/**
	 * 设计时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shejishijian;
		
	/**
	 * 设计方案
	 */
	
	private String shejifangan;
		
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
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：装修公司封面
	 */
	 
	public void setGongsifengmian(String gongsifengmian) {
		this.gongsifengmian = gongsifengmian;
	}
	
	/**
	 * 获取：装修公司封面
	 */
	public String getGongsifengmian() {
		return gongsifengmian;
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
	 * 设置：报价
	 */
	 
	public void setBaojia(Double baojia) {
		this.baojia = baojia;
	}
	
	/**
	 * 获取：报价
	 */
	public Double getBaojia() {
		return baojia;
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
	 * 设置：设计时间
	 */
	 
	public void setShejishijian(Date shejishijian) {
		this.shejishijian = shejishijian;
	}
	
	/**
	 * 获取：设计时间
	 */
	public Date getShejishijian() {
		return shejishijian;
	}
				
	
	/**
	 * 设置：设计方案
	 */
	 
	public void setShejifangan(String shejifangan) {
		this.shejifangan = shejifangan;
	}
	
	/**
	 * 获取：设计方案
	 */
	public String getShejifangan() {
		return shejifangan;
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
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
