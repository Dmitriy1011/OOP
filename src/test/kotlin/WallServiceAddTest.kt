import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceAddTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val service = WallService

        service.add(
            Post(
                id = 0,
                ownerId = 11,
                createdBy = "John Smith",
                date = 12122022,
                text = "This article about the greatest president of USA - Avraam Linkoln",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        when {

        }
    }
}

