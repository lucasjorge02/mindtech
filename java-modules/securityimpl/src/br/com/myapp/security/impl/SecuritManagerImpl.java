package br.com.myapp.security.impl;

import br.com.myapp.security.SecuritManager;

import java.util.Objects;

public class SecuritManagerImpl  implements SecuritManager {

    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username,"A") && Objects.equals(password,"B");
    }
}
