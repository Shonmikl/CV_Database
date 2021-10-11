package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("0001", "Mikhail Egorov");

        Map<ContactType, String> resumeContactTypeMap = new EnumMap<>(ContactType.class);
        resumeContactTypeMap.put(ContactType.MAIL, "mikhailegorov676@gmail.com");
        resumeContactTypeMap.put(ContactType.PHONE_NUMBER, "+79119028180");
        resumeContactTypeMap.put(ContactType.SOCIAL_NETWORKS, "https://www.facebook.com/mikhail.egorov.7");

        resume.setContacts(resumeContactTypeMap);

        Map<SectionType, Section> resumeSectionTypeMap = new EnumMap<>(SectionType.class);

        Section positionSection = new TextSection("JAVA JUNIOR");
        resumeSectionTypeMap.put(SectionType.OBJECTIVE, positionSection);

        Section personalitySection = new TextSection("Communication skills, ability to achieve goals, team management experience, project management\n" +
                "experience, broad outlook, market knowledge B2B, FMCG\n" +
                "ability to build relationships at all levels.");
        resumeSectionTypeMap.put(SectionType.PERSONAL, personalitySection);

        Section achievementSection = new TextSection("* 100% independent work\n" +
                "* Delegation of non-key tasks to the J-sales team\n" +
                "* The highest margin rate in the department\n" +
                "* Focus on recurring business");
        resumeSectionTypeMap.put(SectionType.ACHIEVEMENT, achievementSection);

        Section qualificationSection = new TextSection("- OOP\n" +
                "- Arrays, Collections\n" +
                "- SQL, PostgreSQL\n" +
                "- GIT");
        resumeSectionTypeMap.put(SectionType.QUALIFICATIONS, qualificationSection);

        LocalDate slStartDate = LocalDate.of(2017, 7,15);
        LocalDate slEndDate = LocalDate.of(2020, 10,1);
        Organization softLineCompany = new Organization("Softline LLC  ( Clobal IT Integrator )",
                "https://softline.com", slStartDate, slEndDate, "Enterprise Account Manager",
                "Work with a valid account sheet. (LENTA, SRV DEVELOPMENT, ACCOUNTOR RUSSIA, TIKKURILA, HOFFMAN GROUP, JOTUN PAINTS, etc.)\n" +
                        "- Building trusting relationships with decision makers\n" +
                        "- Work on finding out the IT budget of the customer, key tasks, decision-making schemes.\n" +
                        "- Development of new decision-makers in the customer having influence\n" +
                        "- Focus on Cloud and IT Development\n" +
                        "- Work with CxO\n" +
                        "- Work with vendors\n" +
                        "- Generation of a new business in the customer\n" +
                        "- Project management\n" +
                        "- Work with the project team\n" +
                        "- Monitoring the implementation of all stages of the project\n" +
                        "- Management of business tasks in the customer\n" +
                        "- Preparation and management of competitions\n" +
                        "- Planning\n" +
                        "- Carrying out marketing activities in order to generate new business in the customer and increase the level of loyalty\n" +
                        "- Work with competitors\n" +
                        "- Work with a sales team\n" +
                        "- Prioritization in planning\n" +
                        "- Work on increasing business margins\n" +
                        "- Improving the image of the company\n" +
                        "- Reporting in CRM\n" +
                        "- Strict adherence to company values\n" +
                        "- Work within the framework of a clear methodology.");
        List<Organization> organizationList = new ArrayList<>();

        organizationList.add(softLineCompany);
        Section softLineSection = new OrganizationSection(softLineCompany);
        resumeSectionTypeMap.put(SectionType.EXPERIENCE, softLineSection);

        LocalDate universityStartDate = LocalDate.of(2004, 9, 15);
        LocalDate universityEndDate = LocalDate.of(2008, 7, 11);
        Organization university = new Organization("St. Petersburg University of Management and Economics", "https://www.spbume.ru/ru/",
                universityStartDate, universityEndDate, "Management, Crisis management", "");

        organizationList.add(university);
        Section universitySection = new OrganizationSection(university);
        resumeSectionTypeMap.put(SectionType.EDUCATION, universitySection);
        resume.setSections(resumeSectionTypeMap);

        System.out.println(resume.getFullName());
        System.out.println("*******************************************");
        System.out.println(resume.getContacts(ContactType.MAIL));
        System.out.println(resume.getContacts(ContactType.PHONE_NUMBER));
        System.out.println(resume.getContacts(ContactType.SOCIAL_NETWORKS));
        System.out.println("*******************************************");
        System.out.println(resume.getSections(SectionType.OBJECTIVE));
        System.out.println("*******************************************");
        System.out.println(resume.getSections(SectionType.PERSONAL));
        System.out.println("*******************************************");
        System.out.println(resume.getSections(SectionType.ACHIEVEMENT));
        System.out.println("*******************************************");
        System.out.println(resume.getSections(SectionType.QUALIFICATIONS));
        System.out.println("*******************************************");
        System.out.println(resume.getSections(SectionType.EXPERIENCE));
        System.out.println("*******************************************");
        System.out.println(resume.getSections(SectionType.EDUCATION));
        System.out.println("*******************************************");
    }
}