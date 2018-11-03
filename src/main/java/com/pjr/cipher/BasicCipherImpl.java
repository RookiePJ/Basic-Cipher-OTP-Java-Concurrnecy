package com.pjr.cipher;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Callable;

/**
 * Created by peterrooke on 05/07/16.
 */
public class BasicCipherImpl implements BasicCipher, Callable<String> {

    private String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String processWord(String word) {

        StringBuffer codedWord = new StringBuffer();
        int wordNumber = 0;

        for (char c : word.toCharArray()) {

            int letterNumber = 0;
            char upperC = Character.toUpperCase(c);

            switch (upperC) {

                case 'A':
                case 'N':
                case 'M':
                case 'Z':
                    letterNumber = 1;
                    break;

                case 'B':
                case 'O':
                case 'L':
                case 'Y':
                    letterNumber = 2;
                    break;

                case 'C':
                case 'P':
                case 'K':
                case 'X':
                    letterNumber = 3;
                    break;

                case 'D':
                case 'Q':
                case 'J':
                case 'W':
                    letterNumber = 4;
                    break;

                case 'E':
                case 'R':
                case 'I':
                case 'V':
                    letterNumber = 5;
                    break;

                case 'F':
                case 'S':
                case 'H':
                case 'U':
                    letterNumber = 6;
                    break;

                case 'G':
                case 'T':
                    letterNumber = 7;
                    break;

                default: letterNumber = 0;
                    break;

            }
            codedWord.append("[" + c + "," + letterNumber + "]");
            wordNumber += letterNumber;
        }
        codedWord.append("[" + wordNumber + "]");
        return codedWord.toString();
    }

    public String processSentence(String sentence) {
        StringBuffer codedSentence = new StringBuffer();

        for (String word : sentence.split("\\s+")) {
            String processedWord = this.processWord(word);
            codedSentence.append(" " + processedWord);
        }
        return codedSentence.toString();
    }


    public void pushText(String text) {
        this.setText(text);
    }

    public String call() {
        StringBuffer codedSentence = new StringBuffer();
        for (String word : getText().split("\\s+")) {
            String processedWord = this.processWord(word);
            codedSentence.append(" " + this.processWord(word));
        }
        return codedSentence.toString();
    }

}
