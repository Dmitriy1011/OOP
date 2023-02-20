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
                id = 1,
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

        val result = service.add(
            Post(
                id = 1,
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
                id = 2,
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
                id = 3,
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
                id = 4,
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
                id = 2,
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
                id = 3,
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

        service.createComment(2, Comment(1, 5, 6, "text", Donut(true, "some")))
    }

    @Test
    fun update() {
        val service = WallService

        service.add(
            Post(
                id = 1,
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
                id = 2,
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
                id = 3,
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

        val post1 = service.add(
            Post(
                id = 4,
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

        val post2 =
            Post(
                id = 5,
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


        val res1 = service.update(post1)
        val res2 = service.update(post2)

        assertTrue(res1)
        assertFalse(res2)
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
                id = 2,
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

        service.add(
            Post(
                id = 3,
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

        service.add(
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


        service.createComment(1, Comment(1, 5, 4, "text", Donut(true, "who")))
        service.createComment(2, Comment(2, 6, 4, "text", Donut(true, "me")))
        service.createComment(3, Comment(3, 6, 4, "text", Donut(true, "me")))

        service.reportComment(1, 2)
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
                id = 2,
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
                id = 3,
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


        service.add(Post(
                id = 4,
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
        service.createComment(10, Comment(4, 5, 6, "text", Donut(true, "some")))
    }
}








