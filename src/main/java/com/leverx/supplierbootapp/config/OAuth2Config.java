package com.leverx.supplierbootapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    private String clientId = "leverx";
    private String clientSecret = "{noop}leverx-secret-key";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAvEHvClIF1X5wXYs5G86XnHvpZlLFvxNQng/8m9tQJ2Oztsz6\n" +
            "RNYfUkU3YkCijtwxAIvtlwUAhg60rVspuYN8LrBGTHkEbK07gA0JPZLY/wE+pLPy\n" +
            "MIjcLFXtgTXbpCZHIBOyMwlWVMI9r+qwkHwORxgiKFLLzl2f43H0SLYRdcATidbP\n" +
            "N1cLN9RQzD9qmQyt1hsLGGDfdJ47h/VNUypd0PJPGR3zCbvoHozunT4j/e1wR5ql\n" +
            "DSkyJ/K/z56rM0IWvD0rQlU5N8TIJvZGn9l6NsUBnxhEellPh2elMjL/uH7udNuR\n" +
            "+c3v4XKWy1SKUd+tEwaxLSA2lNUikAE7XI+tvwIDAQABAoIBAQCjmMiaN11Kgm4z\n" +
            "XGFsgMPQAP57JUMjIS3Vrh7fcl7dXA84tDhoyYq+e9f9Uh3x9/e9edwmePpThUQN\n" +
            "wkMoK9Mm35i3rBLkPkaOqMV29L4OHI7LonS9KLHs9V9IAf21UG5Ouc8J+vtC/OmO\n" +
            "jmyRorzlm1tTn1/tHf9sMAMRjObvY1UG2d1Mb41PybvGcwl53SFP7QZxCjBTUNkU\n" +
            "sQlexcnZezm2w6qr/9uHF+L1zL0JntNfb+JPJxIg8T8OPwee/Ne7TlwKh4duWMrR\n" +
            "X+iJBfCTZNwnwtFZMD2yto05AkPKyD2PH/1mmH73k8k6J88UNyefgjiX6Zp92gBw\n" +
            "VicTbpoBAoGBAOwbJh9yEDateio44kjPyFflS13VEJl5EmDruZH0nej0V4WKlMUI\n" +
            "/00XG0uHsU03/MBiJX7iGZ5TwR5s01fYq5jGNO6g8nLu70+cmM4wAT+a4s55fuHv\n" +
            "DRyn9/0W4yv31iZ7sUggApgCXHjMDKjy0micPzZUJxoVLpFCupCHoDtfAoGBAMwe\n" +
            "rxXw395cSqLH8VwgnswMASpOEBQUyPdjscwzE6CzTLQdmNDeIbo/Rku/WungGg4D\n" +
            "AI7/ChsTJRSRg9iz7byswQnsM+jjPt1c5jfZLbwhmESRFqo7Bw1sz+wSwXCEFZhL\n" +
            "BXsfWcGYBFA07bkKu7qG6sGbgeSMEpl0TJFBzAmhAoGBAMZrOmqKzR1mRJhfHavb\n" +
            "Ep7rT58Xg8+2c7+H2nfSfzJaxYKwp72+he8fUAz1iAdA2eRDlwc+tBDeihkrk6Dr\n" +
            "sam+SJWSJK56Jhtdmv0MUsBFRf4HFJ6C6x39+uZy6Y71xL6qjJ30aLmeol/R+4Gw\n" +
            "LytCw8zAg+vjiTMCRQ9ZK0s5AoGAdwYBZFLjx56batYaGHVxA1yQpWGFoKAKG6+H\n" +
            "cqHp9Q/4TyLfBBQzKI5S6EJ5udySdM8tWTTAaM8+FQNRFWC95QH7QlT4Y/l2o8/S\n" +
            "8ofyUjxotLrBs5vd3ecwSuEY6QosKXS9inDafres9DQY1oi6tOaNJz4NfP5srgyR\n" +
            "xTXPy2ECgYByc/a1EnLIH3rt+/EchzUVBcerV3bLvvLM1mg+2FvQO4L7OgpnfAuC\n" +
            "+OWHP++KwCyARlcWGbSU+8ZqIAjUMjYzhDlf/oqsDMaLlmyBl+N9ZxBbo8XPHruU\n" +
            "LzW0y0Ut1uob3O67dhgDO1fzNDRjN6CGrZAYXyzDS8TO8nBu1DeyrQ==\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvEHvClIF1X5wXYs5G86X\n" +
            "nHvpZlLFvxNQng/8m9tQJ2Oztsz6RNYfUkU3YkCijtwxAIvtlwUAhg60rVspuYN8\n" +
            "LrBGTHkEbK07gA0JPZLY/wE+pLPyMIjcLFXtgTXbpCZHIBOyMwlWVMI9r+qwkHwO\n" +
            "RxgiKFLLzl2f43H0SLYRdcATidbPN1cLN9RQzD9qmQyt1hsLGGDfdJ47h/VNUypd\n" +
            "0PJPGR3zCbvoHozunT4j/e1wR5qlDSkyJ/K/z56rM0IWvD0rQlU5N8TIJvZGn9l6\n" +
            "NsUBnxhEellPh2elMjL/uH7udNuR+c3v4XKWy1SKUd+tEwaxLSA2lNUikAE7XI+t\n" +
            "vwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientId).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }

}
