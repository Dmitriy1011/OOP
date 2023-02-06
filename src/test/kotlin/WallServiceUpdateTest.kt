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

        var result = service.add(
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
                isFavourite = true,
                attachments = "audio"
            )
        )

        assertTrue(result.id > 0)
        println(result.id)
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
                isFavourite = true,
                "video"
            )
        )

        service.add(
            Post(
                id = 1,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
                "audio"
            )
        )

        service.add(
            Post(
                id = 2,
                ownerId = 13,
                createdBy = "Will Chan",
                date = 12122024,
                text = "The best movies 2022",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
                "video"
            )
        )

        service.add(
            Post(
                id = 3,
                ownerId = 10,
                createdBy = "Jim Buffalo",
                date = 12122020,
                text = "Sights of Saint-Petersburg",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
                "audio"
            )
        )

        val updateResult = Post(
            id = 3,
            ownerId = 11,
            createdBy = "Kelly Chan",
            date = 12122022,
            text = "This article about USA",
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
            likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
            postType = "Article",
            canDelete = false,
            isFavourite = true,
            "video"
        )

        val updateResult2 = Post(
            id = 5,
            ownerId = 11,
            createdBy = "Kelly Chan",
            date = 12122022,
            text = "This article about USA",
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
            likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
            postType = "Article",
            canDelete = false,
            isFavourite = true,
            "video"
        )

        val result = service.update(updateResult)

        val result2 = service.update(updateResult2)

        println(result)
        assertTrue(result)

        println(result2)
        assertFalse(result2)
    }
}








