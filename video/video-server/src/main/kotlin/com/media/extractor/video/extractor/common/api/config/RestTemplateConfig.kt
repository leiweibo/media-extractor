package com.media.extractor.video.extractor.common.api.config

import com.media.extractor.video.extractor.common.api.utils.HttpClientUtil
import org.apache.http.impl.client.CloseableHttpClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {
  @Autowired
  lateinit var httpClientUtil: HttpClientUtil

  @Bean
  fun httpsRestTemplate(httpsFactory: HttpComponentsClientHttpRequestFactory?): RestTemplate? {
    val restTemplate = RestTemplate(httpsFactory!!)
    restTemplate.errorHandler = object : ResponseErrorHandler {
      override fun hasError(p0: ClientHttpResponse): Boolean {
        return false
      }

      override fun handleError(p0: ClientHttpResponse) {
        // 默认处理非200的返回，会抛异常
      }

    }
    return restTemplate
  }

  @Bean(name = arrayOf("httpsFactory")) @Throws(
      Exception::class)
  fun httpComponentsClientHttpRequestFactory(): HttpComponentsClientHttpRequestFactory? {
    val httpClient: CloseableHttpClient? = httpClientUtil.acceptsUntrustedCertsHttpClient()
    val httpsFactory =
        HttpComponentsClientHttpRequestFactory(httpClient!!)
    httpsFactory.setReadTimeout(40000)
    httpsFactory.setConnectTimeout(40000)
    return httpsFactory
  }
}