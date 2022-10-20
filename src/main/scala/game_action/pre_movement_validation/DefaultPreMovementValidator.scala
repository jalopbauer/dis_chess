package game_action.pre_movement_validation

import game_data.GameData
  import game_data.board.Board
  import game_data.movement.Movement
  import game_interruption.GameInterruption
  import game_interruption.pre_movement_validation.{CannotPlayPieceFromDifferentColor, FromCoordinateIsInvalid, NoPieceInFromCoordinate, ToCoordinateIsInvalid, ToDifferentFrom}


  case class DefaultPreMovementValidator() extends PreMovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val board = gameData.board
      val playerMovement = gameData.movement

      val from = playerMovement.from

      val fromOptional = board.coordinateBelongs(from)
      if (fromOptional.isEmpty) Right(FromCoordinateIsInvalid(gameData))
      else
        val value = fromOptional.get

        val to = playerMovement.to
        val toOptional = board.coordinateBelongs(to)
        if (toOptional.isEmpty) Right(ToCoordinateIsInvalid(gameData))
        else
          val optionalPiece = board.getPiece(fromOptional.get)
          if (to == from) Right(ToDifferentFrom(gameData))
          else if (optionalPiece.isEmpty) Right(NoPieceInFromCoordinate(gameData))
          else if (optionalPiece.get.color == playerMovement.player.color) Left(gameData)
          else Right(CannotPlayPieceFromDifferentColor(gameData))

