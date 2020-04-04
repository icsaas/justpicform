package com.numerx.formutil.weixin.company.mssage;

import com.numerx.formutil.weixin.util.MessageType;

public class FileMessage extends Message {
	
	public FileMessage(){
		this.setMsgtype(MessageType.file);
	}
	
	private MediaBody file;

	public MediaBody getFile() {
		return file;
	}

	public void setFile(MediaBody file) {
		this.file = file;
	}

}
