package dis_chess.gameLogic

import dis_chess.gameState.GameState
import dis_chess.movement.Movement
import dis_chess.position.Position
import dis_chess.turnResult.TurnResult

interface GameLogic<T : Position, U : GameState<T>> {
    fun nextTurn(movement : Movement<T>, gameState : U) : TurnResult
}