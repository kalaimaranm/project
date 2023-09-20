package com.kalai.serviceimpl;

import com.kalai.dao.ContactDao;
import com.kalai.service.ContactService;

public class ContactServiceImpl implements ContactService {


    private ContactDao contactDao;


    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public String getNameById(Integer id) {
        return null;
    }
}
