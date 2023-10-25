package com.jump2digital.challenge.v1.services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PlayerSkinServiceImp}.
 */
public class PlayerSkinServiceImp__BeanDefinitions {
  /**
   * Get the bean definition for 'playerSkinServiceImp'.
   */
  public static BeanDefinition getPlayerSkinServiceImpBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlayerSkinServiceImp.class);
    InstanceSupplier<PlayerSkinServiceImp> instanceSupplier = InstanceSupplier.using(PlayerSkinServiceImp::new);
    instanceSupplier = instanceSupplier.andThen(PlayerSkinServiceImp__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
