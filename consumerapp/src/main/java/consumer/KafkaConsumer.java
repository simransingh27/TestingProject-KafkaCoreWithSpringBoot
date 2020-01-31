package consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics ="live", groupId ="group_id" )
    public void consume(String name)
    {
        System.out.println("Consumed message :"+name);
    }
}
