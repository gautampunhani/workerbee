package net.achalaggarwal.workerbee.security;

import java.io.IOException;

public class KerberosAuthenticator implements Authenticator{

  private String keyTabUser;
  private String keytabPath;
  private String kerberosConfPath;
  private String debug;

  public KerberosAuthenticator(String keyTabUser,
                               String keytabPath,
                               String kerberosConfPath,
                               String debug) {

    this.keyTabUser = keyTabUser;
    this.keytabPath = keytabPath;
    this.kerberosConfPath = kerberosConfPath;
    this.debug = debug;
  }

  @Override
  public void authenticate() throws IOException {
    SecurityUtil.login(keyTabUser, keytabPath, kerberosConfPath, debug);
  }
}
