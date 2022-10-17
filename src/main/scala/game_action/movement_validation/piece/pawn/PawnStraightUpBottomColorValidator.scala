package game_action.movement_validation.piece.pawn:

  import game_action.movement_validation.generic.AndCompositeValidator
  import game_action.movement_validation.generic.color.PieceColorIsExpectedValidator
  import game_action.movement_validation.generic.movement.MovementIsOneStraightUpValidator
  import game_data.piece.PieceColor

  case class PawnStraightUpBottomColorValidator(bottomColor:PieceColor) extends AndCompositeValidator(MovementIsOneStraightUpValidator(), PieceColorIsExpectedValidator(bottomColor))