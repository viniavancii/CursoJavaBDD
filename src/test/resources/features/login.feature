# language: pt

Funcionalidade: Apenas usuários cadastrados podem logar

Cenário: Um usuário válido consegue se logar
	Dado o user válido
	Quando realizar login
	Então é redirecionado para a página de login
	
	
Cenário: Um usuário inválido não consegue se logar
	Dado o user inválido
	Quando tenta se logar
	Então continua na página de login