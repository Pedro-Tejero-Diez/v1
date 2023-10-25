package org.springframework.boot.autoconfigure.jmx;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JmxProperties}.
 */
public class JmxProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'jmxProperties'.
   */
  public static BeanDefinition getJmxPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JmxProperties.class);
    beanDefinition.setInstanceSupplier(JmxProperties::new);
    return beanDefinition;
  }
}
