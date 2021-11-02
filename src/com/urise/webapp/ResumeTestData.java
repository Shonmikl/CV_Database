package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {

    public static void main(String[] args) {
        ResumeTestData resumeTestData1 = new ResumeTestData();
        ResumeTestData resumeTestData2 = new ResumeTestData();
        ResumeTestData resumeTestData3 = new ResumeTestData();
        resumeTestData1.resumeCreator(randomStringGenerator(), randomStringGenerator());
        resumeTestData2.resumeCreator(randomStringGenerator(), randomStringGenerator());
        resumeTestData3.resumeCreator(randomStringGenerator(), randomStringGenerator());
    }

    public Resume resumeCreator(String uuid, String name) {
        Resume resume = new Resume(randomStringGenerator(), randomStringGenerator());
        Map<ContactType, String> resumeContactTypeMap = new EnumMap<>(ContactType.class);
        Map<SectionType, AbstractSection> resumeSectionTypeMap = new EnumMap<>(SectionType.class);

        resumeContactTypeMap.put(ContactType.MAIL, randomStringGenerator());
        resumeContactTypeMap.put(ContactType.PHONE_NUMBER, randomStringGenerator());
        resumeContactTypeMap.put(ContactType.SOCIAL_NETWORKS, randomStringGenerator());

        resume.setContacts(resumeContactTypeMap);

        AbstractSection positionAbstractSection = new TextSection(randomStringGenerator());
        resumeSectionTypeMap.put(SectionType.OBJECTIVE, positionAbstractSection);

        AbstractSection personalityAbstractSection = new TextSection(randomStringGenerator());
        resumeSectionTypeMap.put(SectionType.PERSONAL, personalityAbstractSection);

        AbstractSection achievementAbstractSection = new TextSection(randomStringGenerator());
        resumeSectionTypeMap.put(SectionType.ACHIEVEMENT, achievementAbstractSection);

        AbstractSection qualificationAbstractSection = new TextSection(randomStringGenerator());
        resumeSectionTypeMap.put(SectionType.QUALIFICATIONS, qualificationAbstractSection);

        LocalDate slStartDate = LocalDate.of(2017, 7,15);
        LocalDate slEndDate = LocalDate.of(2020, 10,1);
        AdditionalInformation softLineAdditionalInformation = new AdditionalInformation(slStartDate, slEndDate, randomStringGenerator(),
                randomStringGenerator());
        List<AdditionalInformation> softLineList = new ArrayList<>();
        softLineList.add(softLineAdditionalInformation);

        Organization softLineCompany = new Organization(new Link(randomStringGenerator(),randomStringGenerator()),  softLineList);
        AbstractSection softLineAbstractSection = new OrganizationSection(softLineCompany);
        resumeSectionTypeMap.put(SectionType.EXPERIENCE, softLineAbstractSection);

        LocalDate universityStartDate1 = LocalDate.of(2004, 9, 15);
        LocalDate universityEndDate1 = LocalDate.of(2008, 7, 11);
        AdditionalInformation university_information_1 =
                new AdditionalInformation(universityStartDate1, universityEndDate1, randomStringGenerator(), randomStringGenerator());

        LocalDate universityStartDate2 = LocalDate.of(2006, 3, 11);
        LocalDate universityEndDate2 = LocalDate.of(2007, 4, 21);
        AdditionalInformation university_information_2 =
                new AdditionalInformation(universityStartDate2, universityEndDate2, randomStringGenerator(), randomStringGenerator());

        List<AdditionalInformation> universityList = new ArrayList<>();
        universityList.add(university_information_1);
        universityList.add(university_information_2);

        Organization university = new Organization(new Link(randomStringGenerator(), randomStringGenerator()),
                universityList);

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
            System.out.println(map1);
            System.out.println("*******************************************");
        }
        return  resume;
    }

    public static String randomStringGenerator() {
        StringBuffer stringBuffer = new StringBuffer("QWERTYUIOPASDFGHJKLZXCVBNM");
        Random random = new Random();
        int randomDigit = random.nextInt(25);
        String randomString = stringBuffer.substring(randomDigit);
        return randomString;
    }
}