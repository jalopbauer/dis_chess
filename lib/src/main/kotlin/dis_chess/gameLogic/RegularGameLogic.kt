package dis_chess.gameLogic

import dis_chess.gameState.GameState
import dis_chess.movement.Movement
import dis_chess.movementValidation.MovementValidator
import dis_chess.position.Position
import dis_chess.turnResult.TurnResult

class RegularGameLogic<T : Position, U : GameState<T>>(
    private val movementValidator: MovementValidator<T, U>
) : GameLogic<T, U> {

    override fun nextTurn(movement: Movement<T>, gameState: U): TurnResult {
        val movementValidationResult = movementValidator.validateMovement(movement, gameState)

        TODO()
    }
}