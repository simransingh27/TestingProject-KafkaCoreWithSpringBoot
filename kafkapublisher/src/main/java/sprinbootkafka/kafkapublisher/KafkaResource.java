package sprinbootkafka.kafkapublisher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import sprinbootkafka.kafkapublisher.model.User;

import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;

@RestController
@RequestMapping("Kafka")
public class KafkaResource {
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    @GetMapping("/publish")
    public String publishMessage() {
        try {
            String msg = null;

            BufferedReader br = publishFile("C:\\Users\\Dell\\Desktop\\DataFilesForTest\\test.csv");
            User user = new User();
            //String[] array = null;
            while ((msg = br.readLine()) != null) {
                String[] array = msg.split(",");
                System.out.println("test : "+array[0].toString());
                kafkaTemplate.send("test", new User(array[0], array[1], array[2], array[3]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "publish successfully";
    }


    public BufferedReader publishFile(String path) throws FileNotFoundException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        return br;
    }
}
