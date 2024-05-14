package com.entity.vo;

import com.entity.FuliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 福利信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fuli")
public class FuliVO implements Serializable {
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
     * 福利名称
     */

    @TableField(value = "fuli_name")
    private String fuliName;


    /**
     * 福利类型
     */

    @TableField(value = "fuli_types")
    private Integer fuliTypes;


    /**
     * 福利详情
     */

    @TableField(value = "fuli_content")
    private String fuliContent;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fafang_time")
    private Date fafangTime;


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
	 * 设置：福利名称
	 */
    public String getFuliName() {
        return fuliName;
    }


    /**
	 * 获取：福利名称
	 */

    public void setFuliName(String fuliName) {
        this.fuliName = fuliName;
    }
    /**
	 * 设置：福利类型
	 */
    public Integer getFuliTypes() {
        return fuliTypes;
    }


    /**
	 * 获取：福利类型
	 */

    public void setFuliTypes(Integer fuliTypes) {
        this.fuliTypes = fuliTypes;
    }
    /**
	 * 设置：福利详情
	 */
    public String getFuliContent() {
        return fuliContent;
    }


    /**
	 * 获取：福利详情
	 */

    public void setFuliContent(String fuliContent) {
        this.fuliContent = fuliContent;
    }
    /**
	 * 设置：发放时间
	 */
    public Date getFafangTime() {
        return fafangTime;
    }


    /**
	 * 获取：发放时间
	 */

    public void setFafangTime(Date fafangTime) {
        this.fafangTime = fafangTime;
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
