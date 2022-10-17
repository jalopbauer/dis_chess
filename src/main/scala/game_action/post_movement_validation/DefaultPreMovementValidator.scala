package game_action.post_movement_validation

import game_data.GameData
  import game_data.board.Board
  import game_data.movement.Movement
  import game_interruption.GameInterruption
  import game_interruption.pre_movement_validation.{CannotPlayPieceFromDifferentColor, FromCoordinateIsInvalid, NoPieceInFromCoordinate, ToCoordinateIsInvalid}


  case class DefaultPreMovementValidator() extends PreMovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val board = gameData.board
      val playerMovement = gameData.movement

      val from = playerMovement.from

      val fromOptional = board.coordinateBelongs(from)
      if (fromOptional.isEmpty) Right(FromCoordinateIsInvalid(gameData))

      val to = playerMovement.to
      val toOptional = board.coordinateBelongs(to)
      if (toOptional.isEmpty) Right(ToCoordinateIsInvalid(gameData))

      val optionalPiece = board.getPiece(fromOptional.get)
      if (optionalPiece.isEmpty) Right(NoPieceInFromCoordinate(gameData))
      if (optionalPiece.get.color == playerMovement.player.color) Right(CannotPlayPieceFromDifferentColor(gameData))

      Left(gameData)
