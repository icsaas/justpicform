package com.numerx.formutil.weixin.company.mssage;

import com.numerx.formutil.weixin.util.MessageType;

public class TextMessage extends Message {
	
	public TextMessage(){
		this.setMsgtype(MessageType.text);
	}
	
	/**
	 * 消息内容，最长不超过2048个字节
	 */
	private TextBody text;

	public TextBody getText() {
		return text;
	}

	public void setText(TextBody text) {
		this.text = text;
	}

	
}
