package br.com.myapp.security;

import java.util.Objects;

public interface SecuritManager {

    public boolean authenticate(String username, String password);
}
