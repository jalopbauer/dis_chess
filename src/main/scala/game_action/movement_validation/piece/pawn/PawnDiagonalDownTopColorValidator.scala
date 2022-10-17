package game_action.movement_validation.piece.pawn:
  
  import game_action.movement_validation.generic.AndCompositeValidator
  import game_action.movement_validation.generic.color.PieceColorIsExpectedValidator
  import game_action.movement_validation.generic.movement.{MovementIsOneDiagonalDownValidator, MovementIsOneStraightDownValidator}
  import game_data.piece.PieceColor

  case class PawnDiagonalDownTopColorValidator(topColor:PieceColor) extends AndCompositeValidator(MovementIsOneDiagonalDownValidator(), PieceColorIsExpectedValidator(topColor))