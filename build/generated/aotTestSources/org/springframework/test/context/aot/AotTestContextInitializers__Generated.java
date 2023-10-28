package org.springframework.test.context.aot;

import com.jump2digital.challenge.v1.V1ApplicationTests__TestContext001_ApplicationContextInitializer;
import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Generated mappings for {@link AotTestContextInitializers}.
 */
public class AotTestContextInitializers__Generated {
  public static Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> getContextInitializers(
      ) {
    Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> map = new HashMap<>();
    map.put("com.jump2digital.challenge.v1.V1ApplicationTests", () -> new V1ApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.jump2digital.challenge.v1.testcontrollers.PlayerSkinControllerTest", () -> new V1ApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.jump2digital.challenge.v1.testrepository.PlayerSkinRepositoryTest", () -> new V1ApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.jump2digital.challenge.v1.testservices.PlayerSkinServiceImpTest", () -> new V1ApplicationTests__TestContext001_ApplicationContextInitializer());
    return map;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializerClasses(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> map = new HashMap<>();
    map.put("com.jump2digital.challenge.v1.V1ApplicationTests", V1ApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.jump2digital.challenge.v1.testcontrollers.PlayerSkinControllerTest", V1ApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.jump2digital.challenge.v1.testrepository.PlayerSkinRepositoryTest", V1ApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.jump2digital.challenge.v1.testservices.PlayerSkinServiceImpTest", V1ApplicationTests__TestContext001_ApplicationContextInitializer.class);
    return map;
  }
}
