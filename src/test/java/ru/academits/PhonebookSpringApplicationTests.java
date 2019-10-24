package ru.academits;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.academits.dao.ContactDao;
import ru.academits.model.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhonebookSpringApplicationTests {
    @Autowired
    private ContactDao contactDao;

    private Contact contact = new Contact();

    @Test
    public void test() {
        Assert.assertEquals(contactDao.getAllContacts().size(), 0);
    }

    @Test
    public void test2() {
        contact.setFirstName("Иван");
        contact.setLastName("Каширин");
        contact.setPhone("923114");
        contactDao.add(contact);
        System.out.println(contactDao.getAllContacts().size());
        Assert.assertEquals(contactDao.getAllContacts().size(), 2);
    }

    @Test
    public void test3() {
        contactDao.delete(contactDao.getAllContacts().get(1));
        System.out.println(contactDao.getAllContacts().size());
        Assert.assertEquals(contactDao.getAllContacts().size(), 1);
    }
}
