package dis_chess.position

data class RowColumnPosition(val row : Int, val column : Int) : Position {
    override fun toString(): String {
        return "($row, $column)"
    }
}
