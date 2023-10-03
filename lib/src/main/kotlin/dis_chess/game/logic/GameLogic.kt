package dis_chess.game.logic

import dis_chess.game.state.GameState
import dis_chess.movement.Movement
import dis_chess.position.Position
import dis_chess.turn.result.TurnResult

interface GameLogic<T : Position, U : GameState<T>> {
    fun nextTurn(movement : Movement<T>, currentGameState : U) : TurnResult
}