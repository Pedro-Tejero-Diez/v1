package org.springframework.boot.autoconfigure.jmx;

import javax.management.MBeanServer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;

/**
 * Bean definitions for {@link JmxAutoConfiguration}.
 */
public class JmxAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration'.
   */
  private static BeanInstanceSupplier<JmxAutoConfiguration> getJmxAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JmxAutoConfiguration>forConstructor(JmxProperties.class)
            .withGenerator((registeredBean, args) -> new JmxAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'jmxAutoConfiguration'.
   */
  public static BeanDefinition getJmxAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JmxAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getJmxAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mbeanExporter'.
   */
  private static BeanInstanceSupplier<AnnotationMBeanExporter> getMbeanExporterInstanceSupplier() {
    return BeanInstanceSupplier.<AnnotationMBeanExporter>forFactoryMethod(JmxAutoConfiguration.class, "mbeanExporter", ObjectNamingStrategy.class, BeanFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JmxAutoConfiguration.class).mbeanExporter(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'mbeanExporter'.
   */
  public static BeanDefinition getMbeanExporterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AnnotationMBeanExporter.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getMbeanExporterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'objectNamingStrategy'.
   */
  private static BeanInstanceSupplier<ParentAwareNamingStrategy> getObjectNamingStrategyInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ParentAwareNamingStrategy>forFactoryMethod(JmxAutoConfiguration.class, "objectNamingStrategy")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(JmxAutoConfiguration.class).objectNamingStrategy());
  }

  /**
   * Get the bean definition for 'objectNamingStrategy'.
   */
  public static BeanDefinition getObjectNamingStrategyBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ParentAwareNamingStrategy.class);
    beanDefinition.setInstanceSupplier(getObjectNamingStrategyInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mbeanServer'.
   */
  private static BeanInstanceSupplier<MBeanServer> getMbeanServerInstanceSupplier() {
    return BeanInstanceSupplier.<MBeanServer>forFactoryMethod(JmxAutoConfiguration.class, "mbeanServer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(JmxAutoConfiguration.class).mbeanServer());
  }

  /**
   * Get the bean definition for 'mbeanServer'.
   */
  public static BeanDefinition getMbeanServerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MBeanServer.class);
    beanDefinition.setInstanceSupplier(getMbeanServerInstanceSupplier());
    return beanDefinition;
  }
}
