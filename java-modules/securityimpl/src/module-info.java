import br.com.myapp.security.SecuritManager;
import br.com.myapp.security.impl.SecuritManagerImpl;

module securityimpl {
    requires security;
    provides SecuritManager with SecuritManagerImpl;
}