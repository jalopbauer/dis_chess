package dis_chess.movement

import dis_chess.position.Position

data class Movement<T : Position>(val from : T, val to : T)
