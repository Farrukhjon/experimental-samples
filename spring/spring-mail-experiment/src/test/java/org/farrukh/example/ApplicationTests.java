package org.farrukh.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.InternetAddress;

import static javax.mail.Message.RecipientType.TO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void testIfMailSenderInstantiated() throws Exception {
        Assert.assertNotNull(javaMailSender);
    }

    @Test
    public void shouldSendSimpleTextToMyGMailBox() throws Exception {
        javaMailSender.send(mimeMessage -> {
            mimeMessage.setSubject("Very important mail!");
            mimeMessage.setText("Hello World!");
            mimeMessage.setDescription("This this just mail from my app");
            mimeMessage.setFrom("firedandy@gmail.com");
            mimeMessage.setRecipient(TO, new InternetAddress("farrukhjon.sattorov@gmail.com"));
        });
    }

}
