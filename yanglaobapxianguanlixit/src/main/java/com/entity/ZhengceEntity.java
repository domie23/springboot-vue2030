package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 养老政策
 *
 * @author 
 * @email
 */
@TableName("zhengce")
public class ZhengceEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhengceEntity() {

	}

	public ZhengceEntity(T t) {
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
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 养老政策名称
     */
    @ColumnInfo(comment="养老政策名称",type="varchar(200)")
    @TableField(value = "zhengce_name")

    private String zhengceName;


    /**
     * 养老政策编号
     */
    @ColumnInfo(comment="养老政策编号",type="varchar(200)")
    @TableField(value = "zhengce_uuid_number")

    private String zhengceUuidNumber;


    /**
     * 养老政策照片
     */
    @ColumnInfo(comment="养老政策照片",type="varchar(200)")
    @TableField(value = "zhengce_photo")

    private String zhengcePhoto;


    /**
     * 养老政策类型
     */
    @ColumnInfo(comment="养老政策类型",type="int(11)")
    @TableField(value = "zhengce_types")

    private Integer zhengceTypes;


    /**
     * 养老政策介绍
     */
    @ColumnInfo(comment="养老政策介绍",type="longtext")
    @TableField(value = "zhengce_content")

    private String zhengceContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zhengce_delete")

    private Integer zhengceDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：养老政策名称
	 */
    public String getZhengceName() {
        return zhengceName;
    }
    /**
	 * 设置：养老政策名称
	 */

    public void setZhengceName(String zhengceName) {
        this.zhengceName = zhengceName;
    }
    /**
	 * 获取：养老政策编号
	 */
    public String getZhengceUuidNumber() {
        return zhengceUuidNumber;
    }
    /**
	 * 设置：养老政策编号
	 */

    public void setZhengceUuidNumber(String zhengceUuidNumber) {
        this.zhengceUuidNumber = zhengceUuidNumber;
    }
    /**
	 * 获取：养老政策照片
	 */
    public String getZhengcePhoto() {
        return zhengcePhoto;
    }
    /**
	 * 设置：养老政策照片
	 */

    public void setZhengcePhoto(String zhengcePhoto) {
        this.zhengcePhoto = zhengcePhoto;
    }
    /**
	 * 获取：养老政策类型
	 */
    public Integer getZhengceTypes() {
        return zhengceTypes;
    }
    /**
	 * 设置：养老政策类型
	 */

    public void setZhengceTypes(Integer zhengceTypes) {
        this.zhengceTypes = zhengceTypes;
    }
    /**
	 * 获取：养老政策介绍
	 */
    public String getZhengceContent() {
        return zhengceContent;
    }
    /**
	 * 设置：养老政策介绍
	 */

    public void setZhengceContent(String zhengceContent) {
        this.zhengceContent = zhengceContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZhengceDelete() {
        return zhengceDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZhengceDelete(Integer zhengceDelete) {
        this.zhengceDelete = zhengceDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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

    @Override
    public String toString() {
        return "Zhengce{" +
            ", id=" + id +
            ", zhengceName=" + zhengceName +
            ", zhengceUuidNumber=" + zhengceUuidNumber +
            ", zhengcePhoto=" + zhengcePhoto +
            ", zhengceTypes=" + zhengceTypes +
            ", zhengceContent=" + zhengceContent +
            ", zhengceDelete=" + zhengceDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
