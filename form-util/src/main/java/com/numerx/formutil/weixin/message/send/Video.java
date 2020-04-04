package com.numerx.formutil.weixin.message.send;

/**
 * 视频
 */
public class Video {
	// 视频媒体文件id
	private String MediaId;
	// 视频消息的标题
	private String Title;
	//视频消息的描述
	private String Description;
	
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}	
}
