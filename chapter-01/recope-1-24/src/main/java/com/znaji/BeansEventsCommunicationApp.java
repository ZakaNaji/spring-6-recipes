package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class BeansEventsCommunicationApp
{
    public static void main( String[] args )
    {
        var ctx = new AnnotationConfigApplicationContext(Configuration.class);
        var userRegistrationService = ctx.getBean(UserRegistrationService.class);
        userRegistrationService.registerUser("znaji", "znaji@gmail.com");
        ctx.close();
    }
}
