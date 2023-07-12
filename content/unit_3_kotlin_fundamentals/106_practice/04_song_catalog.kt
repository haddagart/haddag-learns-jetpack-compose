/*
Imagine that you need to create a music-player app.

Create a class that can represent the structure of a song. The Song class must include these code elements:

Properties for the title, artist, year published, and play count
A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
A method that prints a song description in this format:
"[Title], performed by [artist], was released in [year published]."
 */

class Song(
    title: String,
    artist: String,
    year: Int,
    playCount: Int,
){
    val title = title
    val artist = artist
    val year = year
    val playCount = playCount

    private var isPopular = playCount >= 1_000

    fun printDescription() {
        println("$title, performed by $artist, was released in $year.")
    }
}

fun main() {
    val song = Song("Mfaker 7alek Min", "Melissa", 2011, 1152000)
    song.printDescription()
}