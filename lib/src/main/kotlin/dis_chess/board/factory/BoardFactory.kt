package dis_chess.board.factory

import dis_chess.board.ChessBoard
import dis_chess.position.Position

interface BoardFactory<T : Position> {
    fun build() : ChessBoard<T>
}