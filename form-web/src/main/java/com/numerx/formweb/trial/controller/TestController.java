package com.numerx.formweb.trial.controller;

import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.numerx.formutil.utils.CheckUtil;
import com.numerx.formweb.trial.manager.TestManager;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author matrixorz
 * @data 2019-08-11 23:17
 */
@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestManager testManager;

    @Autowired
    private BaseMysqlCRUDManager baseMysqlCRUDManager;

   @RequestMapping("/index")
    public String index(){

//       Test test = new Test();
//       test.setName("sss333");
//       test.setNumber(9L);
//       test.setDescription("adfsdfe");
//
//       baseMysqlCRUDManager.delete(test);
//       baseMysqlCRUDManager.save(test);
//       int count = testManager.findTestCount();
       return "index";
   }
    @GetMapping("/verify_wx_token")
    public void login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
                out.write(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @PostMapping("/verify_wx_token")
    public void handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Map<String, String> parseXml = parseXml(request);
        String msgType = parseXml.get("MsgType");
        String content = parseXml.get("Content");
        String fromusername = parseXml.get("FromUserName");
        String tousername = parseXml.get("ToUserName");
        System.out.println(msgType);
        System.out.println(content);
        System.out.println(fromusername);
        System.out.println(tousername);
    }
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document;
        document = reader.read(new BufferedReader(new InputStreamReader(inputStream,"UTF-8")));
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        inputStream.close();
        inputStream = null;
        return map;
    }


}
