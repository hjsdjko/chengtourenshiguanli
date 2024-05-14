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
 * 员工
 *
 * @author 
 * @email
 */
@TableName("yuangong")
public class YuangongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuangongEntity() {

	}

	public YuangongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 员工编号
     */
    @TableField(value = "yuangong_uuid_number")

    private String yuangongUuidNumber;


    /**
     * 员工姓名
     */
    @TableField(value = "yuangong_name")

    private String yuangongName;


    /**
     * 员工手机号
     */
    @TableField(value = "yuangong_phone")

    private String yuangongPhone;


    /**
     * 员工身份证号
     */
    @TableField(value = "yuangong_id_number")

    private String yuangongIdNumber;


    /**
     * 员工头像
     */
    @TableField(value = "yuangong_photo")

    private String yuangongPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @TableField(value = "yuangong_email")

    private String yuangongEmail;


    /**
     * 部门
     */
    @TableField(value = "bumen_types")

    private Integer bumenTypes;


    /**
     * 学历
     */
    @TableField(value = "xueli_types")

    private Integer xueliTypes;


    /**
     * 专业职务
     */
    @TableField(value = "zhuanyezhiwu_types")

    private Integer zhuanyezhiwuTypes;


    /**
     * 合同类型
     */
    @TableField(value = "hetong_types")

    private Integer hetongTypes;


    /**
     * 合同文件
     */
    @TableField(value = "hetong_file")

    private String hetongFile;


    /**
     * 合同签订时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "hetong_qianding_time")

    private Date hetongQiandingTime;


    /**
     * 合同到期时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "hetong_jieshu_time")

    private Date hetongJieshuTime;


    /**
     * 政治面貌
     */
    @TableField(value = "zhengzhi_types")

    private Integer zhengzhiTypes;


    /**
     * 毕业院校
     */
    @TableField(value = "yuangong_xuexiao")

    private String yuangongXuexiao;


    /**
     * 岗位
     */
    @TableField(value = "gangwei_types")

    private Integer gangweiTypes;


    /**
     * 户口所在地
     */
    @TableField(value = "hukou")

    private String hukou;


    /**
     * 婚姻
     */
    @TableField(value = "hunyin_types")

    private Integer hunyinTypes;


    /**
     * 家庭住址
     */
    @TableField(value = "zhuzhi")

    private String zhuzhi;


    /**
     * 参加工作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "gongzuo_time")

    private Date gongzuoTime;


    /**
     * 民族
     */
    @TableField(value = "minzu")

    private String minzu;


    /**
     * 入职时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "ruzhi_time")

    private Date ruzhiTime;


    /**
     * 入党时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "rudang_time")

    private Date rudangTime;


    /**
     * 专业
     */
    @TableField(value = "zhuanye_types")

    private Integer zhuanyeTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：员工编号
	 */
    public String getYuangongUuidNumber() {
        return yuangongUuidNumber;
    }


    /**
	 * 获取：员工编号
	 */

    public void setYuangongUuidNumber(String yuangongUuidNumber) {
        this.yuangongUuidNumber = yuangongUuidNumber;
    }
    /**
	 * 设置：员工姓名
	 */
    public String getYuangongName() {
        return yuangongName;
    }


    /**
	 * 获取：员工姓名
	 */

    public void setYuangongName(String yuangongName) {
        this.yuangongName = yuangongName;
    }
    /**
	 * 设置：员工手机号
	 */
    public String getYuangongPhone() {
        return yuangongPhone;
    }


    /**
	 * 获取：员工手机号
	 */

    public void setYuangongPhone(String yuangongPhone) {
        this.yuangongPhone = yuangongPhone;
    }
    /**
	 * 设置：员工身份证号
	 */
    public String getYuangongIdNumber() {
        return yuangongIdNumber;
    }


    /**
	 * 获取：员工身份证号
	 */

    public void setYuangongIdNumber(String yuangongIdNumber) {
        this.yuangongIdNumber = yuangongIdNumber;
    }
    /**
	 * 设置：员工头像
	 */
    public String getYuangongPhoto() {
        return yuangongPhoto;
    }


    /**
	 * 获取：员工头像
	 */

    public void setYuangongPhoto(String yuangongPhoto) {
        this.yuangongPhoto = yuangongPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getYuangongEmail() {
        return yuangongEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setYuangongEmail(String yuangongEmail) {
        this.yuangongEmail = yuangongEmail;
    }
    /**
	 * 设置：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 获取：部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：学历
	 */
    public Integer getXueliTypes() {
        return xueliTypes;
    }


    /**
	 * 获取：学历
	 */

    public void setXueliTypes(Integer xueliTypes) {
        this.xueliTypes = xueliTypes;
    }
    /**
	 * 设置：专业职务
	 */
    public Integer getZhuanyezhiwuTypes() {
        return zhuanyezhiwuTypes;
    }


    /**
	 * 获取：专业职务
	 */

    public void setZhuanyezhiwuTypes(Integer zhuanyezhiwuTypes) {
        this.zhuanyezhiwuTypes = zhuanyezhiwuTypes;
    }
    /**
	 * 设置：合同类型
	 */
    public Integer getHetongTypes() {
        return hetongTypes;
    }


    /**
	 * 获取：合同类型
	 */

    public void setHetongTypes(Integer hetongTypes) {
        this.hetongTypes = hetongTypes;
    }
    /**
	 * 设置：合同文件
	 */
    public String getHetongFile() {
        return hetongFile;
    }


    /**
	 * 获取：合同文件
	 */

    public void setHetongFile(String hetongFile) {
        this.hetongFile = hetongFile;
    }
    /**
	 * 设置：合同签订时间
	 */
    public Date getHetongQiandingTime() {
        return hetongQiandingTime;
    }


    /**
	 * 获取：合同签订时间
	 */

    public void setHetongQiandingTime(Date hetongQiandingTime) {
        this.hetongQiandingTime = hetongQiandingTime;
    }
    /**
	 * 设置：合同到期时间
	 */
    public Date getHetongJieshuTime() {
        return hetongJieshuTime;
    }


    /**
	 * 获取：合同到期时间
	 */

    public void setHetongJieshuTime(Date hetongJieshuTime) {
        this.hetongJieshuTime = hetongJieshuTime;
    }
    /**
	 * 设置：政治面貌
	 */
    public Integer getZhengzhiTypes() {
        return zhengzhiTypes;
    }


    /**
	 * 获取：政治面貌
	 */

    public void setZhengzhiTypes(Integer zhengzhiTypes) {
        this.zhengzhiTypes = zhengzhiTypes;
    }
    /**
	 * 设置：毕业院校
	 */
    public String getYuangongXuexiao() {
        return yuangongXuexiao;
    }


    /**
	 * 获取：毕业院校
	 */

    public void setYuangongXuexiao(String yuangongXuexiao) {
        this.yuangongXuexiao = yuangongXuexiao;
    }
    /**
	 * 设置：岗位
	 */
    public Integer getGangweiTypes() {
        return gangweiTypes;
    }


    /**
	 * 获取：岗位
	 */

    public void setGangweiTypes(Integer gangweiTypes) {
        this.gangweiTypes = gangweiTypes;
    }
    /**
	 * 设置：户口所在地
	 */
    public String getHukou() {
        return hukou;
    }


    /**
	 * 获取：户口所在地
	 */

    public void setHukou(String hukou) {
        this.hukou = hukou;
    }
    /**
	 * 设置：婚姻
	 */
    public Integer getHunyinTypes() {
        return hunyinTypes;
    }


    /**
	 * 获取：婚姻
	 */

    public void setHunyinTypes(Integer hunyinTypes) {
        this.hunyinTypes = hunyinTypes;
    }
    /**
	 * 设置：家庭住址
	 */
    public String getZhuzhi() {
        return zhuzhi;
    }


    /**
	 * 获取：家庭住址
	 */

    public void setZhuzhi(String zhuzhi) {
        this.zhuzhi = zhuzhi;
    }
    /**
	 * 设置：参加工作时间
	 */
    public Date getGongzuoTime() {
        return gongzuoTime;
    }


    /**
	 * 获取：参加工作时间
	 */

    public void setGongzuoTime(Date gongzuoTime) {
        this.gongzuoTime = gongzuoTime;
    }
    /**
	 * 设置：民族
	 */
    public String getMinzu() {
        return minzu;
    }


    /**
	 * 获取：民族
	 */

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }
    /**
	 * 设置：入职时间
	 */
    public Date getRuzhiTime() {
        return ruzhiTime;
    }


    /**
	 * 获取：入职时间
	 */

    public void setRuzhiTime(Date ruzhiTime) {
        this.ruzhiTime = ruzhiTime;
    }
    /**
	 * 设置：入党时间
	 */
    public Date getRudangTime() {
        return rudangTime;
    }


    /**
	 * 获取：入党时间
	 */

    public void setRudangTime(Date rudangTime) {
        this.rudangTime = rudangTime;
    }
    /**
	 * 设置：专业
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }


    /**
	 * 获取：专业
	 */

    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yuangong{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yuangongUuidNumber=" + yuangongUuidNumber +
            ", yuangongName=" + yuangongName +
            ", yuangongPhone=" + yuangongPhone +
            ", yuangongIdNumber=" + yuangongIdNumber +
            ", yuangongPhoto=" + yuangongPhoto +
            ", sexTypes=" + sexTypes +
            ", yuangongEmail=" + yuangongEmail +
            ", bumenTypes=" + bumenTypes +
            ", xueliTypes=" + xueliTypes +
            ", zhuanyezhiwuTypes=" + zhuanyezhiwuTypes +
            ", hetongTypes=" + hetongTypes +
            ", hetongFile=" + hetongFile +
            ", hetongQiandingTime=" + hetongQiandingTime +
            ", hetongJieshuTime=" + hetongJieshuTime +
            ", zhengzhiTypes=" + zhengzhiTypes +
            ", yuangongXuexiao=" + yuangongXuexiao +
            ", gangweiTypes=" + gangweiTypes +
            ", hukou=" + hukou +
            ", hunyinTypes=" + hunyinTypes +
            ", zhuzhi=" + zhuzhi +
            ", gongzuoTime=" + gongzuoTime +
            ", minzu=" + minzu +
            ", ruzhiTime=" + ruzhiTime +
            ", rudangTime=" + rudangTime +
            ", zhuanyeTypes=" + zhuanyeTypes +
            ", createTime=" + createTime +
        "}";
    }
}
