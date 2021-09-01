package clone.shmehdi.jetinsta.data.model

data class Story(
    val id: String,
    val name: String,
    val image: String,
    val isSeen: Boolean
)

val fakeStories = listOf(
    Story(
        id = "1",
        name = "insanecodes",
        image = "",
        isSeen = false
    ),

    Story(
        id = "2",
        name = "afterglowstudio_",
        image = "",
        isSeen = false
    ),

    Story(
        id = "3",
        name = "ransegall",
        image = "",
        isSeen = false
    ),

    Story(
        id = "4",
        name = "officialhackermedia",
        image = "",
        isSeen = true
    ),

    Story(
        id = "5",
        name = "logo_lesson",
        image = "",
        isSeen = true
    ),

    Story(
        id = "6",
        name = "programmer.me",
        image = "",
        isSeen = true
    )

)