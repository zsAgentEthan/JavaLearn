package com.ethan.study;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流IO
 * @author Ethan
 *
 */
public class MyByteIOStudy {

	public static void main(String[] args) {

		MyByteIOStudy myByteIOStudy = new MyByteIOStudy();
		myByteIOStudy.useFileInputStream();
		System.out.println("-------");
		myByteIOStudy.useBufferedInputStream();
		
		myByteIOStudy.useOutputStream();
		myByteIOStudy.useBufferedOutputStream();
	}
	
	/**
	 * 用字节文件流读取文件
	 */
	public void useFileInputStream() {
		try {
			FileInputStream fis = new FileInputStream(new File("E:\\JavaLearn\\streamTest.txt"));
			byte[] buff = new byte[1024];
			int length;
			// 
			while((length = fis.read(buff)) != -1) {
				System.out.println("带缓冲区字节文件输入流：" + new String(buff, "UTF-8"));
			}
			// 
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  用带缓冲区的字节文件流读取文件
	 */
	public void useBufferedInputStream() {
		try {
			FileInputStream fis = new FileInputStream(new File("E:\\JavaLearn\\streamTest.txt"));
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			byte[] buff = new byte[1024];
			int length;
			// 
			while((length = bis.read(buff)) != -1) {
				System.out.println("带缓冲区字节文件输入流：" + new String(buff,0,length));
			}
			bis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 利用字节文件流输出
	 */
	public void useOutputStream() {
		
		File file = new File("E:\\JavaLearn\\outStreamTest.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fos = new FileOutputStream(file,true);   // true:代表追加
			fos.write("zi jie liu shu chu:".getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 利用带缓冲区字节文件流输出
	 */
	public void useBufferedOutputStream() {
		File file = new File("E:\\JavaLearn\\outStreamTest.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write("dai huan chong zi jie liu shu chu 中文:".getBytes());
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
