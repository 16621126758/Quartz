package cn.com.chnsys;

import cn.com.chnsys.job.HelloJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
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
                withIdentity("myJob","group1").
                build();

        //每秒钟触发一次任务
        CronTrigger trigger =(CronTrigger) TriggerBuilder.
                newTrigger().
                withIdentity("myTrigger","groupq1").
               // withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).
                  //?代表没有用   *代表每的意思   每秒
                withSchedule(CronScheduleBuilder.cronSchedule("0 20 16 * * ? 2019")).
                build();

        //2017年内每天十点十五分触发一次
        //0 20 16 * * * 2019
        //每天14点整至14点59分55秒，以及18点整至18点59分59秒   每五秒触发一次
        //0/5 * 14,18 * * ?
        //每月周一至周五的10点15分触发一次
        //0 15 10 ? * 1-5


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
