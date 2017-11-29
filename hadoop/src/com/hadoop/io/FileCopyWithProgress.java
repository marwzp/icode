
package com.hadoop.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

/**
 * 本地文件复制到Hadoop文件系统
 * TODO javadoc for com.hadoop.io.FileCopyWithProgress
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年11月6日
 */
public class FileCopyWithProgress {

	public static void main(String[] args) throws Exception{
		
		//本地路径
		String localSrc = args[0];
		
		//目标路径
		String dst = args[1];
		
		//根据路径，获取本地系统文件
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		
		Configuration conf = new Configuration();
		
		FileSystem fs = FileSystem.get(URI.create(dst),conf);
		
		fs.create(new Path(dst), new Progressable() {
			@Override
			public void progress() {
			   System.out.println(".");	
			}
		});
		
		IOUtils.copyBytes(in, System.out, conf, true);

	}

}

