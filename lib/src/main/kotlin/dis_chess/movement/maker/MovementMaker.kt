package dis_chess.movement.maker

import dis_chess.game.state.GameState
import dis_chess.movement.Movement
import dis_chess.position.Position

interface MovementMaker<T : Position, U : GameState<T>> {
    fun makeMovement(movement: Movement<T>): U

}
