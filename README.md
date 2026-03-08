# Trabalho 1 — Hello World

Curso: Licenciatura em Engenharia Informática e Multimédia (LEIM)
Aluno: a51812
Data: Março 2026
URL do Repositório: https://github.com/DanilBaril/HelloWorld

---

## 1. Introdução

Este trabalho corresponde às secções 4 e 7 do Tutorial 1 de Desenvolvimento de
Aplicações Móveis. O objetivo é construir uma primeira aplicação Android funcional,
familiarizar com o ambiente Android Studio, e adicionar funcionalidades extra para
aprofundar a experiência com o desenvolvimento Android.

## 2. Visão Geral do Sistema

A aplicação é uma versão melhorada do clássico "Hello World" com várias
funcionalidades interativas. Permite ao utilizador inserir o seu nome e receber
uma saudação personalizada, alternar entre português e inglês, e alternar entre
modo claro e escuro. Inclui também uma imagem, um calendário e logging no Logcat.

Funcionalidades principais:
- Saudação personalizada com o nome inserido pelo utilizador
- Alternância entre português e inglês
- Interruptor de modo claro/escuro
- Imagem e CalendarView no layout
- Logging do ciclo de vida da Activity no Logcat

## 3. Arquitetura e Design

A aplicação segue uma arquitetura de Activity única utilizando o sistema de Views
padrão do Android com ConstraintLayout. Toda a lógica está contida no MainActivity.kt.

O layout é composto por dois TextViews no topo, seguidos de uma imagem e um
CalendarView. Na parte inferior encontram-se o campo de texto, o botão de saudação,
o botão de idioma e o interruptor de modo claro/escuro.

Estrutura de pastas:
```
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/
│   └── dam_a51812/helloworld/
│       └── MainActivity.kt
└── res/
    ├── drawable/
    │   └── ribeiros.png
    ├── layout/
    │   └── activity_main.xml
    └── values/
        ├── strings.xml
        ├── colors.xml
        └── themes.xml
```

## 4. Implementação

O MainActivity.kt gere três funcionalidades principais:

**Saudação personalizada:** o botão `buttonNome` lê o conteúdo do `nomeBox` e
atualiza o `textView2` com uma saudação no idioma atual. Se o campo estiver vazio,
mostra apenas a saudação sem nome.

**Alternância de idioma:** a variável booleana `pt` controla o idioma atual.
Quando o botão `langBtn` é clicado, todos os textos da interface são atualizados
para o idioma oposto e a variável `pt` é invertida.

**Modo claro/escuro:** o `LDswitch` utiliza `AppCompatDelegate.setDefaultNightMode()`
para alternar entre os modos claro e escuro do sistema.

**Logging:** é enviada uma mensagem para o Logcat no `onCreate` com o nome da
Activity, usando uma string dinâmica definida no `strings.xml`.

## 5. Testes e Validação

Testes manuais realizados no emulador Pixel 9 Pro AVD e em dispositivo físico:

- Campo de nome vazio → mostra apenas a saudação ✓
- Campo de nome preenchido → mostra saudação com nome ✓
- Botão PT/EN alterna todos os textos corretamente ✓
- Saudação mantém o nome ao trocar de idioma ✓
- Interruptor de modo claro/escuro funciona corretamente ✓
- Mensagem de onCreate aparece no Logcat ✓

Limitações conhecidas:
- O nome não é guardado quando a app é fechada

## 6. Instruções de Utilização

Requisitos:
- Android Studio Ladybug ou superior
- Android SDK API 24 ou superior
- Kotlin 1.9 ou superior

Passos para executar:
1. Clonar o repositório: `git clone https://github.com/DanilBaril/HelloWorld`
2. Abrir o projeto no Android Studio
3. Executar num emulador ou dispositivo físico com API 24+
4. Inserir um nome no campo de texto e carregar em "Selecionar" para ver a saudação
5. Usar o botão PT/EN para alternar o idioma
6. Usar o interruptor no canto inferior esquerdo para alternar entre modo claro e escuro

---

# Processo de Desenvolvimento

## 12. Controlo de Versão e Histórico de Commits

O projeto foi desenvolvido de forma incremental com commits em cada etapa:
- Inicialização do projeto Hello World, configuração das strings e recursos, implementação do layout v1 com TextView básico, melhorias do layout v2 com imagem e CalendarView
- Implementação da saudação personalizada com EditText e Button, implementação da alternância de idioma PT/EN, implementação do interruptor de modo claro/escuro

## 13. Dificuldades e Lições Aprendidas

A principal dificuldade foi perceber o sistema de constraints do ConstraintLayout,
especialmente ao posicionar elementos lado a lado e encadeados verticalmente.

Outro desafio foi garantir que a saudação se mantinha correta ao trocar de idioma
quando o campo de nome já tinha conteúdo, o que foi resolvido atualizando o
`textView2` diretamente no listener do botão de idioma.

A distinção entre `.text =` e `.setText()` para EditText também causou alguma
confusão inicial mas ficou clara após perceber que o EditText usa `Editable` e
não `String` diretamente.

## 14. Melhorias Futuras

- Guardar o nome e o idioma escolhido entre sessões com SharedPreferences
- Adicionar animação de fade ao mudar a saudação
- Adicionar mais idiomas

---

## 15. Declaração de Utilização de IA

Ferramentas de IA utilizadas: Claude (claude.ai)
Utilização: a IA foi utilizada exclusivamente como ferramenta de aprendizagem,
para esclarecer dúvidas sobre conceitos como TextWatcher, constraints do layout
e diferenças entre `.text` e `.setText()`. Nenhum código foi gerado ou copiado
diretamente de ferramentas de IA. Todo o código foi escrito pelo aluno.