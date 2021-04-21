package my.play.ground.cupid;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

@Slf4j
abstract class HttpClientBase {
    private OkHttpClient client;
    private static String base = "https://b-cupid-athenz.nevec.yahoo.com:4443";
    private static String trustStorePath = "/opt/yahoo/share/ssl/certs/yahoo_certificate_bundle.jks";
    private static String trustStorePassword = "changeit";
    private static String keyPath = "/Users/zli02/.athenz/key";
    private static String certPath = "/Users/zli02/.athenz/cupid-beta.cert";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    protected HttpClientBase() {
        this.client = new OkHttpClient.Builder()
                .sslSocketFactory(createSslContext().getSocketFactory(), getTrustManagers())
                .hostnameVerifier((s, sslSession) -> true)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        // base = "https://egs-cupid-development.v2-canary1-tp2.omega.yahoo.com:4443";
    }

    private void setInt() {
        base = "https://sb-cupid-athenz.nevec.yahoo.com:4443";
        certPath = "/Users/zli02/.athenz/cupid-int.cert";
    }

    protected void get(String path) {
        Request request = new Request.Builder()
                .url(base + path)
                .build();
        call(request);
    }

    protected void post(String path, String json) {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(base + path)
                .post(body)
                .build();
        call(request);
    }

    private void call(Request request) {
        try {
            Response response = client.newCall(request).execute();

            String body = response.body().string();
            if (response.code() != 201) {
                log.warn("get {}, body={}", response.code(), body);
            }
            // log.info("code={}, body={}", response.code(), body);
            response.close();
        } catch (IOException e) {
            log.error("failed to call {} {}, message={}", request.method(), request.url().toString(), e.getMessage());
        }
    }

    private SSLContext createSslContext() {
        return new SslContextProvider(trustStorePath, trustStorePassword, certPath, keyPath).getSslContext();
    }

    private X509TrustManager getTrustManagers() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };
        return (X509TrustManager) trustAllCerts[0];
    }
}
