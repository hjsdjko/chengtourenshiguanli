package com.entity.view;

import com.entity.YuangongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 员工
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yuangong")
public class YuangongView extends YuangongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 部门的值
		*/
		private String bumenValue;
		/**
		* 学历的值
		*/
		private String xueliValue;
		/**
		* 专业职务的值
		*/
		private String zhuanyezhiwuValue;
		/**
		* 合同类型的值
		*/
		private String hetongValue;
		/**
		* 政治面貌的值
		*/
		private String zhengzhiValue;
		/**
		* 岗位的值
		*/
		private String gangweiValue;
		/**
		* 婚姻的值
		*/
		private String hunyinValue;
		/**
		* 专业的值
		*/
		private String zhuanyeValue;



	public YuangongView() {

	}

	public YuangongView(YuangongEntity yuangongEntity) {
		try {
			BeanUtils.copyProperties(this, yuangongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 部门的值
			*/
			public String getBumenValue() {
				return bumenValue;
			}
			/**
			* 设置： 部门的值
			*/
			public void setBumenValue(String bumenValue) {
				this.bumenValue = bumenValue;
			}
			/**
			* 获取： 学历的值
			*/
			public String getXueliValue() {
				return xueliValue;
			}
			/**
			* 设置： 学历的值
			*/
			public void setXueliValue(String xueliValue) {
				this.xueliValue = xueliValue;
			}
			/**
			* 获取： 专业职务的值
			*/
			public String getZhuanyezhiwuValue() {
				return zhuanyezhiwuValue;
			}
			/**
			* 设置： 专业职务的值
			*/
			public void setZhuanyezhiwuValue(String zhuanyezhiwuValue) {
				this.zhuanyezhiwuValue = zhuanyezhiwuValue;
			}
			/**
			* 获取： 合同类型的值
			*/
			public String getHetongValue() {
				return hetongValue;
			}
			/**
			* 设置： 合同类型的值
			*/
			public void setHetongValue(String hetongValue) {
				this.hetongValue = hetongValue;
			}
			/**
			* 获取： 政治面貌的值
			*/
			public String getZhengzhiValue() {
				return zhengzhiValue;
			}
			/**
			* 设置： 政治面貌的值
			*/
			public void setZhengzhiValue(String zhengzhiValue) {
				this.zhengzhiValue = zhengzhiValue;
			}
			/**
			* 获取： 岗位的值
			*/
			public String getGangweiValue() {
				return gangweiValue;
			}
			/**
			* 设置： 岗位的值
			*/
			public void setGangweiValue(String gangweiValue) {
				this.gangweiValue = gangweiValue;
			}
			/**
			* 获取： 婚姻的值
			*/
			public String getHunyinValue() {
				return hunyinValue;
			}
			/**
			* 设置： 婚姻的值
			*/
			public void setHunyinValue(String hunyinValue) {
				this.hunyinValue = hunyinValue;
			}
			/**
			* 获取： 专业的值
			*/
			public String getZhuanyeValue() {
				return zhuanyeValue;
			}
			/**
			* 设置： 专业的值
			*/
			public void setZhuanyeValue(String zhuanyeValue) {
				this.zhuanyeValue = zhuanyeValue;
			}













}
