package com.entity.model;

import com.entity.KaoheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考核信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoheModel implements Serializable {
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
     * 考核名称
     */
    private String kaoheName;


    /**
     * 考核类型
     */
    private Integer kaoheTypes;


    /**
     * 考核详情
     */
    private String kaoheContent;


    /**
     * 考核结果
     */
    private Integer kaoheJieguoTypes;


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
	 * 获取：考核名称
	 */
    public String getKaoheName() {
        return kaoheName;
    }


    /**
	 * 设置：考核名称
	 */
    public void setKaoheName(String kaoheName) {
        this.kaoheName = kaoheName;
    }
    /**
	 * 获取：考核类型
	 */
    public Integer getKaoheTypes() {
        return kaoheTypes;
    }


    /**
	 * 设置：考核类型
	 */
    public void setKaoheTypes(Integer kaoheTypes) {
        this.kaoheTypes = kaoheTypes;
    }
    /**
	 * 获取：考核详情
	 */
    public String getKaoheContent() {
        return kaoheContent;
    }


    /**
	 * 设置：考核详情
	 */
    public void setKaoheContent(String kaoheContent) {
        this.kaoheContent = kaoheContent;
    }
    /**
	 * 获取：考核结果
	 */
    public Integer getKaoheJieguoTypes() {
        return kaoheJieguoTypes;
    }


    /**
	 * 设置：考核结果
	 */
    public void setKaoheJieguoTypes(Integer kaoheJieguoTypes) {
        this.kaoheJieguoTypes = kaoheJieguoTypes;
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
