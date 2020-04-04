package com.numerx.formutil.weixin.company.mssage;

/**
 * 文本消息体
 *
 */
public class TextBody {

	/**
	 * 消息内容，最长不超过2048个字节
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
