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
                comments = Comment(1, 2, 3, "text", Donut(true, "smth")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
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
                comments = Comment(1, 2, 3, "text", Donut(true, "smth")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
            )
        )

        service.add(
            Post(
                id = 1,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comment(2, 3, 4, "text", Donut(true, "anything")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        service.add(
            Post(
                id = 2,
                ownerId = 13,
                createdBy = "Will Chan",
                date = 12122024,
                text = "The best movies 2022",
                comments = Comment(3, 4, 5, "text", Donut(true, "anywhere")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        val addResult = service.add(
            Post(
                id = 3,
                ownerId = 10,
                createdBy = "Jim Buffalo",
                date = 12122020,
                text = "Sights of Saint-Petersburg",
                comments = Comment(4, 5, 6, "text", Donut(true, "some")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        val res1 = service.update(addResult)
        println(addResult.id)

        val res2 = service.update(Post(
            id = 10,
            ownerId = 10,
            createdBy = "Jim Buffalo",
            date = 12122020,
            text = "Sights of Saint-Petersburg",
            comments = Comment(4, 5, 6, "text", Donut(true, "some")),
            likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
            postType = "Article",
            canDelete = false,
            isFavourite = true
        ))

        assertTrue(res1)
        assertFalse(res2)
    }

    @Test
    fun createComment() {
        val service = WallService

        service.add(
            Post(
                id = 0,
                ownerId = 11,
                createdBy = "John Smith",
                date = 12122022,
                text = "This article about the greatest president of USA - Avraam Linkoln",
                comments = Comment(1, 2, 3, "text", Donut(true, "smth")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
            )
        )

        service.add(
            Post(
                id = 1,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comment(2, 3, 4, "text", Donut(true, "anything")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        val result = service.createComment(1, Comment(2, 3, 4, "text", Donut(true, "anything")))
        println(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService

        service.add(
            Post(
                id = 0,
                ownerId = 11,
                createdBy = "John Smith",
                date = 12122022,
                text = "This article about the greatest president of USA - Avraam Linkoln",
                comments = Comment(1, 2, 3, "text", Donut(true, "smth")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
            )
        )

        service.add(
            Post(
                id = 1,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comment(2, 3, 4, "text", Donut(true, "anything")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        service.add(
            Post(
                id = 2,
                ownerId = 13,
                createdBy = "Will Chan",
                date = 12122024,
                text = "The best movies 2022",
                comments = Comment(3, 4, 5, "text", Donut(true, "anywhere")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        val res1 = service.add(
            Post(
                id = 3,
                ownerId = 10,
                createdBy = "Jim Buffalo",
                date = 12122020,
                text = "Sights of Saint-Petersburg",
                comments = Comment(4, 5, 6, "text", Donut(true, "some")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        println(res1)

        service.createComment(13, Comment(4, 5, 6, "text", Donut(true, "some")))
    }


    @Test
    fun report() {
        val service = WallService

        service.add(
            Post(
                id = 0,
                ownerId = 11,
                createdBy = "John Smith",
                date = 12122022,
                text = "This article about the greatest president of USA - Avraam Linkoln",
                comments = Comment(1, 2, 3, "text", Donut(true, "smth")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true,
            )
        )

        service.add(
            Post(
                id = 1,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comment(2, 3, 4, "text", Donut(true, "anything")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        service.add(
            Post(
                id = 3,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comment(3, 3, 4, "text", Donut(true, "anything")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        var post1 = service.add(
            Post(
                id = 4,
                ownerId = 12,
                createdBy = "John Doe",
                date = 12122023,
                text = "News today",
                comments = Comment(4, 3, 4, "text", Donut(true, "anything")),
                likes = Likes(10, userLikes = true, canLike = true, canPublish = true),
                postType = "Article",
                canDelete = false,
                isFavourite = true
            )
        )

        service.createComment(3, Comment(1, 3, 4, "text", Donut(true, "anything")))
    }
}








