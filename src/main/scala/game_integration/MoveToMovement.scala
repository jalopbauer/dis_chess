package game_integration

import edu.austral.dissis.chess.gui.{BoardSize, InitialState, Move}
import game_data.GameData
import game_data.movement.Movement
import player.Player

  case class MoveToMovement():
    val myCoordinateToPosition: MyCoordinateToPosition = MyCoordinateToPosition()
    def create(move:Move, player:Player): Movement =
      val to = myCoordinateToPosition.reverse(move.getTo)
      val from = myCoordinateToPosition.reverse(move.getFrom)
      Movement(from,to, player)
