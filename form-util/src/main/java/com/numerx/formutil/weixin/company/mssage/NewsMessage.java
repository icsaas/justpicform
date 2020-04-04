package com.numerx.formutil.weixin.company.mssage;

import com.numerx.formutil.weixin.util.MessageType;

public class NewsMessage extends Message {

	public NewsMessage(){
		this.setMsgtype(MessageType.news);
	}
	
	private NewsBody news;

	public NewsBody getNews() {
		return news;
	}

	public void setNews(NewsBody news) {
		this.news = news;
	}
}
