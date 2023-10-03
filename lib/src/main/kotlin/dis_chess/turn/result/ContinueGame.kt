package dis_chess.turn.result

import dis_chess.game.state.GameState
import dis_chess.position.Position

data class ContinueGame<T : Position, U : GameState<T>>(val postMovementGameState: U) : TurnResult