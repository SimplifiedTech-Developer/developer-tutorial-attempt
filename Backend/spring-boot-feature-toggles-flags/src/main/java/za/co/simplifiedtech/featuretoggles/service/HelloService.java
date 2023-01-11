package za.co.simplifiedtech.featuretoggles.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;
import za.co.simplifiedtech.featuretoggles.enums.FeatureToggleFlags;

@Service
@RequiredArgsConstructor
public class HelloService {

  private final FeatureManager featureManager;

  public String hello() {
    if (featureManager.isActive(FeatureToggleFlags.PERSONALISED_GREETING)) {
      return "Dumela";
    } else {
      return "Hello world";
    }
  }
}

