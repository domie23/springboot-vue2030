package com.entity.model;

import com.entity.XiangmuYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 保险参保
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String xiangmuYuyueUuidNumber;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 报名理由
     */
    private String xiangmuYuyueText;


    /**
     * 项目报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 所属村镇
     */
    private String xiangmuYuyueCunzhen;


    /**
     * 家庭地址
     */
    private String xiangmuYuyueDizhi;


    /**
     * 报名状态
     */
    private Integer xiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String xiangmuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiangmuYuyueShenheTime;


    /**
     * 参保日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiangmuYuyueTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：报名编号
	 */
    public String getXiangmuYuyueUuidNumber() {
        return xiangmuYuyueUuidNumber;
    }


    /**
	 * 设置：报名编号
	 */
    public void setXiangmuYuyueUuidNumber(String xiangmuYuyueUuidNumber) {
        this.xiangmuYuyueUuidNumber = xiangmuYuyueUuidNumber;
    }
    /**
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 设置：项目
	 */
    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
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
	 * 获取：报名理由
	 */
    public String getXiangmuYuyueText() {
        return xiangmuYuyueText;
    }


    /**
	 * 设置：报名理由
	 */
    public void setXiangmuYuyueText(String xiangmuYuyueText) {
        this.xiangmuYuyueText = xiangmuYuyueText;
    }
    /**
	 * 获取：项目报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：项目报名时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：所属村镇
	 */
    public String getXiangmuYuyueCunzhen() {
        return xiangmuYuyueCunzhen;
    }


    /**
	 * 设置：所属村镇
	 */
    public void setXiangmuYuyueCunzhen(String xiangmuYuyueCunzhen) {
        this.xiangmuYuyueCunzhen = xiangmuYuyueCunzhen;
    }
    /**
	 * 获取：家庭地址
	 */
    public String getXiangmuYuyueDizhi() {
        return xiangmuYuyueDizhi;
    }


    /**
	 * 设置：家庭地址
	 */
    public void setXiangmuYuyueDizhi(String xiangmuYuyueDizhi) {
        this.xiangmuYuyueDizhi = xiangmuYuyueDizhi;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getXiangmuYuyueYesnoTypes() {
        return xiangmuYuyueYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setXiangmuYuyueYesnoTypes(Integer xiangmuYuyueYesnoTypes) {
        this.xiangmuYuyueYesnoTypes = xiangmuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getXiangmuYuyueYesnoText() {
        return xiangmuYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setXiangmuYuyueYesnoText(String xiangmuYuyueYesnoText) {
        this.xiangmuYuyueYesnoText = xiangmuYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXiangmuYuyueShenheTime() {
        return xiangmuYuyueShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setXiangmuYuyueShenheTime(Date xiangmuYuyueShenheTime) {
        this.xiangmuYuyueShenheTime = xiangmuYuyueShenheTime;
    }
    /**
	 * 获取：参保日期
	 */
    public Date getXiangmuYuyueTime() {
        return xiangmuYuyueTime;
    }


    /**
	 * 设置：参保日期
	 */
    public void setXiangmuYuyueTime(Date xiangmuYuyueTime) {
        this.xiangmuYuyueTime = xiangmuYuyueTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
