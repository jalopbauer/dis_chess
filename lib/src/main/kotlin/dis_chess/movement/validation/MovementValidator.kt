package dis_chess.movement.validation

import dis_chess.game.state.GameState
import dis_chess.movement.Movement
import dis_chess.position.Position

interface MovementValidator<T : Position, U : GameState<T>> {
    fun validateMovement(movement: Movement<T>, gameState: U) : MovementValidationResult

}
