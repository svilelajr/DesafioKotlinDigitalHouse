package desafio.modelo

fun main() {

    val digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarAluno("Nome1", "SobreNome1", 1)
    digitalHouseManager.registrarAluno("Nome2", "SobreNome2", 2)
    digitalHouseManager.registrarAluno("Nome3", "SobreNome3", 3)
    digitalHouseManager.registrarAluno("Nome4", "SobreNome4", 4)
    digitalHouseManager.registrarAluno("Nome5", "SobreNome5", 5)

    digitalHouseManager.registrarProfessorTitular("ProfTitular1", "SobrenomeProfTitular1", 1, 3, "Cálculo")
    digitalHouseManager.registrarProfessorTitular("ProfTitular2", "SobrenomeProfTitular1", 2, 2, "Java")

    digitalHouseManager.registrarProfessorAdjunto("ProfTAdjunto1", "SobrenomeProfTAdjunto2", 3, 12)
    digitalHouseManager.registrarProfessorAdjunto("ProfTAdjunto2", "SobrenomeProfTAdjunto2", 4, 11)

    digitalHouseManager.registrarCurso("Full stack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)


    digitalHouseManager.alocarProfessores(20001, 1, 3)
    digitalHouseManager.alocarProfessores(20002, 2, 4)

    digitalHouseManager.matricularAluno(1, 20001)
    digitalHouseManager.matricularAluno(2, 20001)
    digitalHouseManager.matricularAluno(3, 20002)
    digitalHouseManager.matricularAluno(4, 20002)
    digitalHouseManager.matricularAluno(5, 20002)
}