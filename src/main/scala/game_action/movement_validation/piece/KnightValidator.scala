package game_action.movement_validation.piece:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.{AndCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_action.movement_validation.generic.movement.MovementIsLShapedValidator
  import game_interruption.GameInterruption

  case class KnightValidator() extends AndCompositeValidator(MovementIsLShapedValidator(), ToPositionIsEmptyOrPieceIsDifferentColorValidator())