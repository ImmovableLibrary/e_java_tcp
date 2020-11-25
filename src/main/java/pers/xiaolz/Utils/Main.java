package pers.xiaolz.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pers.xiaolz.Functions.ImageFunction;
import pers.xiaolz.Functions.WOWSFunction;

import java.util.Base64;

/**
 * 主要类
 * @author zhaoqk
 *
 * 2020年8月10日 下午5:07:37
 */
public class Main {
	
	
	
	/**
	 * 程序简介
	 * 1.如果我需要的事件下面没有怎么办？
	 * 答：作者是采集了一些常用的如果你需要其他事件 比如 好友更改签名  
	 * 	     那你就启动项目 用机器人号的好友改一下签名 就会收到改签名的消息 看看msgType是对多少然后下面加个判断就行了。
	 * 2.如果我需要的API操作Core中没有怎么办？
	 * 答：如果你具备易语言开发能力请下载TcpAPI的源码然后按照格式增加一个API然后在Core中也增加一个对应的就可以了
	 *    如果你不具备易语言开发能力请加群742830386向我反映你需要的API 我会在更新时一块加上
	 * 3.你的插件不收费还开源为了什么？
	 * 答：这个东西对于我来说很简单，本来打算做一个自己玩玩然后越做越完善于是就开源大家一起玩
	 *    开源是因为我的维护时间不多你需要的可能我无法帮你完善，所以我开个头 你们 尽情发挥^_^
	 */
	
	static ChatClient clientTest;
	
	public static void main(String[] args) {
		clientTest = new ChatClient("120.26.234.98", 8404);
	    clientTest.start();
	} 

	/**
	 * 收到好友消息与事件
	 * @param data
	 */
	public static void receivePrivateMessages(String data){
		System.out.println("[收到好友消息]" + data);
		JSONObject json = JSONObject.parseObject(data);
		long selfQQ = json.getInteger("selfQQ");//框架QQ
		long fromQQ = json.getInteger("fromQQ");//对方QQ
		long random = json.getInteger("random");//撤回消息用
		long req = json.getInteger("req");//撤回消息用
		String msg = json.getString("msg");//消息内容
		long msgType = json.getInteger("msgType");//消息类型
		long msgType2 = json.getInteger("msgType2");//消息类型
		if(msgType == 141){//公众号消息
			
		}else if(msgType == 87){//好友邀请入群
			
		}else if(msgType == 528){//申请加为好友
			
		}else if(msgType == 529){//好友文件消息
			
		}else if(msgType == 208){//好友语音消息
			
		}else if(msgType == 87){//好友邀请入群
			
		}else if(msgType == 166){//普通好友消息
			if(msg.equals("点赞")){
				Core.callpPraise(selfQQ,fromQQ,10);
			}else if(msg.equals("来个红包")){
				Core.pushRedPacket(selfQQ,fromQQ,1,1,"好的大哥","支付密码");//如果发送不成功请登录机器人号确保可以正常发红包
			}else if(msg.equals("图文")){
				byte[] bts = StringUtils.readFile("D:\\1.png");//读取文件
				String base64Str = Base64.getEncoder().encodeToString(bts);//字节数组转Base64
				base64Str = "[pic:"+ base64Str + "]";//组装图片的格式
				Core.sendPrivateMessagesPicText(selfQQ, fromQQ, base64Str + "111" + base64Str, random, req);
			}else if(msg.equals("好友列表")){
				Core.friendsList(selfQQ);
			}else if(msg.equals("群列表")){
				Core.groupList(selfQQ);
			}else if(msg.equals("插件数据目录")){
				Core.selectPluginPath();
			}else if(msg.indexOf("输出日志") == 0){
				String log = msg.substring(msg.indexOf("输出日志") + 4);//取出右边要踢的QQ
				Core.outputLog(log, 0, 16777215);
			}else {
				Core.sendPrivateMessages(selfQQ, fromQQ, msg, random, req);
			}
		}
		
		//红包发送成功  "msgType":141,"msgType2":134,"msgTempType":129
		//87	好友邀请入群
		//528	申请加为好友
		//166	收到好友红包
	}
	/**
	 * 收到群聊消息
	 * @param data
	 */
	public static void receiveGroupMessages(String data){
	    try{
            System.out.println("[收到群聊消息]" + data);
            JSONObject json = JSONObject.parseObject(data);
            long selfQQ = json.getInteger("selfQQ");//框架QQ
            long fromGroup = json.getInteger("fromGroup");//群号
            long fromQQ = json.getInteger("fromQQ");//对方QQ
            String msg = json.getString("msg").trim();//消息内容
            //这里我写了一些常用指令
//		if(msg.indexOf("改名片") == 0){//默认改自己的 如  改名片404
//			String cardName = msg.substring(msg.indexOf("改名片") + 3);//取出右边的名片
//			Core.setGroupCardName(selfQQ, fromGroup, fromQQ, cardName);
//		}else if(msg.indexOf("踢") == 0){//右边需要加上要踢的QQ 如 踢123456
//			String otherQQ = msg.substring(msg.indexOf("踢") + 1);//取出右边要踢的QQ
//			Core.delGroupMember(selfQQ, fromGroup, Integer.valueOf(otherQQ), 0);
//		}else if(msg.indexOf("禁言") == 0){//右边需要加上要禁言的QQ 如 禁言123456
//			String otherQQ = msg.substring(msg.indexOf("禁言") + 2);//取出右边要禁言的QQ
//			Core.prohibitSpeak(selfQQ, fromGroup, Integer.valueOf(otherQQ), 60);
//		}else if(msg.equals("图文")){
//			byte[] bts = StringUtils.readFile("D:\\1.png");//读取文件
//			String base64Str = Base64.getEncoder().encodeToString(bts);//字节数组转Base64
//			base64Str = "[pic:"+ base64Str + "]";//组装图片的格式
//			Core.sendGroupMessagesPicText(selfQQ, fromGroup, base64Str + "111" + base64Str,0);
//		}else if(msg.equals("来个红包")){
//			Core.pushRedPacketGroup(selfQQ,fromGroup,1,1,"好的大哥","支付密码");//如果发送不成功请登录机器人号确保可以正常发红包
//		}else if(msg.equals("全员禁言")){
//			Core.prohibitSpeakAll(selfQQ, fromGroup, 1);
//		}else if(msg.equals("全员解禁")){
//			Core.prohibitSpeakAll(selfQQ, fromGroup, 0);
//		}else if(msg.equals("群信息")){
//			Core.selectGroupInfo(selfQQ, fromGroup);
//		}else if(fromGroup == 742830386){//除了以上三个指令 其他的都原样返回  这里的群号需要改成你的测试群
//			Core.sendGroupMessages(selfQQ, fromGroup, msg, 0);
//		}
            if(fromQQ==2795645176L){
//                msg = "@2795645176"+msg;
                Core.sendGroupMessages(selfQQ, fromGroup, msg, 0);
            }
            if(msg.startsWith(".战绩查询")){
                WOWSFunction.selectPersonData(msg,selfQQ,fromGroup);
            }
            if(msg.startsWith(".随机")){
                int type = 0;
                if(msg.contains("二次元")){
                    type = 1;
                }else if (msg.contains("壁纸")){
                    type = 2;
                }else if (msg.contains("头像")){
                    type = 3;
                }else if(msg.contains("幼犬")){
                    type = 4;
                }
                ImageFunction.random(selfQQ,fromGroup,type);
            }
            //134	上传群文件
        }catch (Exception e){

        }
	}
	
	/**
	 * 收到事件消息
	 * @param data
	 */
	public static void receiveEventMessages(String data){
		System.out.println("[收到事件消息]" + data);
		JSONObject json = JSONObject.parseObject(data);
		long selfQQ = json.getInteger("selfQQ");//框架QQ
		long fromGroup = json.getInteger("fromGroup");//群号
		int msgType = json.getInteger("msgType");//类型
		long triggerQQ = json.getInteger("triggerQQ");//对方QQ
		//String triggerQQName = json.getString("triggerQQName");//对方昵称
		long seq = json.getLongValue("seq");//操作用
		
		//32表示QQ上线
		//17表示好友更改昵称
		//25表示邀请加入了群聊
		if(msgType == 3){//群验证事件 申请入群
			Core.handleGroupEvent(selfQQ, fromGroup, triggerQQ, seq, 11, 3);
		}else if(msgType == 20){//申请加为好友
			Core.handlePrivateEvent(selfQQ, triggerQQ, seq, 1);
		}else if(msgType == 19){//有新好友
			Core.sendPrivateMessages(selfQQ, triggerQQ, "哈喽", 0, 0);
		}else if(msgType == 23){
			Core.callpPraise(selfQQ,triggerQQ,10);
		}
	}
	
	/**
	 * 收到查询返回
	 * @param data
	 */
	public static void selectResult(String data){
		System.out.println("[收到查询返回]" + data);
		JSONObject json = JSONObject.parseObject(data);
		//long selfQQ = json.getInteger("selfQQ");//框架QQ
		int msgType = json.getInteger("msgType");//类型
		if(msgType == 107){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[好友列表返回]" + list.size());
		}else if(msgType == 109){
			JSONObject userInfo = json.getJSONObject("info");
			System.out.println("[好友信息返回]" + JSONObject.toJSONString(userInfo));
		}else if(msgType == 212){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[群聊列表返回]" + list.size());
		}else if(msgType == 213){
			JSONObject groupInfo = json.getJSONObject("info");
			System.out.println("[群聊信息返回]" + JSONObject.toJSONString(groupInfo));
		}else if(msgType == 302){
			String path = json.getString("path");
			System.out.println("[插件路径返回]" + path);
		}
	}
}
