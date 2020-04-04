package com.numerx.formutil.weixin.message.send; ;
 
/** 
 * mpnews消息与news消息类似，不同的是图文消息内容存储在微信后台，并且支持保密选项。 
 *  
 */
public class MpNews { 
    // 图文消息名称 
    private String Title; 
    // 图文消息缩略图的media_id
    private String ThumbMediaId; 
    // 图文消息的作者
    private String Author; 
    // 图文消息点击“阅读原文”之后的页面链接
    private String ContentSourceUrl; 
    // 图文消息的内容，支持html标签
    private String Content; 
    // 图文消息的描述
    private String Digest; 
    // 是否显示封面，1为显示，0为不显示
    private String ShowCoverPic;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getContentSourceUrl() {
		return ContentSourceUrl;
	}
	public void setContentSourceUrl(String contentSourceUrl) {
		ContentSourceUrl = contentSourceUrl;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getDigest() {
		return Digest;
	}
	public void setDigest(String digest) {
		Digest = digest;
	}
	public String getShowCoverPic() {
		return ShowCoverPic;
	}
	public void setShowCoverPic(String showCoverPic) {
		ShowCoverPic = showCoverPic;
	} 
 
} 
