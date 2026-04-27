package com.fsd_CSE.TnP_Connect.config;

import com.fsd_CSE.TnP_Connect.Enitities.*;
import com.fsd_CSE.TnP_Connect.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Configuration
public class DatabaseSeeder {

    @Bean
    public CommandLineRunner seedDatabase(
            TnPAdminRepository adminRepository,
            InternshipRepository internshipRepository,
            ContestRepository contestRepository,
            SessionRepository sessionRepository,
            NotificationRepository notificationRepository
    ) {
        return args -> {
            if (internshipRepository.count() == 0) {
                System.out.println("Seeding database with dummy data...");
                
                // Create Admin
                TnPAdmin admin = new TnPAdmin();
                admin.setName("Super Admin");
                admin.setEmail("admin@tcetmumbai.in");
                admin.setPasswordHash("hashedpassword");
                admin.setRole("SUPERADMIN");
                admin.setApprovalStatus("APPROVED");
                admin = adminRepository.save(admin);

                // Create Internships
                Internship internship1 = new Internship();
                internship1.setRole("Software Engineer Intern");
                internship1.setCompany("Google");
                internship1.setStipend("1,00,000 / month");
                internship1.setEligibility("B.Tech CSE/IT, CGPA > 8.0");
                internship1.setDeadline(LocalDate.now().plusDays(30));
                internship1.setDescription("Summer internship program for 3rd year students.");
                internship1.setStatus("OPEN");
                internship1.setCreatedByAdmin(admin);
                internshipRepository.save(internship1);
                
                Internship internship2 = new Internship();
                internship2.setRole("Frontend Developer");
                internship2.setCompany("Amazon");
                internship2.setStipend("80,000 / month");
                internship2.setEligibility("B.Tech, CGPA > 7.5");
                internship2.setDeadline(LocalDate.now().plusDays(15));
                internship2.setDescription("Frontend development role focusing on React and Next.js.");
                internship2.setStatus("OPEN");
                internship2.setCreatedByAdmin(admin);
                internshipRepository.save(internship2);

                // Create Contest
                Contest contest = new Contest();
                contest.setTitle("TCET Codeathon 2026");
                contest.setPlatform("HackerRank");
                contest.setContestUrl("https://hackerrank.com/tcet-codeathon");
                contest.setStartDatetime(OffsetDateTime.now().plusDays(2));
                contest.setEndDatetime(OffsetDateTime.now().plusDays(3));
                contest.setDescription("Annual coding competition for all students.");
                contest.setCreatedByAdmin(admin);
                contestRepository.save(contest);

                // Create Session
                Session session = new Session();
                session.setTitle("How to crack MAANG");
                session.setSpeaker("Sundar Pichai");
                session.setSessionDatetime(OffsetDateTime.now().plusDays(5));
                session.setJoinUrl("https://meet.google.com/xyz");
                session.setTargetBranch("ALL");
                session.setTargetYear(3);
                session.setDescription("Guest lecture on interview preparation.");
                session.setCreatedByAdmin(admin);
                sessionRepository.save(session);
                
                // Create Notification
                Notification notif = new Notification();
                notif.setTitle("Google Internship Drive");
                notif.setCategory("Placement");
                notif.setContent("Google is visiting our campus next month. Start preparing!");
                notif.setPostedByAdmin(admin);
                notif.setTargetBranch("CSE");
                notif.setTargetYear(3);
                notificationRepository.save(notif);
                
                // Add more Internships
                Internship internship3 = new Internship();
                internship3.setRole("Data Science Intern");
                internship3.setCompany("Microsoft");
                internship3.setStipend("90,000 / month");
                internship3.setEligibility("B.Tech CSE/IT/AI, CGPA > 8.5");
                internship3.setDeadline(LocalDate.now().plusDays(5));
                internship3.setDescription("Work on advanced ML models and data pipelines.");
                internship3.setStatus("OPEN");
                internship3.setCreatedByAdmin(admin);
                internshipRepository.save(internship3);
                
                Internship internship4 = new Internship();
                internship4.setRole("Backend Developer");
                internship4.setCompany("Netflix");
                internship4.setStipend("1,20,000 / month");
                internship4.setEligibility("B.Tech CSE/IT, CGPA > 8.0");
                internship4.setDeadline(LocalDate.now().plusDays(20));
                internship4.setDescription("Core backend engineering using Spring Boot and Java.");
                internship4.setStatus("OPEN");
                internship4.setCreatedByAdmin(admin);
                internshipRepository.save(internship4);
                
                Internship internship5 = new Internship();
                internship5.setRole("UI/UX Design Intern");
                internship5.setCompany("Apple");
                internship5.setStipend("75,000 / month");
                internship5.setEligibility("Any Branch, Portfolio Required");
                internship5.setDeadline(LocalDate.now().plusDays(10));
                internship5.setDescription("Design the next generation of Apple software interfaces.");
                internship5.setStatus("OPEN");
                internship5.setCreatedByAdmin(admin);
                internshipRepository.save(internship5);

                // Add more Contests
                Contest contest2 = new Contest();
                contest2.setTitle("LeetCode Weekly 400");
                contest2.setPlatform("LeetCode");
                contest2.setContestUrl("https://leetcode.com/contest");
                contest2.setStartDatetime(OffsetDateTime.now().plusDays(4));
                contest2.setEndDatetime(OffsetDateTime.now().plusDays(4).plusHours(2));
                contest2.setDescription("Global weekly coding contest on LeetCode.");
                contest2.setCreatedByAdmin(admin);
                contestRepository.save(contest2);
                
                Contest contest3 = new Contest();
                contest3.setTitle("Codeforces Round 950");
                contest3.setPlatform("Codeforces");
                contest3.setContestUrl("https://codeforces.com/contests");
                contest3.setStartDatetime(OffsetDateTime.now().plusDays(6));
                contest3.setEndDatetime(OffsetDateTime.now().plusDays(6).plusHours(2));
                contest3.setDescription("Div 2 competitive programming round.");
                contest3.setCreatedByAdmin(admin);
                contestRepository.save(contest3);

                // Add more Sessions
                Session session2 = new Session();
                session2.setTitle("Resume Building Workshop");
                session2.setSpeaker("Jane Doe (HR Manager)");
                session2.setSessionDatetime(OffsetDateTime.now().plusDays(1));
                session2.setJoinUrl("https://zoom.us/j/12345");
                session2.setTargetBranch("ALL");
                session2.setTargetYear(3);
                session2.setDescription("Learn how to make an ATS-friendly resume.");
                session2.setCreatedByAdmin(admin);
                sessionRepository.save(session2);
                
                Session session3 = new Session();
                session3.setTitle("System Design Masterclass");
                session3.setSpeaker("John Smith (Staff Engg)");
                session3.setSessionDatetime(OffsetDateTime.now().plusDays(7));
                session3.setJoinUrl("https://meet.google.com/abc");
                session3.setTargetBranch("CSE, IT");
                session3.setTargetYear(4);
                session3.setDescription("Deep dive into scalable system architectures.");
                session3.setCreatedByAdmin(admin);
                sessionRepository.save(session3);

                // Add more Notifications
                Notification notif2 = new Notification();
                notif2.setTitle("Upcoming Hackathon");
                notif2.setCategory("Event");
                notif2.setContent("Smart India Hackathon registrations are now open.");
                notif2.setPostedByAdmin(admin);
                notif2.setTargetBranch("ALL");
                notif2.setTargetYear(0); // 0 could mean ALL years if logic permits
                notificationRepository.save(notif2);
                
                Notification notif3 = new Notification();
                notif3.setTitle("Deadline Reminder");
                notif3.setCategory("Alert");
                notif3.setContent("Tomorrow is the last day to apply for the Microsoft internship.");
                notif3.setPostedByAdmin(admin);
                notif3.setTargetBranch("ALL");
                notif3.setTargetYear(3);
                notificationRepository.save(notif3);
                
                System.out.println("Dummy data seeded successfully!");
            }
        };
    }
}
