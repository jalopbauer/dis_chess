package game_action.movement_validation.piece.pawn:

  import game_action.movement_validation.generic.AndCompositeValidator
  import game_action.movement_validation.generic.color.PieceColorIsExpectedValidator
  import game_action.movement_validation.generic.movement.MovementIsOneStraightDownValidator
  import game_data.piece.PieceColor

  case class PawnStraightDownTopColorValidator(topColor:PieceColor) extends AndCompositeValidator(MovementIsOneStraightDownValidator(), PieceColorIsExpectedValidator(topColor))