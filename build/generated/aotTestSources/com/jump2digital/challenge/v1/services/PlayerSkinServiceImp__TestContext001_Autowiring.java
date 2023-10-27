package com.jump2digital.challenge.v1.services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PlayerSkinServiceImp}.
 */
public class PlayerSkinServiceImp__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PlayerSkinServiceImp apply(RegisteredBean registeredBean,
      PlayerSkinServiceImp instance) {
    instance.playerskinrepository = AutowiredFieldValueResolver.forRequiredField("playerskinrepository").resolve(registeredBean);
    return instance;
  }
}
