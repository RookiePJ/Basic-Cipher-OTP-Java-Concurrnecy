package com.pjr.cipher;

/**
 * Created by peterrooke on 05/07/16.
 */
public interface BasicCipher {
    public String processWord(String word);
    public String processSentence(String sentence);
    public void pushText(String text);
}
