package com.numerx.formutil.weixin.company.entity;

/**
 * 媒体文件信息
 */
public class WeixinMedia {
	// 媒体文件类型
	private String type;
	// 媒体文件标识或缩略图的媒体文件标识
	private String mediaId;
	// 媒体文件上传的时间
	private int createdAt;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}
}
