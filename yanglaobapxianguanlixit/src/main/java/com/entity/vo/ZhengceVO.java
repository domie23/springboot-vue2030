package com.entity.vo;

import com.entity.ZhengceEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 养老政策
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhengce")
public class ZhengceVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 养老政策名称
     */

    @TableField(value = "zhengce_name")
    private String zhengceName;


    /**
     * 养老政策编号
     */

    @TableField(value = "zhengce_uuid_number")
    private String zhengceUuidNumber;


    /**
     * 养老政策照片
     */

    @TableField(value = "zhengce_photo")
    private String zhengcePhoto;


    /**
     * 养老政策类型
     */

    @TableField(value = "zhengce_types")
    private Integer zhengceTypes;


    /**
     * 养老政策介绍
     */

    @TableField(value = "zhengce_content")
    private String zhengceContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zhengce_delete")
    private Integer zhengceDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：养老政策名称
	 */
    public String getZhengceName() {
        return zhengceName;
    }


    /**
	 * 获取：养老政策名称
	 */

    public void setZhengceName(String zhengceName) {
        this.zhengceName = zhengceName;
    }
    /**
	 * 设置：养老政策编号
	 */
    public String getZhengceUuidNumber() {
        return zhengceUuidNumber;
    }


    /**
	 * 获取：养老政策编号
	 */

    public void setZhengceUuidNumber(String zhengceUuidNumber) {
        this.zhengceUuidNumber = zhengceUuidNumber;
    }
    /**
	 * 设置：养老政策照片
	 */
    public String getZhengcePhoto() {
        return zhengcePhoto;
    }


    /**
	 * 获取：养老政策照片
	 */

    public void setZhengcePhoto(String zhengcePhoto) {
        this.zhengcePhoto = zhengcePhoto;
    }
    /**
	 * 设置：养老政策类型
	 */
    public Integer getZhengceTypes() {
        return zhengceTypes;
    }


    /**
	 * 获取：养老政策类型
	 */

    public void setZhengceTypes(Integer zhengceTypes) {
        this.zhengceTypes = zhengceTypes;
    }
    /**
	 * 设置：养老政策介绍
	 */
    public String getZhengceContent() {
        return zhengceContent;
    }


    /**
	 * 获取：养老政策介绍
	 */

    public void setZhengceContent(String zhengceContent) {
        this.zhengceContent = zhengceContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZhengceDelete() {
        return zhengceDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZhengceDelete(Integer zhengceDelete) {
        this.zhengceDelete = zhengceDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
