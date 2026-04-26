# language: fr
Fonctionnalité: Détection des champs null dans NutScanExtractionDomain

  Scénario: Tous les champs sont remplis
    Étant donné une extraction avec tous les champs remplis
    Quand on récupère les noms des champs null
    Alors la liste des champs null est vide

  Scénario: Quelques champs sont null
    Étant donné une extraction avec fibers et sodium null
    Quand on récupère les noms des champs null
    Alors la liste des champs null contient "fibers"
    Et la liste des champs null contient "sodium"
    Et la liste des champs null a 2 éléments

  Scénario: Tous les champs sont null
    Étant donné une extraction avec tous les champs null
    Quand on récupère les noms des champs null
    Alors la liste des champs null a 8 éléments
