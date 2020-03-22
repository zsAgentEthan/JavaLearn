package com.ethan.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class MyCharIOStudy {

	public static void main(String[] args) {
		MyCharIOStudy myCharIOStudy = new MyCharIOStudy();
		myCharIOStudy.useInputStreamReader();

		System.out.println("--------------");

		myCharIOStudy.useFileReader();
		System.out.println("--------------");
		myCharIOStudy.useBufferedReader();

		myCharIOStudy.useOutputWriter();
		myCharIOStudy.useFileWriter();
		myCharIOStudy.useBufferedWriter();
	}

	/**
	 * 利用字符流读取文件中的内容
	 */
	public void useInputStreamReader() {

		try {
			InputStreamReader isr = new InputStreamReader(
					new FileInputStream(new File("E:\\JavaLearn\\streamTest.txt")), "UTF-8");
			int ch;
			while ((ch = isr.read()) != -1) {
				System.out.println((char) ch);
			}
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 利用FileReader读取文件内容
	 */
	public void useFileReader() {

		try {
			FileReader fr = new FileReader("E:\\JavaLearn\\streamTest.txt");
			char[] buff = new char[1024];
			int len;
			while ((len = fr.read(buff)) != -1) {
				System.out.println(new String(buff, 0, len));
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 利用BufferedRead读取文件内容
	 * 
	 */
	public void useBufferedReader() {

		try {
			FileReader fr = new FileReader("E:\\JavaLearn\\streamTest.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			fr.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 利用字符流输出内容到文件
	 */
	public void useOutputWriter() {

		File file = new File("output/writerTest.txt");

		try {
			OutputStream os = new FileOutputStream(file,true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write("利用字符流输出内容到文件" + "\n");
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 利用FileWriter输出内容到文件
	 */
	public void useFileWriter() {

		File file = new File("output/writerTest.txt");

		try {
			FileWriter fw = new FileWriter(file,true);
			fw.write("利用FileWriter写出" + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 利用BufferedWriter写内容到文件
	 */
	public void useBufferedWriter() {
		
		File file = new File("output/writerTest.txt");

		try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write("利用BufferedWriter写出" + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
