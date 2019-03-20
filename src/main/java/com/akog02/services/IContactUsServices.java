package com.akog02.services;

import java.util.Optional;

import com.akog02.domain.ContactUs;

public interface IContactUsServices {
Iterable<ContactUs> getAllContactus();
boolean Save(ContactUs c);
boolean DeleteById(Integer Id);
Optional<ContactUs> SelectById(Integer Id);
}
