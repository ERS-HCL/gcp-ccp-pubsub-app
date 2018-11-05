package com.cloud.hybrid.ccp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@RestController
public class WebAppController {

  private final PubSubApplication.PubSubOutboundGateway messagingGateway;

  public WebAppController(PubSubApplication.PubSubOutboundGateway messagingGateway) {
    this.messagingGateway = messagingGateway;
  }


/*  @PostMapping("/postMessage")
  public RedirectView postMessage(@RequestParam("message") String message) {
    this.messagingGateway.sendToPubSub(message);
    return new RedirectView("/");
  }*/

  @PostMapping("/publish")
  @Async
  public CompletableFuture<String>  publishtMessage(@RequestBody InputData message) {

      String output = null;
      try {
          ObjectMapper mapper = new ObjectMapper();
          mapper.enable(SerializationFeature.INDENT_OUTPUT);
          String input = mapper.writeValueAsString(message);
          System.out.println(" Json : " + input + "\n");
          CompletableFuture<String> completableFuture = new CompletableFuture<>();
            Executors.newCachedThreadPool().submit(() -> {
                    Thread.sleep(25);
                    String out = this.messagingGateway.sendToPubSub(input);
                    completableFuture.complete("OK");
                    return completableFuture;
            });
            return null;
      }
      catch(Exception ex){

          return null;
      }
  }
}
