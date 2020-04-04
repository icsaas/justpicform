package com.numerx.formutil.weixin.company.mssage;

public class MediaBody {

	private String media_id;

	public String getMedia_id() {
		return media_id;
	}

	/**
	 * 图片媒体文件id，可以调用上传临时素材或者永久素材接口获取,永久素材media_id必须由发消息的应用创建 
	 * @param media_id
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
}
