package com.kalai.serviceimpl;

import com.kalai.dao.ContactDao;
import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;

public class ContactServiceImplTest extends TestCase {

@Test
    public String getNameById(Integer id) {

    ContactDao contactDaoProxy = EasyMock.createMock(ContactDao.class);

    ContactServiceImpl contactService = new ContactServiceImpl();
    contactService.setContactDao(contactDaoProxy);

        return null;
    }

}