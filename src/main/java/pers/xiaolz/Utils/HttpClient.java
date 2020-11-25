package pers.xiaolz.Utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * File: HttpClient
 * Description:
 * Date: 2020-04-03 10:52
 *
 * @Author: 毛豪峰
 */
public class HttpClient {
    public JSONObject doPost(String url, HttpHeaders headers, Object body){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(body,headers);

        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST,httpEntity,String.class);
        JSONObject responseBody = JSONObject.parseObject(response.getBody());
        System.out.println(responseBody.toJSONString());
        return responseBody;
    }

    @RequestMapping(method = RequestMethod.POST)
    public static JSONObject doPostStatic(String url, HttpHeaders headers, Object body){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(body,headers);

        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST,httpEntity,String.class);
        JSONObject responseBody = JSONObject.parseObject(response.getBody());
        System.out.println(responseBody.toJSONString());
        return responseBody;
    }

    @RequestMapping(method = RequestMethod.GET)
    public static JSONObject doGet(String url, Map<String,Object> param){
        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject(url, String.class,param);
        return JSONObject.parseObject(jsonStr);
    }

    @RequestMapping(method = RequestMethod.GET)
    public static JSONObject get(String url, Object object) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        StringBuffer stringBuffer = new StringBuffer(url);
        if (object instanceof Map) {
            Iterator iterator = ((Map) object).entrySet().iterator();
            if (iterator.hasNext()) {
                stringBuffer.append("?");
                Object element;
                while (iterator.hasNext()) {
                    element = iterator.next();
                    Map.Entry<String, Object> entry = (Map.Entry) element;
                    //过滤value为null，value为null时进行拼接字符串会变成 "null"字符串
                    if (entry.getValue() != null) {
                        stringBuffer.append(element).append("&");
                    }
                    url = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
            }
        } else {
            throw new RuntimeException("url请求:" + url + "请求参数有误不是map类型");
        }
        System.out.println(url);
        String jsonStr = restTemplate.getForObject(url, String.class);
        return JSONObject.parseObject(jsonStr);
    }

    public static InputStream getInputStream(String urlstr) throws IOException {
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlstr);
            if (url != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                // 设置连接网络的超时时间
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setDoInput(true);
                // 设置本次http请求使用get方式请求
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    // 从服务器获得一个输入流
                    inputStream = httpURLConnection.getInputStream();
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return inputStream;
    }

}
