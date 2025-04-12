# Projeto UC12 - Simulador de Ligações Telefônicas

Este projeto foi desenvolvido como atividade final da Unidade Curricular 12 do curso Técnico em Informática do SENAC. A proposta consiste em criar uma simulação de funcionamento de aparelhos telefônicos (celulares e fixos), aplicando os conceitos fundamentais da Programação Orientada a Objetos (POO).

## Desenvolvido por

*Igor Martins Santos*  
Turma: 0066 — SENAC Minas  
Curso Técnico em Informática

## Conceitos aplicados

- *Encapsulamento:* Proteção dos atributos com modificadores de acesso e uso de métodos getters e setters.
- *Herança:* As classes Samsung, Iphone e Fixo herdam de Celulares.
- *Polimorfismo:* Métodos como ligar(), status() e ligacao() foram sobrescritos nas subclasses.
- *Lógica de programação:* O projeto contém menus interativos, verificações de senha, cadastro de usuário, controle de volume e gerenciamento de crédito/mensalidade.

## Estrutura do projeto

- Celular.java: Interface com os métodos básicos de um celular (encapsulamento).
- Celulares.java: Classe abstrata para os modelos, implementa os métodos da interface.
- Samsung.java: Classe que representa um modelo Samsung.
- Iphone.java: Classe que representa um modelo iPhone.
- Fixo.java: Classe que representa um telefone fixo.
- LigacaoCelular.java: Classe com o método main, responsável por iniciar a aplicação.

## Testes e Execução

Como executar o projeto no NetBeans
Abra o NetBeans.

1. Vá em "File" > "Open Project...".

2. Navegue até a pasta onde está o projeto salvo (a pasta que contém o diretório src/).

3. Clique em "Abrir projeto".

4. Com o projeto aberto, clique com o botão direito no nome do projeto e selecione "Run" ou pressione F6.

5. O programa será executado no console interno do NetBeans.

Certifique-se de que o método main está na classe LigacaoCelular.java, que é o ponto de entrada do programa.
