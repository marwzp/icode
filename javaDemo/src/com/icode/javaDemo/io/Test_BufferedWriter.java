
package com.icode.javaDemo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 测试写入字符缓冲流
 * TODO javadoc for com.icode.javaDemo.io.Test_BufferedWriter
 */
public class Test_BufferedWriter {

	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("D:\\eking_project\\maven\\javaDemo\\src\\com\\icode\\javaDemo\\io\\Buffered.txt");
            //fw.write("hello");	
            //fw.close();
			/** 
	         * 为了提高写入的效率，使用了字符流的缓冲区。 
	         * 创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联。 
	         */
			BufferedWriter bufw = new BufferedWriter(fw);
			//使用缓冲区中的方法将数据写入到缓冲区中。
			bufw.write("hello world!");
			bufw.newLine();
			bufw.newLine();
			bufw.write("!hello world !");  
	        bufw.write("!hello world !");
	        //使用缓冲区中的方法，将数据刷新到目的地文件中去。  
	        bufw.flush();
	        bufw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

