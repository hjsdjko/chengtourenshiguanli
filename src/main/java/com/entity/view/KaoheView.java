package com.entity.view;

import com.entity.KaoheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 考核信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kaohe")
public class KaoheView extends KaoheEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 考核类型的值
		*/
		private String kaoheValue;
		/**
		* 考核结果的值
		*/
		private String kaoheJieguoValue;



		//级联表 yuangong
			/**
			* 员工编号
			*/
			private String yuangongUuidNumber;
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工头像
			*/
			private String yuangongPhoto;
			/**
			* 电子邮箱
			*/
			private String yuangongEmail;
			/**
			* 部门
			*/
			private Integer bumenTypes;
				/**
				* 部门的值
				*/
				private String bumenValue;
			/**
			* 学历
			*/
			private Integer xueliTypes;
				/**
				* 学历的值
				*/
				private String xueliValue;
			/**
			* 专业职务
			*/
			private Integer zhuanyezhiwuTypes;
				/**
				* 专业职务的值
				*/
				private String zhuanyezhiwuValue;
			/**
			* 合同类型
			*/
			private Integer hetongTypes;
				/**
				* 合同类型的值
				*/
				private String hetongValue;
			/**
			* 合同文件
			*/
			private String hetongFile;
			/**
			* 合同签订时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date hetongQiandingTime;
			/**
			* 合同到期时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date hetongJieshuTime;
			/**
			* 政治面貌
			*/
			private Integer zhengzhiTypes;
				/**
				* 政治面貌的值
				*/
				private String zhengzhiValue;
			/**
			* 毕业院校
			*/
			private String yuangongXuexiao;
			/**
			* 岗位
			*/
			private Integer gangweiTypes;
				/**
				* 岗位的值
				*/
				private String gangweiValue;
			/**
			* 户口所在地
			*/
			private String hukou;
			/**
			* 婚姻
			*/
			private Integer hunyinTypes;
				/**
				* 婚姻的值
				*/
				private String hunyinValue;
			/**
			* 家庭住址
			*/
			private String zhuzhi;
			/**
			* 参加工作时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date gongzuoTime;
			/**
			* 民族
			*/
			private String minzu;
			/**
			* 入职时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date ruzhiTime;
			/**
			* 入党时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date rudangTime;
			/**
			* 专业
			*/
			private Integer zhuanyeTypes;
				/**
				* 专业的值
				*/
				private String zhuanyeValue;

	public KaoheView() {

	}

	public KaoheView(KaoheEntity kaoheEntity) {
		try {
			BeanUtils.copyProperties(this, kaoheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 考核类型的值
			*/
			public String getKaoheValue() {
				return kaoheValue;
			}
			/**
			* 设置： 考核类型的值
			*/
			public void setKaoheValue(String kaoheValue) {
				this.kaoheValue = kaoheValue;
			}
			/**
			* 获取： 考核结果的值
			*/
			public String getKaoheJieguoValue() {
				return kaoheJieguoValue;
			}
			/**
			* 设置： 考核结果的值
			*/
			public void setKaoheJieguoValue(String kaoheJieguoValue) {
				this.kaoheJieguoValue = kaoheJieguoValue;
			}




















				//级联表的get和set yuangong
					/**
					* 获取： 员工编号
					*/
					public String getYuangongUuidNumber() {
						return yuangongUuidNumber;
					}
					/**
					* 设置： 员工编号
					*/
					public void setYuangongUuidNumber(String yuangongUuidNumber) {
						this.yuangongUuidNumber = yuangongUuidNumber;
					}
					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}
					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}
					/**
					* 获取： 员工头像
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工头像
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYuangongEmail() {
						return yuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYuangongEmail(String yuangongEmail) {
						this.yuangongEmail = yuangongEmail;
					}
					/**
					* 获取： 部门
					*/
					public Integer getBumenTypes() {
						return bumenTypes;
					}
					/**
					* 设置： 部门
					*/
					public void setBumenTypes(Integer bumenTypes) {
						this.bumenTypes = bumenTypes;
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
					* 获取： 学历
					*/
					public Integer getXueliTypes() {
						return xueliTypes;
					}
					/**
					* 设置： 学历
					*/
					public void setXueliTypes(Integer xueliTypes) {
						this.xueliTypes = xueliTypes;
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
					* 获取： 专业职务
					*/
					public Integer getZhuanyezhiwuTypes() {
						return zhuanyezhiwuTypes;
					}
					/**
					* 设置： 专业职务
					*/
					public void setZhuanyezhiwuTypes(Integer zhuanyezhiwuTypes) {
						this.zhuanyezhiwuTypes = zhuanyezhiwuTypes;
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
					* 获取： 合同类型
					*/
					public Integer getHetongTypes() {
						return hetongTypes;
					}
					/**
					* 设置： 合同类型
					*/
					public void setHetongTypes(Integer hetongTypes) {
						this.hetongTypes = hetongTypes;
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
					* 获取： 合同文件
					*/
					public String getHetongFile() {
						return hetongFile;
					}
					/**
					* 设置： 合同文件
					*/
					public void setHetongFile(String hetongFile) {
						this.hetongFile = hetongFile;
					}
					/**
					* 获取： 合同签订时间
					*/
					public Date getHetongQiandingTime() {
						return hetongQiandingTime;
					}
					/**
					* 设置： 合同签订时间
					*/
					public void setHetongQiandingTime(Date hetongQiandingTime) {
						this.hetongQiandingTime = hetongQiandingTime;
					}
					/**
					* 获取： 合同到期时间
					*/
					public Date getHetongJieshuTime() {
						return hetongJieshuTime;
					}
					/**
					* 设置： 合同到期时间
					*/
					public void setHetongJieshuTime(Date hetongJieshuTime) {
						this.hetongJieshuTime = hetongJieshuTime;
					}
					/**
					* 获取： 政治面貌
					*/
					public Integer getZhengzhiTypes() {
						return zhengzhiTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setZhengzhiTypes(Integer zhengzhiTypes) {
						this.zhengzhiTypes = zhengzhiTypes;
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
					* 获取： 毕业院校
					*/
					public String getYuangongXuexiao() {
						return yuangongXuexiao;
					}
					/**
					* 设置： 毕业院校
					*/
					public void setYuangongXuexiao(String yuangongXuexiao) {
						this.yuangongXuexiao = yuangongXuexiao;
					}
					/**
					* 获取： 岗位
					*/
					public Integer getGangweiTypes() {
						return gangweiTypes;
					}
					/**
					* 设置： 岗位
					*/
					public void setGangweiTypes(Integer gangweiTypes) {
						this.gangweiTypes = gangweiTypes;
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
					* 获取： 户口所在地
					*/
					public String getHukou() {
						return hukou;
					}
					/**
					* 设置： 户口所在地
					*/
					public void setHukou(String hukou) {
						this.hukou = hukou;
					}
					/**
					* 获取： 婚姻
					*/
					public Integer getHunyinTypes() {
						return hunyinTypes;
					}
					/**
					* 设置： 婚姻
					*/
					public void setHunyinTypes(Integer hunyinTypes) {
						this.hunyinTypes = hunyinTypes;
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
					* 获取： 家庭住址
					*/
					public String getZhuzhi() {
						return zhuzhi;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setZhuzhi(String zhuzhi) {
						this.zhuzhi = zhuzhi;
					}
					/**
					* 获取： 参加工作时间
					*/
					public Date getGongzuoTime() {
						return gongzuoTime;
					}
					/**
					* 设置： 参加工作时间
					*/
					public void setGongzuoTime(Date gongzuoTime) {
						this.gongzuoTime = gongzuoTime;
					}
					/**
					* 获取： 民族
					*/
					public String getMinzu() {
						return minzu;
					}
					/**
					* 设置： 民族
					*/
					public void setMinzu(String minzu) {
						this.minzu = minzu;
					}
					/**
					* 获取： 入职时间
					*/
					public Date getRuzhiTime() {
						return ruzhiTime;
					}
					/**
					* 设置： 入职时间
					*/
					public void setRuzhiTime(Date ruzhiTime) {
						this.ruzhiTime = ruzhiTime;
					}
					/**
					* 获取： 入党时间
					*/
					public Date getRudangTime() {
						return rudangTime;
					}
					/**
					* 设置： 入党时间
					*/
					public void setRudangTime(Date rudangTime) {
						this.rudangTime = rudangTime;
					}
					/**
					* 获取： 专业
					*/
					public Integer getZhuanyeTypes() {
						return zhuanyeTypes;
					}
					/**
					* 设置： 专业
					*/
					public void setZhuanyeTypes(Integer zhuanyeTypes) {
						this.zhuanyeTypes = zhuanyeTypes;
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
