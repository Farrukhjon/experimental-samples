public class Ext2<T extends Runnable, String> {
    java.lang.String s = "Hello";    
    
    public void test(T t) {
        t.run();
    }
}


