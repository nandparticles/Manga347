package eu.kanade.tachiyomi.extension.en.manga347

import eu.kanade.tachiyomi.source.model.Filter

object Note : Filter.Header("NOTE: Ignored if using text search!")

sealed class Select(
        name: String,
        val param: String,
        values: Array<String>,
) : Filter.Select<String>(name, values) {
    open val selection: String
        get() = if (state == 0) "" else state.toString()
}

class StatusFilter(
        values: Array<String> = statuses.keys.toTypedArray(),
) : Select("Status", "status", values) {
    override val selection: String
        get() = statuses[values[state]]!!

    companion object {
        private val statuses =
                mapOf(
                        "All" to "",
                        "Completed" to "completed",
                        "OnGoing" to "on-going",
                        "On-Hold" to "on-hold",
                        "Canceled" to "canceled",
                )
    }
}

class SortFilter(
        values: Array<String> = orders.keys.toTypedArray(),
) : Select("Sort", "sort", values) {
    override val selection: String
        get() = orders[values[state]]!!

    companion object {
        private val orders =
                mapOf(
                        "Default" to "default",
                        "Latest Updated" to "latest-updated",
                        "Most Viewed" to "views",
                        "Most Viewed Month" to "views_month",
                        "Most Viewed Week" to "views_week",
                        "Most Viewed Day" to "views_day",
                        "Score" to "score",
                        "Name A-Z" to "az",
                        "Name Z-A" to "za",
                        "The highest chapter count" to "chapters",
                        "Newest" to "new",
                        "Oldest" to "old",
                )
    }
}

class Genre(name: String, val id: String) : Filter.CheckBox(name)

class GenresFilter(
        values: List<Genre> = genres,
) : Filter.Group<Genre>("Genres", values) {
    val param = "genres"

    val selection: String
        get() = state.filter { it.state }.joinToString(",") { it.id }

    companion object {
        private val genres: List<Genre>
            get() =
                    listOf(
                            Genre("Action", "1"),
                            Genre("Adaptation", "47"),
                            Genre("Adventure", "5"),
                            Genre("Comedy", "9"),
                            Genre("Drama", "11"),
                            Genre("Ecchi", "46"),
                            Genre("Fantasy", "2"),
                            Genre("Full Color", "34"),
                            Genre("Harem", "13"),
                            Genre("Historical", "6"),
                            Genre("Horror", "15"),
                            Genre("Isekai", "10"),
                            Genre("Long Strip", "31"),
                            Genre("Magic", "48"),
                            Genre("Manhua", "26"),
                            Genre("Martial Arts", "4"),
                            Genre("Mature", "17"),
                            Genre("Monsters", "35"),
                            Genre("Murim", "24"),
                            Genre("Mystery", "16"),
                            Genre("Romance", "3"),
                            Genre("School Life", "7"),
                            Genre("Sci fi", "18"),
                            Genre("Seinen", "14"),
                            Genre("Shounen", "8"),
                            Genre("Super Power", "27"),
                            Genre("Supernatural", "12"),
                            Genre("System", "25"),
                            Genre("Time Travel", "57"),
                            Genre("Video Games", "32"),
                            Genre("Virtual Reality", "36"),
                            Genre("Web Comic", "33"),
                            Genre("Webtoons", "22"),
                    )
    }
}
