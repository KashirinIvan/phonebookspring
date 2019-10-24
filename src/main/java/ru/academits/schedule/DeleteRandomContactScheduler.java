package ru.academits.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.academits.dao.ContactDao;

import java.util.Random;

@Component
public class DeleteRandomContactScheduler {
    private static final Logger logger = LoggerFactory.getLogger(DeleteRandomContactScheduler.class);
    private final ContactDao contactDao;

    public DeleteRandomContactScheduler(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Scheduled(fixedRate = 10000)
    private void deleteRandomContactScheduler() {
     /*   if (contactDao.getAllContacts().size() != 0) {
            Random random = new Random();
            contactDao.delete(contactDao.getAllContacts().get(random.nextInt(contactDao.getAllContacts().size())));
            logger.info("called method DeleteRandomContactScheduler");
            System.out.println("Scheduler!");
        } else {
            logger.info("called method DeleteRandomContactScheduler contact = 0");
            System.out.println("Scheduler!");
        }*/
    }
}
