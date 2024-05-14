package com.entity.model;

import com.entity.XiziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 薪资信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 薪资名称
     */
    private String xiziName;


    /**
     * 月份
     */
    private String xiziMonth;


    /**
     * 基本工资
     */
    private Double xiziJibenMoney;


    /**
     * 绩效工资
     */
    private Double xiziJixiaoMoney;


    /**
     * 餐饮补贴
     */
    private Double xiziCanyinMoney;


    /**
     * 实发工资
     */
    private Double xiziShifaMoney;


    /**
     * 备注
     */
    private String xiziContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：薪资名称
	 */
    public String getXiziName() {
        return xiziName;
    }


    /**
	 * 设置：薪资名称
	 */
    public void setXiziName(String xiziName) {
        this.xiziName = xiziName;
    }
    /**
	 * 获取：月份
	 */
    public String getXiziMonth() {
        return xiziMonth;
    }


    /**
	 * 设置：月份
	 */
    public void setXiziMonth(String xiziMonth) {
        this.xiziMonth = xiziMonth;
    }
    /**
	 * 获取：基本工资
	 */
    public Double getXiziJibenMoney() {
        return xiziJibenMoney;
    }


    /**
	 * 设置：基本工资
	 */
    public void setXiziJibenMoney(Double xiziJibenMoney) {
        this.xiziJibenMoney = xiziJibenMoney;
    }
    /**
	 * 获取：绩效工资
	 */
    public Double getXiziJixiaoMoney() {
        return xiziJixiaoMoney;
    }


    /**
	 * 设置：绩效工资
	 */
    public void setXiziJixiaoMoney(Double xiziJixiaoMoney) {
        this.xiziJixiaoMoney = xiziJixiaoMoney;
    }
    /**
	 * 获取：餐饮补贴
	 */
    public Double getXiziCanyinMoney() {
        return xiziCanyinMoney;
    }


    /**
	 * 设置：餐饮补贴
	 */
    public void setXiziCanyinMoney(Double xiziCanyinMoney) {
        this.xiziCanyinMoney = xiziCanyinMoney;
    }
    /**
	 * 获取：实发工资
	 */
    public Double getXiziShifaMoney() {
        return xiziShifaMoney;
    }


    /**
	 * 设置：实发工资
	 */
    public void setXiziShifaMoney(Double xiziShifaMoney) {
        this.xiziShifaMoney = xiziShifaMoney;
    }
    /**
	 * 获取：备注
	 */
    public String getXiziContent() {
        return xiziContent;
    }


    /**
	 * 设置：备注
	 */
    public void setXiziContent(String xiziContent) {
        this.xiziContent = xiziContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
