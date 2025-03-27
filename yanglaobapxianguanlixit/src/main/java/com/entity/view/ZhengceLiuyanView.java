package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhengceLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 养老政策留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhengce_liuyan")
public class ZhengceLiuyanView extends ZhengceLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
	//级联表 养老政策
		/**
		* 养老政策名称
		*/

		@ColumnInfo(comment="养老政策名称",type="varchar(200)")
		private String zhengceName;
		/**
		* 养老政策编号
		*/

		@ColumnInfo(comment="养老政策编号",type="varchar(200)")
		private String zhengceUuidNumber;
		/**
		* 养老政策照片
		*/

		@ColumnInfo(comment="养老政策照片",type="varchar(200)")
		private String zhengcePhoto;
		/**
		* 养老政策类型
		*/
		@ColumnInfo(comment="养老政策类型",type="int(11)")
		private Integer zhengceTypes;
			/**
			* 养老政策类型的值
			*/
			@ColumnInfo(comment="养老政策类型的字典表值",type="varchar(200)")
			private String zhengceValue;
		/**
		* 养老政策介绍
		*/

		@ColumnInfo(comment="养老政策介绍",type="longtext")
		private String zhengceContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zhengceDelete;



	public ZhengceLiuyanView() {

	}

	public ZhengceLiuyanView(ZhengceLiuyanEntity zhengceLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zhengceLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
	//级联表的get和set 养老政策

		/**
		* 获取： 养老政策名称
		*/
		public String getZhengceName() {
			return zhengceName;
		}
		/**
		* 设置： 养老政策名称
		*/
		public void setZhengceName(String zhengceName) {
			this.zhengceName = zhengceName;
		}

		/**
		* 获取： 养老政策编号
		*/
		public String getZhengceUuidNumber() {
			return zhengceUuidNumber;
		}
		/**
		* 设置： 养老政策编号
		*/
		public void setZhengceUuidNumber(String zhengceUuidNumber) {
			this.zhengceUuidNumber = zhengceUuidNumber;
		}

		/**
		* 获取： 养老政策照片
		*/
		public String getZhengcePhoto() {
			return zhengcePhoto;
		}
		/**
		* 设置： 养老政策照片
		*/
		public void setZhengcePhoto(String zhengcePhoto) {
			this.zhengcePhoto = zhengcePhoto;
		}
		/**
		* 获取： 养老政策类型
		*/
		public Integer getZhengceTypes() {
			return zhengceTypes;
		}
		/**
		* 设置： 养老政策类型
		*/
		public void setZhengceTypes(Integer zhengceTypes) {
			this.zhengceTypes = zhengceTypes;
		}


			/**
			* 获取： 养老政策类型的值
			*/
			public String getZhengceValue() {
				return zhengceValue;
			}
			/**
			* 设置： 养老政策类型的值
			*/
			public void setZhengceValue(String zhengceValue) {
				this.zhengceValue = zhengceValue;
			}

		/**
		* 获取： 养老政策介绍
		*/
		public String getZhengceContent() {
			return zhengceContent;
		}
		/**
		* 设置： 养老政策介绍
		*/
		public void setZhengceContent(String zhengceContent) {
			this.zhengceContent = zhengceContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZhengceDelete() {
			return zhengceDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZhengceDelete(Integer zhengceDelete) {
			this.zhengceDelete = zhengceDelete;
		}


	@Override
	public String toString() {
		return "ZhengceLiuyanView{" +
			", zhengceName=" + zhengceName +
			", zhengceUuidNumber=" + zhengceUuidNumber +
			", zhengcePhoto=" + zhengcePhoto +
			", zhengceContent=" + zhengceContent +
			", zhengceDelete=" + zhengceDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
