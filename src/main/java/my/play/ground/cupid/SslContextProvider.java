package my.play.ground.cupid;

import com.oath.auth.KeyRefresher;
import com.oath.auth.Utils;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.SSLContext;

@Slf4j
public class SslContextProvider {
    private SSLContext sslContext;


    public SslContextProvider(
            String trustStorePath,
            String trustStorePassword,
            String certPath,
            String keyPath) {
        try {
            KeyRefresher keyRefresher = Utils.generateKeyRefresher(trustStorePath,
                    trustStorePassword,
                    certPath,
                    keyPath);
            keyRefresher.startup();
            sslContext = Utils.buildSSLContext(keyRefresher.getKeyManagerProxy(),
                    keyRefresher.getTrustManagerProxy());
        } catch (Exception e) {
            log.error("failed to init, message={}", e.getMessage(), e);
        }
    }

    /**
     * Returns a SSL context
     *
     * @return SSL context
     */
    public SSLContext getSslContext() {
        return sslContext;
    }

}
