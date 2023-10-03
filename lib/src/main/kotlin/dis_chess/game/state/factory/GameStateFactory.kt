package dis_chess.game.state.factory

import dis_chess.game.state.GameState
import dis_chess.position.Position

interface GameStateFactory<T: Position> {
    fun build() : GameState<T>
}
