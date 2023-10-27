package com.jump2digital.challenge.v1.controllers;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PlayerSkinController}.
 */
public class PlayerSkinController__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PlayerSkinController apply(RegisteredBean registeredBean,
      PlayerSkinController instance) {
    instance.playerskinservice = AutowiredFieldValueResolver.forRequiredField("playerskinservice").resolve(registeredBean);
    return instance;
  }
}
