package com.numerx.formutil.weixin.message.send;
 
/** 
 * 发送消息基类（公众帐号 -> 普通用户）
 */ 
public class BaseMessage { 
    // UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送 
    private String ToUser; 
    // PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数
    private String ToParty; 
    // TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数
    private String ToTag; 
    // 消息类型（text/image/voice/video/file/news/manews） 
    private String MsgType; 
    // 企业应用的id，整型
    private int AgentId; 
	// 表示是否是保密消息
    private boolean Safe;
    
	public String getToUser() {
		return ToUser;
	}
	public void setToUser(String toUser) {
		ToUser = toUser;
	}
	public String getToParty() {
		return ToParty;
	}
	public void setToParty(String toParty) {
		ToParty = toParty;
	}
	public String getToTag() {
		return ToTag;
	}
	public void setToTag(String toTag) {
		ToTag = toTag;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public int getAgentId() {
		return AgentId;
	}
	public void setAgentId(int agentId) {
		AgentId = agentId;
	}
	public boolean isSafe() {
		return Safe;
	}
	public void setSafe(boolean safe) {
		Safe = safe;
	} 
    
} 
