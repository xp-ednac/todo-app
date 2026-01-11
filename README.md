# Todo App em Clojure – Atividade da Unidade 2

**Aluno(a): Edna Cristina Durans Santos**

Este repositório contém o projeto desenvolvido para a Unidade 2 da disciplina, seguindo o tutorial  
**“Clojure/ClojureScript: Construindo uma Aplicação Persistente e Reativa”**.

O objetivo do trabalho foi reproduzir, passo a passo, a construção de uma aplicação **Todo List full-stack**, contemplando backend, frontend, integração entre as camadas e persistência real em banco de dados SQLite.

---

## 📌 Tutoriais Utilizados

- Tutorial principal:  
  https://www.notion.so/2a5cce975093807aa9f0f0cb0cf69645?pvs=21

---

## 📌 Observação sobre o Histórico de Commits

Durante o desenvolvimento, o projeto original foi apagado acidentalmente.  
Para preservar a fidelidade ao processo incremental proposto no tutorial, o histórico de commits foi **restaurado manualmente a partir da versão local**, mantendo a sequência lógica das etapas.

Os commits refletem as fases reais de implementação do projeto.

---

## 📘 Descrição do Projeto

Este projeto implementa uma aplicação Todo List full-stack utilizando o ecossistema Clojure, contendo:

- Backend em **Clojure** com **Jetty** e **Reitit**
- API REST para gerenciamento de tarefas
- Persistência real em **SQLite** utilizando **next.jdbc**
- Frontend em **ClojureScript** com **Reagent**
- Comunicação frontend ↔ backend via **fetch** e **core.async**
- Build e hot reload com **Shadow-CLJS**

---

## 🧪 Funcionalidades Implementadas

- Criar tarefas
- Listar tarefas
- Marcar/desmarcar tarefas como concluídas (toggle)
- Persistência dos dados em SQLite
- Integração completa entre frontend e backend
- Atualização reativa da interface

---

## 🛠 Tecnologias Utilizadas

- Clojure
- ClojureScript
- Ring / Jetty
- Reitit
- next.jdbc
- SQLite
- Reagent
- Shadow-CLJS

---

## ▶ Como Executar o Projeto

### 📦 Pré-requisitos

- Java JDK 17+
- Clojure CLI
- Node.js + npm
- SQLite3

---

### 🚀 Execução

#### **Terminais:**
# Terminal 1 — Back End
clj -M:run
Servidor: http://localhost:3000

# Terminal 2 — Frontend
npx shadow-cljs watch app
Interface: http://localhost:8000


