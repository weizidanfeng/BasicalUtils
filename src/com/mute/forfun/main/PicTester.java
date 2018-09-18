package com.mute.forfun.main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import com.mute.forfun.utils.AnimatedGifEncoder;
import com.mute.forfun.utils.MathUtil;

public class PicTester {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedImage src[] = new BufferedImage[3];
		src[0] = ImageIO.read(new File("test1.jpg"));
		src[1] = ImageIO.read(new File("test1.jpg"));
		src[2] = ImageIO.read(new File("test1.jpg"));
		BufferedImage target[] = new BufferedImage[3];
		for(int i=0;i<src.length;i++ ) {
			target[i]  = src[i];
			
			 int green=0,red=0,blue=0,rgb;  
		        int imageWidth = src[i].getWidth();  
		        int imageHeight = src[i].getHeight();  
		        for(int k = src[i].getMinX();k < imageWidth ;k++)  
		            {  
		                for(int j = src[i].getMinY();j < imageHeight ;j++)  
		                {  
		//图片的像素点其实是个矩阵，这里利用两个for循环来对每个像素进行操作  
		                    Object data = src[i].getRaster().getDataElements(k, j, null);//获取该点像素，并以object类型表示  
		                    red = src[i].getColorModel().getRed(data);  
		                    blue = src[i].getColorModel().getBlue(data);  
		                    green = src[i].getColorModel().getGreen(data);  
		                    red = (red*3 + green*6 + blue*1)/10;  
		                    green = red;  
		                    blue = green;  
		/* 
		这里将r、g、b再转化为rgb值，因为bufferedImage没有提供设置单个颜色的方法，只能设置rgb。rgb最大为8388608，当大于这个值时，应减去255*255*255即16777216 
		*/  
		                    rgb = ((red)*256 + green)*256+blue;  
		                    if(rgb>8388608)  
		                    {  
		                        rgb = rgb - 16777216;  
		                    }  
		//将rgb值写回图片  
		    target[i].setRGB(k, j, rgb);  
		                }  
		                  
		            }  

			
		}
		
		
	     AnimatedGifEncoder e = new AnimatedGifEncoder();
	     e.setRepeat(0);
	     e.start("test2.gif");
	     e.setDelay(100);   // 1 frame per sec
	     e.addFrame(target[0]);
	     e.addFrame(target[1]);
	     e.addFrame(target[2]);
	     e.finish();

	}

}
