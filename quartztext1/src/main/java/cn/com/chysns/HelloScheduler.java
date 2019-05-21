package cn.com.chysns;

import cn.com.chysns.job.HelloJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Class: HelloScheduler
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-05-21 10:56
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        //创建一个jobDetail实例，将该实例与HelloJob绑定
        //.usingJobDate  传递自定义参数 可以在jobDetail和Trigger中添加，在job中接收这些参数
        JobDetail jobDetail = JobBuilder.
                newJob(HelloJob.class).
                withIdentity("myJob","group1").usingJobData("message","hello myjob1").
                usingJobData("FloatJobValue",3.14F).
                build();

        System.out.println("jobDetail's  name---"+jobDetail.getKey().getName());
        System.out.println("jobDetail's  group---"+jobDetail.getKey().getGroup());
        System.out.println("jobDetail's  group---"+jobDetail.getJobClass().getClass());

        //创建要给Trigger实例。触发job取执行，怎么执行  本次定义job立即执，每隔两秒执行一次
        Trigger trigger = TriggerBuilder.
                newTrigger().
                withIdentity("myTrigger","groupq1").
                usingJobData("message","hello myTrriger1").
                usingJobData("DoubleTriggerValue",2.0D).
                startNow().
                withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).
                build();

        //创建Scheduler实例  通过Factory创建
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

        //
        Date date = new Date();
        SimpleDateFormat sc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sc.format(date);
        System.out.println("Current Time is ===="+date1);





    }

}
