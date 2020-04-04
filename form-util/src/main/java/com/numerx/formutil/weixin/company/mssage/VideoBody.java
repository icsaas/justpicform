package com.numerx.formutil.weixin.company.mssage;

/**
 * video消息
 * @author 3hhjj
 *
 */
public class VideoBody extends MediaBody {

	private String title;
	
	private String description;

	public String getTitle() {
		return title;
	}

	/**
	 * 视频消息的标题，不超过128个字节
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title == null ? "" : title;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * 视频消息的描述，不超过512个字节
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description == null ? "" : description;
	}
}
