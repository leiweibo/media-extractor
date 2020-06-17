package com.media.extractor.video.extractor.common.api.res

class VideoUrlInfoRes {
    var title: String = ""
    var url: String = ""

    companion object {
        fun convertFromRawRes(rawRes: VideoUrlInfoRawRes): VideoUrlInfoRes {
            var result = VideoUrlInfoRes()
            result.title = rawRes.title
            result.url = rawRes.url_info[0].url
            return result
        }

        fun convertFromRawRes(rawRes: VideoUrlInfoRaw2Res): VideoUrlInfoRes {
            var result = VideoUrlInfoRes()
            result.title = rawRes.vl.vi[0].title
            result.url = "http://ugcdx.qq.com/" + rawRes.vl.vi[0].fileName + "?vkey=" + rawRes.vl.vi[0].fvkey
            return result
        }
    }
}