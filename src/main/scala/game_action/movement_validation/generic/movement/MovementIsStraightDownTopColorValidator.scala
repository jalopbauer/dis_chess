package game_action.movement_validation.generic.movement:
  
  import game_action.movement_validation.generic.AndCompositeValidator
  import game_action.movement_validation.generic.color.PieceColorIsExpectedValidator
  import game_data.piece.PieceColor
  
  case class MovementIsStraightDownTopColorValidator(topColor: PieceColor) extends AndCompositeValidator(MovementIsOneStraightDownValidator(), PieceColorIsExpectedValidator(topColor))
