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

interface Attachments {
    val type: String
}

class AudioAttachment(
    val insideAttachment: Audio
): Attachments {
    override val type: String = "audio"
}

class VideoAttachment(
    val insideAttachment: Video
): Attachments {
    override val type: String = "video"
}

class PhotoAttachment(
    val insideAttachment: Photo
): Attachments {
    override val type: String = "photo"
}

class DocumentAttachment(
    val insideAttachment: Doc
): Attachments {
    override val type: String = "doc"
}

class LinkAttachment(
    val insideAttachment: Link
): Attachments {
    override val type: String = "link"
}

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int
)

class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String
)

class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String
)

class Link(
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
    val post = Post(
        1,
        2,
        "createdBy",
        15,
        text = null,
//        "text",
//        comments = Comments(3, canPost = false, groupsCanPost = false, canClose = true, canOpen = true),
        comments = null,
        likes = Likes(5, userLikes = true, canLike = true, canPublish = false),
        "post",
        canDelete = true,
        isFavourite = false,
    )

    println(post)
}