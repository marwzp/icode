
package com.icode.javaDemo.io;

import java.io.Console;

/**
 * Console类测试
 * TODO javadoc for com.icode.javaDemo.io.Test_Console
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年12月1日
 */
public class Test_Console {

	public static void main(String[] args) {
		Console csl = System.console();
		String userName = csl.readLine("User name:");
		csl.printf("user:"+userName+"\n");
		char[] password = csl.readPassword("password:");
		csl.printf(String.valueOf(password));
	}
	
	
}

