package cn.no7player.controller;

import cn.no7player.Util.wangyi.CheckSumBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping({"appMsgCode"})
public class appMsgCodeController {

    private Logger logger = Logger.getLogger(appMsgCodeController.class);

    private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";//发送验证码的请求路径URL
    private static final String APP_KEY="47045ca57e2ca57f805cb24563e34160";//网易云信分配的账号
    private static final String APP_SECRET="818942ff3fac";//网易云信分配的密钥
    private static final String NONCE="123456";//随机数


    /**
     * 发送手机验证码
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/sendMsg"})
    @ResponseBody
    public String sendMsg(String phone,String template) throws IOException {
        String mobile = phone;                    // 目标手机号码
        String templateid = template;              // 短信模板

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);

        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum= CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);//得到 发送验证码必须的参数checkSum

        //设置请求的header
        post.addHeader("AppKey",APP_KEY);
        post.addHeader("Nonce",NONCE);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        //设置请求参数
        List<NameValuePair> nameValuePairs =new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("mobile",mobile));
        nameValuePairs.add(new BasicNameValuePair("templateid", templateid));

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

        //执行请求
        HttpResponse response=httpclient.execute(post);
        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("验证码："+responseEntity);
        //判断是否发送成功，发送成功返回true
        JSONObject jsonStr= JSON.parseObject(responseEntity);
        logger.info("service:【appMsgCode】 function：【sendMsg】 phone:【"+mobile+"】 result:【"+jsonStr.toString()+"】");
        return jsonStr.toString();
    }

}
