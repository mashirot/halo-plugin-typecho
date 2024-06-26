package io.sakurasou.halo.typecho.entity

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * @author mashirot
 * 2024/5/6 23:08
 */

private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

class RawMetaData {
    val layout: String?
    val cid: Long?
    val title: String?
    val slug: String?
    val date: LocalDateTime
    val updated: LocalDateTime?
    val status: String?
    val author: String?
    val categories: List<String>?
    val tags: List<String>?
    val customSummary: String?

    constructor(results: Map<*, *>) {
        layout = results["layout"]?.toString()
        cid = results["cid"]?.toString()?.toLong()
        title = results["title"]?.toString()
        slug = results["slug"]?.toString()
        date = LocalDateTime.parse(results["date"] as String, dateTimeFormatter)
        updated = results["updated"]?.let { LocalDateTime.parse(it as String, dateTimeFormatter) }
        status = results["status"]?.toString()
        author = results["author"]?.toString()
        categories = results["categories"] as List<String>?
        tags = results["tags"] as List<String>?
        customSummary = results["customSummary"]?.toString()
    }
}
