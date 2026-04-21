# language: fr
Fonctionnalité: Conversion des inscriptions utilisateur-programme entre les couches Presentation et Domain

  Scénario: Conversion UserProgramDTO vers UserProgramDomain
    Étant donné un UserProgramDTO avec la startDate "2024-06-01"
    Et le UserProgramDTO ayant aussi la endDate "2024-08-31"
    Et le UserProgramDTO ayant aussi le isActive true
    Quand il est convertit en UserProgramDomain
    Alors le UserProgramDomain résultant contient la startDate "2024-06-01"
    Et le UserProgramDomain résultant contient la endDate "2024-08-31"
    Et le UserProgramDomain résultant contient le isActive true

  Scénario: Conversion UserProgramResponseDomain vers UserProgramResponseDTO
    Étant donné un UserProgramResponseDomain avec le userId 1 et le programId 2
    Et le UserProgramResponseDomain ayant aussi la startDate "2024-06-01"
    Et le UserProgramResponseDomain ayant aussi la endDate "2024-08-31"
    Et le UserProgramResponseDomain ayant aussi le isActive true
    Quand il est convertit en UserProgramResponseDTO
    Alors le UserProgramResponseDTO résultant contient le userId 1
    Et le UserProgramResponseDTO résultant contient le programId 2
    Et le UserProgramResponseDTO résultant contient la startDate "2024-06-01"
    Et le UserProgramResponseDTO résultant contient la endDate "2024-08-31"
    Et le UserProgramResponseDTO résultant contient le isActive true
