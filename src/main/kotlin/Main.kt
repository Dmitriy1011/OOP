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
    val attachments: String
)

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
    override val type: String = "audio",
    val insideAttachment: Audio
): Attachments {

}

class VideoAttachment(
    override val type: String = "video",
    val insideAttachment: Video
): Attachments {

}

class Audio(
    val audioId: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

class Video(
    val videoId: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int
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
        attachments = "audio"
    )

    println(post)
}