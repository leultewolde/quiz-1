package com.leultewolde.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Contact {
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private List<EmailAddress> emailAddresses = new ArrayList<>();
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Contact() {}

    public Contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
    }

    public Contact(String firstName, String lastName, String company, String jobTitle, List<EmailAddress> emailAddresses, List<PhoneNumber> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String toJSON() {
        String emails = emailAddresses.stream().map(EmailAddress::toJSON)
                .collect(Collectors.joining(", ", "[","]"));
        String phones = phoneNumbers.stream().map(PhoneNumber::toJSON)
                .collect(Collectors.joining(", ", "[","]"));
        return String.format(
                "\t{\"firstname\": \"%s\",\"lastName\": \"%s\",\"company\": \"%s\",\"jobTitle\": \"%s\"," +
                        "\"emailAddresses\": %s,\"phoneNumbers\": %s}",
                firstName, lastName, company, jobTitle, emails, phones);
    }
}
