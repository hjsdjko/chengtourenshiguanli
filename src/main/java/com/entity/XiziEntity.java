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
 * 薪资信息
 *
 * @author 
 * @email
 */
@TableName("xizi")
public class XiziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiziEntity() {

	}

	public XiziEntity(T t) {
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
     * 员工
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 薪资名称
     */
    @TableField(value = "xizi_name")

    private String xiziName;


    /**
     * 月份
     */
    @TableField(value = "xizi_month")

    private String xiziMonth;


    /**
     * 基本工资
     */
    @TableField(value = "xizi_jiben_money")

    private Double xiziJibenMoney;


    /**
     * 绩效工资
     */
    @TableField(value = "xizi_jixiao_money")

    private Double xiziJixiaoMoney;


    /**
     * 餐饮补贴
     */
    @TableField(value = "xizi_canyin_money")

    private Double xiziCanyinMoney;


    /**
     * 实发工资
     */
    @TableField(value = "xizi_shifa_money")

    private Double xiziShifaMoney;


    /**
     * 备注
     */
    @TableField(value = "xizi_content")

    private String xiziContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：薪资名称
	 */
    public String getXiziName() {
        return xiziName;
    }


    /**
	 * 获取：薪资名称
	 */

    public void setXiziName(String xiziName) {
        this.xiziName = xiziName;
    }
    /**
	 * 设置：月份
	 */
    public String getXiziMonth() {
        return xiziMonth;
    }


    /**
	 * 获取：月份
	 */

    public void setXiziMonth(String xiziMonth) {
        this.xiziMonth = xiziMonth;
    }
    /**
	 * 设置：基本工资
	 */
    public Double getXiziJibenMoney() {
        return xiziJibenMoney;
    }


    /**
	 * 获取：基本工资
	 */

    public void setXiziJibenMoney(Double xiziJibenMoney) {
        this.xiziJibenMoney = xiziJibenMoney;
    }
    /**
	 * 设置：绩效工资
	 */
    public Double getXiziJixiaoMoney() {
        return xiziJixiaoMoney;
    }


    /**
	 * 获取：绩效工资
	 */

    public void setXiziJixiaoMoney(Double xiziJixiaoMoney) {
        this.xiziJixiaoMoney = xiziJixiaoMoney;
    }
    /**
	 * 设置：餐饮补贴
	 */
    public Double getXiziCanyinMoney() {
        return xiziCanyinMoney;
    }


    /**
	 * 获取：餐饮补贴
	 */

    public void setXiziCanyinMoney(Double xiziCanyinMoney) {
        this.xiziCanyinMoney = xiziCanyinMoney;
    }
    /**
	 * 设置：实发工资
	 */
    public Double getXiziShifaMoney() {
        return xiziShifaMoney;
    }


    /**
	 * 获取：实发工资
	 */

    public void setXiziShifaMoney(Double xiziShifaMoney) {
        this.xiziShifaMoney = xiziShifaMoney;
    }
    /**
	 * 设置：备注
	 */
    public String getXiziContent() {
        return xiziContent;
    }


    /**
	 * 获取：备注
	 */

    public void setXiziContent(String xiziContent) {
        this.xiziContent = xiziContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Xizi{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", xiziName=" + xiziName +
            ", xiziMonth=" + xiziMonth +
            ", xiziJibenMoney=" + xiziJibenMoney +
            ", xiziJixiaoMoney=" + xiziJixiaoMoney +
            ", xiziCanyinMoney=" + xiziCanyinMoney +
            ", xiziShifaMoney=" + xiziShifaMoney +
            ", xiziContent=" + xiziContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
