import java.util.Objects

data class Post(
    val id: Int,
    val ownerId: Int,
    val createdBy: String,
    val date: Int,
    val text: String?,
    val comments: Comments?,
    val likes: Likes?,
    val postType: String,
    val canDelete: Boolean,
    val isFavourite: Boolean,
    var attachments: Array<Attachments> = emptyArray()

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        return attachments.contentHashCode()
    }
}

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

sealed class Attachments (val type: String)

data class AudioAttachment(
    val insideAttachment: Audio
): Attachments ("audio")

data class VideoAttachment(
    val insideAttachment: Video
): Attachments ("video")

data class PhotoAttachment(
    val insideAttachment: Photo
): Attachments ("photo")


data class DocumentAttachment(
    val insideAttachment: Doc
): Attachments ("doc")

data class LinkAttachment(
    val insideAttachment: Link
): Attachments ("link")

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int
)

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String
)

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String
)

data class Link(
    val url: Int,
    val title: Int,
    val caption: String,
    val description: String,
    val previewUrl: String
)



object WallService {

    fun clear() {
        posts = emptyArray()
    }

    private var posts = emptyArray<Post>()
    private var privateId = 0;

    fun add(post: Post): Post {
        posts += post.copy(id = privateId++)
        return posts.last()
    }


    fun update(post: Post): Boolean {
        for ((index, postInArray) in posts.withIndex()) {
            if (post.id == postInArray.id) {
                posts[index] = post.copy(ownerId = postInArray.ownerId, date = postInArray.date)
                return true
            }
        }
        return false
    }
}


fun main() {
    val attachment: Attachments = AudioAttachment(Audio(1, 1, "", "", 1))
    println(attachment.type)
}