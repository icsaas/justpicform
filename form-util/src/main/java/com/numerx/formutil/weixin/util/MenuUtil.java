package com.numerx.formutil.weixin.util;

import net.sf.json.JSONObject;
import com.numerx.formutil.weixin.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义菜单工具类
 */
public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

	/**
	 * 创建企业号菜单
	 * @param menu 菜单数据 
	 * @param agentId 企业应用的id，整型。可在应用的设置页面查看 
	 * @return
	 */
	public static boolean createMenu(Menu menu, int agentId) {
		boolean result = false;
		String accessToken = CommonUtil.getToken();
		String url = String.format(QiyehaoConst.URL_MENU_create, accessToken, agentId);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
				log.debug("创建菜单成功！");
			} else {
				result = false;
				log.error("创建菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}

		return result;
	}

	/**
	 * 查询企业号菜单
	 * @param agentid 企业应用的id，整型。可在应用的设置页面查看 
	 * @return
	 */
	public static String getMenu(int agentid) {
		String result = null;
		String accessToken = CommonUtil.getToken();
		String requestUrl = String.format(QiyehaoConst.URL_MENU_get, accessToken, agentid);
		// 发起GET请求查询菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			result = jsonObject.toString();
		}
		return result;
	}

	/**
	 * 删除企业菜单
	 * 
	 * @param accessToken 凭证
	 * @return true成功 false失败
	 */
	public static boolean deleteMenu(int agentid) {
		boolean result = false;
		String accessToken = CommonUtil.getToken();
		String requestUrl = String.format(QiyehaoConst.URL_MENU_delete, accessToken, agentid);
		// 发起GET请求删除菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				log.error("删除菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}
}
