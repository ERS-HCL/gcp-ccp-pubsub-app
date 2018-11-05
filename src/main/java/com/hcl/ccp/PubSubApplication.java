package com.cloud.hybrid.ccp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.Publisher;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.util.concurrent.ListenableFutureCallback;

//@EnableAutoConfiguration
@SpringBootApplication
public class PubSubApplication {

  private static final Log LOGGER = LogFactory.getLog(PubSubApplication.class);

  public String getTOPICS() {
    return TOPICS;
  }

  public void setTOPICS(String TOPICS) {
    this.TOPICS = TOPICS;
  }

  public String getSUBS() {
    return SUBS;
  }

  public void setSUBS(String SUBS) {
    this.SUBS = SUBS;
  }


  @Value("${GOOGLE_CLOUD_PUBSUB_TOPIC}")
  private String TOPICS;
  @Value("${GOOGLE_CLOUD_PUBSUB_SUBSCRIPTION}")
  private String SUBS ;


  public static void main(String[] args) {
    SpringApplication.run(PubSubApplication.class, args);
  }

  @Bean
  @ServiceActivator(inputChannel = "pubSubOutputChannel")
  public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {

    

    PubSubMessageHandler adapter =
            new PubSubMessageHandler(pubsubTemplate, TOPICS);
    adapter.setPublishCallback(new ListenableFutureCallback<String>() {
    @Override
    public void onFailure(Throwable ex) {
        LOGGER.info("There was an error sending the message.");
      LOGGER.info(" Topics" + TOPICS);
      LOGGER.info(" SUBS" + SUBS);
     }

      @Override
      public void onSuccess(String result) {
        LOGGER.info("Message was sent successfully.");
        LOGGER.info(" Topics" + TOPICS);
        LOGGER.info(" SUBS" + SUBS);

      }
    });

    return adapter;
  }

  @MessagingGateway(defaultRequestChannel = "pubSubOutputChannel")
  public interface PubSubOutboundGateway {
    String sendToPubSub(String message);
  }
}