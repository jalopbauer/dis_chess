package game_action.game_end_validation

import game_action.movement_validation.exposed.RegularBoardPiecesMovementValidator
import game_action.post_movement_invalidation.{CheckValidator, ToCoordinateCheckValidator}
import game_data.GameData
import game_data.piece.{PieceColor, PieceType}
import game_data.movement.Movement
import game_data.board.{Board, Coordinate}
import game_interruption.GameInterruption
import game_interruption.game_end_validation.KingWasEaten
import player.Player

  case class CheckMateValidation() extends GameEndValidator:
    val toCoordinateCheckValidator: ToCoordinateCheckValidator = ToCoordinateCheckValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val movement = gameData.movement
      val player = movement.player
      val pieces = gameData.board.getPieces
      val enemyColor = if (player.color == PieceColor.WHITE) PieceColor.BLACK else PieceColor.WHITE
      val enemyPieces = pieces.filter(x => x._2.color == enemyColor)
      val enemyKingCoordinate = enemyPieces.filter(x => x._2.pieceType == PieceType.KING).keys.head
      println(enemyPieces)
      toCoordinateCheckValidator.act(GameData(gameData.board
        , Movement(movement.from, enemyKingCoordinate, Player(enemyColor))
        , gameData.turns)) match
        case Left(_) =>
          Left(gameData)
        case Right(_) =>
          val value = kingToCoordinates(enemyKingCoordinate, gameData.board)
          if (value.exists(toCoordinate => {
            val dataOrInterruption = toCoordinateCheckValidator.act(GameData(gameData.board
              , Movement(enemyKingCoordinate, toCoordinate, player)
              , gameData.turns))
            dataOrInterruption.isLeft
          }
          )) Right(KingWasEaten(gameData))
          else Left(gameData)

    def kingToCoordinates(from: Coordinate, board: Board): List[Coordinate] =
      List(
          from.sum(Coordinate(-1,1))
        , from.sum(Coordinate(1,-1))
        , from.sum(Coordinate(0,1))
        , from.sum(Coordinate(1,0))
        , from.sum(Coordinate(1,1))
        , from.sum(Coordinate(-1,-1))
        , from.sum(Coordinate(0,-1))
        , from.sum(Coordinate(-1,0))
      ).filter(coordinate => board.coordinateBelongs(coordinate).isDefined)