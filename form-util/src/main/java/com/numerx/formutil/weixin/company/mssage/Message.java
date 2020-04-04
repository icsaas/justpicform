package com.numerx.formutil.weixin.company.mssage;

import com.numerx.formutil.weixin.util.MessageType;

import java.util.List;

/**
 * 企业号发关的消息
 *
 */
public abstract class Message {
	
	/**
	 * 成员ID列表,消息接收者，多个接收者用‘|’分隔
	 */
	private String touser;
	
	/**
	 * 部门ID列表，多个接收者用‘|’分隔，最多支持100个
	 */
	private String toparty;
	
	/**
	 * 标签ID列表，多个接收者用‘|’分隔，最多支持100个
	 */
	private String totag;
	
	/**
	 * 企业应用的id，整型
	 */
	private int agentid;
	
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0 
	 */
	private int safe;
	
	/**
	 * 消息类型
	 */
	private MessageType msgtype;
	
	private String listToString(List<String> list){
		if(list == null || list.isEmpty())
			return "";
		StringBuilder sb = new StringBuilder(list.get(0));
		for(int i=1; i<list.size(); i++){
			sb.append("|").append(list.get(i));
		}
		return sb.toString();
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(List<String> touser) {
		this.touser = listToString(touser);
	}

	public String getToparty() {
		return toparty;
	}

	public void setToparty(List<String> toparty) {
		this.toparty = listToString(toparty);
	}

	public String getTotag() {
		return totag;
	}

	public void setTotag(List<String> totag) {
		this.totag = listToString(totag);
	}

	public MessageType getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(MessageType msgtype) {
		this.msgtype = msgtype;
	}

	public int getAgentid() {
		return agentid;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}
}
