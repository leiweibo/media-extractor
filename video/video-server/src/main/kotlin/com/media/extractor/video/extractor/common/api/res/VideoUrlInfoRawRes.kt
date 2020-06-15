package com.media.extractor.video.extractor.common.api.res

class VideoUrlInfoRawRes {
    lateinit var url_info: MutableList<UrlInfo>
    lateinit var title: String
}

class UrlInfo {
    lateinit var url: String
    var format_id: Long = 0
    var duration_ms: Long = 0
    var filesize: Long = 0
    var width: Int = 0
    var height: Int = 0
}
