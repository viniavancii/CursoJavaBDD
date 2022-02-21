# language: pt
Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um lance valido
	Dado um lance valido
	Quando propoe ao leilao
	Entao o lance eh aceito
	
	
Cenario: Propondo varios lances validos
	Dado um lance de 10.00 reais do usuario "Fulano"
	E um lance de 15.00 reais do usuario "Beltrano"
	Quando propoe varios lances ao leilao
	Entao os lances sao aceitos
	

Esquema do Cenario: Propondo um lance invalido
	Dado um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
	Quando propoe ao leilao
	Entao o lance nao e aceito
	
	Exemplos:
		| valor | nomeUsuario |
		| 0     | beltrano    |
		| -1    | cigano      |
		
		
Cenario: Propondo uma sequencia de lances
	Dado dois lances
		| valor | nomeUsuario |
		| 10.00 | beltrano    |
		| 15.00 | beltrano    |
	Quando propoe varios lances ao leilao
	Entao o segundo lance nao sera aceito
	
	
	