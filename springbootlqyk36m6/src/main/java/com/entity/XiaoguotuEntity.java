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
 * 效果图
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-02-03 16:53:29
 */
@TableName("xiaoguotu")
public class XiaoguotuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiaoguotuEntity() {
		
	}
	
	public XiaoguotuEntity(T t) {
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
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 空间
	 */
					
	private String kongjian;
	
	/**
	 * 风格
	 */
					
	private String fengge;
	
	/**
	 * 颜色
	 */
					
	private String yanse;
	
	/**
	 * 效果图
	 */
					
	private String xiaoguotu;
	
	/**
	 * 家具布置
	 */
					
	private String jiajubuzhi;
	
	/**
	 * 材料说明
	 */
					
	private String cailiaoshuoming;
	
	/**
	 * 装饰细节
	 */
					
	private String zhuangshixijie;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 装修公司名称
	 */
					
	private String gongsimingcheng;
	
	/**
	 * 负责人
	 */
					
	private String fuzeren;
	
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
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
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
	 * 设置：风格
	 */
	public void setFengge(String fengge) {
		this.fengge = fengge;
	}
	/**
	 * 获取：风格
	 */
	public String getFengge() {
		return fengge;
	}
	/**
	 * 设置：颜色
	 */
	public void setYanse(String yanse) {
		this.yanse = yanse;
	}
	/**
	 * 获取：颜色
	 */
	public String getYanse() {
		return yanse;
	}
	/**
	 * 设置：效果图
	 */
	public void setXiaoguotu(String xiaoguotu) {
		this.xiaoguotu = xiaoguotu;
	}
	/**
	 * 获取：效果图
	 */
	public String getXiaoguotu() {
		return xiaoguotu;
	}
	/**
	 * 设置：家具布置
	 */
	public void setJiajubuzhi(String jiajubuzhi) {
		this.jiajubuzhi = jiajubuzhi;
	}
	/**
	 * 获取：家具布置
	 */
	public String getJiajubuzhi() {
		return jiajubuzhi;
	}
	/**
	 * 设置：材料说明
	 */
	public void setCailiaoshuoming(String cailiaoshuoming) {
		this.cailiaoshuoming = cailiaoshuoming;
	}
	/**
	 * 获取：材料说明
	 */
	public String getCailiaoshuoming() {
		return cailiaoshuoming;
	}
	/**
	 * 设置：装饰细节
	 */
	public void setZhuangshixijie(String zhuangshixijie) {
		this.zhuangshixijie = zhuangshixijie;
	}
	/**
	 * 获取：装饰细节
	 */
	public String getZhuangshixijie() {
		return zhuangshixijie;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
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
