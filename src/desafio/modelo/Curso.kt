package desafio.modelo

data class Curso(val nome: String, val codigoCurso: Int, var quantidadeMaximaAlunos: Int){

    lateinit var professorAdjunto: ProfessorAdjunto
    lateinit var professorTitular: ProfessorTitular

    var alunosMatriculados = mutableListOf<Aluno>()

    fun adicionarUmAluno(aluno: Aluno):Boolean{

        if(alunosMatriculados.size < quantidadeMaximaAlunos){
            alunosMatriculados.add(aluno)
            println("Aluno ${aluno.nome} cadastrado com sucesso no Curso $nome")
            return true
        }
        return false
    }

    fun excluirAluno(aluno: Aluno){
        alunosMatriculados.remove(aluno)
        println("O Aluno ${aluno.nome} foi removido do curso $nome")
    }

    override fun equals(other: Any?): Boolean {

            if (other is Curso){
                if(codigoCurso == other.codigoCurso){
                    return true
                }
            }
            return false
        }
}