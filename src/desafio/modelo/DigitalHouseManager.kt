package desafio.modelo

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DigitalHouseManager() {

    private val alunos = mutableListOf<Aluno>()
    private val professores = mutableListOf<Professor>()
    private val cursos = mutableListOf<Curso>()
    private val matriculas = mutableListOf<Matricula>()


    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int ){

        if(buscaCurso(codigoCurso) is Curso){
            println("Não foi possivel cadastrar o Curso, código $codigoCurso, já inserido no sistema!")
        } else {
            val curso = Curso(nome = nome, codigoCurso = codigoCurso, quantidadeMaximaAlunos = quantidadeMaximaDeAlunos)
            cursos.add(curso)
            println("O curso ${curso.nome},codigo ${curso.codigoCurso} e com quantidade maxima de ${curso.quantidadeMaximaAlunos} alunos, foi registrado com sucesso!!")
        }


    }

    fun excluirCurso(codigoCurso: Int){
        for (curso in cursos){
            if (curso.codigoCurso == codigoCurso){
                cursos.remove(curso)
            }
        }
    }

    fun registrarProfessorAdjunto(nome: String , sobrenome: String , codigoProfessor: Int, quantidadeDeHoras: Int){

        if (buscaProfessorAdjunto(codigoProfessor) is ProfessorAdjunto){
            println("Não foi possivel cadastrar o Professor Adjunto, código $codigoProfessor, já inserido no sistema!")
        }else {
            val professorAdjunto = ProfessorAdjunto(nome = nome,sobrenome = sobrenome,tempoDeCasa = 0, codigoProfessor = codigoProfessor, horasMonitoria = quantidadeDeHoras)
            professores.add(professorAdjunto)
            println("O Professor Adjunto ${professorAdjunto.nome} ${professorAdjunto.sobrenome} seu codigo é ${professorAdjunto.codigoProfessor}, com ${professorAdjunto.tempoDeCasa} de tempo de casa e com ${professorAdjunto.horasMonitoria} horas de monitoria ")
        }


    }

    fun registrarProfessorTitular(nome: String , sobrenome: String , codigoProfessor: Int,tempoDeCasa :Int, especialidade: String){
        if (buscaProfessorTitular(codigoProfessor) is ProfessorTitular){
            println("Não foi possivel cadastrar o Professor Titular, código $codigoProfessor, já inserido no sistema!")
        }else {
        val professorTitular = ProfessorTitular(nome = nome,sobrenome = sobrenome,tempoDeCasa = 0, codigoProfessor = codigoProfessor, especialidade = especialidade)
        professores.add(professorTitular)
        println("O Professor Titular ${professorTitular.nome} ${professorTitular.sobrenome} seu codigo é ${professorTitular.codigoProfessor}, com ${professorTitular.tempoDeCasa} de tempo de casa e com especialidade em ${professorTitular.especialidade}")
        }
    }

    fun excluirProfessor(codigoProfessor: Int){
        for (professor in professores){
            if (professor.codigoProfessor == codigoProfessor){
                professores.remove(professor)
            }
        }
    }


    fun registrarAluno(nome: String,sobrenome: String, codigoAluno: Int){
        if(buscaAluno(codigoAluno) is Aluno){
            println("Não foi possivel cadastrar o Aluno, código $codigoAluno, já inserido no sistema!")
        }else{
            val aluno = Aluno(nome = nome, sobrenome = sobrenome, codigoAluno = codigoAluno)
            alunos.add(aluno)
            println("O Aluno ${aluno.nome} ${aluno.sobrenome} foi cadastrado com o código ${aluno.codigoAluno}")
        }



    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        var alunoAMatricular = buscaAluno(codigoAluno)
        var cursoAMatricular = buscaCurso(codigoCurso)
        val data = LocalDateTime.now()

        if (alunoAMatricular != null && cursoAMatricular != null){
            if (cursoAMatricular.adicionarUmAluno(alunoAMatricular) == true) {
                val matricula = Matricula(alunoAMatricular, cursoAMatricular,data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
                matriculas.add(matricula)
                println("O ${alunoAMatricular.nome} foi matriculado no Curso ${cursoAMatricular.nome} em ${matricula.dataMatricula}")
            }else {
                println("Não há vagas disponiveis")
            }
        }else  {
           println("Não foi possivel criar sua matricula")
        }

    }

    fun buscaAluno(codigoAluno: Int): Aluno? {
        for (aluno in alunos){
            if (aluno.codigoAluno == codigoAluno){
                return aluno
            }
        }
        return null
    }


    fun buscaCurso(codigoCurso: Int): Curso? {
        for (curso in cursos){
            if (curso.codigoCurso == codigoCurso){
                return curso
            }
        }
        return null
    }

    fun buscaProfessorAdjunto(codigoProfessorAdjunto: Int): Professor? {
        for (professorAdjunto in professores) {
            if (professorAdjunto.codigoProfessor == codigoProfessorAdjunto && professorAdjunto is ProfessorAdjunto) {
                return professorAdjunto
            }
        }
        return null
    }

    fun buscaProfessorTitular(codigoProfessorTitular: Int): Professor? {
        for (professorTitular in professores) {
            if (professorTitular.codigoProfessor == codigoProfessorTitular && professorTitular is ProfessorTitular) {
                return professorTitular
            }
        }
        return null
    }

    fun alocarProfessores(codigoCurso: Int,codigoProfessorTitular: Int, codigoProfessorAdjunto : Int){

        var cursoAlocacao = buscaCurso(codigoCurso)
        var professorTitularAlocacao = buscaProfessorTitular(codigoProfessorTitular)
        var professorAdjuntoAlocacao = buscaProfessorAdjunto(codigoProfessorAdjunto)

        if(cursoAlocacao != null && professorAdjuntoAlocacao != null && professorTitularAlocacao != null){

            cursoAlocacao.professorAdjunto = professorAdjuntoAlocacao as ProfessorAdjunto
            cursoAlocacao.professorTitular = professorTitularAlocacao as ProfessorTitular

            println("O Professor Adjunto ${professorAdjuntoAlocacao.nome} e o Professor Titular ${professorTitularAlocacao.nome} foram alocados no Curso ${cursoAlocacao.nome}")

        }else{
            println("Não foi possivel realizar a alocacao")
        }



        }

}