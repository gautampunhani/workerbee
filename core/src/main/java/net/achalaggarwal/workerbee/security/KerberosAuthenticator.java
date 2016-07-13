package net.achalaggarwal.workerbee.security;

import java.io.IOException;

public class KerberosAuthenticator implements Authenticator{

  private String principal;
  private String keytabPath;
  private String kerberosConfPath;
  private String debug;

  public KerberosAuthenticator(String principal,
                               String keytabPath,
                               String kerberosConfPath,
                               String debug) {

    this.principal = principal;
    this.keytabPath = keytabPath;
    this.kerberosConfPath = kerberosConfPath;
    this.debug = debug;
  }

  @Override
  public void authenticate() throws IOException {
    SecurityUtil.login(principal, keytabPath, kerberosConfPath, debug);
  }
}
