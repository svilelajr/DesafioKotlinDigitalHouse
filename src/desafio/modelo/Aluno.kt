package desafio.modelo

data class Aluno(val nome: String, val sobrenome: String, val codigoAluno:Int) {

    override fun equals(other: Any?): Boolean {

        if (other is Aluno){
            if(codigoAluno == other.codigoAluno){
                return true
            }
        }
        return false
    }
}