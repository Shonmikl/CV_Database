package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("1", "Mikhail Egorov");

        Map<ContactType, String> contacts = new HashMap<>();
        contacts.put(ContactType.PHONE_NUMBER, "+79119028180");
        contacts.put(ContactType.MAIL, "mikhailEgorov676@gmail.com");
        contacts.put(ContactType.SOCIAL_NETWORKS, "https://www.facebook.com/mikhail.egorov.7");
        resume.setContacts(contacts);

        Map<SectionType, Section> sections  = new HashMap<>();

        Section sectionPosition = new Section();
        sectionPosition.setSectionContent("Junior Java Developer");
        sections.put(SectionType.OBJECTIVE, sectionPosition);

        Section sectionPersonality = new Section();
        sectionPersonality.setSectionContent("- Communication skills, ability to achieve goals, " +
                "- team management experience, project management" +
                "- experience, broad outlook, market knowledge B2B, FMCG" +
                "- ability to build relationships at all levels.");
        sections.put(SectionType.PERSONAL, sectionPersonality);

        Section sectionAchievement = new Section();
        sectionAchievement.setSectionContent("100% Target's achievement");
        sections.put(SectionType.ACHIEVEMENT, sectionAchievement);

        Section sectionQualification = new Section();
        sectionQualification.setSectionContent("- OOP, Arrays, Collections SQL, PostgreSQL, GIT");
        sections.put(SectionType.QUALIFICATIONS, sectionQualification);

        Organization organization = new Organization();
        organization.setTitle("Softline ( Global IT Integrator )");
        organization.setPositionName("Enterprise Account Manager\n");
        organization.setDescription(
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
        LocalDate softlineStartDate = LocalDate.of(2017, 7, 15);
        LocalDate softlineEndDate = LocalDate.of(2019, 10, 1);
        organization.setStartDate(softlineStartDate);
        organization.setEndDate(softlineEndDate);




    }
}
