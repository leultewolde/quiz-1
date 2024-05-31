package com.leultewolde;

import com.leultewolde.model.Contact;
import com.leultewolde.model.EmailAddress;
import com.leultewolde.model.PhoneNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Contact> contacts = List.of(
                new Contact("David", "Sanger", "Argos LLC", "Sales Manager",
                        List.of(
                                new EmailAddress("dave.sang@gmail.com", "Home"),
                                new EmailAddress("dsanger@argos.com", "Work")
                                ),
                        List.of(
                                new PhoneNumber("240-133-0011", "Home"),
                                new PhoneNumber("240-112-0123", "Mobile")
                                )
                ),
                new Contact("Carlos", "Jimenez", "Zappos", "Director"),
                new Contact("Ali", "Gafar", "BMI Services", "HR Manager",
                        List.of(new EmailAddress("ali@bmi.com", "Work")),
                        List.of(new PhoneNumber("412-116-9988", "Work"))
                )

        );


        List<Contact> sortedContacts = contacts.stream()
                .sorted(Comparator.comparing(Contact::getLastName))
                .toList();
        printContacts(sortedContacts);
    }

    static void printContacts(List<Contact> contacts) {
        String jsonContacts = contacts.stream().map(Contact::toJSON)
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
        System.out.println(jsonContacts);
    }
}