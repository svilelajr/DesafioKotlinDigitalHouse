package desafio.modelo

class Curso(val nome: String,val codigoCurso: Int){

    lateinit var professorAdjunto: ProfessorAdjunto
    lateinit var professorTitular: ProfessorTitular
    var quantidadeMaximaAlunos: Int = 0
    var alunosMatriculados = listOf<Aluno>()

    fun adicionarUmAluno(aluno: Aluno):Boolean{

        if(quantidadeMaximaAlunos > 0){
            return true
        }
        return false
    }

    fun excluirAluno(aluno: Aluno){

    }

}