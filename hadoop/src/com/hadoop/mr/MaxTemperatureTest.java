
package com.hadoop.mr;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;
import org.junit.Test;


public class MaxTemperatureTest {

	@Test
	public void test() throws Exception{
		
		
		JobConf conf = new JobConf();
		
		conf.set("fs.default.name","file:///");
		
		conf.set("mapred.job.tracker", "local");
		
		Path input = new Path("input/ncdc/micro");
		
		Path output = new Path("output");
		
		FileSystem fs = FileSystem.getLocal(conf);
		
		fs.delete(output, true);//删除旧的文件夹
		
		MaxTemperatureDriver driver = new MaxTemperatureDriver();
		
		driver.setConf(conf);
		
		int exitCode = driver.run(new String[]{input.toString(),output.toString()});
		
	}

}

