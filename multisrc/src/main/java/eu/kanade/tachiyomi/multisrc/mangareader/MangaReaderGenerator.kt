package eu.kanade.tachiyomi.multisrc.mangareader

import generator.ThemeSourceData.MultiLang
import generator.ThemeSourceData.SingleLang
import generator.ThemeSourceGenerator

class MangaReaderGenerator : ThemeSourceGenerator {
    override val themeClass = "MangaReader"
    override val themePkg = "mangareader"
    override val baseVersionCode = 1
    override val sources = listOf(

        SingleLang(
            name = "Manga347",
            baseUrl = "https://Manga347.com",
            lang = "en",
            isNsfw = true,
            className = "Manga347",
            pkgName = "Manga347",
            overrideVersionCode = 33,
        ),
    )

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MangaReaderGenerator().createAll()
        }
    }
}
