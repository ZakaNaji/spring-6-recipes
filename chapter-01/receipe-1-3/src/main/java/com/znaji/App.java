package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        final Sequence sequence = context.getBean(Sequence.class);
        System.out.println(sequence.getSequence());
    }
}
