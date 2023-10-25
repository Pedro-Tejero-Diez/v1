package com.jump2digital.challenge.v1;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link V1Application}.
 */
public class V1Application__BeanDefinitions {
  /**
   * Get the bean definition for 'v1Application'.
   */
  public static BeanDefinition getVApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(V1Application.class);
    beanDefinition.setTargetType(V1Application.class);
    ConfigurationClassUtils.initializeConfigurationClass(V1Application.class);
    beanDefinition.setInstanceSupplier(V1Application$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
