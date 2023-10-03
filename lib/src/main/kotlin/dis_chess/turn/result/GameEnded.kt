package dis_chess.turn.result

import dis_chess.game.endingCondition.GameEndingCondition

data class GameEnded(val gameEndingCondition: GameEndingCondition) : TurnResult