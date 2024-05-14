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
 * 培训信息
 *
 * @author 
 * @email
 */
@TableName("peixun")
public class PeixunEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeixunEntity() {

	}

	public PeixunEntity(T t) {
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
     * 培训名称
     */
    @TableField(value = "peixun_name")

    private String peixunName;


    /**
     * 培训类型
     */
    @TableField(value = "peixun_types")

    private Integer peixunTypes;


    /**
     * 培训开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "peixun_kaishi_time")

    private Date peixunKaishiTime;


    /**
     * 培训结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "peixun_jieshu_time")

    private Date peixunJieshuTime;


    /**
     * 培训内容
     */
    @TableField(value = "peixun_content")

    private String peixunContent;


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
	 * 设置：培训名称
	 */
    public String getPeixunName() {
        return peixunName;
    }


    /**
	 * 获取：培训名称
	 */

    public void setPeixunName(String peixunName) {
        this.peixunName = peixunName;
    }
    /**
	 * 设置：培训类型
	 */
    public Integer getPeixunTypes() {
        return peixunTypes;
    }


    /**
	 * 获取：培训类型
	 */

    public void setPeixunTypes(Integer peixunTypes) {
        this.peixunTypes = peixunTypes;
    }
    /**
	 * 设置：培训开始时间
	 */
    public Date getPeixunKaishiTime() {
        return peixunKaishiTime;
    }


    /**
	 * 获取：培训开始时间
	 */

    public void setPeixunKaishiTime(Date peixunKaishiTime) {
        this.peixunKaishiTime = peixunKaishiTime;
    }
    /**
	 * 设置：培训结束时间
	 */
    public Date getPeixunJieshuTime() {
        return peixunJieshuTime;
    }


    /**
	 * 获取：培训结束时间
	 */

    public void setPeixunJieshuTime(Date peixunJieshuTime) {
        this.peixunJieshuTime = peixunJieshuTime;
    }
    /**
	 * 设置：培训内容
	 */
    public String getPeixunContent() {
        return peixunContent;
    }


    /**
	 * 获取：培训内容
	 */

    public void setPeixunContent(String peixunContent) {
        this.peixunContent = peixunContent;
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
        return "Peixun{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", peixunName=" + peixunName +
            ", peixunTypes=" + peixunTypes +
            ", peixunKaishiTime=" + peixunKaishiTime +
            ", peixunJieshuTime=" + peixunJieshuTime +
            ", peixunContent=" + peixunContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
