package org.farrukh.experiments.java;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Blogger blogger = new Blogger();
        
        new BlogSubscriber("Ali", blogger);
        new BlogSubscriber("Vali", blogger);
        new BlogSubscriber("Sami", blogger);
        
        blogger.generateBlog();
    }
}
