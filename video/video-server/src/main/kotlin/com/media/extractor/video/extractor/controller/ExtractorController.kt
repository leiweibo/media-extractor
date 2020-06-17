package com.media.extractor.video.extractor.controller

import com.media.extractor.video.extractor.common.api.CommonResult
import com.media.extractor.video.extractor.common.api.req.VideoUrlExtractorReq
import com.media.extractor.video.extractor.common.api.res.VideoUrlInfoRes
import com.media.extractor.video.extractor.service.RequestVideoInfoService
import com.media.extractor.video.extractor.service.RequestWebService
import kotlinx.coroutines.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExtractorController {

    @Autowired
    lateinit var service: RequestWebService

    @Autowired
    lateinit var videoService: RequestVideoInfoService

    // 最多3个，超过三个目前前端还没有适配
    val arraySize = 3
    @PostMapping("/getVideoUrls")
    @ResponseBody
    fun hello(@RequestBody req: VideoUrlExtractorReq):CommonResult<MutableList<MutableList<VideoUrlInfoRes>>> {
        println(req.url)
        var vids = service.requestWeb(req.url!!)
        var finalResult = mutableListOf<MutableList<VideoUrlInfoRes>>()
        var results = mutableListOf<VideoUrlInfoRes>()

        for(vid in vids) {
            var res = videoService.requestVideoInfo(vid)
            if (results.size < arraySize) {
                results.add(res)
            }
            if (results.size == arraySize) {
                finalResult.add(results.toMutableList())
                results.clear()
            }
        }
        if (results.size > 0) {
            finalResult.add(results)
        }
        return CommonResult.success(finalResult)
    }
}