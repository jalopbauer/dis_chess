package dis_chess.game.endingCondition.validator

import dis_chess.game.state.GameState
import dis_chess.position.Position
import dis_chess.game.endingCondition.GameEndingCondition

interface GameEndingConditionValidator<T : Position, U : GameState<T>> {
    fun validateWinCondition(postMovementGameState: U) : GameEndingCondition?
}
