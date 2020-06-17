package com.media.extractor.video.extractor.service

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.media.extractor.video.extractor.common.api.res.VideoUrlInfoRaw2Res
import com.media.extractor.video.extractor.common.api.res.VideoUrlInfoRawRes
import com.media.extractor.video.extractor.common.api.res.VideoUrlInfoRes
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class RequestVideoInfoService {
    @Value("\${wx.video.url1}")
    lateinit var videoApiUrl1: String

    @Value("\${wx.video.url2}")
    lateinit var videoApiUrl2: String

    @Autowired
    lateinit var restTemplate: RestTemplate
    
    val logger = LoggerFactory.getLogger(RequestVideoInfoService::class.java)

    fun requestVideoInfo(vid: String): VideoUrlInfoRes {
        if (vid.startsWith("wxv")) {
            // 通过 https://mp.weixin.qq.com/mp/videoplayer?action=get_mp_video_play_url&vid=wxv_1331528065104674816
            // 这个接口获取
            var builder = UriComponentsBuilder.fromHttpUrl(videoApiUrl1)
                    .queryParam("action", "get_mp_video_play_url")
                    .queryParam("vid", vid)

            var finalUrl = builder.toUriString()
            var rawRes = restTemplate.getForEntity<VideoUrlInfoRawRes>(finalUrl, VideoUrlInfoRawRes::class.java)
            return VideoUrlInfoRes.convertFromRawRes(rawRes.body!!)
        } else {
            // https://h5vv.video.qq.com/getinfo?callback=txplayerJsonpCallBack_getinfo_67771&defaultfmt=auto&otype=json&appver=3.4.40&platform=11001&sdtfrom=v5010&defnpayver=0&appVer=3.4.40&host=v.qq.com&ehost=https%3A%2F%2Fv.qq.com%2Ftxp%2Fiframe%2Fplayer.html&refer=v.qq.com&sphttps=1&spwm=4&vid=b05382nzw9j&defn=auto&show1080p=true&dtype=1&clip=4&fmt=auto&defsrc=1
            var builder = UriComponentsBuilder.fromHttpUrl(videoApiUrl2)
                    .queryParam("callback", "txplayerJsonpCallBack_getinfo_67771")
                    .queryParam("defaultfmt", "auto")
                    .queryParam("otype", "json")
                    .queryParam("appver", "3.4.40")
                    .queryParam("platform", "11001")
                    .queryParam("sdtfrom", "v5010")
                    .queryParam("defnpayver", "0")
                    .queryParam("appVer", "3.4.40")
                    .queryParam("host", "v.qq.com")
                    .queryParam("ehost", "https://v.qq.com/txp/iframe/Fplayer.html")
                    .queryParam("refer", "v.qq.com")
                    .queryParam("sphttps", "1")
                    .queryParam("spwm", "4")
                    .queryParam("vid", vid)
                    .queryParam("defn", "auto")
                    .queryParam("show1080p", true)
                    .queryParam("dtype", "1")
                    .queryParam("clip", "4")
                    .queryParam("fmt", "auto")
                    .queryParam("defsrc", "1")
            var finalUrl = builder.toUriString()
            var rawRes = restTemplate.getForEntity(finalUrl, String::class.java)
            var rawResStr = rawRes.body
            rawResStr = rawResStr?.substring("txplayerJsonpCallBack_getinfo_67771".length + 1, rawResStr.length - 1)
            logger.info("Get video info: {}", rawResStr)
            return VideoUrlInfoRes.convertFromRawRes(jsonToObject<VideoUrlInfoRaw2Res>(rawResStr!!))
        }
    }

    fun <T> jsonToObject(jsonStr: String):VideoUrlInfoRaw2Res {
        var mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonStr) as VideoUrlInfoRaw2Res
    }
}