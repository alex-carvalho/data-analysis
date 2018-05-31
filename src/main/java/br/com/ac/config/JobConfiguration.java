package br.com.ac.config;

import br.com.ac.processor.FileProcessorJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alex Carvalho
 */
@Configuration
public class JobConfiguration {

    @Value("${app.job.interval}")
    private Integer interval;

    @Bean
    public JobDetail sampleJobDetail() {
        return JobBuilder.newJob(FileProcessorJob.class)
                .withIdentity("fileProcessorJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger sampleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(interval)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(sampleJobDetail())
                .withIdentity("fileProcessorTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
