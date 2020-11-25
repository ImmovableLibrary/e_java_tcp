package pers.xiaolz.Functions;

import com.alibaba.fastjson.JSONObject;
import pers.xiaolz.Dto.*;
import pers.xiaolz.Utils.*;

import java.awt.*;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * File: ImageFunction
 * Description:
 * Date: 2020-11-20 15:59
 *
 * @Author: 毛豪峰
 */
public class ImageFunction {
    public static void random(long selfQQ,long fromGroup,int type){
        try {
            String url = "https://api.yimian.xyz/img";
            switch (type){
                case 0:
                    break;
                case 1:
                    url += "?type=moe";
                    break;
                case 2:
                    url += "?type=wallpaper";
                    break;
                case 3:
                    url += "?type=head";
                    break;
                case 4:
                    url += "?type=koino";
                default:
                    break;
            }
            InputStream inputStream = HttpClient.getInputStream(url);
            String filePath = ImageUtils.saveImageToLocal(inputStream);
            if("文件下载失败".equals(filePath)){
                Core.sendGroupMessages(selfQQ, fromGroup, filePath, 0);
            }else{
                //读取文件
                byte[] bts = StringUtils.readFile(filePath);
                //字节数组转Base64
                String base64Str = Base64.getEncoder().encodeToString(bts);
                //组装图片的格式
                base64Str = "[pic:"+ base64Str + "]";
                Core.sendGroupMessagesPicText(selfQQ, fromGroup, base64Str,0);
            }
        } catch (Exception e) {
            System.out.println("ImageFunction.random:"+e);
        }
    }
}
