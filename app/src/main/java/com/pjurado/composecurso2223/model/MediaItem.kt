package com.pjurado.composecurso2223.model

import com.pjurado.composecurso2223.model.MediaItem.Type

data class MediaItem(
    val id: Int,
    val title: String,
    val photo: String,
    val type: Type
){
    enum class Type{PHOTO, VIDEO}
}

fun getMedia() = (1..100).map{
    MediaItem(
        id = it,
        title = "Título $it",
        photo = "https://loremflickr.com/240/320/people?lock=$it/",
        type = if (it % 3 == 0) Type.VIDEO else Type.PHOTO
    )
}
