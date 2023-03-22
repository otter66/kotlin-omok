package domain.state.running

import domain.state.end.End
import domain.stone.Board
import domain.stone.Stone
import domain.stone.StonePosition
import domain.stone.StoneType
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WhiteTurnTest {

    @Test
    fun `stone을 추가할 수 없는 상태라면 추가하지 않고 WhiteTurn을 반환`() {
        val board: Board = Board()
        val stone: Stone = Stone(StonePosition(2, 1), StoneType.WHITE)
        board.putStone(stone)

        val whiteTurn: WhiteTurn = WhiteTurn()

        Assertions.assertThat(
            whiteTurn.next(board, stone.position) is WhiteTurn,
        ).isEqualTo(true)
    }

    @Test
    fun `stone를 추가한 후 BlackTurn를 반환`() {
        val board: Board = Board()
        val stone: Stone = Stone(StonePosition(2, 1), StoneType.WHITE)

        val whiteTurn: WhiteTurn = WhiteTurn()

        Assertions.assertThat(
            whiteTurn.next(board, stone.position) is BlackTurn,
        ).isEqualTo(true)
    }

    @Test
    fun `오목 조건 충족하면 End 상태로 white가 Win`() {
        val board: Board = Board()
        board.putStone(Stone(StonePosition(1, 1), StoneType.WHITE))
        board.putStone(Stone(StonePosition(2, 2), StoneType.WHITE))
        board.putStone(Stone(StonePosition(3, 3), StoneType.WHITE))
        board.putStone(Stone(StonePosition(4, 4), StoneType.WHITE))

        val stone: Stone = Stone(StonePosition(5, 5), StoneType.WHITE)
        val whiteTurn: WhiteTurn = WhiteTurn()

        Assertions.assertThat(
            whiteTurn.next(board, stone.position) is End,
        ).isEqualTo(true)
    }
}
