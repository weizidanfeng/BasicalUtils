package com.mute.forfun.main;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.mute.forfun.utils.AnimatedGifEncoder;
import com.mute.forfun.utils.GifUtil;

public class GifTester {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
	if(false) {	
		BufferedImage src[] = new BufferedImage[3];
		src[0] = ImageIO.read(new File("test1.jpg"));
		src[1] = ImageIO.read(new File("test2.jpg"));
		src[2] = ImageIO.read(new File("test3.jpg"));
		
		
		
	     AnimatedGifEncoder e = new AnimatedGifEncoder();
	     e.setRepeat(0);
	     e.start("test.gif");
	     e.setDelay(100);   // 1 frame per sec
	     e.addFrame(src[0]);
	     e.addFrame(src[1]);
	     e.addFrame(src[2]);
	     e.finish();
	}else {
		String names= "花姐,F大,D太,兔兔,吞仔,らù,影子,晓晓,女大生X,女大生Y,女大生W,女大生Z";
		
		String[] list = names.split(",");
		BufferedImage src[] = new BufferedImage[list.length];
	     AnimatedGifEncoder e = new AnimatedGifEncoder();
	     e.setRepeat(0);
	     e.start("tuoLeg.gif");
	     e.setDelay(100);   // 1 frame per sec
		for(int i=0;i<list.length;i++) {
			GifUtil.addStrToJPG(list[i], null,i);
			src[i]=ImageIO.read(new File("tuo"+i+".jpg"));
			e.addFrame(src[i]);
		}
		 e.finish();
		
		
		
		
		
	}

	}

}
