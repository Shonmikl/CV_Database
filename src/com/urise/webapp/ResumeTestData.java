package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public class ResumeTestData {

    public Resume makeResume(String uuid, String fullName) {
        return null;
    }

    public static void main(String[] args) {
        Resume resume = new Resume("0001", "Mikhail Egorov");
        Map<ContactType, String> resumeContactTypeMap = new EnumMap<>(ContactType.class);
        Map<SectionType, AbstractSection> resumeSectionTypeMap = new EnumMap<>(SectionType.class);

        resumeContactTypeMap.put(ContactType.MAIL, "mikhailegorov676@gmail.com");
        resumeContactTypeMap.put(ContactType.PHONE_NUMBER, "+79119028180");
        resumeContactTypeMap.put(ContactType.SOCIAL_NETWORKS, "https://www.facebook.com/mikhail.egorov.7");

        resume.setContacts(resumeContactTypeMap);

        AbstractSection positionAbstractSection = new TextSection("JAVA JUNIOR");
        resumeSectionTypeMap.put(SectionType.OBJECTIVE, positionAbstractSection);

        AbstractSection personalityAbstractSection = new TextSection("""
                * Communication skills, ability to achieve goals, team management experience, project management
                * experience, broad outlook, market knowledge B2B, FMCG
                * ability to build relationships at all levels
                """);
        resumeSectionTypeMap.put(SectionType.PERSONAL, personalityAbstractSection);

        AbstractSection achievementAbstractSection = new TextSection("""
                * 100% independent work
                * Delegation of non-key tasks to the J-sales team
                * The highest margin rate in the department
                * Focus on recurring business
                """);
        resumeSectionTypeMap.put(SectionType.ACHIEVEMENT, achievementAbstractSection);

        AbstractSection qualificationAbstractSection = new TextSection("""
                * OOP
                * Arrays, Collections
                * SQL, PostgreSQL
                * GIT
                """);
        resumeSectionTypeMap.put(SectionType.QUALIFICATIONS, qualificationAbstractSection);

        LocalDate slStartDate = LocalDate.of(2017, 7,15);
        LocalDate slEndDate = LocalDate.of(2020, 10,1);
        AdditionalInformation softLineAdditionalInformation = new AdditionalInformation(slStartDate, slEndDate, "Enterprise Account Manager",
                """
                        * Work with a valid account sheet. (LENTA, SRV DEVELOPMENT, ACCOUNTOR RUSSIA, TIKKURILA, HOFFMAN GROUP, JOTUN PAINTS, etc.)
                        * Building trusting relationships with decision makers +
                        * Work on finding out the IT budget of the customer, key tasks, decision-making schemes.
                        * Development of new decision-makers in the customer having influence
                        * Focus on Cloud and IT Development
                        * Work with CxO
                        * Work with vendors
                        * Generation of a new business in the customer
                        * Project management
                        * Work with the project team
                        * Monitoring the implementation of all stages of the project
                        * Management of business tasks in the customer
                        * Preparation and management of competitions
                        * Planning
                        * Carrying out marketing activities in order to generate new business in the customer and increase the level of loyalty
                        * Work with competitors
                        * Work with a sales team
                        * Prioritization in planning
                        * Work on increasing business margins
                        * Improving the image of the company
                        * Reporting in CRM
                        * Strict adherence to company values
                        * Work within the framework of a clear methodology.
                        """);
        Organization softLineCompany = new Organization("Softline LLC  ( Global IT Integrator )","https://softline.com", softLineAdditionalInformation);
        AbstractSection softLineAbstractSection = new OrganizationSection(softLineCompany);
        resumeSectionTypeMap.put(SectionType.EXPERIENCE, softLineAbstractSection);

        LocalDate universityStartDate1 = LocalDate.of(2004, 9, 15);
        LocalDate universityEndDate1 = LocalDate.of(2008, 7, 11);
        AdditionalInformation university_information_1 =
                new AdditionalInformation(universityStartDate1, universityEndDate1, "Management, Crisis management", "");

        LocalDate universityStartDate2 = LocalDate.of(2006, 3, 11);
        LocalDate universityEndDate2 = LocalDate.of(2007, 4, 21);
        AdditionalInformation university_information_2 =
                new AdditionalInformation(universityStartDate2, universityEndDate2, "Test Additional Information", "Test Additional Information");

        Organization university = new Organization("St. Petersburg University of Management and Economics", "https://www.spbume.ru/ru/",
                university_information_1, university_information_2);

        AbstractSection universityAbstractSection = new OrganizationSection(university);
        resumeSectionTypeMap.put(SectionType.EDUCATION, universityAbstractSection);
        resume.setSections(resumeSectionTypeMap);

        System.out.println(resume.getFullName());
        System.out.println("*******************************************");
        for (Map.Entry<ContactType, String> map: resumeContactTypeMap.entrySet()) {
            System.out.println(map.getValue());
        }
        System.out.println("*******************************************");
        for (Map.Entry<SectionType, AbstractSection> map1: resumeSectionTypeMap.entrySet()) {
            System.out.println(map1.toString());

            System.out.println("*******************************************");
        }
    }
}