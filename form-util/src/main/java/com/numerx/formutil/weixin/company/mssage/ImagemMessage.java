package com.numerx.formutil.weixin.company.mssage;

import com.numerx.formutil.weixin.util.MessageType;

/**
 * image消息
 * @author 3hhjj
 *
 */
public class ImagemMessage extends Message {

	public ImagemMessage(){
		this.setMsgtype(MessageType.image);
	}
	
	private MediaBody image;

	public MediaBody getImage() {
		return image;
	}

	public void setImage(MediaBody image) {
		this.image = image;
	}
}
