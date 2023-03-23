package view

import domain.state.State
import domain.state.end.End
import domain.state.running.BlackTurn
import domain.state.running.WhiteTurn
import domain.stone.Stone
import domain.stone.StoneType
import domain.stone.Stones

class OutputView {

    fun printOmokStart() {
        println(MESSAGE_OMOK_START)
        println()
        printBoard(Stones())
    }

    fun printBoard(stones: Stones) {
        setBoard(stones)

        board.indices.forEach {
            println(boardForm[it].format(*board[it].toTypedArray()))
        }
        println(boardForm[boardForm.lastIndex])
        println()
    }

    fun printTurn(state: State, stones: Stones) {
        val text: StringBuilder = StringBuilder()

        text.append(MESSAGE_FORMAT_TURN.format(getTurnText(state)))
        if (stones.values.isNotEmpty()) {
            text.append(MESSAGE_FORMAT_LAST_STONE_POSITION.format(positionToAlphaCoordinate(stones.values[stones.values.lastIndex])))
        }

        println(text)
    }

    fun printWinner(end: End) {
        println(MESSAGE_FORMAT_WINNER.format(getWinnerText(end)))
    }

    private fun setBoard(stones: Stones) {
        stones.values.forEach {
            if (getStoneTypeEmoji(it.type) != null)
                board[(15 - it.position.y)][it.position.x - 1] = getStoneTypeEmoji(it.type)!!
        }
    }

    private fun positionToAlphaCoordinate(value: Stone): String {
        val xCoordinate: String = ('A' + value.position.x - 1).toString()
        val yCoordinate: String = value.position.y.toString()
        return "$xCoordinate$yCoordinate"
    }

    private fun getStoneTypeEmoji(stoneType: StoneType): Char = when (stoneType) {
        StoneType.BLACK -> '●'
        StoneType.WHITE -> '○'
    }

    private fun getTurnText(state: State): String? = when (state) {
        is WhiteTurn -> "백"
        is BlackTurn -> "흑"
        else -> null
    }

    private fun getWinnerText(end: End): String = when (end.getWinner()) {
        StoneType.BLACK -> "흑"
        StoneType.WHITE -> "백"
    }

    companion object {
        private const val MESSAGE_OMOK_START = "오목 게임을 시작합니다."
        private const val MESSAGE_FORMAT_TURN = "%s의 차례입니다. "
        private const val MESSAGE_FORMAT_LAST_STONE_POSITION = "(마지막 돌의 위치: %s)"
        private const val MESSAGE_FORMAT_WINNER = "%s돌이 우승했습니다."

        val board: MutableList<MutableList<Char>> = mutableListOf(
            mutableListOf('┌', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┐'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'),
            mutableListOf('└', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┘'),

        )
        val boardForm =
            listOf(
                " 15 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                " 14 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                " 13 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                " 12 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                " 11 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                " 10 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  9 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  8 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  7 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  6 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  5 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  4 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  3 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  2 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "  1 %c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c──%c",
                "    A  B  C  D  E  F  G  H  I  J  K  L  M  N  O",
            )
    }
}
