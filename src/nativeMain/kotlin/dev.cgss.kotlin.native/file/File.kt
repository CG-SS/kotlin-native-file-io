package dev.cgss.kotlin.native.file

class File(path: String) {

    companion object {

        private val forbiddenFilePathChars: String = when (Platform.osFamily) {
            // source https://stackoverflow.com/questions/1976007/what-characters-are-forbidden-in-windows-and-linux-directory-names
            OsFamily.WINDOWS -> "<>:\"/\\|?*"
            OsFamily.LINUX -> "/"
            else -> throw NotImplementedError("Missing forbiddenFilePathChars definition for OS family ${Platform.osFamily}!")
        }

        val extensionSeparator: Char = when (Platform.osFamily) {
            OsFamily.LINUX, OsFamily.WINDOWS, OsFamily.IOS, OsFamily.MACOSX -> '\u002E'
            else -> throw NotImplementedError("Missing extensionSeparator definition for OS family ${Platform.osFamily}!")
        }

        val fileSeparator: Char = when (Platform.osFamily) {
            OsFamily.LINUX -> '\u002F'
            OsFamily.WINDOWS -> '\u005C'
            else -> throw NotImplementedError("Missing fileSeparator definition for OS family ${Platform.osFamily}!")
        }

        val pathSeparator: Char = when (Platform.osFamily) {
            OsFamily.LINUX -> '\u003A'
            OsFamily.WINDOWS -> '\u003B'
            else -> throw NotImplementedError("Missing pathSeparator definition for OS family ${Platform.osFamily}!")
        }
    }

    val absoluteFilePath: String
    val volumeName: String
    val fileExtension: String?

    init {
        absoluteFilePath = sanitizePath(path)
    }

    private fun sanitizePath(path: String): String {
        if (path.contains(forbiddenFilePathChars))
            throw FileException("File path should not contain any of the following characters: ${forbiddenFilePathChars}!")

        return when (Platform.osFamily) {
            OsFamily.LINUX -> sanitizeLinuxPath(path)
            OsFamily.WINDOWS -> sanitizeWindowsPath(path)
            else -> ""
        }
    }

    private fun sanitizeWindowsPath(path: String): String {

    }

    private fun sanitizeLinuxPath(path: String): String {

    }
}