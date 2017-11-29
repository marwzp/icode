
package com.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * 数据排序
 * TODO javadoc for com.hadoop.mr.Sort
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年10月27日
 */
public class Sort {

	//map 将输入中的 value 化成 IntWritable 类型，作为输出的 key
	public static class Map extends Mapper<Object, Text, IntWritable, IntWritable> {

		//数据
		private static IntWritable data = new IntWritable();

		//实现 map 函数
		@Override
		protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

			String line = value.toString();

			data.set(Integer.parseInt(line));

			context.write(data, new IntWritable(1));

		}
	}

	//reduce 将输入中的 key 复制到输出数据的 key 上，
	//然后根据输入的 value-list 中元素的个数决定 key 的输出次数
	//用全局 linenum 来代表 key 的位次
	public static class Reduce extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

		private static IntWritable linenum = new IntWritable(1);

		//实现 reduce 函数
		@Override
		public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

			for (IntWritable val : values) {
				context.write(linenum, key);
				linenum = new IntWritable(linenum.get() + 1);
			}

		}

	}
	
	
	public static void main(String[] args) throws Exception{
		
		Configuration conf = new Configuration();
		
		conf.set("mapred.job.tracker", "192.168.200.4:9001");
		
		String[] ioArgs = new String[]{"sort_in","sort_out"};
		
		String[] otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
		
		if(otherArgs.length != 2){
			System.err.println("Usage: Data Sort <in> <out>");
			System.exit(2);
		}
		
		Job job = new Job(conf,"Data Sort");
		
		job.setJarByClass(Sort.class);
		
		//设置 Map 和 Reduce 处理类
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		//设置输出类型
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		//设置输出路径
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
