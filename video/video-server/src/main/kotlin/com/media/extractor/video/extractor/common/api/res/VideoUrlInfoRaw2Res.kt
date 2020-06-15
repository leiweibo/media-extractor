package com.media.extractor.video.extractor.common.api.res

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.beans.factory.annotation.Value

class VideoUrlInfoRaw2Res {
    lateinit var ip:String
    lateinit var vl: VL
}

class VL {
    var cnt: Int = 0
    lateinit var vi: MutableList<VideoInfo>
}

class VideoInfo {
    @JsonProperty("fn")
    lateinit var fileName:String
    @JsonProperty("fvkey")
    lateinit var fvkey: String
    @JsonProperty("ti")
    lateinit var title:String

    lateinit var ul: UL

}

class UL {
    lateinit var ui: MutableList<VideoUrlInfo>
}

class VideoUrlInfo {
    lateinit var url: String
    var vt: Int = 0
    var dtc: Int = 0
    var dt: Int = 0
}
