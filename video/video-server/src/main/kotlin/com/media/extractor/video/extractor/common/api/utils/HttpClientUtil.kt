package com.media.extractor.video.extractor.common.api.utils

import org.apache.http.config.Registry
import org.apache.http.config.RegistryBuilder
import org.apache.http.conn.socket.ConnectionSocketFactory
import org.apache.http.conn.socket.PlainConnectionSocketFactory
import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustStrategy
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.apache.http.ssl.SSLContextBuilder
import org.springframework.stereotype.Component
import java.security.KeyManagementException
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext

@Component
class HttpClientUtil {
  @Throws(KeyStoreException::class, NoSuchAlgorithmException::class, KeyManagementException::class)
  fun acceptsUntrustedCertsHttpClient(): CloseableHttpClient? {
    val b: HttpClientBuilder = HttpClientBuilder.create()
    // setup a Trust Strategy that allows all certificates.
//
    val sslContext: SSLContext =
        SSLContextBuilder().loadTrustMaterial(null, object : TrustStrategy {
          @Throws(
              CertificateException::class) override fun isTrusted(
            arg0: Array<X509Certificate?>?,
            arg1: String?
          ): Boolean {
            return true
          }
        }).build()
    b.setSSLContext(sslContext)
    // don't check Hostnames, either.
//      -- use SSLConnectionSocketFactory.getDefaultHostnameVerifier(), if you don't want to weaken
    val hostnameVerifier: HostnameVerifier = NoopHostnameVerifier.INSTANCE
    // here's the special part:
//      -- need to create an SSL Socket Factory, to use our weakened "trust strategy";
//      -- and create a Registry, to register it.
//
    val sslSocketFactory =
        SSLConnectionSocketFactory(sslContext, hostnameVerifier)

    val socketFactoryRegistry: Registry<ConnectionSocketFactory> =
        RegistryBuilder.create<ConnectionSocketFactory>()
            .register("http", PlainConnectionSocketFactory.getSocketFactory())
            .register("https", sslSocketFactory)
            .build()
    // now, we create connection-manager using our Registry.
//      -- allows multi-threaded use
    val connMgr =
        PoolingHttpClientConnectionManager(socketFactoryRegistry)
    connMgr.setMaxTotal(200)
    connMgr.setDefaultMaxPerRoute(100)
    b.setConnectionManager(connMgr)
    // finally, build the HttpClient;
//      -- done!
    return b.build()
  }
}