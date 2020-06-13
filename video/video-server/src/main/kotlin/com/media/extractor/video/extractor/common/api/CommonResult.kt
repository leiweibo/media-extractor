package com.media.extractor.video.extractor.common.api

class CommonResult<T> {

    var success: Boolean? = null
    var code: Long ? = null
    var info: String ? = null
    var data: T ? = null

    constructor(code: Long?, msg: String?, data: T? = null) {
        this.code = code
        this.info =msg
        this.data = data
    }

    companion object {
        fun<T> success(data: T): CommonResult<T> {
            return CommonResult(ResultCode.SUCCESS.code, ResultCode.SUCCESS.message, data)
        }
    }
}