package org.farrukh.experiments.spring.batch;

public interface ReadTranslateWrite {
    
    public String readSentenceFrom(String fileName);

    public String translateToRussian(String aSentence);
    
    public String writeSentenceTo(String fileName);
    
}
