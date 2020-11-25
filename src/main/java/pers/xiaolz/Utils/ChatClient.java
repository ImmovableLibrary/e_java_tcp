package pers.xiaolz.Utils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 通信类
 * @author zhaoqk
 *
 * 2020年8月10日 下午5:07:31
 */
public class ChatClient extends Thread{

    private Socket socket = null;

    ChatClient(String host, int port) {
        try {
            //需要服务器的IP地址和端口号，才能获得正确的Socket对象
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void run() {
        super.run();
        try {
            InputStream s = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len;
            StringBuilder temp = new StringBuilder();
            while ((len = s.read(buf)) != -1) {
                String data = new String(buf, 0, len);
                temp.append(data);
                if(len < 1024){
                    parseData(temp.toString());
                    temp = new StringBuilder();
                }
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    private static void parseData(String data) {
        try {
            if("".equals(data)){
                return;
            }
            data = StringUtils.getURLDecoderString(data);
            JSONObject json = null;
            for(int i=0;i<10;i++){
                try{
                    json = JSONObject.parseObject(data);
                    break;
                }catch (Exception e) {
                    System.out.println("解析出错" + data);
                    data = data.substring(data.indexOf("}") + 1);
                }
            }
            if(json.getInteger("type") == 0){
                System.out.println("[type=0 连接成功]");
            }else if(json.getInteger("type") == 1){
                System.out.println("[type=1 好友消息]");
//            Main.receivePrivateMessages(json.toJSONString());
            }else if(json.getInteger("type") == 2){
                System.out.println("[type=2 群聊消息]");
                Main.receiveGroupMessages(json.toJSONString());
            }else if(json.getInteger("type") == 3){
                System.out.println("[type=3 事件消息]");
//            Main.receiveEventMessages(json.toJSONString());
            }else if(json.getInteger("type") == 4){
                System.out.println("[type=4 查询返回]");
//            Main.selectResult(json.toJSONString());
            }

        }catch (Exception ignored){

        }
    }


    void sendMsg(String msg){
        OutputStream os= null;
        try {
            os= socket.getOutputStream();
            os.write(msg.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ChatClient.sendMsg:"+e);
        }
    }
}

