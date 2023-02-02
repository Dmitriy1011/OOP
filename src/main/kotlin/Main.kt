data class Post(
    val id: Int,
    val ownerId: Int,
    val createdBy: String,
    val date: Int,
    val text: String,
    val comments: Comments,
    val likes: Likes,
    val postType: String,
    val canDelete: Boolean,
    val isFavourite: Boolean
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


object WallService {

    fun clear() {
        posts = emptyArray()
    }

    private var posts = emptyArray<Post>()
    private var privateId = 0;

    fun add(post: Post): Post {
        for((index, postInArray) in posts.withIndex()) {
            if(post.id != postInArray.id) {
                posts[index] = post.copy(id = privateId + 1)
                privateId += 1
                posts += post
            }
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postInArray) in posts.withIndex()) {
            if(post.id == postInArray.id) {
                posts[index] = post.copy(
                    id = 1,
                    createdBy = "John Smith",
                    text = "This article about the greatest president of USA - Avraam Linkoln",
                    comments = Comments(1, canPost = true, groupsCanPost = true,canClose = false, canOpen = true),
                    likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                    postType = "Article",
                    canDelete = false,
                    isFavourite = true
                )
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
        "text",
        comments = Comments(3, canPost = false, groupsCanPost = false, canClose = true, canOpen = true),
        likes = Likes(5, userLikes = true, canLike = true, canPublish = false),
        "post",
        canDelete = true,
        isFavourite = false
    )
}