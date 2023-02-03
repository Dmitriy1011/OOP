import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceUpdateTest {

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
    }

    @Test
    fun update() {
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

        service.add(
            Post(
                id = 0,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        service.add(
            Post(
                id = 0,
                ownerId = 13,
                createdBy = "Will Chan",
                date = 12122024,
                text = "The best movies 2022",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        service.add(
            Post(
                id = 0,
                ownerId = 10,
                createdBy = "Jim Buffalo",
                date = 12122020,
                text = "Sights of Saint-Petersburg",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        val update = Post(
            id = 0,
            ownerId = 11,
            createdBy = "Kelly Chan",
            date = 12122022,
            text = "This article about USA",
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
            likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
            postType = "Article",
            canDelete = false,
            isFavourite = true
        )

        val result = service.update(update)

        assertTrue(result)
        assertFalse(result)
    }
}







