package com.media.extractor.video.extractor.service

import org.jsoup.Jsoup
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class RequestWebService {
    fun requestWeb(url: String): MutableList<String> {
        var doc = Jsoup.connect(url).get();
        var iframes = doc.select("iframe")
        var results:MutableList<String> = mutableListOf()
        for(iframe in iframes) {
            var dataSrc = iframe.attr("data-src")
            try {
                var urls = dataSrc.split("?")
                if (urls.size > 1) {
                    var params = urls[1]
                    var paramsGrps = params.split("&")
                    for (paramsGrp in paramsGrps) {
                        var params = paramsGrp.split("=")
                        if (params.size == 2) {
                            if (params[0] == "vid") {
                                results.add(params[1])
                                break
                            }
                        }
                    }

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return results;
    }
}