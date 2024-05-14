package com.entity.vo;

import com.entity.KaoheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考核信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kaohe")
public class KaoheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
