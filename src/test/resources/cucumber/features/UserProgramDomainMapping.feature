# language: fr
Fonctionnalité: Conversion des inscriptions utilisateur-programme entre les couches Domain et Infrastructure

  Scénario: Conversion UserProgramDomain vers UserProgram entity
    Étant donné un UserProgramDomain avec le userId 1 et le programId 2
    Et la startDate "2024-06-01"
    Et la endDate "2024-08-31"
    Et le isActive true
    Quand il est convertit en entité UserProgram
    Alors l'entité UserProgram résultante contient le userId 1
    Et l'entité UserProgram résultante contient le programId 2
    Et l'entité UserProgram résultante contient la startDate "2024-06-01"
    Et l'entité UserProgram résultante contient la endDate "2024-08-31"
    Et l'entité UserProgram résultante contient le isActive true

  Scénario: Conversion UserProgram entity vers UserProgramResponseDomain
    Étant donné une entité UserProgram avec le userId 1 et le programId 2
    Et la startDate entity "2024-06-01"
    Et la endDate entity "2024-08-31"
    Et le isActive entity true
    Quand elle est convertit en UserProgramResponseDomain
    Alors le UserProgramResponseDomain résultant contient le userId 1
    Et le UserProgramResponseDomain résultant contient le programId 2
    Et le UserProgramResponseDomain résultant contient la startDate "2024-06-01"
    Et le UserProgramResponseDomain résultant contient la endDate "2024-08-31"
    Et le UserProgramResponseDomain résultant contient le isActive true
