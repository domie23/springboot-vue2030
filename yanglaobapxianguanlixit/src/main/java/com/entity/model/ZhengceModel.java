package com.entity.model;

import com.entity.ZhengceEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 养老政策
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhengceModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 养老政策名称
     */
    private String zhengceName;


    /**
     * 养老政策编号
     */
    private String zhengceUuidNumber;


    /**
     * 养老政策照片
     */
    private String zhengcePhoto;


    /**
     * 养老政策类型
     */
    private Integer zhengceTypes;


    /**
     * 养老政策介绍
     */
    private String zhengceContent;


    /**
     * 逻辑删除
     */
    private Integer zhengceDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
