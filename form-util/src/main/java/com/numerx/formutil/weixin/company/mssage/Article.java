package com.numerx.formutil.weixin.company.mssage;

/**
 * 图文消息体
 * @author 3hhjj
 *
 */
public class Article {

	private String title;
	
	private String description;
	
	private String url;
	
	private String picurl;

	public String getTitle() {
		return title;
	}

	/**
	 * 标题，不超过128个字节
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title == null ? "":title;
	}

	/**
	 * 描述，不超过512个字节
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null? "" : description;
	}

	/**
	 * 点击后跳转的链接
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null? "" : url;
	}

	public String getPicurl() {
		return picurl;
	}

	/**
	 * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。如不填，在客户端不显示图片 
	 * @param picurl
	 */
	public void setPicurl(String picurl) {
		this.picurl = picurl == null? "" : picurl;
	}
}
