package com.cy.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * Application configuration properties
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "swallow")
public class ApplicationProperties {

  private final System system = new System();

  private final Uploadfile uploadfile = new Uploadfile();

  private final Ip ip = new Ip();

  private final FromMail fromMail = new FromMail();

  @Data
  public static class System {

    private String name = "swallow管理系统V0.0.1";
  }

  @Data
  public static class Uploadfile {

    private String src = "./file";
  }

  @Data
  public static class Ip {

      private String analysis = "http://ip.taobao.com/service/getIpInfo.php?ip=,http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js&ip=";
  }

  @Data
  public static class FromMail {

      private String addr = "swallow";
  }
}
