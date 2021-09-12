package dev.cgss.kotlin.native.file

class File(path: String) {

    companion object {
        val extensionSeparator: Char = when (Platform.osFamily) {
            OsFamily.LINUX, OsFamily.WINDOWS, OsFamily.IOS, OsFamily.MACOSX -> '\u002E'
            else -> throw NotImplementedError("Missing extensionSeparator definition for OS family " + Platform.osFamily + "!")
        }
    }

    val absoluteFilePath: String

    init {

    }

    private fun sanitizePath() {

    }
}