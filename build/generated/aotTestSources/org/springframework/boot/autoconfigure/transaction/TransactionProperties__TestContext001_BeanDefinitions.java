package org.springframework.boot.autoconfigure.transaction;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TransactionProperties}.
 */
public class TransactionProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'transactionProperties'.
   */
  public static BeanDefinition getTransactionPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionProperties.class);
    beanDefinition.setInstanceSupplier(TransactionProperties::new);
    return beanDefinition;
  }
}
