package pers.xiaolz.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * File: ImageUtils
 * Description:
 * Date: 2020-11-20 16:38
 *
 * @Author: 毛豪峰
 */
public class ImageUtils {
    /**
     * 根据str,font的样式等生成图片
     * https://blog.csdn.net/sinat_28505133/article/details/54669111
     *
     * @param strArr
     * @param font
     * @param width
     * @param image_height
     * @throws Exception
     */
    public static String createImage(String[] strArr, Font font, int width, int image_height, int every_line, int line_height, long fromQQ) throws Exception {

        FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
        int stringWidth = fm.charWidth('1');// 标点符号也算一个字
        int line_string_num = width % stringWidth == 0 ? (width / stringWidth) : (width / stringWidth) + 1;
        System.out.println("每行=" + line_string_num);

        List<String> listStr = new ArrayList<String>();
        List<String> newList = new ArrayList<String>();
        for (int h = 0; h < strArr.length; h++) {
            listStr.add(strArr[h]);
        }
        for (int j = 0; j < listStr.size(); j++) {
            if( listStr.get(j).length() > line_string_num){
                newList.add(listStr.get(j).substring(0,line_string_num));
                listStr.add(j+1,listStr.get(j).substring(line_string_num));
                listStr.set(j,listStr.get(j).substring(0,line_string_num));
            }else{
                newList.add(listStr.get(j));
            }
        }

        int a = newList.size();
        int b = every_line;
        int imgNum = a % b == 0 ? (a / b) : (a / b) + 1;

        for (int m = 0; m < imgNum; m++) {
            Long timestamp = System.currentTimeMillis();
            String filePath = "C:\\Users\\Administrator\\Desktop\\wows\\" + fromQQ + "-" + timestamp + "-" + m + ".jpg";
            File outFile = new File(filePath);
            // 创建图片
            BufferedImage image = new BufferedImage(width, image_height,
                    BufferedImage.TYPE_INT_BGR);
            Graphics g = image.getGraphics();
            g.setClip(0, 0, width, image_height);
            g.setColor(Color.white); // 背景色白色
            g.fillRect(0, 0, width, image_height);
            g.setColor(Color.black);//  字体颜色黑色
            g.setFont(font);// 设置画笔字体
            // 每张多少行，当到最后一张时判断是否填充满
            for (int i = 0; i < every_line; i++) {
                int index = i + m * every_line;
                if (newList.size() - 1 >= index) {
//                    System.out.println("每行实际=" + newList.get(index).length());
                    g.drawString(newList.get(index), 0, line_height * (i + 1));
                }
            }
            g.dispose();
            ImageIO.write(image, "jpg", outFile);
            return filePath;
        }
        return null;
    }

    public static String saveImageToLocal(InputStream inputStream) {
        byte[] data = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = null;
        Random random=new Random();
        String filePath = "C:\\Users\\ImmovableLibrary\\Desktop\\picture\\"+System.currentTimeMillis()+random.nextInt(10)+".jpg";
        try {
            fileOutputStream = new FileOutputStream(filePath);
            while ((len = inputStream.read(data)) != -1) {
                fileOutputStream.write(data, 0, len);
            }
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            return "文件下载失败";
        } finally {
            if (inputStream != null) {
                try {
//                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
//                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
