package za.co.simplifiedtech.featuretoggles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import za.co.simplifiedtech.featuretoggles.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final HelloService helloService;

  @GetMapping( value = "/hello")
  public String sayHello() {
    return helloService.hello();
  }
}
