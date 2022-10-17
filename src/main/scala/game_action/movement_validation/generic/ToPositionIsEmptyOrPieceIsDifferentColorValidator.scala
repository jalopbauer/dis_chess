package game_action.movement_validation.generic:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid
  case class ToPositionIsEmptyOrPieceIsDifferentColorValidator() extends OrCompositionValidator(ToPositionIsEmptyValidator()
                                                                                                , ToPiecePositionIsDifferentColorValidator())



