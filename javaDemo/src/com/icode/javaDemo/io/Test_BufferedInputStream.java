
package com.icode.javaDemo.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 测试BufferedInputStream
 * BufferedInputStream 是缓冲输入流。它继承于FilterInputStream
 * TODO javadoc for com.icode.javaDemo.io.Test_BufferedInputStream
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年12月1日
 */
public class Test_BufferedInputStream {

	private final static int LEN = 5;

	public static void main(String[] args) {
		testBufferedInputStream();
	}

	/**
	 * 测试BufferedInputStream
	 * @description: TODO
	 * @creator: wang-zepeng
	 * @createDate: 2017年12月1日 
	 * @modifier:
	 * @modifiedDate:
	 */
	private static void testBufferedInputStream() {

		try {
			File file = new File("D:\\eking_project\\maven\\javaDemo\\src\\com\\icode\\javaDemo\\io\\bufferedinputstream.txt");
			InputStream input = new BufferedInputStream(new FileInputStream(file), 512);
			// 从字节流中读取5个字节。“abcde”，a对应0x61，b对应0x62，依次类推...
			for (int i = 0; i < LEN; i++) {
				//若能继续读取下一个字节，则读取下一个字节
				if (input.available() >= 0) {
					int tmp = input.read();
					System.out.printf("%d : 0x%s\n", i, Integer.toHexString(tmp));
				}
			}

			//如果该字节流不支持标记功能，则直接退出
			if (!input.markSupported()) {
				System.out.println("mark not supported!");
				return;
			}
			
			// 标记当前索引位置，即标记第6个位置的元素--"f"
            input.mark(1024);
            
            // 跳过22个字节
            input.skip(22);
            
            // 读取5个字节
            byte[] buf = new byte[LEN];
            input.read(buf, 0, LEN);
            // 将buf转换为String字符串。
			String str1 = new String(buf);
			System.out.printf("str1=%s\n", str1);
            
			// 重置"输入流的索引"为mark()所标记的位置，即重置到"f"处。
			input.reset();
			// 从“重置后的字节流”中读取5个字节到buf中。即读取“fghij”
		    input.read(buf, 0, LEN);
		    // 将buf转换为String字符串。
		    String str2 = new String(buf);
		    System.out.printf("str2=%s\n", str2);
		    
		    input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
