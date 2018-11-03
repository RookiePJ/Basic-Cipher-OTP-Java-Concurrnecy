package com.pjr.cipher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BasicCipherJavaThreadsApplication.class)
public class BasicCipherJavaThreadsApplicationTests {

    BasicCipher basicCipher = new BasicCipherImpl();

	@Test
	public void contextLoads() {
	}

    @Test
    public void testProcessWordGod() {
        String word = "God";
        String result;
        String expectedResult = "[G,7][o,2][d,4][13]";
        result = basicCipher.processWord(word);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testProcessWordDog() {
        String word = "Dog";
        String result;
        String expectedResult = "[D,4][o,2][g,7][13]";
        result = basicCipher.processWord(word);
        assertEquals(result, expectedResult);
    }


    @Test
    public void testProcessSentenceOne() {
        String sentence = "A Cat Shat On The Mat";
        String result;
        String expectedResult = " [A,1][1] [C,3][a,1][t,7][11] [S,6][h,6][a,1][t,7][20] [O,2][n,1][3] [T,7][h,6][e,5][18] [M,1][a,1][t,7][9]";
        result = basicCipher.processSentence(sentence);
        assertEquals(result, expectedResult);
    }

}
