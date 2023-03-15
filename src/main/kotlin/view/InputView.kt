package view

import domain.stone.StonePosition

class InputView {

    fun inputStonePosition(): StonePosition {
        return runCatching {
            val parsePosition: Pair<Int, Int> = parseXAndY(readln())
            StonePosition.from(parsePosition.first, parsePosition.second)
        }.onFailure {
            println("올바른 위치를 입력해주세요.")
        }.getOrNull() ?: inputStonePosition()
    }

    private fun parseXAndY(value: String): Pair<Int, Int> {
        return Pair((value[0] + 1) - 'A', value.substring(1).toInt())
    }
}