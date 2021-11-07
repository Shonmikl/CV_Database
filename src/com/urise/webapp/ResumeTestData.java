package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {

    public static void main(String[] args) {
        System.out.println(receiveFilledResume(createsRandomString(), createsRandomString()));
    }

    public static Resume receiveFilledResume(String uuid, String name) {
        Resume resume = new Resume(uuid, name);
        Map<ContactType, String> resumeContactTypeMap = new EnumMap<>(ContactType.class);
        Map<SectionType, AbstractSection> resumeSectionTypeMap = new EnumMap<>(SectionType.class);

        resumeContactTypeMap.put(ContactType.MAIL, createsRandomString());
        resumeContactTypeMap.put(ContactType.PHONE_NUMBER, createsRandomString());
        resumeContactTypeMap.put(ContactType.SOCIAL_NETWORKS, createsRandomString());

        resume.setContacts(resumeContactTypeMap);

        AbstractSection positionAbstractSection = new TextSection(createsRandomString());
        resumeSectionTypeMap.put(SectionType.OBJECTIVE, positionAbstractSection);

        AbstractSection personalityAbstractSection = new TextSection(createsRandomString());
        resumeSectionTypeMap.put(SectionType.PERSONAL, personalityAbstractSection);

        AbstractSection achievementAbstractSection = new TextSection(createsRandomString());
        resumeSectionTypeMap.put(SectionType.ACHIEVEMENT, achievementAbstractSection);

        AbstractSection qualificationAbstractSection = new TextSection(createsRandomString());
        resumeSectionTypeMap.put(SectionType.QUALIFICATIONS, qualificationAbstractSection);

        LocalDate slStartDate = LocalDate.of(2017, 7, 15);
        LocalDate slEndDate = LocalDate.of(2020, 10, 1);
        Experience softLineAdditionalInformation = new Experience(slStartDate, slEndDate, createsRandomString(),
                createsRandomString());
        List<Experience> softLineList = new ArrayList<>();
        softLineList.add(softLineAdditionalInformation);

        Organization softLineCompany = new Organization(new Link(createsRandomString(), createsRandomString()), softLineList);
        AbstractSection softLineAbstractSection = new OrganizationSection(softLineCompany);
        resumeSectionTypeMap.put(SectionType.EXPERIENCE, softLineAbstractSection);

        LocalDate universityStartDate1 = LocalDate.of(2004, 9, 15);
        LocalDate universityEndDate1 = LocalDate.of(2008, 7, 11);
        Experience university_information_1 =
                new Experience(universityStartDate1, universityEndDate1, createsRandomString(), createsRandomString());

        LocalDate universityStartDate2 = LocalDate.of(2006, 3, 11);
        LocalDate universityEndDate2 = LocalDate.of(2007, 4, 21);
        Experience university_information_2 =
                new Experience(universityStartDate2, universityEndDate2, createsRandomString(), createsRandomString());

        List<Experience> universityList = new ArrayList<>();
        universityList.add(university_information_1);
        universityList.add(university_information_2);

        Organization university = new Organization(new Link(createsRandomString(), createsRandomString()),
                universityList);

        AbstractSection universityAbstractSection = new OrganizationSection(university);
        resumeSectionTypeMap.put(SectionType.EDUCATION, universityAbstractSection);
        resume.setSections(resumeSectionTypeMap);

        System.out.println(resume.getFullName());
        System.out.println("*******************************************");
        for (Map.Entry<ContactType, String> map : resumeContactTypeMap.entrySet()) {
            System.out.println(map.getValue());
        }
        System.out.println("*******************************************");
        for (Map.Entry<SectionType, AbstractSection> map1 : resumeSectionTypeMap.entrySet()) {
            System.out.println(map1);
            System.out.println("*******************************************");
        }
        return resume;
    }

    public static String createsRandomString() {
        String list = "Q1W2E3R4T5Y6U7I8O9P0A9S8D7F6G5H4J3K2L/*/1-Z=2(X((3))C*4&V^5%B$6N@!#0M";
        char[] listChar = list.toCharArray();
        Random random = new Random();
        char[] randomElement = new char[9];

        for (int i = 0; i < 9; i++) {
            randomElement[i] = listChar[random.nextInt(68)];
        }
        return String.valueOf(randomElement);
    }
}