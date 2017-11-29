
package com.hadoop.io;

import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * hadoop 文件操作
 * TODO javadoc for com.hadoop.io.FileSystemCat
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年11月6日
 */
public class FileSystemCat {

	public static void main(String[] args) throws Exception {

		//文件路径
		String uri = args[0];
		//配置对象
		Configuration conf = new Configuration();
		//文件系统
		FileSystem fs = FileSystem.get(URI.create(uri), conf);

		InputStream in = null;

		try {
			//打开文件，获取数据流
			in = fs.open(new Path(uri));
			//复制文件
			IOUtils.copyBytes(in, System.out, 4096, false);
			
			
		} finally {
			IOUtils.closeStream(in);
		}

	}

}
