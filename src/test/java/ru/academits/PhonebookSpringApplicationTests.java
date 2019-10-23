package ru.academits;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.academits.dao.ContactDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhonebookSpringApplicationTests {
    @Autowired
    private ContactDao contactDao;

    @Test
    public void test() {
        Assert.assertEquals(contactDao.getAllContacts().size(),0);
    }

    @Test
    public void test2() {
        Assert.assertEquals(contactDao.getAllContacts().size(),2);
    }
}
