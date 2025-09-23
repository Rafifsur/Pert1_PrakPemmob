package com.example.pertemuan1.data.model

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class SearchResponse(
   @SerializedName("docs")
    val docs: List<BookDoc>
)

data class BookDoc(
    @SerializedName("title")
    val title: String?,
    @SerializedName("author_name")
    val authorName: List<String>?,
    @SerializedName("first_publish_year")
    val firstPublishYear: Int?
)
