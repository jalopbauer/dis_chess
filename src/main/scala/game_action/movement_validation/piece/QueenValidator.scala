package game_action.movement_validation.piece:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.movement.MovementIsDiagonalValidator
  import game_action.movement_validation.generic.path.DiagonalOrStraightPathIsEmptyValidator
  import game_action.movement_validation.generic.{AndCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid

  case class QueenValidator() extends AndCompositeValidator(DiagonalOrStraightPathIsEmptyValidator(), ToPositionIsEmptyOrPieceIsDifferentColorValidator())