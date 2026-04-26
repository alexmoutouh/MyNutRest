# language: fr
Fonctionnalité: Scan d'étiquettes nutritionnelles

  Scénario: Scan complet d'une étiquette nutritionnelle
    Étant donné un utilisateur existant avec l'id 1
    Et une image d'étiquette nutritionnelle lisible
    Et un poids consommé de 150 grammes
    Et le service de scan retourne un résultat complet
    Quand on effectue un POST multipart scan sur '/my-nut/api/v1/user/id/1/nut/scan'
    Alors la réponse HTTP est 200
    Et le statut du scan est "COMPLETE"
    Et la réponse du scan contient 0 messages
    Et la réponse du scan contient un nut avec l'id 1

  Scénario: Scan partiel d'une étiquette nutritionnelle
    Étant donné un utilisateur existant avec l'id 1
    Et une image d'étiquette partiellement lisible
    Et un poids consommé de 200 grammes
    Et le service de scan retourne un résultat partiel
    Quand on effectue un POST multipart scan sur '/my-nut/api/v1/user/id/1/nut/scan'
    Alors la réponse HTTP est 200
    Et le statut du scan est "PARTIAL"
    Et la réponse du scan contient 1 messages
    Et la réponse du scan contient un nut avec l'id 2

  Scénario: Échec total du scan
    Étant donné un utilisateur existant avec l'id 1
    Et une image illisible
    Et un poids consommé de 100 grammes
    Et le service de scan retourne un échec
    Quand on effectue un POST multipart scan sur '/my-nut/api/v1/user/id/1/nut/scan'
    Alors la réponse HTTP est 200
    Et le statut du scan est "FAILURE"
    Et la réponse du scan contient 1 messages
    Et la réponse du scan ne contient pas de nut
