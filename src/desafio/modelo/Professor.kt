package desafio.modelo

abstract class Professor(val nome: String, val sobrenome: String, var tempoDeCasa: Int, var codigoProfessor: Int) {

    override fun equals(other: Any?): Boolean {
        if (other is Professor){
            if (other.codigoProfessor == codigoProfessor){
                return true
            }
        }
        return false
    }


}