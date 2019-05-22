package cn.com.chnsys.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * @Class: HelloJob
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-05-21 10:48
 */
public class HelloJob implements Job {

    private Float  FloatJobValue;

    public Float getFloatJobValue() {
        return FloatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        FloatJobValue = floatJobValue;
    }

    //通过JobExcutionContext 获取jobDetail和Trigger的信息
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //打印当前的执行时间 格式为2017-01-01  00：00：00
        //编写具体的业务逻辑



//        Date date = new Date();
//        SimpleDateFormat sc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1 = sc.format(date);
//        System.out.println("Current Exec Time Id"+date1);
//       // System.out.println("Hello World");
//
//        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
//        System.out.println("My Name and Group is --- "+jobKey.getName()+":"+jobKey.getGroup());
//
//        TriggerKey trigger = jobExecutionContext.getTrigger().getKey();
//        System.out.println(" My Trigger Name and Group is --"+trigger.getName()+":"+jobKey.getGroup());
//
//
//
//        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        JobDataMap dataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
//        //第一种获取HelloScheduler的参数
//        String msg = dataMap.getString("message");
//        //Float FloatValue = dataMap.getFloat("FloatJobValue");
//        String triggerMessage = dataMap1.getString("message");
//        Double sdf = dataMap1.getDouble("DoubleTriggerValue");
//       // System.out.println(msg+"---"+FloatValue+"---"+triggerMessage+"---"+sdf);
//
//        //第二种方式，用getset方法，获取HelloScheduler的参数
//        System.out.println("------"+FloatJobValue);

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String teime = sf.format(date);
        System.out.println("the current time is " + teime);
        System.out.println("hello World");
    }
}
