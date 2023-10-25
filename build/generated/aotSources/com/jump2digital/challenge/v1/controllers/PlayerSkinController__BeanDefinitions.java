package com.jump2digital.challenge.v1.controllers;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PlayerSkinController}.
 */
public class PlayerSkinController__BeanDefinitions {
  /**
   * Get the bean definition for 'playerSkinController'.
   */
  public static BeanDefinition getPlayerSkinControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlayerSkinController.class);
    InstanceSupplier<PlayerSkinController> instanceSupplier = InstanceSupplier.using(PlayerSkinController::new);
    instanceSupplier = instanceSupplier.andThen(PlayerSkinController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
