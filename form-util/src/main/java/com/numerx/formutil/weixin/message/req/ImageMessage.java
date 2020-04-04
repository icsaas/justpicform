package com.numerx.formutil.weixin.message.req;
 
/** 
 * 图片消息 
 */
public class ImageMessage extends BaseMessage { 
    // 图片链接 
    private String PicUrl; 
    //图片媒体文件id，可以调用获取媒体文件接口拉取数据
    private long MediaId;
 
    public String getPicUrl() { 
        return PicUrl; 
    } 
 
    public void setPicUrl(String picUrl) { 
        PicUrl = picUrl; 
    }

	public long getMediaId() {
		return MediaId;
	}

	public void setMediaId(long mediaId) {
		MediaId = mediaId;
	} 
    
} 
