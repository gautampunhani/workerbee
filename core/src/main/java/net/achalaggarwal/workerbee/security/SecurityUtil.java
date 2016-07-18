package net.achalaggarwal.workerbee.security;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.lang.String.format;
import static org.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab;

public class SecurityUtil {
  private static Configuration conf = new Configuration();
  private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

  public static void login(
    String keyTabUser,
    String keytabPath,
    String kerberosConfPath,
    String debug
  ) throws IOException {
    System.setProperty("sun.security.krb5.debug", debug);
    logger.info(format("login with principal=%s, keytabPath=%s, kerberosConfPath=%s", keyTabUser, keytabPath, kerberosConfPath));
    System.setProperty("java.security.krb5.conf", kerberosConfPath);

    conf.set("hadoop.security.authentication", "Kerberos");

    UserGroupInformation.setConfiguration(conf);
    loginUserFromKeytab(keyTabUser, keytabPath);
  }
}
