package com.huiting.xml.dto;

import java.util.Date;

public class CcUploadFilesDto {
	private String fileid;

	private String filegroupid;

	private String moduleid;

	private String uploadfilename;

	private String uploadrealname;

	private String uploadcontenttype;

	private String savepath;

	private Date createtime;

	private String createusercode;

	private String remark;

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid == null ? null : fileid.trim();
	}

	public String getFilegroupid() {
		return filegroupid;
	}

	public void setFilegroupid(String filegroupid) {
		this.filegroupid = filegroupid == null ? null : filegroupid.trim();
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid == null ? null : moduleid.trim();
	}

	public String getUploadfilename() {
		return uploadfilename;
	}

	public void setUploadfilename(String uploadfilename) {
		this.uploadfilename = uploadfilename == null ? null : uploadfilename
				.trim();
	}

	public String getUploadrealname() {
		return uploadrealname;
	}

	public void setUploadrealname(String uploadrealname) {
		this.uploadrealname = uploadrealname == null ? null : uploadrealname
				.trim();
	}

	public String getUploadcontenttype() {
		return uploadcontenttype;
	}

	public void setUploadcontenttype(String uploadcontenttype) {
		this.uploadcontenttype = uploadcontenttype == null ? null
				: uploadcontenttype.trim();
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath == null ? null : savepath.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateusercode() {
		return createusercode;
	}

	public void setCreateusercode(String createusercode) {
		this.createusercode = createusercode == null ? null : createusercode
				.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}
