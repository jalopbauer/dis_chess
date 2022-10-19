package game_integration:

  import edu.austral.dissis.chess.gui.{GameOver, InvalidMove, MoveResult}
  import game_interruption.GameInterruption
  import game_interruption.post_movement_validation.GameEnd

  case class GameInterruptionToMoveResult():
    val myPieceColorToPlayerColor: MyPieceColorToPlayerColor = MyPieceColorToPlayerColor()
    def transform(gameInterruption:GameInterruption): MoveResult =
        gameInterruption match
          case gI: GameEnd => GameOver(myPieceColorToPlayerColor.transform(gI.getGameData.movement.player.color))
          case gI => InvalidMove(gI.getMessage)
