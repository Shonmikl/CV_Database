package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("0001", "Mikhail Egorov");

        Map<ContactType, String> contactTypeStringMap = new EnumMap<>(ContactType.class);
        contactTypeStringMap.put(ContactType.MAIL, "mikhailegorov676@gmail.com");
        contactTypeStringMap.put(ContactType.PHONE_NUMBER, "+79119028180");
        contactTypeStringMap.put(ContactType.SOCIAL_NETWORKS, "https://www.facebook.com/mikhail.egorov.7");

        resume.setContacts(contactTypeStringMap);

        Map<SectionType, Section> sectionTypeSectionMap = new EnumMap<>(SectionType.class);

        Section positionSection = new TextSection("JAVA JUNIOR");
        sectionTypeSectionMap.put(SectionType.OBJECTIVE, positionSection);

        Section personalitySection = new TextSection("Communication skills, ability to achieve goals, team management experience, project management\n" +
                "experience, broad outlook, market knowledge B2B, FMCG\n" +
                "ability to build relationships at all levels.");
        sectionTypeSectionMap.put(SectionType.PERSONAL, personalitySection);

        Section achievementSection = new TextSection("* 100% independent work\n" +
                "* Delegation of non-key tasks to the J-sales team\n" +
                "* The highest margin rate in the department\n" +
                "* Focus on recurring business");
        sectionTypeSectionMap.put(SectionType.ACHIEVEMENT, achievementSection);

        Section qualificationSection = new TextSection("- OOP\n" +
                "- Arrays, Collections\n" +
                "- SQL, PostgreSQL\n" +
                "- GIT");
        sectionTypeSectionMap.put(SectionType.QUALIFICATIONS, qualificationSection);

        LocalDate slStartDate = LocalDate.of(2017, 07,15);
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
        List<Organization> organizationList = new LinkedList<>();
        organizationList.add(softLineCompany);

        Section softLineSection = new OrganizationSection(organizationList);
        sectionTypeSectionMap.put(SectionType.EXPERIENCE, softLineSection);

























    }
}

