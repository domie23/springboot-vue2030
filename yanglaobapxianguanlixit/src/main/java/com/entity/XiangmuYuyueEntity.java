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
 * 保险参保
 *
 * @author 
 * @email
 */
@TableName("xiangmu_yuyue")
public class XiangmuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuYuyueEntity() {

	}

	public XiangmuYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "xiangmu_yuyue_uuid_number")

    private String xiangmuYuyueUuidNumber;


    /**
     * 项目
     */
    @ColumnInfo(comment="项目",type="int(11)")
    @TableField(value = "xiangmu_id")

    private Integer xiangmuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "xiangmu_yuyue_text")

    private String xiangmuYuyueText;


    /**
     * 项目报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="项目报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 所属村镇
     */
    @ColumnInfo(comment="所属村镇",type="varchar(200)")
    @TableField(value = "xiangmu_yuyue_cunzhen")

    private String xiangmuYuyueCunzhen;


    /**
     * 家庭地址
     */
    @ColumnInfo(comment="家庭地址",type="varchar(200)")
    @TableField(value = "xiangmu_yuyue_dizhi")

    private String xiangmuYuyueDizhi;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "xiangmu_yuyue_yesno_types")

    private Integer xiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "xiangmu_yuyue_yesno_text")

    private String xiangmuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "xiangmu_yuyue_shenhe_time")

    private Date xiangmuYuyueShenheTime;


    /**
     * 参保日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="参保日期",type="timestamp")
    @TableField(value = "xiangmu_yuyue_time")

    private Date xiangmuYuyueTime;


    /**
     * 创建时间  listShow
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "XiangmuYuyue{" +
            ", id=" + id +
            ", xiangmuYuyueUuidNumber=" + xiangmuYuyueUuidNumber +
            ", xiangmuId=" + xiangmuId +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", xiangmuYuyueText=" + xiangmuYuyueText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", xiangmuYuyueCunzhen=" + xiangmuYuyueCunzhen +
            ", xiangmuYuyueDizhi=" + xiangmuYuyueDizhi +
            ", xiangmuYuyueYesnoTypes=" + xiangmuYuyueYesnoTypes +
            ", xiangmuYuyueYesnoText=" + xiangmuYuyueYesnoText +
            ", xiangmuYuyueShenheTime=" + DateUtil.convertString(xiangmuYuyueShenheTime,"yyyy-MM-dd") +
            ", xiangmuYuyueTime=" + DateUtil.convertString(xiangmuYuyueTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
