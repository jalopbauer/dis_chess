package game_action.game_end_validation

import game_action.post_movement_invalidation.CheckValidator
import game_data.GameData
import game_data.board.Board
import game_interruption.GameInterruption

  case class CheckMateValidation() extends GameEndValidator:
    val checkValidator: CheckValidator = CheckValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
//      val movement = gameData.movement
    //    val player = movement.player
    //    val pieces = gameData.board.getPieces
    //    val enemyKing = pieces.filter(x => x._2.color != player.color && x._2.pieceType == PieceType.KING).keys.head
    //    toCoordinateCheckValidator.act(GameData(gameData.board
    //      , Movement(movement.from, enemyKing, player)
    //      , gameData.turns))
      Left(gameData)