package com.media.extractor.video.extractor.service

import org.springframework.stereotype.Service

@Service
class RequestVideoInfoService {
    fun requestVideoInfo(vid: String) {
        if (vid.startsWith("wxv")) {
            // 通过 https://mp.weixin.qq.com/mp/videoplayer?action=get_mp_video_play_url&vid=wxv_1331528065104674816
            // 这个接口获取
        } else {
            // https://h5vv.video.qq.com/getinfo?callback=txplayerJsonpCallBack_getinfo_67771&defaultfmt=auto&otype=json&appver=3.4.40&platform=11001&sdtfrom=v5010&defnpayver=0&appVer=3.4.40&host=v.qq.com&ehost=https%3A%2F%2Fv.qq.com%2Ftxp%2Fiframe%2Fplayer.html&refer=v.qq.com&sphttps=1&spwm=4&vid=b05382nzw9j&defn=auto&show1080p=true&dtype=1&clip=4&fmt=auto&defsrc=1
        }
    }
}