/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import VO.DataBase;
import java.sql.Connection;
import models.ConnectionToDB;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import views.MainView;

/**
 *
 * @author Jarvis
 */
public class MainController {
    
    private ConnectionToDB connectionToDB = null;

    public void startSystem() {
        MainView mainView = new MainView();
        mainView.setVisible(true);
        //this.trigger();
    }

    public Connection addConfigDataBase(DataBase dataBase) {
        this.connectionToDB = new ConnectionToDB(dataBase);
        return this.connectionToDB.getConnection();
    }
    
    public void trigger(){
        try {
        JobDetail job1 = JobBuilder.newJob(CheckConnection.class)
                        .withIdentity("job1", "group1").build();

        Trigger trigger1 = TriggerBuilder.newTrigger()
                        .withIdentity("cronTrigger1", "group1")
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                        .build();

        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        scheduler1.start();
        scheduler1.scheduleJob(job1, trigger1);



        Thread.sleep(100000);

        scheduler1.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
