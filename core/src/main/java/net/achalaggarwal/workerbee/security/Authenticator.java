package net.achalaggarwal.workerbee.security;

import java.io.IOException;

public interface Authenticator {
  void authenticate() throws IOException;
}
