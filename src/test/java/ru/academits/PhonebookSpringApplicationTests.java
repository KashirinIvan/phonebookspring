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
        for (int i = 0; i < contactDao.getAllContacts().size(); i++) {
            System.out.println(contactDao.getAllContacts().get(i).getId() + " " + contactDao.getAllContacts().get(i).getFirstName() + " " + contactDao.getAllContacts().get(i).getLastName() + " " + contactDao.getAllContacts().get(i).getPhone());
        }
    }

    @Test
    public void test4() {
        int count = 0;
        contact.setFirstName("Петр");
        contact.setLastName("Петров");
        contact.setPhone("9231143380");
        contact.setImportant(true);
        contactDao.add(contact);
        for (int i = 0; i < contactDao.getAllContacts().size(); i++) {
            if (contactDao.getAllContacts().get(i).isImportant()) {
                System.out.println("Важный контакт с id=" + contactDao.getAllContacts().get(i).getId());
                count++;
            }
        }
        Assert.assertEquals(count, 1);
    }

    @Test
    public void test5() {
        contactDao.delete(contactDao.getAllContacts().get(1));
        System.out.println(contactDao.getAllContacts().size());
        Assert.assertEquals(contactDao.getAllContacts().size(), 2);
    }
}
