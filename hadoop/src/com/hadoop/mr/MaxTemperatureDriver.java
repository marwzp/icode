
package com.hadoop.mr;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


/**
 * 最高气温驱动类，用于测试
 * TODO javadoc for com.hadoop.mr.MaxTemperatureDriver
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年11月8日
 */
public class MaxTemperatureDriver extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		
		if(args.length != 2){
			System.err.printf("Usage: %s [generic options] <input> <output>\n", 
					getClass().getSimpleName());
			ToolRunner.printGenericCommandUsage(System.err);
			return -1;
		}
		
		JobConf conf = new JobConf(getConf(),getClass());
		conf.setJobName("Max temperature");
		
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		conf.setMapperClass(MaxTemperatureMapper.class);
		conf.setCombinerClass(MaxTemperatureReduce.class);
		conf.setReducerClass(MaxTemperatureReduce.class);
		
		//运行作业
		JobClient.runJob(conf);
		return 0;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		int exitCode = ToolRunner.run(new MaxTemperatureDriver(), args);
		
		System.exit(exitCode);
	}

}

