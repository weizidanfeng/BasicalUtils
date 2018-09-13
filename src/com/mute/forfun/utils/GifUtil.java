package com.mute.forfun.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class GifUtil {
	
	public static void addStrToJPG(String str,String sourceFile,int outputNum)throws Exception{
		 File srcImgFile = new File("tuo.jpg");//得到文件
         Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
         int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
         int srcImgHeight = srcImg.getHeight(null);//获取图片的高
         
         BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
         Graphics2D g = bufImg.createGraphics();
         g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
          //g.setFont(font);              //设置字体

         //设置水印的坐标
         g.setColor(new Color(0,0,0)); //根据图片的背景设置水印颜色
         
         g.drawString(str, 1, 10);
         g.drawString("*", 17, 53+MathUtil.randomINT(0, 3));
        
         
      
         
         g.setColor(new Color(MathUtil.randomINT(0, 255),MathUtil.randomINT(0, 255),MathUtil.randomINT(0, 255))); //根据图片的背景设置水印颜色
         g.drawString("马大", 30+MathUtil.randomINT(0, 5), 30+MathUtil.randomINT(0, 5));
         g.dispose();  
         // 输出图片  
         FileOutputStream outImgStream = new FileOutputStream("tuo"+outputNum+".jpg");  
         ImageIO.write(bufImg, "jpg", outImgStream);
         System.out.println("添加水印完成");  
         outImgStream.flush();  
         outImgStream.close();  
		
		
		
		
		
	}

}
