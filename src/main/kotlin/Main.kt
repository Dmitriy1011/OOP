import java.util.Objects

data class Post(
    val id: Int,
    val ownerId: Int,
    val createdBy: String,
    val date: Int,
    val text: String?,
    val comments: Comment?,
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

sealed class Attachments(val type: String)

data class AudioAttachment(
    val insideAttachment: Audio
) : Attachments("audio")

data class VideoAttachment(
    val insideAttachment: Video
) : Attachments("video")

data class PhotoAttachment(
    val insideAttachment: Photo
) : Attachments("photo")


data class DocumentAttachment(
    val insideAttachment: Doc
) : Attachments("doc")

data class LinkAttachment(
    val insideAttachment: Link
) : Attachments("link")

data class wallComment(
    val insideAttachment: Comment
) : Attachments("wallComment")

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

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut
)

data class Donut(
    val idDon: Boolean,
    val placeHolder: String
)


data class ReportComment(
    val ownerId: Int,
    val commentId: Int,
    val reason: Int
)

class PostNotFoundException(message: String) : RuntimeException(message)

object WallService {

    fun clear() {
        posts = emptyArray()
    }

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = arrayOf(1, 2, 3, 4, 5, 6, 8)
    private var privateId = 0;

    fun add(post: Post): Post {
        posts += post.copy(id = privateId++)
        return posts.last()
    }


    class PostNotFoundException(message: String) : RuntimeException(message)
    class ReportNumberNotFoundException(message: String) : RuntimeException(message)

    fun reportComment(commentId: Int, claimCode: Int): Int {
        for (comment in comments) {
            if (commentId == comment.id) {
                for (report in reports) {
                    if (claimCode == report) {
                        return 1
                    }
                }
                throw ReportNumberNotFoundException("Report is not found")
            }
        }
        throw PostNotFoundException("Comment is not found")
    }

    fun createComment
                (postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (postId == post.id) {
                comments += comment
                return comments.last()
            }
        }
        return throw PostNotFoundException("Post is not found")
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