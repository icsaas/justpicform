package com.numerx.formutil.weixin.util;


/**
 * 微信企业号常量配置
 */

public class QiyehaoConst {
    
    /*******************************************************
     *         微信企业号配置
     *******************************************************/
	
	/**
	 * 企业号河道台理应用
	 */
	public final static int AGENTID_WATER = 1;
	
	/**
	 * 微信的用户ID
	 */
	public final static String Weixin_UserId = "QiYeWeiXinUserId";
	
	/**
	 * 微信用户的OpenID
	 */
	public final static String Weixin_OpenId = "QiYeWeiXinOpenId";
	
	/**
	 * 企业号ID
	 */
    public final static String CorpID="wx7d9176de98109ba1";
    
    /**
     * token
     */
    public final static String Token = "D1W4oxb";
   
    /**
     * 随机戳
     */
    public final static String EncodingAESKey = "QyGHQMcIRVVk3C0ektfjnHfhQag2AgF9UNAJShz6EGp";
    
    /**
     * 信任域名
     */
    public final static String Domain_Name = "http://wx1.ccqm.cn";
    
    /**
     * OAuth2 回调地址
     */
    public final static String REDIRECT_URI = Domain_Name + "/weixinqy/authorizes";
    
    /**
     * 采用http GET方式请求获得jsapi_ticket
     */
    public final static String URL_Ticket = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=%s";
    
    /**
     * 管理组的凭证密钥，每个secret代表了对应用、通讯录、接口的不同权限；不同的管理组拥有不同的secret
     */
 	public static String corpsecret = "f6QHGzTnqt5oQijGAS0WLf2JVawjtwgK5yykcL2BoT1I4dBwf_67oGb8twVYxX-3";
 	
 	/**
 	 * 企业获取code
 	 */
 	public static String URL_Authorize = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=SCOPE&state=%s#wechat_redirect";
 	
 	/**
 	 * 根据code获取成员信息,(GET)
 	 */
 	public static String URL_UserInfo = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=%s&code=%s";
 	
 	/**
 	 * 获取AccessToken（GET）
 	 */
 	public final static String URL_Token = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";
 	
 	/**
 	 * userid转换成openid接口
 	 */
 	public final static String URL_UserIdToOpenId = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=%s";
 	
 	/**
 	 * 创建成员地址(POST)
 	 */
 	public static String URL_CREATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=%s";
 	
 	/**
 	 * 更新成员地址(POST)
 	 */
	public static String URL_UPDATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=%s";
	/**
	 * 删滁成员地址(GET)
	 */
	public static String URL_DELETE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=%s&userid=%s";
	/**
	 * 获取成员地址(GET)
	 */
	public static String URL_GET_PERSON = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=%s&userid=%s";
	
	/**
	 * 获取部门成员地址(GET)
	 */
	public static String URL_GET_GROUP = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=%s&department_id=%s&fetch_child=%d&status=%d";
	
	/**
	 *  菜单创建（POST）
	 */
	public final static String URL_MENU_create = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=%s&agentid=%d";
	/**
	 * 菜单查询（GET）
	 */
	public final static String URL_MENU_get = "https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=%s&agentid=%d";
	/**
	 * 菜单删除（GET）
	 */
	public final static String URL_MENU_delete = " https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=%s&agentid=%d";
	
	/**
	 * 创建部门(POST)
	 */
	public static String URL_DEPART_CREATE = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=%s";
	/**
	 * 更新部门(POST)
	 */
	public static String URL_DEPART_UPDATE = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=%s";
	/**
	 * 删除部门(GET)
	 */
	public static String URL_DEPART_DELETE = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=%s&id=%d";
	/**
	 * 获取部门列表(GET)
	 */
	public static String URL_DEPART_LIST = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%s&id=%d";

	/**
	 * 发送消息接口(POST)
	 */
	public static String URL_MESSAGE_SED = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";
	
	/**
	 * 下载文件
	 */
	public static String URL_DOWNLOAD_FILE = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
}
