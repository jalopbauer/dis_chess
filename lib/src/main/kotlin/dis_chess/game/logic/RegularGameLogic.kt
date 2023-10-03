package dis_chess.game.logic

import dis_chess.game.state.GameState
import dis_chess.movement.Movement
import dis_chess.movement.maker.MovementMaker
import dis_chess.movement.validation.InvalidMovement
import dis_chess.movement.validation.MovementValidator
import dis_chess.movement.validation.ValidMovement
import dis_chess.position.Position
import dis_chess.turn.result.ContinueGame
import dis_chess.turn.result.GameEnded
import dis_chess.turn.result.TurnResult
import dis_chess.game.endingCondition.validator.GameEndingConditionValidator

class RegularGameLogic<T : Position, U : GameState<T>>(
    private val movementValidator: MovementValidator<T, U>,
    private val movementMaker: MovementMaker<T, U>,
    private val gameEndingConditionValidator: GameEndingConditionValidator<T, U>
) : GameLogic<T, U> {

    override fun nextTurn(movement: Movement<T>, currentGameState: U): TurnResult {
        return when (val movementValidationResult = movementValidator.validateMovement(movement, currentGameState)) {
            is InvalidMovement -> movementValidationResult
            ValidMovement -> {
                val postMovementGameState = movementMaker.makeMovement(movement)
                when (val gameEndingCondition = gameEndingConditionValidator.validateWinCondition(postMovementGameState)) {
                    null -> ContinueGame(postMovementGameState)
                    else -> GameEnded(gameEndingCondition)
                }
            }
        }
    }
}