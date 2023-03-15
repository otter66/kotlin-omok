package domain.stone

open class Stones(values: List<Stone> = emptyList()) {
    private val _values = values.toMutableList()
    val values: List<Stone>
        get() = _values.toList()

    val size: Int
        get() = values.size

    constructor(vararg stones: Stone) : this(stones.toList())

    fun add(stone: Stone) {
        _values.add(stone)
    }

    fun containsPosition(stone: Stone): Boolean =
        values.asSequence().map { it.position }.contains(stone.position)

    operator fun plus(stones: Stones): Stones = Stones(values.plus(stones.values))
}