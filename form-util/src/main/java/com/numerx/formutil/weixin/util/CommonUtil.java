package com.numerx.formutil.weixin.util;

import com.numerx.formutil.weixin.company.entity.Token;
import com.numerx.formutil.weixin.company.mssage.Message;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 通用工具类
 */
public class CommonUtil {
	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

	private static Token initiative_token = new Token();
	/**
	 * jsapi_ticket
	 */
	private static Token initiative_ticket = new Token();

	/**
	 * 发送https请求
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		HttpsURLConnection conn = null;
		InputStream inputStream = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
log.debug("HTTPS返回："+buffer.toString());
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("连接超时：{}", ce);
		} catch (Exception e) {
			log.error("https请求异常：{}", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
					inputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return jsonObject;
	}

	/**
	 * 发送http请求
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String url, String requestMethod, String outputStr) {
		JSONObject json = null;
		InputStream is = null;
		HttpURLConnection http = null;
		try {
			URL request = new URL(url);
			http = (HttpURLConnection) request.openConnection();
			http.setRequestMethod(requestMethod); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			if (null != outputStr) {
				OutputStream outputStream = http.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			json = JSONObject.fromObject(message);

		} catch (ConnectException ce) {
			log.error("连接超时：{}", ce);
		} catch (Exception e) {
			log.error("https请求异常：{}", e);
		} finally {
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (http != null) {
				http.disconnect();
			}
		}
		return json;
	}

	/**
	 * AccessToken是企业号的全局唯一票据，调用接口时需携带AccessToken。<br/>
	 * AccessToken需要用CorpID和Secret来换取，不同的Secret会返回不同的AccessToken。<br/>
	 * 正常情况下AccessToken有效期为7200秒，有效期内重复获取返回相同结果。
	 * 
	 * @param corpid
	 *            企业Id
	 * @param corpsecret
	 *            管理组的凭证密钥
	 * @return
	 */
	public static String getToken() {
		long ctime = System.currentTimeMillis();

		if (ctime - initiative_token.getStartTime() > initiative_token.getExpiresIn() * 1000) {
			String requestUrl = String.format(QiyehaoConst.URL_Token, QiyehaoConst.CorpID, QiyehaoConst.corpsecret);
			// 发起GET请求获取凭证
			JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

			if (null != jsonObject) {
				try {
					initiative_token.setAccessToken(jsonObject.getString("access_token"));
					initiative_token.setExpiresIn(jsonObject.getInt("expires_in") - 200);
					initiative_token.setStartTime(ctime);
				} catch (JSONException e) {
					log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
							jsonObject.getString("errmsg"));
				}
			}else{
				log.debug("获取token失败");
			}
		}

		return initiative_token.getAccessToken();
	}

	/**
	 * 根据code获取成员信息
	 * 
	 * @param code
	 *            通过成员授权获取到的code
	 * @return 返回JSON对象，<br/>
	 * 		a)企业成员授权时返回：{"UserId":"USERID", "DeviceId":"DEVICEID"}<br/>
	 *         b)非企业成员授权时返回:{"OpenId":"OPENID", "DeviceId":"DEVICEID"}
	 */
	public static JSONObject getUserInfo(String code) {
		String access_token = getToken();
		String url = String.format(QiyehaoConst.URL_UserInfo, access_token, code);
		JSONObject jsonObject = httpsRequest(url, "GET", null);
		return jsonObject;
	}

	/**
	 * 获取企业如果需要员工在跳转到企业网页时带上员工的身份信息的URL
	 * 
	 * @param state
	 *            重定向的企业网页URL
	 * @return
	 */
	public static String authorizeLink(String state) {
		String url = String.format(QiyehaoConst.URL_Authorize, QiyehaoConst.CorpID, QiyehaoConst.REDIRECT_URI,
				urlEncodeUTF8(state));
		return url;
	}

	/**
	 * userid转换成openid
	 * 
	 * @param userid
	 *            企业号内的成员id
	 * @param agentid
	 *            整型，需要发送红包的应用ID，若只是使用微信支付和企业转账，则无需该参数 ,传null即可
	 * @return JSON对象
	 *         <p>
	 * 		{ "openid": "oDOGms-6yCnGrRovBj2yHij5JL6E",
	 *         "appid":"wxf874e15f78cc84a7" }
	 *         </p>
	 *         企业号成员userid对应的openid，若有传参agentid，则是针对该agentid的openid。否则是针对企业号corpid的openid<br/>
	 *         应用的appid，若请求包中不包含agentid则不返回appid。该appid在使用微信红包时会用到
	 */
	public static JSONObject convertToOpenId(String userid, Integer agentid) {
		String accessToken = getToken();
		String url = String.format(QiyehaoConst.URL_UserIdToOpenId, accessToken);
		StringBuilder sb = new StringBuilder("{\"userid\":\"");
		sb.append(userid).append("\"");
		if (agentid != null) {
			sb.append(",\"agentid\":").append(agentid);
		}
		sb.append("}");
		JSONObject jsonObject = httpsRequest(url, "POST", sb.toString());
		return jsonObject;
	}

	/**
	 * 获得jsapi_ticket
	 * 
	 * @return
	 */
	public static String getTicket() {
		String accessToken = getToken();
		long ctime = System.currentTimeMillis();
		if (ctime - initiative_ticket.getStartTime() > initiative_ticket.getExpiresIn() * 1000) {
			String requestUrl = String.format(QiyehaoConst.URL_Ticket, accessToken);
			// 发起GET请求获取凭证
			JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

			if (null != jsonObject) {
				try {
					initiative_ticket.setAccessToken(jsonObject.getString("ticket"));
					initiative_ticket.setExpiresIn(jsonObject.getInt("expires_in") - 200);
					initiative_ticket.setStartTime(ctime);
				} catch (JSONException e) {
					log.error("获取Ticket失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
							jsonObject.getString("errmsg"));
				}
			}
		}
		return initiative_ticket.getAccessToken();
	}

	/**
	 * sha1加密
	 */
	private static String SHA1(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 生成JS-SDK签名
	 * 
	 * @param appId
	 *            应用ID或 企业ID
	 * @param accessToken
	 *            访问凭证
	 * @param jsapi_ticket
	 *            JS接口的临时票据
	 * @param url
	 *            引用js sdk的URL
	 * @return map数据，包含key:appId, timestamp, noncestr, signature
	 */
	public static Map<String, String> getSignature(String appId, String accessToken, String jsapi_ticket, String url) {
		Map<String, String> map = new HashMap<String, String>();

		// 3、时间戳和随机字符串
		String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);// 随机字符串
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);// 时间戳

		map.put("appId", appId);
		map.put("timestamp", timestamp);
		map.put("noncestr", noncestr);
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
				+ url;

		// 6、将字符串进行sha1加密
		String signature = SHA1(str);
		log.debug("参数：" + str + "\n签名：" + signature);
		map.put("signature", signature);
		return map;
	}

	/**
	 * 发送消息 消息型应用支持文本、图片、语音、视频、文件、图文等消息类型。<br/>
	 * 主页型应用只支持文本消息类型，且文本长度不超过20个字。
	 * 
	 * @param msg
	 * @return 如果无权限或收件人不存在，则本次发送失败；如果未关注，发送仍然执行。 {"errcode": 0,"errmsg":
	 *         "ok","invaliduser":
	 *         "UserID1","invalidparty":"PartyID1","invalidtag":"TagID1"}
	 */
	public static JSONObject sendMessage(Message msg) {
		String accessToken = getToken();
		String url = String.format(QiyehaoConst.URL_MESSAGE_SED, accessToken);
		JSONObject outstr = JSONObject.fromObject(msg);
		log.debug("####发送的消息对象：" + outstr.toString());
		JSONObject jsonObject = httpsRequest(url, "POST", outstr.toString());
		return jsonObject;
	}

	/**
	 * URL编码（utf-8）
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * URL解码（utf8）
	 * 
	 * @param source
	 * @return
	 */
	public static String urlDecodeUTF8(String source) {
		String result = source;
		try {
			result = URLDecoder.decode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据内容类型判断文件扩展名
	 * 
	 * @param contentType
	 *            内容类型
	 * @return
	 */
	public static String getFileExt(String contentType) {
		String fileExt = "";
		if ("image/jpeg".equals(contentType))
			fileExt = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileExt = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileExt = ".amr";
		else if ("video/mp4".equals(contentType))
			fileExt = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileExt = ".mp4";
		return fileExt;
	}

	/**
	 * 微信下载图片文件
	 * 
	 * @param accessToken
	 *            访问凭证
	 * @param url
	 *            微信下载文件url
	 * @param mediaIds
	 *            下载文件ID
	 * @param load
	 *            保存文件接口
	 */
	public static void download(final String accessToken, final String url, final String[] mediaIds,
			final WeixinSave load) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				InputStream is = null;
				HttpURLConnection http = null;
				for (String mid : mediaIds) {
					if (mid != null && !"".equals(mid)) {
						int k = 0;
						String urlstr = String.format(url, accessToken, mid);
						log.debug("URL=" + url + mid);
						while (true && k < 3) {
							k++;
							try {
								URL urlGet = new URL(urlstr);
								http = (HttpURLConnection) urlGet.openConnection();
								http.setRequestMethod("GET"); 
								http.setRequestProperty("Content-Type", "application/octet-stream");
								http.setDoOutput(true);
								http.setDoInput(true);
								System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
								System.setProperty("sun.net.client.defaultReadTimeout", "30000"); 
								http.connect();
								is = http.getInputStream();
								load.write(is);

								log.debug("下载完成");
								break;
							} catch (Exception e) {
								e.printStackTrace();
								log.debug("下载失败");
								try {
									Thread.sleep(5 * 1000);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							} finally {
								try {
									if (is != null) {
										is.close();
									}
									if (http != null) {
										http.disconnect();
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}).start();
		;
	}

}
