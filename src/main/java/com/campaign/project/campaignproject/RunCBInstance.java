package com.campaign.project.campaignproject;

import com.campaign.project.campaignproject.service.CampaignService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class RunCBInstance {

    public static void main(String[] args) {
        SpringApplication.run(RunCBInstance.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            CampaignService campaignService = ctx.getBean(CampaignService.class);

            LocalDate date = LocalDate.now().minusDays(1); // Fecha por defecto: ayer
            if (args.length > 0) {
                date = LocalDate.parse(args[0]);
            }

            campaignService.processDailyVisitCampaign(date);
            System.out.println("Daily visit campaign processed for date: " + date);
        };
    }
}
