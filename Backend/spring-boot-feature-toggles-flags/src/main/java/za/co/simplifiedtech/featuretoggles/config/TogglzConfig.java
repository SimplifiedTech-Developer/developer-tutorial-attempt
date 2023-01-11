package za.co.simplifiedtech.featuretoggles.config;

import za.co.simplifiedtech.featuretoggles.enums.FeatureToggleFlags;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.activation.ActivationStrategyProvider;
import org.togglz.core.activation.DefaultActivationStrategyProvider;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.spi.FeatureProvider;

@Configuration
public class TogglzConfig {

  @Bean
  public FeatureProvider featureProvider() {
    EnumBasedFeatureProvider enumBasedFeatureProvider = new EnumBasedFeatureProvider();
    enumBasedFeatureProvider.addFeatureEnum(FeatureToggleFlags.class);
    return enumBasedFeatureProvider;
  }

  @Bean
  public StateRepository stateRepository(DataSource dataSource) {
    return new JDBCStateRepository(dataSource, "togglz_features");
  }

  @Bean
  public ActivationStrategyProvider activationStrategyProvider(List<ActivationStrategy> activationStrategies) {
    DefaultActivationStrategyProvider defaultActivationStrategyProvider = new DefaultActivationStrategyProvider();
    defaultActivationStrategyProvider.addActivationStrategies(activationStrategies);
    return defaultActivationStrategyProvider;
  }

  @Bean
  public FeatureManager featureManager(StateRepository stateRepository,
                                       FeatureProvider featureProvider,
                                       ActivationStrategyProvider activationStrategyProvider) {
    return new FeatureManagerBuilder()
        .stateRepository(stateRepository)
        .featureProvider(featureProvider)
        .activationStrategyProvider(activationStrategyProvider)
        .build();
  }
}

