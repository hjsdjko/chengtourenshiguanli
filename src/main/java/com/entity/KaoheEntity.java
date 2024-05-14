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
 * 考核信息
 *
 * @author 
 * @email
 */
@TableName("kaohe")
public class KaoheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoheEntity() {

	}

	public KaoheEntity(T t) {
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
     * 考核名称
     */
    @TableField(value = "kaohe_name")

    private String kaoheName;


    /**
     * 考核类型
     */
    @TableField(value = "kaohe_types")

    private Integer kaoheTypes;


    /**
     * 考核详情
     */
    @TableField(value = "kaohe_content")

    private String kaoheContent;


    /**
     * 考核结果
     */
    @TableField(value = "kaohe_jieguo_types")

    private Integer kaoheJieguoTypes;


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
	 * 设置：考核名称
	 */
    public String getKaoheName() {
        return kaoheName;
    }


    /**
	 * 获取：考核名称
	 */

    public void setKaoheName(String kaoheName) {
        this.kaoheName = kaoheName;
    }
    /**
	 * 设置：考核类型
	 */
    public Integer getKaoheTypes() {
        return kaoheTypes;
    }


    /**
	 * 获取：考核类型
	 */

    public void setKaoheTypes(Integer kaoheTypes) {
        this.kaoheTypes = kaoheTypes;
    }
    /**
	 * 设置：考核详情
	 */
    public String getKaoheContent() {
        return kaoheContent;
    }


    /**
	 * 获取：考核详情
	 */

    public void setKaoheContent(String kaoheContent) {
        this.kaoheContent = kaoheContent;
    }
    /**
	 * 设置：考核结果
	 */
    public Integer getKaoheJieguoTypes() {
        return kaoheJieguoTypes;
    }


    /**
	 * 获取：考核结果
	 */

    public void setKaoheJieguoTypes(Integer kaoheJieguoTypes) {
        this.kaoheJieguoTypes = kaoheJieguoTypes;
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
        return "Kaohe{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", kaoheName=" + kaoheName +
            ", kaoheTypes=" + kaoheTypes +
            ", kaoheContent=" + kaoheContent +
            ", kaoheJieguoTypes=" + kaoheJieguoTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
