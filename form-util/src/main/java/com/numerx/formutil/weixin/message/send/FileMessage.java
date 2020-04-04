package com.numerx.formutil.weixin.message.send;

/**
 * 语音消息
 */
public class FileMessage extends BaseMessage {
	// 文件
	private File File;

	public File getFile() {
		return File;
	}

	public void setFile(File file) {
		File = file;
	}

	
}
