
package com.hadoop.mr;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 * 计算最高气温
 * TODO javadoc for com.hadoop.mr.MaxTemperature
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: wang-zepeng
 * @since: 2017年11月1日
 */
public class MaxTemperature {

	private static final int MISSING = 9999;

	public static class MaxTemperatureMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

		//实现map函数
		@Override
		public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			String line = value.toString();
			String year = line.substring(15, 19);
			int airTemprature;
			if (line.charAt(87) == '+') {
				airTemprature = Integer.parseInt(line.substring(88, 92));
			} else {
				airTemprature = Integer.parseInt(line.substring(87, 92));
			}

			String quality = line.substring(92, 93);

			if (airTemprature != MISSING && quality.matches("01459")) {
				output.collect(new Text(year), new IntWritable(airTemprature));
			}

		}

	}

	//实现reduce函数,找出每年的最高温
	public static class MaxTemperatureReduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

		@Override
		public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

			int maxValue = Integer.MAX_VALUE;

			while (values.hasNext()) {
				maxValue = Math.max(maxValue, values.next().get());
			}

			//输出值
			output.collect(key, new IntWritable(maxValue));

		}

	}

	//负责运行Map喝Reduce
	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.err.println("Usage: MaxTemperature <input path> <output path>");
			System.exit(-1);
		}

		JobConf conf = new JobConf(MaxTemperature.class);
		conf.setJobName("Max temperature");

		//设置输入输出文件夹
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));

		//设置Mapper和Reduce
		conf.setMapperClass(MaxTemperatureMapper.class);
		conf.setReducerClass(MaxTemperatureReduce.class);

		//设置输出类型
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		//运行job
		JobClient.runJob(conf);

	}

}
