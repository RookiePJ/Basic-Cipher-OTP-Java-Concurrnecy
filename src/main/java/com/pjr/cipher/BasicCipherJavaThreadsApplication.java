package com.pjr.cipher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class BasicCipherJavaThreadsApplication {

    ExecutorService workStealingPool = Executors.newWorkStealingPool();
    BasicCipherImpl basicCipherImpl = new BasicCipherImpl();


    public static void main(String[] args) {
		SpringApplication.run(BasicCipherJavaThreadsApplication.class, args);
    }

    public void process() {
        Collection<Future<String>> processedText = new ArrayList<>();

        String text = "adfsa fdsafdas dsafdsa safdsaf safdsa dsafas fdsaf sdf fdsa dsf dsf afd fdsa. safdsafd asdfsa dfsaasfd fdsafdsaf fdsfsa fdsafdsa fdsafdsaf fdafdsafds fdsafdsaf";
        basicCipherImpl.pushText(text);
        processedText.add(workStealingPool.submit(basicCipherImpl));
        workStealingPool.shutdown();

        System.out.println(processedText);
    }
}
