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
 * 装修公司
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@TableName("gongsi")
public class GongsiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongsiEntity() {
		
	}
	
	public GongsiEntity(T t) {
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
    @TableId
    private Long id;
	/**
	 * 装修公司名称
	 */
					
	private String gongsimingcheng;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
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
	 * 装修公司邮箱
	 */
					
	private String gongsiyouxiang;
	
	/**
	 * 装修公司地址
	 */
					
	private String gongsidizhi;
	
	/**
	 * 创立时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chuanglishijian;
	
	/**
	 * 设计团队
	 */
					
	private String shejituandui;
	
	/**
	 * 装修公司简介
	 */
					
	private String gongsijianjie;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
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
	 * 设置：装修公司邮箱
	 */
	public void setGongsiyouxiang(String gongsiyouxiang) {
		this.gongsiyouxiang = gongsiyouxiang;
	}
	/**
	 * 获取：装修公司邮箱
	 */
	public String getGongsiyouxiang() {
		return gongsiyouxiang;
	}
	/**
	 * 设置：装修公司地址
	 */
	public void setGongsidizhi(String gongsidizhi) {
		this.gongsidizhi = gongsidizhi;
	}
	/**
	 * 获取：装修公司地址
	 */
	public String getGongsidizhi() {
		return gongsidizhi;
	}
	/**
	 * 设置：创立时间
	 */
	public void setChuanglishijian(Date chuanglishijian) {
		this.chuanglishijian = chuanglishijian;
	}
	/**
	 * 获取：创立时间
	 */
	public Date getChuanglishijian() {
		return chuanglishijian;
	}
	/**
	 * 设置：设计团队
	 */
	public void setShejituandui(String shejituandui) {
		this.shejituandui = shejituandui;
	}
	/**
	 * 获取：设计团队
	 */
	public String getShejituandui() {
		return shejituandui;
	}
	/**
	 * 设置：装修公司简介
	 */
	public void setGongsijianjie(String gongsijianjie) {
		this.gongsijianjie = gongsijianjie;
	}
	/**
	 * 获取：装修公司简介
	 */
	public String getGongsijianjie() {
		return gongsijianjie;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
